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
var InfoBItem = (function (_super) {
    __extends(InfoBItem, _super);
    function InfoBItem() {
        var _this = _super.call(this) || this;
        _this.init();
        return _this;
    }
    InfoBItem.prototype.init = function () {
        this.bottomImg = new egret.Bitmap();
        this.addChild(this.bottomImg);
        this.zbImg = new egret.Bitmap();
        this.addChild(this.zbImg);
        this.chooseImg = new egret.Bitmap();
        this.addChild(this.chooseImg);
    };
    InfoBItem.prototype.dataChanged = function (data) {
        _super.prototype.dataChanged.call(this);
        this.bottomImg.texture = RES.getRes("InfoB_item1_png");
        this.bottomImg.x = 0;
        this.bottomImg.y = 0;
        this.zbImg.texture = RES.getRes("InfoB_item4_png");
        this.zbImg.x = 52;
        this.zbImg.y = 9;
        this.chooseImg.texture = RES.getRes("InfoB_item3_png");
        this.chooseImg.x = 172;
        this.chooseImg.y = 0;
        this.touchEnabled = true;
        this.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    };
    InfoBItem.prototype.onTouchTap = function (e) {
        switch (e.currentTarget) {
            case this:
                this.bottomImg.texture = RES.getRes("InfoB_item2_png");
                break;
            default:
                break;
        }
    };
    return InfoBItem;
}(wy.ItemRenderer));
__reflect(InfoBItem.prototype, "InfoBItem");
