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
var MailCUI = (function (_super) {
    __extends(MailCUI, _super);
    function MailCUI() {
        var _this = _super.call(this) || this;
        _this.width = 750;
        _this.height = 1334;
        _this.createChildren();
        return _this;
    }
    MailCUI.prototype.createChildren = function () {
        this.mc = new egret.Bitmap(RES.getRes("mc_png"));
        this.mc.x = 0;
        this.mc.y = 0;
        this.addChild(this.mc);
        this.bg = new egret.Bitmap(RES.getRes("Mail_bg_png"));
        this.bg.x = 43;
        this.bg.y = 218;
        this.addChild(this.bg);
        this.btn1 = new egret.Bitmap(RES.getRes("Mail_btn1_png"));
        this.btn1.x = 98;
        this.btn1.y = 269;
        this.btn1.name = "btn";
        this.addChild(this.btn1);
        this.btn2 = new egret.Bitmap(RES.getRes("Mail_btn2_png"));
        this.btn2.x = 98;
        this.btn2.y = 350;
        this.btn2.name = "btn";
        this.addChild(this.btn2);
        this.btn3 = new egret.Bitmap(RES.getRes("Mail_btn3_png"));
        this.btn3.x = 98;
        this.btn3.y = 429;
        this.btn3.alpha = 0;
        this.btn3.name = "btn";
        this.addChild(this.btn3);
        this.bgC = new egret.Bitmap(RES.getRes("Mail_bgC_png"));
        this.bgC.x = 71;
        this.bgC.y = 429;
        this.addChild(this.bgC);
        this.backBtn = new egret.Bitmap(RES.getRes("backBtn_png"));
        this.backBtn.x = 630;
        this.backBtn.y = 195;
        this.backBtn.name = "btn";
        this.addChild(this.backBtn);
        this.theme = new egret.Bitmap(RES.getRes("Mail_theme_png"));
        this.theme.x = 26;
        this.theme.y = 191;
        this.addChild(this.theme);
        //动画
    };
    return MailCUI;
}(wy.BaseSprite));
__reflect(MailCUI.prototype, "MailCUI");
