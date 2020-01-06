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
var ResultSUI = (function (_super) {
    __extends(ResultSUI, _super);
    function ResultSUI() {
        var _this = _super.call(this) || this;
        _this.width = 750;
        _this.height = 1334;
        _this.createChildren();
        return _this;
    }
    ResultSUI.prototype.createChildren = function () {
        this.mc = new egret.Bitmap(RES.getRes("mc_png"));
        this.mc.x = 0;
        this.mc.y = 0;
        this.addChild(this.mc);
        this.bg = new egret.Bitmap(RES.getRes("ResultS_bg_png"));
        this.bg.x = 46;
        this.bg.y = 217;
        this.addChild(this.bg);
        this.txt3 = new egret.TextField();
        this.txt3.text = "label";
        this.txt3.textAlign = "left";
        this.txt3.size = 26;
        this.txt3.textColor = 0xfff17a;
        this.txt3.x = 386;
        this.txt3.y = 628;
        this.txt3.width = 150;
        this.txt3.height = 29;
        this.addChild(this.txt3);
        this.txt2 = new egret.TextField();
        this.txt2.text = "label";
        this.txt2.textAlign = "left";
        this.txt2.size = 26;
        this.txt2.textColor = 0xfff17a;
        this.txt2.x = 386;
        this.txt2.y = 546;
        this.txt2.width = 150;
        this.txt2.height = 29;
        this.addChild(this.txt2);
        this.txt1 = new egret.TextField();
        this.txt1.text = "label";
        this.txt1.textAlign = "center";
        this.txt1.size = 50;
        this.txt1.textColor = 0xffffff;
        this.txt1.x = 227;
        this.txt1.y = 391;
        this.txt1.width = 300;
        this.txt1.height = 51;
        this.addChild(this.txt1);
        this.theme = new egret.Bitmap(RES.getRes("ResultS_theme_png"));
        this.theme.x = 263;
        this.theme.y = 261;
        this.addChild(this.theme);
        this.btn3 = new egret.Bitmap(RES.getRes("ResultS_btn3_png"));
        this.btn3.x = 244;
        this.btn3.y = 994;
        this.btn3.name = "btn";
        this.addChild(this.btn3);
        this.btn2 = new egret.Bitmap(RES.getRes("ResultS_btn2_png"));
        this.btn2.x = 398;
        this.btn2.y = 780;
        this.btn2.name = "btn";
        this.addChild(this.btn2);
        this.btn1 = new egret.Bitmap(RES.getRes("ResultS_btn1_png"));
        this.btn1.x = 109;
        this.btn1.y = 780;
        this.btn1.name = "btn";
        this.addChild(this.btn1);
        //动画
    };
    return ResultSUI;
}(wy.BaseSprite));
__reflect(ResultSUI.prototype, "ResultSUI");
