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
var InfoCItem = (function (_super) {
    __extends(InfoCItem, _super);
    function InfoCItem() {
        var _this = _super.call(this) || this;
        _this.init();
        return _this;
    }
    InfoCItem.prototype.init = function () {
        this.bottomImg = new egret.Bitmap();
        this.addChild(this.bottomImg);
        this.headImg = new wy.HeadImg(38, true, 80, 80);
        this.addChild(this.headImg);
        this.nickname = new egret.TextField();
        this.addChild(this.nickname);
        this.chooseImg = new egret.Bitmap();
        this.addChild(this.chooseImg);
    };
    InfoCItem.prototype.dataChanged = function (data) {
        _super.prototype.dataChanged.call(this);
        this.bottomImg.texture = RES.getRes("InfoC_item1_png");
        this.bottomImg.x = 0;
        this.bottomImg.y = 0;
        if (this.data.img) {
            this.headImg.source = this.data.img;
        }
        else {
            this.headImg.source = StaticVar.defaultHeadImgUrl;
        }
        this.headImg.x = 63 + 38;
        this.headImg.y = 17 + 38;
        if (this.data.name == '' || this.data.name == 'null' || this.data.name == null || this.data.name == undefined
            || (this.data.name.length > 0 && this.data.name.trim().length == 0)) {
            MyTools.getItemTxt(this.nickname, '游客', 29, 0xffffff, 170, 41 + 5, 180, 32, 0, 0x276ba9, 'left');
        }
        else {
            MyTools.getItemTxt(this.nickname, this.data.name, 29, 0xffffff, 170, 41 + 5, 180, 32, 0, 0x276ba9, 'left');
        }
        this.chooseImg.texture = RES.getRes("InfoC_item2_png");
        this.chooseImg.x = 500;
        this.chooseImg.y = 0;
        this.touchEnabled = true;
        this.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    };
    InfoCItem.prototype.onTouchTap = function (e) {
        switch (e.currentTarget) {
            case this:
                this.bottomImg.texture = RES.getRes("InfoC_item2_png");
                break;
            default:
                break;
        }
    };
    return InfoCItem;
}(wy.ItemRenderer));
__reflect(InfoCItem.prototype, "InfoCItem");
