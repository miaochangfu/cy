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
var Game0UI = (function (_super) {
    __extends(Game0UI, _super);
    function Game0UI() {
        var _this = _super.call(this) || this;
        _this.width = 750;
        _this.height = 1334;
        _this.createChildren();
        return _this;
    }
    Game0UI.prototype.createChildren = function () {
        this.game0_0 = new egret.Bitmap(RES.getRes("Game_rectImg0_png"));
        this.game0_0.x = 59;
        this.game0_0.y = 301;
        this.addChild(this.game0_0);
        this.game0_1 = new egret.Bitmap(RES.getRes("Game_rectImg0_png"));
        this.game0_1.x = 149;
        this.game0_1.y = 301;
        this.addChild(this.game0_1);
        this.game0_2 = new egret.Bitmap(RES.getRes("Game_rectImg0_png"));
        this.game0_2.x = 241;
        this.game0_2.y = 301;
        this.addChild(this.game0_2);
        this.game0_7 = new egret.Bitmap(RES.getRes("Game_rectImg0_png"));
        this.game0_7.x = 240;
        this.game0_7.y = 468;
        this.addChild(this.game0_7);
        this.game0_6 = new egret.Bitmap(RES.getRes("Game_rectImg0_png"));
        this.game0_6.x = 330;
        this.game0_6.y = 469;
        this.addChild(this.game0_6);
        this.game0_5 = new egret.Bitmap(RES.getRes("Game_rectImg0_png"));
        this.game0_5.x = 330;
        this.game0_5.y = 385;
        this.addChild(this.game0_5);
        this.game0_3 = new egret.Bitmap(RES.getRes("Game_rectImg0_png"));
        this.game0_3.x = 330;
        this.game0_3.y = 301;
        this.addChild(this.game0_3);
        this.game0_4 = new egret.Bitmap(RES.getRes("Game_rectImg0_png"));
        this.game0_4.x = 330;
        this.game0_4.y = 219;
        this.addChild(this.game0_4);
        this.game0_8 = new egret.Bitmap(RES.getRes("Game_rectImg0_png"));
        this.game0_8.x = 421;
        this.game0_8.y = 469;
        this.addChild(this.game0_8);
        this.game0_10 = new egret.Bitmap(RES.getRes("Game_rectImg0_png"));
        this.game0_10.x = 512;
        this.game0_10.y = 555;
        this.addChild(this.game0_10);
        this.game0_9 = new egret.Bitmap(RES.getRes("Game_rectImg0_png"));
        this.game0_9.x = 511;
        this.game0_9.y = 469;
        this.addChild(this.game0_9);
        this.game0_11 = new egret.Bitmap(RES.getRes("Game_rectImg0_png"));
        this.game0_11.x = 512;
        this.game0_11.y = 639;
        this.addChild(this.game0_11);
        this.game0_12 = new egret.Bitmap(RES.getRes("Game_rectImg0_png"));
        this.game0_12.x = 512;
        this.game0_12.y = 725;
        this.addChild(this.game0_12);
        this.game0_15 = new egret.Bitmap(RES.getRes("Game_rectImg0_png"));
        this.game0_15.x = 603;
        this.game0_15.y = 639;
        this.addChild(this.game0_15);
        this.game0_13 = new egret.Bitmap(RES.getRes("Game_rectImg0_png"));
        this.game0_13.x = 330;
        this.game0_13.y = 639;
        this.addChild(this.game0_13);
        this.game0_14 = new egret.Bitmap(RES.getRes("Game_rectImg0_png"));
        this.game0_14.x = 421;
        this.game0_14.y = 639;
        this.addChild(this.game0_14);
        //动画
    };
    return Game0UI;
}(wy.BaseSprite));
__reflect(Game0UI.prototype, "Game0UI");
