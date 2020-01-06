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
 * 好友对战
 */
var GameF = (function (_super) {
    __extends(GameF, _super);
    function GameF() {
        return _super.call(this) || this;
    }
    GameF.prototype.createChildren = function () {
        _super.prototype.createChildren.call(this);
        this.gameFM = new GameFM();
        this.addChild(this.gameFM);
        this.gameFM.show();
        this.gameFM.x = 66;
        this.gameFM.y = 412;
        this.chat = new Chat();
        this.addChild(this.chat);
        this.chat.show();
        this.chat.x = 39;
        this.chat.y = 1156;
        this.fhTxt.verticalAlign = 'middle';
        this.infoxyArr_four = [{ x: 50, y: 158 }, { x: 525, y: 158 }, { x: 50, y: 865 }, { x: 525, y: 865 }];
        this.infoxyArr_six = [{ x: 50, y: 158 }, { x: 287, y: 158 }, { x: 525, y: 158 }, { x: 50, y: 865 }, { x: 287, y: 865 }, { x: 525, y: 865 }];
    };
    GameF.prototype.show = function (data) {
        _super.prototype.show.call(this, data);
        this.touchInit();
        this.four_or_six = 6;
        var arr = this.four_or_six == 4 ? this.infoxyArr_four : this.infoxyArr_six;
        for (var i = 0; i < this.four_or_six; i++) {
            var type = i < this.four_or_six / 2 ? 'blueImg' : 'redImg';
            var item = new GameFItem(type, StaticVar.defaultHeadImgUrl, StaticVar.defaultNickname);
            this.addChild(item);
            item.x = arr[i].x;
            item.y = arr[i].y;
        }
    };
    GameF.prototype.onTouchTap = function (e) {
        switch (e.currentTarget) {
            case this.backBtn:
                wy.changeScene(Home);
                break;
            case this.fhBtn:
                break;
            default:
                break;
        }
    };
    GameF.prototype.touchInit = function () {
        this.bg.touchEnabled = true;
        this.backBtn.touchEnabled = true;
        this.backBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.fhBtn.touchEnabled = true;
        this.fhBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    };
    GameF.prototype.hide = function () {
        _super.prototype.hide.call(this);
        this.bg.touchEnabled = false;
        this.backBtn.touchEnabled = false;
        this.backBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.fhBtn.touchEnabled = false;
        this.fhBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    };
    return GameF;
}(GameFUI));
__reflect(GameF.prototype, "GameF");
/**单个item */
var GameFItem = (function (_super) {
    __extends(GameFItem, _super);
    function GameFItem(type, source, nickname) {
        var _this = _super.call(this) || this;
        _this.init(type, source, nickname);
        return _this;
    }
    GameFItem.prototype.init = function (type, source, nickname) {
        this.bottomImg = MyTools.createBitmapByName("GameF_" + type + "_png");
        this.addChild(this.bottomImg);
        this.headImg = new wy.HeadImg(55, true, 88, 88);
        this.addChild(this.headImg);
        this.headImg.source = source ? source : "resource/assets/Common/headBit.png";
        this.headImg.x = 34 + 55;
        this.headImg.y = 27 + 55;
        this.nickname = new egret.TextField();
        this.addChild(this.nickname);
        MyTools.getItemTxt(this.nickname, nickname, 21, 0xffffff, 26, 157, 128, 23, 0, 0x276ba9, 'center');
    };
    return GameFItem;
}(egret.DisplayObjectContainer));
__reflect(GameFItem.prototype, "GameFItem");
