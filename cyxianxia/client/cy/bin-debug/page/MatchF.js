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
var MatchF = (function (_super) {
    __extends(MatchF, _super);
    function MatchF() {
        return _super.call(this) || this;
    }
    MatchF.prototype.createChildren = function () {
        _super.prototype.createChildren.call(this);
        this.theme1.alpha = this.theme2.alpha = 0;
        this.chat = new Chat();
        this.addChild(this.chat);
        this.chat.show();
        this.chat.x = 39;
        this.chat.y = 1218;
        this.timeTxt.verticalAlign = 'middle';
        this.infoxyArr_four = [{ x: 56, y: 112 }, { x: 397, y: 112 }, { x: 56, y: 757 }, { x: 397, y: 757 }];
        this.infoxyArr_six = [{ x: -10, y: 112 }, { x: 229, y: 112 }, { x: 472, y: 112 }, { x: -10, y: 757 }, { x: 229, y: 757 }, { x: 472, y: 757 }];
    };
    MatchF.prototype.show = function (data) {
        _super.prototype.show.call(this, data);
        this.touchInit();
        this.personArr = [];
        this.four_or_six = 6;
        this.four_or_six == 4 ? this.theme1.alpha = 1 : this.theme2.alpha = 1;
        var arr = this.four_or_six == 4 ? this.infoxyArr_four : this.infoxyArr_six;
        for (var i = 0; i < this.four_or_six; i++) {
            var type = i < this.four_or_six / 2 ? 'blueImg' : 'redImg';
            var Imgtype = 'item0';
            var item = new MatchFItem(type, Imgtype, StaticVar.defaultNickname, true);
            this.addChild(item);
            item.x = arr[i].x;
            item.y = arr[i].y;
            this.personArr.push(item);
        }
    };
    MatchF.prototype.onTouchTap = function (e) {
        switch (e.currentTarget) {
            case this.backBtn:
                wy.changeScene(Home);
                break;
            default:
                break;
        }
    };
    MatchF.prototype.touchInit = function () {
        this.bg.touchEnabled = true;
        this.backBtn.touchEnabled = true;
        this.backBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    };
    MatchF.prototype.hide = function () {
        _super.prototype.hide.call(this);
        this.bg.touchEnabled = false;
        this.backBtn.touchEnabled = false;
        this.backBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    };
    return MatchF;
}(MatchFUI));
__reflect(MatchF.prototype, "MatchF");
/**单个item */
var MatchFItem = (function (_super) {
    __extends(MatchFItem, _super);
    function MatchFItem(type, Imgtype, nickname, isBtn) {
        var _this = _super.call(this) || this;
        _this.init(type, Imgtype, nickname, isBtn);
        return _this;
    }
    MatchFItem.prototype.init = function (type, Imgtype, nickname, isBtn) {
        this.bottomImg = MyTools.createBitmapByName("MatchF_" + type + "_png");
        this.addChild(this.bottomImg);
        this.perImg = MyTools.createBitmapByName("MatchF_" + Imgtype + "_png");
        this.addChild(this.perImg);
        wy.Tools.setAnchor(this.perImg, this.perImg.width / 2, this.perImg.height);
        this.perImg.x = 150;
        this.perImg.y = 280;
        if (isBtn) {
            this.shareBtn = MyTools.createBitmapByName("MatchF_item2_png");
            this.addChild(this.shareBtn);
            this.shareBtn.x = 67;
            this.shareBtn.y = 320;
        }
        else {
            this.nickname = new egret.TextField();
            this.addChild(this.nickname);
            MyTools.getItemTxt(this.nickname, nickname, 20, 0xffffff, 67, 330, 158, 23, 0, 0x276ba9, 'center');
        }
    };
    return MatchFItem;
}(egret.DisplayObjectContainer));
__reflect(MatchFItem.prototype, "MatchFItem");
