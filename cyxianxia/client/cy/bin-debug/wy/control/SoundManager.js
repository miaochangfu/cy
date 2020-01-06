var __reflect = (this && this.__reflect) || function (p, c, t) {
    p.__class__ = c, t ? t.push(c) : t = [c], p.__types__ = p.__types__ ? t.concat(p.__types__) : t;
};
var wy;
(function (wy) {
    var SoundManager = (function () {
        function SoundManager() {
        }
        SoundManager.getInstance = function () {
            if (!this.ins) {
                this.ins = new SoundManager();
            }
            return this.ins;
        };
        SoundManager.prototype.init = function () {
            this.channels = {};
            wy.on(this.playSound, "wyPlaySound", this);
            wy.on(this.stopSound, "wyStopSound", this);
            wy.on(this.resetSound, "wyResetSound", this);
            this.sounds = {};
        };
        SoundManager.prototype.preload = function (soundname) {
            var sound = new egret.Sound();
            sound['name'] = soundname;
            sound.addEventListener(egret.Event.COMPLETE, this.onPreloadFinish, this);
            sound.addEventListener(egret.IOErrorEvent.IO_ERROR, this.onPreloadFinish, this);
            sound.load("resource/audio/" + soundname + ".mp3");
        };
        SoundManager.prototype.onPreloadFinish = function (e) {
            var sound = e.target;
            var name = sound['name'];
            this.sounds[name] = sound;
            wy.notify("preloadfinish", name);
        };
        SoundManager.prototype.push = function (soundname, sound) {
            this.sounds[soundname] = sound;
            this.sounds[soundname].name = soundname;
        };
        SoundManager.prototype.preloadGroup = function (groupName) {
            if (this.loadingGroup)
                return;
            this.loadingGroup = groupName;
            RES.addEventListener(RES.ResourceEvent.GROUP_COMPLETE, this.onResourceLoadComplete, this);
            RES.addEventListener(RES.ResourceEvent.GROUP_LOAD_ERROR, this.onResourceLoadError, this);
            RES.addEventListener(RES.ResourceEvent.GROUP_PROGRESS, this.onResourceProgress, this);
            RES.addEventListener(RES.ResourceEvent.ITEM_LOAD_ERROR, this.onItemLoadError, this);
            RES.loadGroup(groupName);
        };
        /**
         * preload资源组加载完成
         * Preload resource group is loaded
         */
        SoundManager.prototype.onResourceLoadComplete = function (event) {
            if (event.groupName == this.loadingGroup) {
                this.loadingGroup = "";
                RES.removeEventListener(RES.ResourceEvent.GROUP_COMPLETE, this.onResourceLoadComplete, this);
                RES.removeEventListener(RES.ResourceEvent.GROUP_LOAD_ERROR, this.onResourceLoadError, this);
                RES.removeEventListener(RES.ResourceEvent.GROUP_PROGRESS, this.onResourceProgress, this);
                RES.removeEventListener(RES.ResourceEvent.ITEM_LOAD_ERROR, this.onItemLoadError, this);
            }
        };
        /**
         * 资源组加载出错
         *  The resource group loading failed
         */
        SoundManager.prototype.onItemLoadError = function (event) {
            console.warn("Url:" + event.resItem.url + " has failed to load");
        };
        /**
         * 资源组加载出错
         *  The resource group loading failed
         */
        SoundManager.prototype.onResourceLoadError = function (event) {
            //TODO
            console.warn("Group:" + event.groupName + " has failed to load");
            //忽略加载失败的项目
            //Ignore the loading failed projects
            this.onResourceLoadComplete(event);
        };
        /**
         * preload资源组加载进度
         * Loading process of preload resource group
         */
        SoundManager.prototype.onResourceProgress = function (event) {
            if (event.groupName == this.loadingGroup) {
                var name_1 = event.resItem.name.replace("_mp3", "");
                if (!this.sounds[name_1]) {
                    this.sounds[name_1] = RES.getRes(event.resItem.name);
                    this.sounds[name_1].name = name_1;
                }
            }
        };
        SoundManager.prototype.playSound = function (eff) {
            if (!this.sounds[eff]) {
                this.loadMusic(eff);
            }
            else {
                var sound_1 = this.sounds[eff];
                var name_2 = sound_1['name'];
                var self_1 = this;
                if (window['wx'] && window['is_weixin']()) {
                    window['wx'].getNetworkType({
                        success: function (res) {
                            var networkType = res.networkType; // 返回网络类型2g，3g，4g，wifi
                            // self.channels[name] = sound.play(0, 1);
                            self_1.playingSound(sound_1);
                        }
                    });
                }
                else {
                    self_1.playingSound(sound_1);
                }
            }
        };
        SoundManager.prototype.loadMusic = function (bgm) {
            // RES.getResByUrl("resource/assets/" + bgm + ".mp3", this.onSoundLoadOK1, this);
            var sound = new egret.Sound();
            sound['name'] = bgm;
            sound.addEventListener(egret.Event.COMPLETE, this.onLoadFinish, this);
            sound.addEventListener(egret.IOErrorEvent.IO_ERROR, this.onLoadFinish, this);
            sound.load("resource/audio/" + bgm + ".mp3");
        };
        SoundManager.prototype.onLoadFinish = function (e) {
            var sound = e.target;
            var name = sound['name'];
            var self = this;
            if (!this.sounds[name]) {
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
            }
            else {
                self.playingSound(sound);
            }
        };
        SoundManager.prototype.playingSound = function (sound) {
            var name = sound['name'];
            var isplay = sound['isplay'];
            var played = sound['played'];
            if (!isplay && !played) {
                sound['isplay'] = true;
                var channel = sound.play(0, 1);
                channel['name'] = name;
                this.channels[name] = channel;
                channel.addEventListener(egret.Event.SOUND_COMPLETE, this.soundComplete, this);
            }
        };
        SoundManager.prototype.stopSound = function (soundname) {
            var sound = this.sounds[soundname];
            var channel = this.channels[soundname];
            if (sound && !sound.played && sound.isplay && channel) {
                channel.stop();
                this.channels[soundname] = null;
            }
        };
        SoundManager.prototype.resetSound = function (soundname) {
            var sound = this.sounds[soundname];
            if (sound) {
                sound['isplay'] = false;
                sound['played'] = false;
            }
        };
        SoundManager.prototype.soundComplete = function (e) {
            var channel = e.target;
            var name = channel['name'];
            var sound = this.sounds[name];
            if (sound) {
                sound.played = true;
            }
            channel.removeEventListener(egret.Event.SOUND_COMPLETE, this.soundComplete, this);
            wy.notify("SoundComplete", channel['name']);
            channel['name'] = null;
        };
        SoundManager.prototype.onLoadError = function (e) {
            egret.warn('音频加载出错');
        };
        return SoundManager;
    }());
    wy.SoundManager = SoundManager;
    __reflect(SoundManager.prototype, "wy.SoundManager");
    /**
     * 播放音频
     * @param soundName 音频名
     * @param once 是否只播放一次，不止播放一次，则每次都会把之前正在播放的对应音频停止然后再播放
     */
    function playSound(soundName, once) {
        if (once === void 0) { once = false; }
        if (!once) {
            stopSound(soundName);
        }
        wy.notify("wyPlaySound", soundName);
    }
    wy.playSound = playSound;
    /**
     * 停止播放音频
     * @param soundName 音频名
     * @param isreset 是否重置，重置则能下次播放，不重置之后即便调用playSound也不会再播放
     */
    function stopSound(soundName, isreset) {
        if (isreset === void 0) { isreset = true; }
        wy.notify("wyStopSound", soundName);
        if (isreset) {
            wy.notify("wyResetSound", soundName);
        }
    }
    wy.stopSound = stopSound;
})(wy || (wy = {}));
