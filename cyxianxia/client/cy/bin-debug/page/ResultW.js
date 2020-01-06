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
var ResultW = (function (_super) {
    __extends(ResultW, _super);
    function ResultW() {
        return _super.call(this) || this;
    }
    ResultW.prototype.createChildren = function () {
        _super.prototype.createChildren.call(this);
    };
    ResultW.prototype.show = function (data) {
        _super.prototype.show.call(this, data);
        this.mc.touchEnabled = true;
        this.mc.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.bg.touchEnabled = true;
        this.bg.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.btn1.touchEnabled = true;
        this.btn1.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.btn2.touchEnabled = true;
        this.btn2.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.txt3.touchEnabled = true;
        this.txt3.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.txt2.touchEnabled = true;
        this.txt2.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.txt1.touchEnabled = true;
        this.txt1.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        wy.Tween.do(this);
    };
    ResultW.prototype.hide = function () {
        _super.prototype.hide.call(this);
        this.mc.touchEnabled = false;
        this.mc.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.bg.touchEnabled = false;
        this.bg.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.btn1.touchEnabled = false;
        this.btn1.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.btn2.touchEnabled = false;
        this.btn2.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.txt3.touchEnabled = false;
        this.txt3.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.txt2.touchEnabled = false;
        this.txt2.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.txt1.touchEnabled = false;
        this.txt1.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    };
    ResultW.prototype.onTouchTap = function (e) {
        switch (e.currentTarget) {
            case this.mc:
                break;
            case this.bg:
                break;
            case this.btn1:
                break;
            case this.btn2:
                break;
            case this.txt3:
                break;
            case this.txt2:
                break;
            case this.txt1:
                break;
            default:
                break;
        }
    };
    return ResultW;
}(ResultWUI));
__reflect(ResultW.prototype, "ResultW");
