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
var WelfareUI = (function (_super) {
    __extends(WelfareUI, _super);
    function WelfareUI() {
        var _this = _super.call(this) || this;
        _this.width = 750;
        _this.height = 1334;
        _this.createChildren();
        return _this;
    }
    WelfareUI.prototype.createChildren = function () {
        this.mc = new egret.Bitmap(RES.getRes("mc_png"));
        this.mc.x = 0;
        this.mc.y = 0;
        this.addChild(this.mc);
        this.bg = new egret.Bitmap(RES.getRes("Welfare_bg_png"));
        this.bg.x = 15;
        this.bg.y = 202;
        this.addChild(this.bg);
        this.btn1 = new egret.Bitmap(RES.getRes("Welfare_btn1_1_png"));
        this.btn1.x = 113;
        this.btn1.y = 299;
        this.btn1.name = "btn";
        this.addChild(this.btn1);
        this.btn2 = new egret.Bitmap(RES.getRes("Welfare_btn2_1_png"));
        this.btn2.x = 387;
        this.btn2.y = 299;
        this.btn2.name = "btn";
        this.addChild(this.btn2);
        this.backBtn = new egret.Bitmap(RES.getRes("Welfare_backBtn_png"));
        this.backBtn.x = 654;
        this.backBtn.y = 267;
        this.backBtn.name = "btn";
        this.addChild(this.backBtn);
        //动画
    };
    return WelfareUI;
}(wy.BaseSprite));
__reflect(WelfareUI.prototype, "WelfareUI");
