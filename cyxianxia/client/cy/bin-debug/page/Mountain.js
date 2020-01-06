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
 * 华山论剑
 */
var Mountain = (function (_super) {
    __extends(Mountain, _super);
    function Mountain() {
        var _this = _super.call(this) || this;
        _this.btnArr = ['backBtn', 'btn1_1', 'btn1_2', 'btn1_3', 'btn2_1', 'btn2_2'];
        return _this;
    }
    Mountain.prototype.createChildren = function () {
        _super.prototype.createChildren.call(this);
    };
    Mountain.prototype.show = function (data) {
        _super.prototype.show.call(this, data);
        this.touchInit();
    };
    Mountain.prototype.onTouchTap = function (e) {
        switch (e.currentTarget) {
            case this.backBtn:
                wy.hideView();
                break;
            case this.btn1_1:
                MyTools.hintMethod('华山论剑4人');
                break;
            case this.btn1_2:
                MyTools.hintMethod('华山论剑6人');
                break;
            case this.btn1_3:
                MyTools.hintMethod('华山论剑8人');
                break;
            case this.btn2_1:
                MyTools.hintMethod('好友对战2v2');
                break;
            case this.btn2_2:
                MyTools.hintMethod('好友对战3v3');
                break;
            default:
                break;
        }
    };
    Mountain.prototype.touchInit = function () {
        this.mc.touchEnabled = true;
        for (var i = 0; i < this.btnArr.length; i++) {
            this[this.btnArr[i]].touchEnabled = true;
            this[this.btnArr[i]].addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        }
    };
    Mountain.prototype.hide = function () {
        _super.prototype.hide.call(this);
        this.mc.touchEnabled = false;
        for (var i = 0; i < this.btnArr.length; i++) {
            this[this.btnArr[i]].touchEnabled = false;
            this[this.btnArr[i]].removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        }
    };
    return Mountain;
}(MountainUI));
__reflect(Mountain.prototype, "Mountain");
