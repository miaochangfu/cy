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
var GameFMUI = (function (_super) {
    __extends(GameFMUI, _super);
    function GameFMUI() {
        var _this = _super.call(this) || this;
        _this.width = 624;
        _this.height = 432;
        _this.createChildren();
        return _this;
    }
    GameFMUI.prototype.createChildren = function () {
        this.bg = new egret.Bitmap(RES.getRes("GameFM_bg_png"));
        this.bg.x = 0;
        this.bg.y = 0;
        this.addChild(this.bg);
        this.timeTxt = new egret.TextField();
        this.timeTxt.text = "label";
        this.timeTxt.textAlign = "center";
        this.timeTxt.size = 30;
        this.timeTxt.textColor = 0xffffff;
        this.timeTxt.x = 253;
        this.timeTxt.y = 32;
        this.timeTxt.width = 100;
        this.timeTxt.height = 34;
        this.addChild(this.timeTxt);
        this.eleImg1 = new egret.Bitmap(RES.getRes("GameFM_eleImgB_png"));
        this.eleImg1.x = 230;
        this.eleImg1.y = 104;
        this.addChild(this.eleImg1);
        this.eleImg2 = new egret.Bitmap(RES.getRes("GameFM_eleImgB_png"));
        this.eleImg2.x = 317;
        this.eleImg2.y = 104;
        this.addChild(this.eleImg2);
        this.eleImg3 = new egret.Bitmap(RES.getRes("GameFM_eleImgB_png"));
        this.eleImg3.x = 405;
        this.eleImg3.y = 104;
        this.addChild(this.eleImg3);
        this.eleImg0 = new egret.Bitmap(RES.getRes("GameFM_eleImgA_png"));
        this.eleImg0.x = 143;
        this.eleImg0.y = 104;
        this.addChild(this.eleImg0);
        this.chooseA = new egret.Bitmap(RES.getRes("GameFM_eleImgC_png"));
        this.chooseA.x = 180;
        this.chooseA.y = 232;
        this.addChild(this.chooseA);
        this.chooseB = new egret.Bitmap(RES.getRes("GameFM_eleImgC_png"));
        this.chooseB.x = 342;
        this.chooseB.y = 232;
        this.addChild(this.chooseB);
        //动画
    };
    return GameFMUI;
}(wy.BaseSprite));
__reflect(GameFMUI.prototype, "GameFMUI");
