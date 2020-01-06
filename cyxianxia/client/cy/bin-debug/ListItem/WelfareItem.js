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
var WelfareItem = (function (_super) {
    __extends(WelfareItem, _super);
    function WelfareItem() {
        var _this = _super.call(this) || this;
        _this.init();
        return _this;
    }
    WelfareItem.prototype.init = function () {
        this.bottomImg = new egret.Bitmap();
        this.addChild(this.bottomImg);
        this.taskTxt = new egret.TextField();
        this.addChild(this.taskTxt);
        this.goldImg = new egret.Bitmap();
        this.addChild(this.goldImg);
        this.btn = new egret.Bitmap();
        this.addChild(this.btn);
    };
    WelfareItem.prototype.dataChanged = function (data) {
        _super.prototype.dataChanged.call(this);
        this.bottomImg.texture = RES.getRes("Welfare_item0_png");
        this.bottomImg.x = 0;
        this.bottomImg.y = 56;
        MyTools.getItemTxt(this.taskTxt, 'this.data.name', 23, 0xffffff, 19, 16 + 5, 180, 25, 0, 0x276ba9, 'left');
        this.goldImg.texture = RES.getRes("Welfare_item9_png");
        this.goldImg.x = 290;
        this.goldImg.y = 5;
        this.btn.texture = RES.getRes("Welfare_item1_png");
        this.btn.x = 405;
        this.btn.y = 0;
        this.btn.touchEnabled = true;
        this.btn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    };
    WelfareItem.prototype.onTouchTap = function (e) {
        switch (e.currentTarget) {
            case this.btn:
                MyTools.hintMethod('click');
                break;
            default:
                break;
        }
    };
    return WelfareItem;
}(wy.ItemRenderer));
__reflect(WelfareItem.prototype, "WelfareItem");
