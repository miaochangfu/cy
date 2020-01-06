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
 * @author
 *
 */
var MailCItem = (function (_super) {
    __extends(MailCItem, _super);
    function MailCItem() {
        var _this = _super.call(this) || this;
        _this.init();
        return _this;
    }
    MailCItem.prototype.init = function () {
        this.bottomImg = new egret.Bitmap();
        this.addChild(this.bottomImg);
        this.headImg = new wy.HeadImg(28, true, 80, 80);
        this.addChild(this.headImg);
        this.nickname = new egret.TextField();
        this.addChild(this.nickname);
        this.btn1 = new egret.Bitmap();
        this.addChild(this.btn1);
        this.btn2 = new egret.Bitmap();
        this.addChild(this.btn2);
    };
    MailCItem.prototype.dataChanged = function (data) {
        _super.prototype.dataChanged.call(this);
        var type = Math.floor(Math.random() * 2); //添加or请求添加:0 or 1
        if (type == 0) {
            this.bottomImg.texture = RES.getRes("MailC_item2_png");
        }
        else {
            this.btn1.visible = this.btn2.visible = false;
            this.bottomImg.texture = RES.getRes("MailC_item1_png");
        }
        this.bottomImg.x = 0;
        this.bottomImg.y = 0;
        this.headImg.source = this.data.img ? this.data.img : StaticVar.defaultHeadImgUrl;
        var nicknameStr = this.data.name;
        if (this.data.name == '' || this.data.name == 'null' || this.data.name == null || this.data.name == undefined
            || (this.data.name.length > 0 && this.data.name.trim().length == 0)) {
            nicknameStr = '游客';
        }
        if (type == 0) {
            this.headImg.x = 3 + 28;
            this.headImg.y = 1 + 28;
            MyTools.getItemTxt(this.nickname, nicknameStr, 18, 0x2c8f93, 63, 20 + 3, 90, 22, 0, 0x276ba9, 'center');
        }
        else {
            this.headImg.x = 78 + 28;
            this.headImg.y = 0 + 28;
            MyTools.getItemTxt(this.nickname, nicknameStr, 18, 0x2c8f93, 140, 20 + 3, 100, 22, 0, 0x276ba9, 'center');
        }
        this.btn1.texture = RES.getRes("MailC_item3_png");
        this.btn1.x = 295;
        this.btn1.y = 0;
        this.btn2.texture = RES.getRes("MailC_item4_png");
        this.btn2.x = 405;
        this.btn2.y = 0;
        this.btn1.touchEnabled = true;
        this.btn1.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.btn2.touchEnabled = true;
        this.btn2.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    };
    MailCItem.prototype.onTouchTap = function (e) {
        switch (e.currentTarget) {
            case this.btn1:
                MyTools.hintMethod('拒绝');
                break;
            case this.btn2:
                MyTools.hintMethod('同意');
                break;
            default:
                break;
        }
    };
    return MailCItem;
}(wy.ItemRenderer));
__reflect(MailCItem.prototype, "MailCItem");
