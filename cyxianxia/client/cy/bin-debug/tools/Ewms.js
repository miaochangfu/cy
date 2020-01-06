var __reflect = (this && this.__reflect) || function (p, c, t) {
    p.__class__ = c, t ? t.push(c) : t = [c], p.__types__ = p.__types__ ? t.concat(p.__types__) : t;
};
var wy;
(function (wy) {
    /**
     * 二维码 通用类
     *
     * @example
     * <pre>
     *    wy.EWM.init('http://wap.i-h5.cn/ljd_game/Aug_rjb/resource/assets/ewm.png');
     *    wy.EWM.set(300,300,200,200);
     *    wy.EWM.show();
     * </pre>
     *
     * @version 0.0.3
     * @platform egret3.0.3
     *
     */
    var EWMs = (function () {
        function EWMs() {
        }
        /**
         * 初始化二维码
         * @param src 二维码地址
         *
         * @version 0.0.3
         * @platform egret3.0.3
         */
        EWMs.prototype.init = function (src) {
            this.myImg = document.createElement("img");
            this.myImg.src = src;
            this.myImg.style.position = "absolute";
        };
        /**
         * 设置二维码的坐标和长宽
         *
         * @param x
         * @param y
         * @param w
         * @param h
         *
         * @version 0.0.3
         * @platform egret3.0.3
         */
        EWMs.prototype.set = function (x, y, w, h) {
            // var width = w / wy.GameInterface.stage.stageWidth * 100;
            // var heigth = h / wy.GameInterface.stage.stageHeight * 100;
            // var left = x / wy.GameInterface.stage.stageWidth * 100;
            // var top = y / wy.GameInterface.stage.stageHeight * 100;
            // this.myImg.style.width = width + "%";
            // this.myImg.style.height = heigth + "%";
            // this.myImg.style.position = "absolute";
            // this.myImg.style.left = left + "%";
            // this.myImg.style.top = top + "%";
            if (this.myImg == null) {
                return;
            }
            //竖屏
            if (document.body.clientWidth < document.body.clientHeight) {
                var wScale = document.body.clientWidth / wy.GameInterface.stage.stageWidth;
                var hScale = document.body.clientHeight / wy.GameInterface.stage.stageHeight;
                this.myImg.style.width = w * wScale + "px";
                this.myImg.style.height = h * hScale + "px";
                this.myImg.style.left = x * wScale + "px";
                this.myImg.style.top = y * hScale + "px";
            }
            else {
                var wScale = document.body.clientWidth / wy.GameInterface.stage.stageHeight;
                var hScale = document.body.clientHeight / wy.GameInterface.stage.stageWidth;
                this.myImg.style.width = h * wScale + "px";
                this.myImg.style.height = w * hScale + "px";
                this.myImg.style.top = (wy.GameInterface.stage.stageWidth - x - w) * hScale + "px";
                this.myImg.style.left = y * wScale + "px";
            }
            this.myImg.style.opacity = '1';
        };
        /**
         * 隐藏二维码
         *
         * @version 0.0.3
         * @platform egret3.0.3
         */
        EWMs.prototype.hide = function () {
            if (this.myImg && this.myImg.parentNode) {
                this.myImg.parentNode.removeChild(this.myImg);
            }
        };
        /**
         * 显示二维码
         *
         * @version 0.0.3
         * @platform egret3.0.3
         */
        EWMs.prototype.show = function () {
            var divMain = document.getElementById("gameID");
            divMain.appendChild(this.myImg);
        };
        EWMs.prototype.click = function (f, thisObj) {
            if (this.myImg) {
                this.myImg.onclick = function () {
                    f.call(thisObj);
                };
            }
        };
        EWMs.prototype.start = function (f, thisObj) {
            if (this.myImg) {
                this.myImg.ontouchstart = function (e) {
                    f.call(thisObj, e);
                };
            }
        };
        EWMs.prototype.move = function (f, thisObj) {
            if (this.myImg) {
                this.myImg.ontouchmove = function (e) {
                    f.call(thisObj, e);
                };
            }
        };
        EWMs.prototype.end = function (f, thisObj) {
            if (this.myImg) {
                this.myImg.ontouchend = function (e) {
                    f.call(thisObj, e);
                };
            }
        };
        EWMs.prototype.down = function (f, thisObj) {
            if (this.myImg) {
                this.myImg.onmousedown = function (e) {
                    f.call(thisObj, e);
                };
            }
        };
        EWMs.prototype.up = function (f, thisObj) {
            if (this.myImg) {
                this.myImg.onmouseup = function (e) {
                    f.call(thisObj, e);
                };
            }
        };
        return EWMs;
    }());
    wy.EWMs = EWMs;
    __reflect(EWMs.prototype, "wy.EWMs");
})(wy || (wy = {}));
