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
var Rank = (function (_super) {
    __extends(Rank, _super);
    function Rank() {
        var _this = _super.call(this) || this;
        _this.btnArr = ['backBtn', 'btn1_1', 'btn2_1', 'btn3_1', 'nextBtn', 'upBtn'];
        return _this;
    }
    Rank.prototype.createChildren = function () {
        _super.prototype.createChildren.call(this);
        //添加一个容器到上面
        this.scrollCon = new egret.Sprite();
        this.myscrollView = MyTools.createSrollView(52, 270, 750, 660, this);
        this.myscrollView.setContent(this.scrollCon);
        this.list = MyTools.createList(0, 0, 750, 1, 0, 8, this.scrollCon);
        this.list.itemRenderer = RankItem;
        this.myscrollView.verticalScrollPolicy = 'off';
    };
    Rank.prototype.show = function (data) {
        _super.prototype.show.call(this, data);
        this.touchInit();
        this.btn1_1.visible = false;
        this.btn1_2.visible = true;
        this.btn2_1.visible = true;
        this.btn2_2.visible = false;
        this.btn3_1.visible = true;
        this.btn3_2.visible = false;
        this.total = ["", "", "", "", "", "", "", "", "", "", ""];
        this.onMsg();
    };
    /**刷新数据 */
    Rank.prototype.onMsg = function () {
        this.list.dataProvider = this.total;
        this.list.updateDisplayList();
    };
    Rank.prototype.onTouchTap = function (e) {
        switch (e.currentTarget) {
            case this.backBtn:
                wy.hidePopUpView();
                wy.hideView();
                break;
            case this.btn1_1:
                this.btn1_1.visible = false;
                this.btn1_2.visible = true;
                this.btn2_1.visible = true;
                this.btn2_2.visible = false;
                this.btn3_1.visible = true;
                this.btn3_2.visible = false;
                break;
            case this.btn2_1:
                this.btn1_1.visible = true;
                this.btn1_2.visible = false;
                this.btn2_1.visible = false;
                this.btn2_2.visible = true;
                this.btn3_1.visible = true;
                this.btn3_2.visible = false;
                break;
            case this.btn3_1:
                this.btn1_1.visible = true;
                this.btn1_2.visible = false;
                this.btn2_1.visible = true;
                this.btn2_2.visible = false;
                this.btn3_1.visible = false;
                this.btn3_2.visible = true;
                break;
            case this.upBtn:
                break;
            case this.nextBtn:
                break;
            default:
                break;
        }
    };
    Rank.prototype.touchInit = function () {
        this.mc.touchEnabled = true;
        for (var i = 0; i < this.btnArr.length; i++) {
            this[this.btnArr[i]].touchEnabled = true;
            this[this.btnArr[i]].addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        }
    };
    Rank.prototype.hide = function () {
        _super.prototype.hide.call(this);
        this.mc.touchEnabled = false;
        for (var i = 0; i < this.btnArr.length; i++) {
            this[this.btnArr[i]].touchEnabled = false;
            this[this.btnArr[i]].removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        }
    };
    return Rank;
}(RankUI));
__reflect(Rank.prototype, "Rank");
