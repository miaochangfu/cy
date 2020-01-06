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
var SetP = (function (_super) {
    __extends(SetP, _super);
    function SetP() {
        var _this = _super.call(this) || this;
        _this.btnArr = ['backBtn', 'musciA_1', 'musciA_2', 'musciB_1', 'musciB_2', 'kfBtn'];
        return _this;
    }
    SetP.prototype.createChildren = function () {
        _super.prototype.createChildren.call(this);
    };
    SetP.prototype.show = function (data) {
        _super.prototype.show.call(this, data);
        this.touchInit();
        this.showSet();
    };
    SetP.prototype.onTouchTap = function (e) {
        switch (e.currentTarget) {
            case this.backBtn:
                wy.hideView();
                break;
            case this.musciA_1:
                StaticVar.MUSIC_A = false;
                this.showSet();
                break;
            case this.musciA_2:
                StaticVar.MUSIC_A = true;
                this.showSet();
                break;
            case this.musciB_1:
                StaticVar.MUSIC_B = false;
                this.showSet();
                break;
            case this.musciB_2:
                StaticVar.MUSIC_B = true;
                this.showSet();
                break;
            case this.kfBtn:
                MyTools.hintMethod('客服');
                // if (!wx.openCustomerServiceConversation) {
                // 	return wy.Toast.setContent("您的微信版本过低，建议升级~");
                // }
                // wx.openCustomerServiceConversation({
                // 	sessionFrom: '',
                // 	showMessageCard: true,
                // 	sendMessageTitle: '玩游戏，捡红包',
                // 	sendMessagePath: '',
                // 	sendMessageImg: StaticVar.RESOURCE_LINKS + 'shareImg/share1.jpg',
                // 	success: (res) => {
                // 		//console.log('res---', res);
                // 	},
                // 	fail: err => {
                // 	},
                // 	complete: () => {
                // 	}
                // })
                break;
            default:
                break;
        }
    };
    SetP.prototype.showSet = function () {
        this.musciA_1.alpha = StaticVar.MUSIC_A ? 0 : 1;
        this.musciA_2.alpha = StaticVar.MUSIC_A ? 1 : 0;
        this.musciB_1.alpha = StaticVar.MUSIC_B ? 0 : 1;
        this.musciB_2.alpha = StaticVar.MUSIC_B ? 1 : 0;
    };
    SetP.prototype.touchInit = function () {
        this.mc.touchEnabled = true;
        for (var i = 0; i < this.btnArr.length; i++) {
            this[this.btnArr[i]].touchEnabled = true;
            this[this.btnArr[i]].addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        }
    };
    SetP.prototype.hide = function () {
        _super.prototype.hide.call(this);
        this.mc.touchEnabled = false;
        for (var i = 0; i < this.btnArr.length; i++) {
            this[this.btnArr[i]].touchEnabled = false;
            this[this.btnArr[i]].removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        }
    };
    return SetP;
}(SetPUI));
__reflect(SetP.prototype, "SetP");
