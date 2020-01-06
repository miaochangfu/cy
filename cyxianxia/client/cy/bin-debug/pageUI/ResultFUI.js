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
var ResultFUI = (function (_super) {
    __extends(ResultFUI, _super);
    function ResultFUI() {
        var _this = _super.call(this) || this;
        _this.width = 750;
        _this.height = 1334;
        _this.createChildren();
        return _this;
    }
    ResultFUI.prototype.createChildren = function () {
        this.mc = new egret.Bitmap(RES.getRes("mc_png"));
        this.mc.x = 0;
        this.mc.y = 0;
        this.addChild(this.mc);
        this.bg = new egret.Bitmap(RES.getRes("ResultF_bg_png"));
        this.bg.x = 46;
        this.bg.y = 216;
        this.addChild(this.bg);
        this.txt3 = new egret.TextField();
        this.txt3.text = "label";
        this.txt3.textAlign = "left";
        this.txt3.size = 23;
        this.txt3.textColor = 0xfff17a;
        this.txt3.x = 378;
        this.txt3.y = 897;
        this.txt3.width = 150;
        this.txt3.height = 25;
        this.addChild(this.txt3);
        this.txt2 = new egret.TextField();
        this.txt2.text = "label";
        this.txt2.textAlign = "left";
        this.txt2.size = 23;
        this.txt2.textColor = 0xfff17a;
        this.txt2.x = 378;
        this.txt2.y = 858;
        this.txt2.width = 150;
        this.txt2.height = 25;
        this.addChild(this.txt2);
        this.txt1 = new egret.TextField();
        this.txt1.text = "label";
        this.txt1.textAlign = "left";
        this.txt1.size = 29;
        this.txt1.textColor = 0xffffff;
        this.txt1.x = 378;
        this.txt1.y = 812;
        this.txt1.width = 150;
        this.txt1.height = 32;
        this.addChild(this.txt1);
        this.btn1 = new egret.Bitmap(RES.getRes("ResultF_btn1_png"));
        this.btn1.x = 109;
        this.btn1.y = 1063;
        this.btn1.name = "btn";
        this.addChild(this.btn1);
        this.btn2 = new egret.Bitmap(RES.getRes("ResultF_btn2_png"));
        this.btn2.x = 398;
        this.btn2.y = 1063;
        this.btn2.name = "btn";
        this.addChild(this.btn2);
        this.win1 = new egret.Bitmap(RES.getRes("ResultF_win1_png"));
        this.win1.x = 71;
        this.win1.y = 357;
        this.addChild(this.win1);
        this.win0 = new egret.Bitmap(RES.getRes("ResultF_win0_png"));
        this.win0.x = 73;
        this.win0.y = 585;
        this.addChild(this.win0);
        this.theme2 = new egret.Bitmap(RES.getRes("ResultF_theme2_png"));
        this.theme2.x = 257;
        this.theme2.y = 238;
        this.addChild(this.theme2);
        this.theme1 = new egret.Bitmap(RES.getRes("ResultF_theme1_png"));
        this.theme1.x = 255;
        this.theme1.y = 238;
        this.addChild(this.theme1);
        //动画
    };
    return ResultFUI;
}(wy.BaseSprite));
__reflect(ResultFUI.prototype, "ResultFUI");
