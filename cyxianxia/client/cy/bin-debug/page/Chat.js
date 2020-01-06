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
var Chat = (function (_super) {
    __extends(Chat, _super);
    function Chat() {
        return _super.call(this) || this;
    }
    Chat.prototype.createChildren = function () {
        _super.prototype.createChildren.call(this);
        this.chatTxt.verticalAlign = 'middle';
        this.ele2.name = 'btn';
    };
    Chat.prototype.show = function (data) {
        _super.prototype.show.call(this, data);
        this.touchInit();
    };
    Chat.prototype.onTouchTap = function (e) {
        switch (e.currentTarget) {
            case this.ele2:
                break;
            default:
                break;
        }
    };
    Chat.prototype.touchInit = function () {
        this.ele2.touchEnabled = true;
        this.ele2.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    };
    Chat.prototype.hide = function () {
        _super.prototype.hide.call(this);
        this.ele2.touchEnabled = false;
        this.ele2.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    };
    return Chat;
}(ChatUI));
__reflect(Chat.prototype, "Chat");
