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
var ChatUI = (function (_super) {
    __extends(ChatUI, _super);
    function ChatUI() {
        var _this = _super.call(this) || this;
        _this.width = 675;
        _this.height = 53;
        _this.createChildren();
        return _this;
    }
    ChatUI.prototype.createChildren = function () {
        this.ele1 = new egret.Bitmap(RES.getRes("Chat_ele1_png"));
        this.ele1.x = 0;
        this.ele1.y = 0;
        this.addChild(this.ele1);
        this.chatTxt = new egret.TextField();
        this.chatTxt.type = "input";
        this.chatTxt.text = "label";
        this.chatTxt.textAlign = "center";
        this.chatTxt.size = 37;
        this.chatTxt.textColor = 0xffffff;
        this.chatTxt.x = 116;
        this.chatTxt.y = 6;
        this.chatTxt.width = 440;
        this.chatTxt.height = 43;
        this.addChild(this.chatTxt);
        this.ele2 = new egret.Bitmap(RES.getRes("Chat_ele2_png"));
        this.ele2.x = 564;
        this.ele2.y = 5;
        this.addChild(this.ele2);
        //动画
    };
    return ChatUI;
}(wy.BaseSprite));
__reflect(ChatUI.prototype, "ChatUI");
