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
 *@author
 *
 */
var Draw = (function (_super) {
    __extends(Draw, _super);
    function Draw() {
        var _this = _super.call(this) || this;
        _this.prize = 0;
        _this.prize_type = 0;
        return _this;
    }
    Draw.prototype.createChildren = function () {
        _super.prototype.createChildren.call(this);
        this.startBtn.name = "";
    };
    Draw.prototype.show = function (data) {
        _super.prototype.show.call(this, data);
        this.touchInit();
        // wy.Tools.setAnchor(this.startBtn, 58, 116);
    };
    Draw.prototype.onTouchTap = function (e) {
        switch (e.currentTarget) {
            case this.backBtn:
                wy.hideView();
                break;
            case this.startBtn:
                this.startBtn.touchEnabled = false;
                this.getPrize();
                break;
            default:
                break;
        }
    };
    /**抽奖 */
    Draw.prototype.getPrize = function () {
        // wy.LoadingData.open();
        // Net.getPlayerGachaAPI(this, (e: egret.Event) => {
        // 	wy.LoadingData.close();
        // 	console.log(e.target.response);
        // 	var data = JSON.parse(e.target.response);
        // 	if (data.status == 'SUCCESS') {
        // this.prize = Number(data.playerGetRewardRes.index);
        this.prize = 3;
        console.log("prizeIndex====" + this.prize);
        var angle = 0; //旋转的角度  [￥10代金券]
        switch (this.prize) {
            case 1:
                angle = 0;
                break;
            case 2:
                angle = 45;
                break;
            case 3:
                angle = 90;
                break;
            case 4:
                angle = 135;
                break;
            case 5:
                angle = 180;
                break;
            case 6:
                angle = 225;
                break;
            case 7:
                angle = 270;
                break;
            case 8:
                angle = 315;
                break;
        }
        egret.Tween.get(this.startBtn).wait(1).to({ rotation: 1800 + angle }, 3000, egret.Ease.cubicOut).wait(500).call(function () {
        }, this);
        // 	}
        // 			else {
        // 	this.startBtn.touchEnabled = true;
        // 	// ('没有抽奖机会');
        // 	MyTools.hintMethod('抽奖次数不足');
        // }
        // 		}, Number(StaticVar.USER_PLAYERID));
    };
    Draw.prototype.touchInit = function () {
        this.mc.touchEnabled = true;
        this.startBtn.touchEnabled = true;
        this.startBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.backBtn.touchEnabled = true;
        this.backBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    };
    Draw.prototype.hide = function () {
        _super.prototype.hide.call(this);
        this.mc.touchEnabled = false;
        this.startBtn.touchEnabled = false;
        this.startBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.backBtn.touchEnabled = false;
        this.backBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    };
    return Draw;
}(DrawUI));
__reflect(Draw.prototype, "Draw");
