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
var GameM = (function (_super) {
    __extends(GameM, _super);
    function GameM() {
        return _super.call(this) || this;
    }
    GameM.prototype.createChildren = function () {
        _super.prototype.createChildren.call(this);
        this.gameFM = new GameFM();
        this.addChild(this.gameFM);
        this.gameFM.show();
        this.gameFM.x = 66;
        this.gameFM.y = 528;
        this.chat = new Chat();
        this.addChild(this.chat);
        this.chat.show();
        this.chat.x = 39;
        this.chat.y = 1156;
        this.headImg = MyTools.setHeadImg(this, this.headBit, 53, true, 0, 0);
        this.headImg.source = StaticVar.defaultHeadImgUrl;
        this.nickname.text = StaticVar.defaultNickname;
        this.fhTxt.verticalAlign = this.nickname.verticalAlign = 'middle';
        this.infoxyArr = [{ x: 63, y: 155 }, { x: 228, y: 155 }, { x: 395, y: 155 }, { x: 560, y: 155 }, { x: 146, y: 339 }, { x: 319, y: 339 }, { x: 479, y: 339 }];
    };
    GameM.prototype.show = function (data) {
        _super.prototype.show.call(this, data);
        this.touchInit();
        this.four_or_six_or_eight = 5; //3,5,7
        for (var i = 0; i < this.four_or_six_or_eight; i++) {
            var type = 'blueImg';
            var item = new GameMItem(type, StaticVar.defaultHeadImgUrl, StaticVar.defaultNickname);
            this.addChild(item);
            item.x = this.infoxyArr[i].x;
            item.y = this.infoxyArr[i].y;
        }
    };
    GameM.prototype.onTouchTap = function (e) {
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
    GameM.prototype.touchInit = function () {
        this.bg.touchEnabled = true;
        this.backBtn.touchEnabled = true;
        this.backBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.fhBtn.touchEnabled = true;
        this.fhBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    };
    GameM.prototype.hide = function () {
        _super.prototype.hide.call(this);
        this.bg.touchEnabled = false;
        this.backBtn.touchEnabled = false;
        this.backBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.fhBtn.touchEnabled = false;
        this.fhBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    };
    return GameM;
}(GameMUI));
__reflect(GameM.prototype, "GameM");
/**单个item */
var GameMItem = (function (_super) {
    __extends(GameMItem, _super);
    function GameMItem(type, source, nickname) {
        var _this = _super.call(this) || this;
        _this.init(type, source, nickname);
        return _this;
    }
    GameMItem.prototype.init = function (type, source, nickname) {
        this.bottomImg = MyTools.createBitmapByName("GameM_" + type + "_png");
        this.addChild(this.bottomImg);
        this.headImg = new wy.HeadImg(41, true, 88, 88);
        this.addChild(this.headImg);
        this.headImg.source = source ? source : "resource/assets/Common/headBit.png";
        this.headImg.x = 23 + 41;
        this.headImg.y = 15 + 41;
        this.nickname = new egret.TextField();
        this.addChild(this.nickname);
        MyTools.getItemTxt(this.nickname, nickname, 17, 0xffffff, 12, 112, 108, 20, 0, 0x276ba9, 'center');
    };
    return GameMItem;
}(egret.DisplayObjectContainer));
__reflect(GameMItem.prototype, "GameMItem");
