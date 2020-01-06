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
var HomeUI = (function (_super) {
    __extends(HomeUI, _super);
    function HomeUI() {
        var _this = _super.call(this) || this;
        _this.width = 750;
        _this.height = 1334;
        _this.createChildren();
        return _this;
    }
    HomeUI.prototype.createChildren = function () {
        this.bg = new egret.Bitmap(RES.getRes("Home_bg_jpg"));
        this.bg.x = 0;
        this.bg.y = 0;
        this.addChild(this.bg);
        this.ele1 = new egret.Bitmap(RES.getRes("Home_ele1_png"));
        this.ele1.x = 0;
        this.ele1.y = 349;
        this.addChild(this.ele1);
        this.ele3 = new egret.Bitmap(RES.getRes("Home_ele3_png"));
        this.ele3.x = 227;
        this.ele3.y = 1042;
        this.addChild(this.ele3);
        this.ele2 = new egret.Bitmap(RES.getRes("Home_ele2_png"));
        this.ele2.x = 148;
        this.ele2.y = 944;
        this.addChild(this.ele2);
        this.sgTxt = new egret.TextField();
        this.sgTxt.text = "label";
        this.sgTxt.textAlign = "center";
        this.sgTxt.size = 23;
        this.sgTxt.textColor = 0xffffff;
        this.sgTxt.x = 260;
        this.sgTxt.y = 1064;
        this.sgTxt.width = 230;
        this.sgTxt.height = 25;
        this.addChild(this.sgTxt);
        this.startBtn = new egret.Bitmap(RES.getRes("Home_startBtn_png"));
        this.startBtn.x = 209;
        this.startBtn.y = 1102;
        this.startBtn.name = "btn";
        this.addChild(this.startBtn);
        this.ele4 = new egret.Bitmap(RES.getRes("Home_ele4_png"));
        this.ele4.x = 151;
        this.ele4.y = 547;
        this.addChild(this.ele4);
        this.ele5 = new egret.Bitmap(RES.getRes("Home_ele5_png"));
        this.ele5.x = 155;
        this.ele5.y = 608;
        this.addChild(this.ele5);
        this.ybImg = new egret.Bitmap(RES.getRes("Home_ybImg_png"));
        this.ybImg.x = 24;
        this.ybImg.y = 38;
        this.addChild(this.ybImg);
        this.ybTxt = new egret.TextField();
        this.ybTxt.text = "label";
        this.ybTxt.textAlign = "center";
        this.ybTxt.size = 25;
        this.ybTxt.textColor = 0xffff4b;
        this.ybTxt.x = 86;
        this.ybTxt.y = 50;
        this.ybTxt.width = 150;
        this.ybTxt.height = 28;
        this.addChild(this.ybTxt);
        this.tlImg = new egret.Bitmap(RES.getRes("Home_tlImg_png"));
        this.tlImg.x = 31;
        this.tlImg.y = 88;
        this.addChild(this.tlImg);
        this.tlTxt = new egret.TextField();
        this.tlTxt.text = "label";
        this.tlTxt.textAlign = "center";
        this.tlTxt.size = 25;
        this.tlTxt.textColor = 0xffff4b;
        this.tlTxt.x = 86;
        this.tlTxt.y = 107;
        this.tlTxt.width = 150;
        this.tlTxt.height = 28;
        this.addChild(this.tlTxt);
        this.leftBtn2 = new egret.Bitmap(RES.getRes("Home_leftBtn2_png"));
        this.leftBtn2.x = 24;
        this.leftBtn2.y = 789;
        this.leftBtn2.name = "btn";
        this.addChild(this.leftBtn2);
        this.leftBtn1 = new egret.Bitmap(RES.getRes("Home_leftBtn1_png"));
        this.leftBtn1.x = 24;
        this.leftBtn1.y = 654;
        this.leftBtn1.name = "btn";
        this.addChild(this.leftBtn1);
        this.leftBtn3 = new egret.Bitmap(RES.getRes("Home_leftBtn3_png"));
        this.leftBtn3.x = 24;
        this.leftBtn3.y = 922;
        this.leftBtn3.name = "btn";
        this.addChild(this.leftBtn3);
        this.leftBtn4 = new egret.Bitmap(RES.getRes("Home_leftBtn4_png"));
        this.leftBtn4.x = 24;
        this.leftBtn4.y = 1054;
        this.leftBtn4.name = "btn";
        this.addChild(this.leftBtn4);
        this.rightBtn1 = new egret.Bitmap(RES.getRes("Home_rightBtn1_png"));
        this.rightBtn1.x = 607;
        this.rightBtn1.y = 654;
        this.rightBtn1.name = "btn";
        this.addChild(this.rightBtn1);
        this.rightBtn2 = new egret.Bitmap(RES.getRes("Home_rightBtn2_png"));
        this.rightBtn2.x = 607;
        this.rightBtn2.y = 789;
        this.rightBtn2.name = "btn";
        this.addChild(this.rightBtn2);
        this.rightBtn3 = new egret.Bitmap(RES.getRes("Home_rightBtn3_png"));
        this.rightBtn3.x = 606;
        this.rightBtn3.y = 922;
        this.rightBtn3.name = "btn";
        this.addChild(this.rightBtn3);
        this.rightBtn4 = new egret.Bitmap(RES.getRes("Home_rightBtn4_png"));
        this.rightBtn4.x = 607;
        this.rightBtn4.y = 1054;
        this.rightBtn4.name = "btn";
        this.addChild(this.rightBtn4);
        this.person = new egret.Bitmap(RES.getRes("Home_person_png"));
        this.person.x = 188;
        this.person.y = 378;
        this.addChild(this.person);
        this.pet = new egret.Bitmap(RES.getRes("Home_pet_png"));
        this.pet.x = 420;
        this.pet.y = 727;
        this.addChild(this.pet);
        this.hintRed = new egret.Bitmap(RES.getRes("Home_hintRed_png"));
        this.hintRed.x = 685;
        this.hintRed.y = 676;
        this.addChild(this.hintRed);
        //动画
    };
    return HomeUI;
}(wy.BaseSprite));
__reflect(HomeUI.prototype, "HomeUI");
