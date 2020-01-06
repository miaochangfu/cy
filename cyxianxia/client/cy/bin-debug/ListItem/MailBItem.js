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
var MailBItem = (function (_super) {
    __extends(MailBItem, _super);
    function MailBItem() {
        var _this = _super.call(this) || this;
        _this.init();
        return _this;
    }
    MailBItem.prototype.init = function () {
        this.bottomImg = new egret.Bitmap();
        this.addChild(this.bottomImg);
        this.lsTxt = new egret.TextField();
        this.addChild(this.lsTxt);
    };
    MailBItem.prototype.dataChanged = function (data) {
        _super.prototype.dataChanged.call(this);
        this.bottomImg.texture = RES.getRes("MailB_line_png");
        this.bottomImg.x = 0;
        this.bottomImg.y = 42;
        MyTools.getItemTxt(this.lsTxt, 'this.data.name', 20, 0x000000, 0, 0, 500, 25, 0, 0x276ba9, 'left');
    };
    return MailBItem;
}(wy.ItemRenderer));
__reflect(MailBItem.prototype, "MailBItem");
