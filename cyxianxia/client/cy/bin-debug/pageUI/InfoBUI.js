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
 *
 *
 *自动生成类
 *
 *请不要直接在此编码  重新生成会覆盖此类的
 *
 *如非必要请勿改动
 *
 *
 */
var InfoBUI = (function (_super) {
    __extends(InfoBUI, _super);
    function InfoBUI() {
        var _this = _super.call(this) || this;
        _this.width = 750;
        _this.height = 1334;
        _this.createChildren();
        return _this;
    }
    InfoBUI.prototype.createChildren = function () {
        this.pop0 = new egret.Bitmap(RES.getRes("InfoB_pop0_png"));
        this.pop0.x = 137;
        this.pop0.y = 541;
        this.addChild(this.pop0);
        this.pop1 = new egret.Bitmap(RES.getRes("InfoB_pop1_png"));
        this.pop1.x = 176;
        this.pop1.y = 687;
        this.addChild(this.pop1);
        this.pop2 = new egret.Bitmap(RES.getRes("InfoB_pop2_png"));
        this.pop2.x = 426;
        this.pop2.y = 689;
        this.addChild(this.pop2);
        //动画
    };
    return InfoBUI;
}(wy.BaseSprite));
__reflect(InfoBUI.prototype, "InfoBUI");
