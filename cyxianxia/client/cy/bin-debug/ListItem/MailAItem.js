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
 *  流水
 */
var MailAItem = (function (_super) {
    __extends(MailAItem, _super);
    function MailAItem() {
        var _this = _super.call(this) || this;
        _this.init();
        return _this;
    }
    MailAItem.prototype.init = function () {
        this.lsTxt = new egret.TextField();
        this.addChild(this.lsTxt);
    };
    MailAItem.prototype.dataChanged = function (data) {
        _super.prototype.dataChanged.call(this);
        MyTools.getItemTxt(this.lsTxt, 'this.data.name', 20, 0x000000, 0, 5, 500, 25, 0, 0x276ba9, 'left');
    };
    return MailAItem;
}(wy.ItemRenderer));
__reflect(MailAItem.prototype, "MailAItem");
