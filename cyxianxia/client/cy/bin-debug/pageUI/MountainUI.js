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
var MountainUI = (function (_super) {
    __extends(MountainUI, _super);
    function MountainUI() {
        var _this = _super.call(this) || this;
        _this.width = 750;
        _this.height = 1334;
        _this.createChildren();
        return _this;
    }
    MountainUI.prototype.createChildren = function () {
        this.mc = new egret.Bitmap(RES.getRes("mc_png"));
        this.mc.x = 0;
        this.mc.y = 0;
        this.addChild(this.mc);
        this.bg = new egret.Bitmap(RES.getRes("Mountain_bg_png"));
        this.bg.x = 0;
        this.bg.y = 280;
        this.addChild(this.bg);
        this.btn2_2 = new egret.Bitmap(RES.getRes("Mountain_btn2_2_png"));
        this.btn2_2.x = 386;
        this.btn2_2.y = 709;
        this.btn2_2.name = "btn";
        this.addChild(this.btn2_2);
        this.btn2_1 = new egret.Bitmap(RES.getRes("Mountain_btn2_1_png"));
        this.btn2_1.x = 166;
        this.btn2_1.y = 709;
        this.btn2_1.name = "btn";
        this.addChild(this.btn2_1);
        this.btn1_1 = new egret.Bitmap(RES.getRes("Mountain_btn1_1_png"));
        this.btn1_1.x = 162;
        this.btn1_1.y = 399;
        this.btn1_1.name = "btn";
        this.addChild(this.btn1_1);
        this.btn1_2 = new egret.Bitmap(RES.getRes("Mountain_btn1_2_png"));
        this.btn1_2.x = 345;
        this.btn1_2.y = 399;
        this.btn1_2.name = "btn";
        this.addChild(this.btn1_2);
        this.btn1_3 = new egret.Bitmap(RES.getRes("Mountain_btn1_3_png"));
        this.btn1_3.x = 524;
        this.btn1_3.y = 399;
        this.btn1_3.name = "btn";
        this.addChild(this.btn1_3);
        this.backBtn = new egret.Bitmap(RES.getRes("backBtn2_png"));
        this.backBtn.x = 655;
        this.backBtn.y = 329;
        this.backBtn.name = "btn";
        this.addChild(this.backBtn);
        //动画
    };
    return MountainUI;
}(wy.BaseSprite));
__reflect(MountainUI.prototype, "MountainUI");
