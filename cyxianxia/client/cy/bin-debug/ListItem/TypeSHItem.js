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
var TypeSHItem = (function (_super) {
    __extends(TypeSHItem, _super);
    function TypeSHItem() {
        var _this = _super.call(this) || this;
        _this.init();
        return _this;
    }
    TypeSHItem.prototype.init = function () {
        this.bottomImg = new egret.Bitmap();
        this.addChild(this.bottomImg);
        this.taskTxt = new egret.TextField();
        this.addChild(this.taskTxt);
        this.goldImg = new egret.Bitmap();
        this.addChild(this.goldImg);
        this.btn = new egret.Bitmap();
        this.addChild(this.btn);
    };
    TypeSHItem.prototype.dataChanged = function (data) {
        _super.prototype.dataChanged.call(this);
        this.bottomImg.texture = RES.getRes("TypeSH_item4_png");
        this.bottomImg.x = -46;
        this.bottomImg.y = 0;
        MyTools.getItemTxt(this.taskTxt, 'this.data.name', 23, 0xffffff, 151 - 46, 342 + 5, 70, 25, 0, 0x276ba9, 'left');
        var type = 1;
        if (type == 1) {
            this.goldImg.texture = RES.getRes("TypeSH_item2_png");
        }
        else {
            this.goldImg.texture = RES.getRes("TypeSH_item3_png");
        }
        this.goldImg.x = 108 - 46;
        this.goldImg.y = 336;
        this.btn.texture = RES.getRes("TypeSH_item1_png");
        this.btn.x = 88 - 46;
        this.btn.y = 324;
        this.btn.touchEnabled = true;
        this.btn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    };
    TypeSHItem.prototype.onTouchTap = function (e) {
        switch (e.currentTarget) {
            case this.btn:
                MyTools.hintMethod('click');
                break;
            default:
                break;
        }
    };
    return TypeSHItem;
}(wy.ItemRenderer));
__reflect(TypeSHItem.prototype, "TypeSHItem");
