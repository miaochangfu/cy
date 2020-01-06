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
var InfoA = (function (_super) {
    __extends(InfoA, _super);
    function InfoA() {
        return _super.call(this) || this;
    }
    InfoA.prototype.createChildren = function () {
        _super.prototype.createChildren.call(this);
        this.txt1.verticalAlign = this.txt2.verticalAlign = this.txt3.verticalAlign = this.txt4.verticalAlign = 'middle';
        this.headImg = MyTools.setHeadImg(this, this.headBit, 53, true, 0, 0);
        this.headImg.source = StaticVar.defaultHeadImgUrl;
        this.nickname.text = StaticVar.defaultNickname;
        this.sex0.alpha = this.sex1.alpha = 0;
    };
    InfoA.prototype.show = function (data) {
        _super.prototype.show.call(this, data);
        this.touchInit();
        var sex = 1;
        sex == 0 ? this.sex0.alpha = 1 : this.sex1.alpha = 1;
    };
    InfoA.prototype.onTouchTap = function (e) {
        switch (e.currentTarget) {
            case this.hbBtn:
                break;
            default:
                break;
        }
    };
    InfoA.prototype.touchInit = function () {
        this.hbBtn.touchEnabled = true;
        this.hbBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    };
    InfoA.prototype.hide = function () {
        _super.prototype.hide.call(this);
        this.hbBtn.touchEnabled = false;
        this.hbBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    };
    return InfoA;
}(InfoAUI));
__reflect(InfoA.prototype, "InfoA");
