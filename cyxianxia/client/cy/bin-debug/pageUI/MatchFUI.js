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
var MatchFUI = (function (_super) {
    __extends(MatchFUI, _super);
    function MatchFUI() {
        var _this = _super.call(this) || this;
        _this.width = 750;
        _this.height = 1334;
        _this.createChildren();
        return _this;
    }
    MatchFUI.prototype.createChildren = function () {
        this.bg = new egret.Bitmap(RES.getRes("MatchF_bg_jpg"));
        this.bg.x = 0;
        this.bg.y = 0;
        this.addChild(this.bg);
        this.matchImg = new egret.Bitmap(RES.getRes("MatchF_matchImg_png"));
        this.matchImg.x = 245;
        this.matchImg.y = 547;
        this.addChild(this.matchImg);
        this.timeTxt = new egret.TextField();
        this.timeTxt.text = "30s";
        this.timeTxt.textAlign = "left";
        this.timeTxt.size = 39;
        this.timeTxt.textColor = 0xf6d562;
        this.timeTxt.x = 412;
        this.timeTxt.y = 707;
        this.timeTxt.width = 105;
        this.timeTxt.height = 39;
        this.timeTxt.stroke = 2;
        this.timeTxt.strokeColor = 0x87785d;
        this.addChild(this.timeTxt);
        this.themeK = new egret.Bitmap(RES.getRes("MatchF_themeK_png"));
        this.themeK.x = 245;
        this.themeK.y = 19;
        this.addChild(this.themeK);
        this.theme1 = new egret.Bitmap(RES.getRes("MatchF_theme1_png"));
        this.theme1.x = 289;
        this.theme1.y = 42;
        this.addChild(this.theme1);
        this.theme2 = new egret.Bitmap(RES.getRes("MatchF_theme2_png"));
        this.theme2.x = 289;
        this.theme2.y = 41;
        this.addChild(this.theme2);
        this.backBtn = new egret.Bitmap(RES.getRes("backBtn_png"));
        this.backBtn.x = 19;
        this.backBtn.y = 18;
        this.backBtn.name = "btn";
        this.addChild(this.backBtn);
        //动画
    };
    return MatchFUI;
}(wy.BaseSprite));
__reflect(MatchFUI.prototype, "MatchFUI");
