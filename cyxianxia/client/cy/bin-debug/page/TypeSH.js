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
var TypeSH = (function (_super) {
    __extends(TypeSH, _super);
    function TypeSH() {
        var _this = _super.call(this) || this;
        _this.btnArr = ['backBtn', 'btn1_1', 'btn2_1', 'sex1', 'sex0'];
        return _this;
    }
    TypeSH.prototype.createChildren = function () {
        _super.prototype.createChildren.call(this);
        //添加一个容器到上面
        this.scrollCon = new egret.Sprite();
        this.myscrollView = MyTools.createSrollView(100, 300, 750, 960, this);
        this.myscrollView.setContent(this.scrollCon);
        this.list = MyTools.createList(0, 0, 750, 2, -46, 15, this.scrollCon);
        this.list.itemRenderer = TypeSHItem;
        this.myscrollView.horizontalScrollPolicy = 'off';
    };
    TypeSH.prototype.show = function (data) {
        _super.prototype.show.call(this, data);
        this.touchInit();
        this.btn1_1.visible = false;
        this.btn1_2.visible = true;
        this.btn2_1.visible = true;
        this.btn2_2.visible = false;
        this.circle1.alpha = 1;
        this.circle2.alpha = 0;
        this.total = ["", "", "", "", "", "", "", "", "", "", ""];
        this.onMsg();
    };
    /**刷新数据 */
    TypeSH.prototype.onMsg = function () {
        this.list.dataProvider = this.total;
        this.list.updateDisplayList();
    };
    TypeSH.prototype.onTouchTap = function (e) {
        switch (e.currentTarget) {
            case this.backBtn:
                wy.hideView();
                break;
            case this.btn1_1:
                this.btn1_1.visible = false;
                this.btn1_2.visible = true;
                this.btn2_1.visible = true;
                this.btn2_2.visible = false;
                this.sex0.visible = this.sex1.visible = this.circle1.visible = this.circle2.visible = true;
                break;
            case this.btn2_1:
                this.btn1_1.visible = true;
                this.btn1_2.visible = false;
                this.btn2_1.visible = false;
                this.btn2_2.visible = true;
                this.sex0.visible = this.sex1.visible = this.circle1.visible = this.circle2.visible = false;
                break;
            case this.sex1:
                this.circle1.alpha = 1;
                this.circle2.alpha = 0;
                break;
            case this.sex0:
                this.circle1.alpha = 0;
                this.circle2.alpha = 1;
                break;
            default:
                break;
        }
    };
    TypeSH.prototype.touchInit = function () {
        this.mc.touchEnabled = true;
        for (var i = 0; i < this.btnArr.length; i++) {
            this[this.btnArr[i]].touchEnabled = true;
            this[this.btnArr[i]].addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        }
    };
    TypeSH.prototype.hide = function () {
        _super.prototype.hide.call(this);
        this.mc.touchEnabled = false;
        for (var i = 0; i < this.btnArr.length; i++) {
            this[this.btnArr[i]].touchEnabled = false;
            this[this.btnArr[i]].removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        }
    };
    return TypeSH;
}(TypeSHUI));
__reflect(TypeSH.prototype, "TypeSH");
