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
var InfoAUI = (function (_super) {
    __extends(InfoAUI, _super);
    function InfoAUI() {
        var _this = _super.call(this) || this;
        _this.width = 750;
        _this.height = 1334;
        _this.createChildren();
        return _this;
    }
    InfoAUI.prototype.createChildren = function () {
        this.hbBtn = new egret.Bitmap(RES.getRes("InfoA_hbBtn_png"));
        this.hbBtn.x = 269;
        this.hbBtn.y = 1045;
        this.hbBtn.name = "btn";
        this.addChild(this.hbBtn);
        this.ele2 = new egret.Bitmap(RES.getRes("InfoA_ele2_png"));
        this.ele2.x = 104;
        this.ele2.y = 556;
        this.addChild(this.ele2);
        this.sex1 = new egret.Bitmap(RES.getRes("InfoA_sex1_png"));
        this.sex1.x = 358;
        this.sex1.y = 721;
        this.addChild(this.sex1);
        this.sex0 = new egret.Bitmap(RES.getRes("InfoA_sex0_png"));
        this.sex0.x = 436;
        this.sex0.y = 721;
        this.addChild(this.sex0);
        this.bestScore = new egret.TextField();
        this.bestScore.text = "label";
        this.bestScore.textAlign = "center";
        this.bestScore.size = 27;
        this.bestScore.textColor = 0xffffff;
        this.bestScore.x = 225;
        this.bestScore.y = 626;
        this.bestScore.width = 300;
        this.bestScore.height = 30;
        this.addChild(this.bestScore);
        this.txt2 = new egret.TextField();
        this.txt2.text = "label";
        this.txt2.textAlign = "center";
        this.txt2.size = 25;
        this.txt2.textColor = 0xffff4b;
        this.txt2.x = 293;
        this.txt2.y = 852;
        this.txt2.width = 190;
        this.txt2.height = 28;
        this.addChild(this.txt2);
        this.txt1 = new egret.TextField();
        this.txt1.text = "label";
        this.txt1.textAlign = "center";
        this.txt1.size = 25;
        this.txt1.textColor = 0xffff4b;
        this.txt1.x = 293;
        this.txt1.y = 795;
        this.txt1.width = 190;
        this.txt1.height = 28;
        this.addChild(this.txt1);
        this.txt4 = new egret.TextField();
        this.txt4.text = "3";
        this.txt4.textAlign = "center";
        this.txt4.size = 18;
        this.txt4.textColor = 0xffffff;
        this.txt4.x = 470;
        this.txt4.y = 962;
        this.txt4.width = 20;
        this.txt4.height = 20;
        this.addChild(this.txt4);
        this.txt3 = new egret.TextField();
        this.txt3.text = "3";
        this.txt3.textAlign = "center";
        this.txt3.size = 18;
        this.txt3.textColor = 0xffffff;
        this.txt3.x = 344;
        this.txt3.y = 961;
        this.txt3.width = 20;
        this.txt3.height = 20;
        this.addChild(this.txt3);
        this.ele1 = new egret.Bitmap(RES.getRes("InfoA_ele1_png"));
        this.ele1.x = 235;
        this.ele1.y = 223;
        this.addChild(this.ele1);
        this.nickname = new egret.TextField();
        this.nickname.text = "label";
        this.nickname.textAlign = "center";
        this.nickname.size = 18;
        this.nickname.textColor = 0xffffff;
        this.nickname.x = 300;
        this.nickname.y = 394;
        this.nickname.width = 150;
        this.nickname.height = 21;
        this.addChild(this.nickname);
        this.headBit = new egret.Bitmap(RES.getRes("InfoA_headBit_png"));
        this.headBit.x = 322;
        this.headBit.y = 269;
        this.addChild(this.headBit);
        //动画
    };
    return InfoAUI;
}(wy.BaseSprite));
__reflect(InfoAUI.prototype, "InfoAUI");
