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
var MailA = (function (_super) {
    __extends(MailA, _super);
    function MailA() {
        var _this = _super.call(this) || this;
        _this.btnArr = ['backBtn', 'btn2', 'btn3'];
        return _this;
    }
    MailA.prototype.createChildren = function () {
        _super.prototype.createChildren.call(this);
        //添加一个容器到上面
        this.scrollCon = new egret.Sprite();
        this.myscrollView = MyTools.createSrollView(125, 385, 750, 476, this);
        this.myscrollView.setContent(this.scrollCon);
        this.list = MyTools.createList(0, 0, 750, 1, 0, 12, this.scrollCon);
        this.list.itemRenderer = MailAItem;
        this.myscrollView.horizontalScrollPolicy = 'off';
    };
    MailA.prototype.show = function (data) {
        _super.prototype.show.call(this, data);
        this.touchInit();
        this.total = ["", "", "", "", "", "", "", "", "", "", ""];
        this.onMsg();
    };
    /**刷新数据 */
    MailA.prototype.onMsg = function () {
        this.list.dataProvider = this.total;
        this.list.updateDisplayList();
    };
    MailA.prototype.onTouchTap = function (e) {
        switch (e.currentTarget) {
            case this.backBtn:
                wy.hideView();
                break;
            case this.btn2:
                wy.changeView(MailB);
                break;
            case this.btn3:
                wy.changeView(MailC);
                break;
            default:
                break;
        }
    };
    MailA.prototype.touchInit = function () {
        this.mc.touchEnabled = true;
        for (var i = 0; i < this.btnArr.length; i++) {
            this[this.btnArr[i]].touchEnabled = true;
            this[this.btnArr[i]].addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        }
    };
    MailA.prototype.hide = function () {
        _super.prototype.hide.call(this);
        this.mc.touchEnabled = false;
        for (var i = 0; i < this.btnArr.length; i++) {
            this[this.btnArr[i]].touchEnabled = false;
            this[this.btnArr[i]].removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        }
    };
    return MailA;
}(MailAUI));
__reflect(MailA.prototype, "MailA");