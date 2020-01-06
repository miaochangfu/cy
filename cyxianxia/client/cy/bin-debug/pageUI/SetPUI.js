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
var SetPUI = (function (_super) {
    __extends(SetPUI, _super);
    function SetPUI() {
        var _this = _super.call(this) || this;
        _this.width = 750;
        _this.height = 1334;
        _this.createChildren();
        return _this;
    }
    SetPUI.prototype.createChildren = function () {
        this.mc = new egret.Bitmap(RES.getRes("mc_png"));
        this.mc.x = 1;
        this.mc.y = 0;
        this.addChild(this.mc);
        this.ele = new egret.Bitmap(RES.getRes("SetP_ele_png"));
        this.ele.x = 68;
        this.ele.y = 371;
        this.addChild(this.ele);
        this.musciB_2 = new egret.Bitmap(RES.getRes("SetP_musicB_2_png"));
        this.musciB_2.x = 353;
        this.musciB_2.y = 563;
        this.addChild(this.musciB_2);
        this.musciB_1 = new egret.Bitmap(RES.getRes("SetP_musicB_1_png"));
        this.musciB_1.x = 433;
        this.musciB_1.y = 563;
        this.addChild(this.musciB_1);
        this.musciA_2 = new egret.Bitmap(RES.getRes("SetP_musicA_2_png"));
        this.musciA_2.x = 353;
        this.musciA_2.y = 501;
        this.addChild(this.musciA_2);
        this.musciA_1 = new egret.Bitmap(RES.getRes("SetP_musicA_1_png"));
        this.musciA_1.x = 433;
        this.musciA_1.y = 501;
        this.addChild(this.musciA_1);
        this.kfBtn = new egret.Bitmap(RES.getRes("SetP_kfBtn_png"));
        this.kfBtn.x = 340;
        this.kfBtn.y = 643;
        this.kfBtn.name = "btn";
        this.addChild(this.kfBtn);
        this.backBtn = new egret.Bitmap(RES.getRes("backBtn_png"));
        this.backBtn.x = 553;
        this.backBtn.y = 377;
        this.backBtn.name = "btn";
        this.addChild(this.backBtn);
        //动画
    };
    return SetPUI;
}(wy.BaseSprite));
__reflect(SetPUI.prototype, "SetPUI");
