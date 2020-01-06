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
var Info = (function (_super) {
    __extends(Info, _super);
    function Info() {
        var _this = _super.call(this) || this;
        _this.btnArr = ['backBtn', 'btn1_1', 'btn2_1', 'btn3_1'];
        return _this;
    }
    Info.prototype.createChildren = function () {
        _super.prototype.createChildren.call(this);
    };
    Info.prototype.show = function (data) {
        _super.prototype.show.call(this, data);
        this.touchInit();
        this.btn1_1.visible = false;
        this.btn1_2.visible = true;
        this.btn2_1.visible = true;
        this.btn2_2.visible = false;
        this.btn3_1.visible = true;
        this.btn3_2.visible = false;
        wy.openPopUpView(InfoA);
    };
    Info.prototype.onTouchTap = function (e) {
        switch (e.currentTarget) {
            case this.backBtn:
                wy.hidePopUpView();
                wy.hideView();
                break;
            case this.btn1_1:
                this.btn1_1.visible = false;
                this.btn1_2.visible = true;
                this.btn2_1.visible = true;
                this.btn2_2.visible = false;
                this.btn3_1.visible = true;
                this.btn3_2.visible = false;
                wy.openPopUpView(InfoA);
                break;
            case this.btn2_1:
                this.btn1_1.visible = true;
                this.btn1_2.visible = false;
                this.btn2_1.visible = false;
                this.btn2_2.visible = true;
                this.btn3_1.visible = true;
                this.btn3_2.visible = false;
                wy.openPopUpView(InfoB);
                break;
            case this.btn3_1:
                this.btn1_1.visible = true;
                this.btn1_2.visible = false;
                this.btn2_1.visible = true;
                this.btn2_2.visible = false;
                this.btn3_1.visible = false;
                this.btn3_2.visible = true;
                wy.openPopUpView(InfoC);
                break;
            default:
                break;
        }
    };
    Info.prototype.touchInit = function () {
        this.mc.touchEnabled = true;
        for (var i = 0; i < this.btnArr.length; i++) {
            this[this.btnArr[i]].touchEnabled = true;
            this[this.btnArr[i]].addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        }
    };
    Info.prototype.hide = function () {
        _super.prototype.hide.call(this);
        this.mc.touchEnabled = false;
        for (var i = 0; i < this.btnArr.length; i++) {
            this[this.btnArr[i]].touchEnabled = false;
            this[this.btnArr[i]].removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        }
    };
    return Info;
}(InfoUI));
__reflect(Info.prototype, "Info");
