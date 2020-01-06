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
var Welfare = (function (_super) {
    __extends(Welfare, _super);
    function Welfare() {
        var _this = _super.call(this) || this;
        _this.btnArr = ['backBtn', 'btn1', 'btn2'];
        return _this;
    }
    Welfare.prototype.createChildren = function () {
        _super.prototype.createChildren.call(this);
        //添加一个容器到上面
        this.scrollCon = new egret.Sprite();
        this.myscrollView = MyTools.createSrollView(107, 385, 750, 460, this);
        this.myscrollView.setContent(this.scrollCon);
        this.list = MyTools.createList(0, 0, 750, 1, 0, 7, this.scrollCon);
        this.list.itemRenderer = WelfareItem;
        // this.myscrollView.verticalScrollPolicy = 'off';
    };
    Welfare.prototype.show = function (data) {
        _super.prototype.show.call(this, data);
        this.touchInit();
        this.btn1.touchEnabled = false;
        this.btn2.texture = RES.getRes('Welfare_btn2_2_png');
        this.total = ["", "", "", "", ""];
        this.onMsg();
    };
    /**刷新数据 */
    Welfare.prototype.onMsg = function () {
        this.list.dataProvider = this.total;
        this.list.updateDisplayList();
    };
    Welfare.prototype.onTouchTap = function (e) {
        switch (e.currentTarget) {
            case this.backBtn:
                wy.hideView();
                break;
            case this.btn1:
                this.btn1.touchEnabled = false;
                this.btn2.touchEnabled = true;
                this.btn1.texture = RES.getRes('Welfare_btn1_1_png');
                this.btn2.texture = RES.getRes('Welfare_btn2_2_png');
                this.total = ["", "", "", "", ""];
                this.onMsg();
                break;
            case this.btn2:
                this.btn2.touchEnabled = false;
                this.btn1.touchEnabled = true;
                this.btn1.texture = RES.getRes('Welfare_btn1_2_png');
                this.btn2.texture = RES.getRes('Welfare_btn2_1_png');
                this.total = ["", "", "", "", "", "", "", "", "", "", ""];
                this.onMsg();
                break;
            default:
                break;
        }
    };
    Welfare.prototype.touchInit = function () {
        this.mc.touchEnabled = true;
        for (var i = 0; i < this.btnArr.length; i++) {
            this[this.btnArr[i]].touchEnabled = true;
            this[this.btnArr[i]].addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        }
    };
    Welfare.prototype.hide = function () {
        _super.prototype.hide.call(this);
        this.mc.touchEnabled = false;
        for (var i = 0; i < this.btnArr.length; i++) {
            this[this.btnArr[i]].touchEnabled = false;
            this[this.btnArr[i]].removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        }
    };
    return Welfare;
}(WelfareUI));
__reflect(Welfare.prototype, "Welfare");
