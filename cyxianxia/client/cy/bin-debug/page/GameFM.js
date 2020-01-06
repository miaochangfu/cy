var __reflect = (this && this.__reflect) || function (p, c, t) {
    p.__class__ = c, t ? t.push(c) : t = [c], p.__types__ = p.__types__ ? t.concat(p.__types__) : t;
};
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
/**
 *
 *@author
 *
 */
var GameFM = (function (_super) {
    __extends(GameFM, _super);
    function GameFM() {
        return _super.call(this) || this;
    }
    GameFM.prototype.createChildren = function () {
        _super.prototype.createChildren.call(this);
    };
    GameFM.prototype.show = function (data) {
        _super.prototype.show.call(this, data);
        this.touchInit();
    };
    GameFM.prototype.onTouchTap = function (e) {
        switch (e.currentTarget) {
            case this.bg:
                break;
            case this.chooseA:
                break;
            case this.chooseB:
                break;
            default:
                break;
        }
    };
    GameFM.prototype.touchInit = function () {
        this.bg.touchEnabled = true;
        this.chooseA.touchEnabled = true;
        this.chooseA.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.chooseB.touchEnabled = true;
        this.chooseB.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    };
    GameFM.prototype.hide = function () {
        _super.prototype.hide.call(this);
        this.bg.touchEnabled = false;
        this.chooseA.touchEnabled = false;
        this.chooseA.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.chooseB.touchEnabled = false;
        this.chooseB.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    };
    return GameFM;
}(GameFMUI));
__reflect(GameFM.prototype, "GameFM");
