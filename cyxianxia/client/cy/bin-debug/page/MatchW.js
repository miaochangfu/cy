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
var MatchW = (function (_super) {
    __extends(MatchW, _super);
    function MatchW() {
        return _super.call(this) || this;
    }
    MatchW.prototype.createChildren = function () {
        _super.prototype.createChildren.call(this);
        this.theme1.alpha = this.theme2.alpha = 0;
        this.chat = new Chat();
        this.addChild(this.chat);
        this.chat.show();
        this.chat.x = 39;
        this.chat.y = 1218;
        this.timeTxt.verticalAlign = 'middle';
        this.infoxyArr_four = [{ x: 91, y: 91 }, { x: 413, y: 91 }, { x: 91, y: 797 }, { x: 413, y: 797 }];
        this.infoxyArr_six = [{ x: 13, y: 91 }, { x: 255, y: 91 }, { x: 495, y: 91 }, { x: 13, y: 797 }, { x: 255, y: 797 }, { x: 495, y: 797 }];
        this.infoxyArr_eight = [{ x: 13, y: 91 }, { x: 255, y: 91 }, { x: 495, y: 91 }, { x: 13, y: 443 }, { x: 495, y: 443 }, { x: 13, y: 797 }, { x: 255, y: 797 }, { x: 495, y: 797 }];
    };
    MatchW.prototype.show = function (data) {
        _super.prototype.show.call(this, data);
        this.touchInit();
        this.personArr = [];
        this.four_or_six_or_eight = 8;
        this.four_or_six_or_eight == 4 ? this.theme1.alpha = 1 : this.theme2.alpha = 1;
        var arr = this.four_or_six_or_eight == 4 ? this.infoxyArr_four : (this.four_or_six_or_eight == 6 ? this.infoxyArr_six : this.infoxyArr_eight);
        console.log(arr);
        for (var i = 0; i < this.four_or_six_or_eight; i++) {
            var type = i < this.four_or_six_or_eight / 2 ? 'item0' : 'item0';
            var Imgtype = 'item1';
            var item = new MatchWItem(type, Imgtype, StaticVar.defaultNickname, true);
            this.addChild(item);
            item.x = arr[i].x;
            item.y = arr[i].y;
            this.personArr.push(item);
        }
    };
    MatchW.prototype.onTouchTap = function (e) {
        switch (e.currentTarget) {
            case this.backBtn:
                wy.changeScene(Home);
                break;
            case this.shareBtn:
                break;
            default:
                break;
        }
    };
    MatchW.prototype.touchInit = function () {
        this.bg.touchEnabled = true;
        this.backBtn.touchEnabled = true;
        this.backBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.shareBtn.touchEnabled = true;
        this.shareBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    };
    MatchW.prototype.hide = function () {
        _super.prototype.hide.call(this);
        this.bg.touchEnabled = false;
        this.backBtn.touchEnabled = false;
        this.backBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.shareBtn.touchEnabled = false;
        this.shareBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    };
    return MatchW;
}(MatchWUI));
__reflect(MatchW.prototype, "MatchW");
/**单个item */
var MatchWItem = (function (_super) {
    __extends(MatchWItem, _super);
    function MatchWItem(type, Imgtype, nickname, isEnter) {
        var _this = _super.call(this) || this;
        _this.init(type, Imgtype, nickname, isEnter);
        return _this;
    }
    MatchWItem.prototype.init = function (type, Imgtype, nickname, isEnter) {
        this.bottomImg = MyTools.createBitmapByName("MatchW_" + type + "_png");
        this.addChild(this.bottomImg);
        this.perImg = MyTools.createBitmapByName("MatchW_" + Imgtype + "_png");
        this.addChild(this.perImg);
        wy.Tools.setAnchor(this.perImg, this.perImg.width / 2, this.perImg.height);
        this.perImg.x = 115;
        this.perImg.y = 265;
        if (isEnter) {
            this.shareBtn = MyTools.createBitmapByName("MatchW_item3_png");
            this.addChild(this.shareBtn);
            this.shareBtn.x = 58;
            this.shareBtn.y = 308;
        }
        else {
            this.nickname = new egret.TextField();
            this.addChild(this.nickname);
            MyTools.getItemTxt(this.nickname, nickname, 20, 0xffffff, 40, 308, 158, 23, 0, 0x276ba9, 'center');
        }
    };
    return MatchWItem;
}(egret.DisplayObjectContainer));
__reflect(MatchWItem.prototype, "MatchWItem");
