
namespace wy {

    export class SoundManager {
        private static ins: SoundManager;
        public static getInstance() {
            if (!this.ins) {
                this.ins = new SoundManager();
            }
            return this.ins;
        }
        public init() {
            this.channels = {};
            wy.on(this.playSound, "wyPlaySound", this);
            wy.on(this.stopSound, "wyStopSound", this);
            wy.on(this.resetSound, "wyResetSound", this);

            this.sounds = {};
        }

        public preload(soundname: string) {
            let sound = new egret.Sound();
            sound['name'] = soundname;
            sound.addEventListener(egret.Event.COMPLETE, this.onPreloadFinish, this);
            sound.addEventListener(egret.IOErrorEvent.IO_ERROR, this.onPreloadFinish, this);
            sound.load("resource/audio/" + soundname + ".mp3");
        }

        private onPreloadFinish(e) {
            let sound = e.target;
            let name = sound['name'];
            this.sounds[name] = sound;
            wy.notify("preloadfinish", name);
        }

        private sounds: any;

        public push(soundname: string, sound: egret.Sound) {
            this.sounds[soundname] = sound;
            this.sounds[soundname].name = soundname;
        }

        private loadingGroup: string;

        public preloadGroup(groupName: string) {
            if (this.loadingGroup) return;
            this.loadingGroup = groupName;
            RES.addEventListener(RES.ResourceEvent.GROUP_COMPLETE, this.onResourceLoadComplete, this);
            RES.addEventListener(RES.ResourceEvent.GROUP_LOAD_ERROR, this.onResourceLoadError, this);
            RES.addEventListener(RES.ResourceEvent.GROUP_PROGRESS, this.onResourceProgress, this);
            RES.addEventListener(RES.ResourceEvent.ITEM_LOAD_ERROR, this.onItemLoadError, this);
            RES.loadGroup(groupName);
        }

        /**
         * preload资源组加载完成
         * Preload resource group is loaded
         */
        private onResourceLoadComplete(event: RES.ResourceEvent): void {
            if (event.groupName == this.loadingGroup) {
                this.loadingGroup = "";
                RES.removeEventListener(RES.ResourceEvent.GROUP_COMPLETE, this.onResourceLoadComplete, this);
                RES.removeEventListener(RES.ResourceEvent.GROUP_LOAD_ERROR, this.onResourceLoadError, this);
                RES.removeEventListener(RES.ResourceEvent.GROUP_PROGRESS, this.onResourceProgress, this);
                RES.removeEventListener(RES.ResourceEvent.ITEM_LOAD_ERROR, this.onItemLoadError, this);
            }
        }

        /**
         * 资源组加载出错
         *  The resource group loading failed
         */
        private onItemLoadError(event: RES.ResourceEvent): void {
            console.warn("Url:" + event.resItem.url + " has failed to load");
        }

        /**
         * 资源组加载出错
         *  The resource group loading failed
         */
        private onResourceLoadError(event: RES.ResourceEvent): void {
            //TODO
            console.warn("Group:" + event.groupName + " has failed to load");
            //忽略加载失败的项目
            //Ignore the loading failed projects
            this.onResourceLoadComplete(event);
        }

        /**
         * preload资源组加载进度
         * Loading process of preload resource group
         */
        private onResourceProgress(event: RES.ResourceEvent): void {
            if (event.groupName == this.loadingGroup) {
                let name = event.resItem.name.replace("_mp3", "");
                if (!this.sounds[name]) {
                    this.sounds[name] = RES.getRes(event.resItem.name);
                    this.sounds[name].name = name;
                }
            }
        }

        private playSound(eff: string) {
            if (!this.sounds[eff]) {
                this.loadMusic(eff);
            } else {
                let sound = this.sounds[eff];
                let name = sound['name'];
                let self = this;
                if (window['wx'] && window['is_weixin']()) {
                    window['wx'].getNetworkType({
                        success: function (res) {
                            var networkType = res.networkType; // 返回网络类型2g，3g，4g，wifi
                            // self.channels[name] = sound.play(0, 1);
                            self.playingSound(sound);
                        }
                    });
                } else {
                    self.playingSound(sound);
                    // self.channels[name] = sound.play(0, 1);
                }
            }
        }

        private loadMusic(bgm: string): void {
            // RES.getResByUrl("resource/assets/" + bgm + ".mp3", this.onSoundLoadOK1, this);
            let sound = new egret.Sound();
            sound['name'] = bgm;
            sound.addEventListener(egret.Event.COMPLETE, this.onLoadFinish, this);
            sound.addEventListener(egret.IOErrorEvent.IO_ERROR, this.onLoadFinish, this);
            sound.load("resource/audio/" + bgm + ".mp3");
        }

        private channels: any;
        private onLoadFinish(e) {
            let sound = e.target;
            let name = sound['name'];
            let self = this;

            if(!this.sounds[name]) {
                this.sounds[name] = sound;
            }

            if (window['wx'] && window['is_weixin']()) {
                window['wx'].getNetworkType({
                    success: function (res) {
                        var networkType = res.networkType; // 返回网络类型2g，3g，4g，wifi
                        // self.channels[name] = sound.play(0, 1);
                        self.playingSound(sound);
                    }
                });
            } else {
                self.playingSound(sound);
                // self.channels[name] = sound.play(0, 1);
            }
        }

        private playingSound(sound: egret.Sound) {
            let name = sound['name'];
            let isplay = sound['isplay'];
            let played = sound['played'];
            if (!isplay && !played) {
                sound['isplay'] = true;
                let channel = sound.play(0, 1);
                channel['name'] = name;
                this.channels[name] = channel;
                channel.addEventListener(egret.Event.SOUND_COMPLETE, this.soundComplete, this);
            }
        }

        private stopSound(soundname: string) {
            let sound = this.sounds[soundname];
            let channel = this.channels[soundname];
            if (sound && !sound.played && sound.isplay && channel) {
                channel.stop();
                this.channels[soundname] = null;
            }
        }
        private resetSound(soundname: string) {
            let sound = this.sounds[soundname];
            if (sound) {
                sound['isplay'] = false;
                sound['played'] = false;
            }
        }
        private soundComplete(e) {
            let channel = e.target;
            let name = channel['name'];
            let sound = this.sounds[name];
            if (sound) {
                sound.played = true;
            }

            channel.removeEventListener(egret.Event.SOUND_COMPLETE, this.soundComplete, this);
            wy.notify("SoundComplete", channel['name']);
            channel['name'] = null;
        }

        private onLoadError(e) {
            egret.warn('音频加载出错');
        }
    }

    /**
     * 播放音频
     * @param soundName 音频名
     * @param once 是否只播放一次，不止播放一次，则每次都会把之前正在播放的对应音频停止然后再播放
     */
    export function playSound(soundName: string, once: boolean = false) {
        if (!once) {
            stopSound(soundName);
        }
        wy.notify("wyPlaySound", soundName);
    }
    /**
     * 停止播放音频
     * @param soundName 音频名
     * @param isreset 是否重置，重置则能下次播放，不重置之后即便调用playSound也不会再播放
     */
    export function stopSound(soundName: string, isreset: boolean = true) {
        wy.notify("wyStopSound", soundName);
        if (isreset) {
            wy.notify("wyResetSound", soundName);
        }
    }
}