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
var TypeSHUI = (function (_super) {
    __extends(TypeSHUI, _super);
    function TypeSHUI() {
        var _this = _super.call(this) || this;
        _this.width = 750;
        _this.height = 1334;
        _this.createChildren();
        return _this;
    }
    TypeSHUI.prototype.createChildren = function () {
        this.mc = new egret.Bitmap(RES.getRes("mc_png"));
        this.mc.x = 0;
        this.mc.y = 0;
        this.addChild(this.mc);
        this.bg = new egret.Bitmap(RES.getRes("TypeSH_bg_png"));
        this.bg.x = 0;
        this.bg.y = 35;
        this.addChild(this.bg);
        this.sex1 = new egret.Bitmap(RES.getRes("TypeSH_sex1_png"));
        this.sex1.x = 118;
        this.sex1.y = 252;
        this.addChild(this.sex1);
        this.sex0 = new egret.Bitmap(RES.getRes("TypeSH_sex0_png"));
        this.sex0.x = 243;
        this.sex0.y = 251;
        this.addChild(this.sex0);
        this.circle2 = new egret.Bitmap(RES.getRes("TypeSH_circle1_png"));
        this.circle2.x = 289;
        this.circle2.y = 258;
        this.addChild(this.circle2);
        this.circle1 = new egret.Bitmap(RES.getRes("TypeSH_circle1_png"));
        this.circle1.x = 159;
        this.circle1.y = 258;
        this.addChild(this.circle1);
        this.btn1_1 = new egret.Bitmap(RES.getRes("TypeSH_btn1_1_png"));
        this.btn1_1.x = 84;
        this.btn1_1.y = 184;
        this.btn1_1.name = "btn";
        this.addChild(this.btn1_1);
        this.btn2_1 = new egret.Bitmap(RES.getRes("TypeSH_btn2_1_png"));
        this.btn2_1.x = 235;
        this.btn2_1.y = 184;
        this.btn2_1.name = "btn";
        this.addChild(this.btn2_1);
        this.btn2_2 = new egret.Bitmap(RES.getRes("TypeSH_btn2_2_png"));
        this.btn2_2.x = 176;
        this.btn2_2.y = 180;
        this.btn2_2.name = "btn";
        this.addChild(this.btn2_2);
        this.btn1_2 = new egret.Bitmap(RES.getRes("TypeSH_btn1_2_png"));
        this.btn1_2.x = 28;
        this.btn1_2.y = 180;
        this.btn1_2.name = "btn";
        this.addChild(this.btn1_2);
        this.backBtn = new egret.TextField();
        this.backBtn.text = "";
        this.backBtn.x = 676;
        this.backBtn.y = 147;
        this.backBtn.width = 60;
        this.backBtn.height = 60;
        this.addChild(this.backBtn);
        //动画
    };
    return TypeSHUI;
}(wy.BaseSprite));
__reflect(TypeSHUI.prototype, "TypeSHUI");
