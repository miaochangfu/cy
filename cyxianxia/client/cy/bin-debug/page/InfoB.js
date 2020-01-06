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
var InfoB = (function (_super) {
    __extends(InfoB, _super);
    function InfoB() {
        return _super.call(this) || this;
    }
    InfoB.prototype.createChildren = function () {
        _super.prototype.createChildren.call(this);
        //添加一个容器到上面
        this.scrollCon = new egret.Sprite();
        this.myscrollView = MyTools.createSrollView(52, 255, 750, 835, this);
        this.myscrollView.setContent(this.scrollCon);
        this.list = MyTools.createList(0, 0, 750, 3, -40, 22, this.scrollCon);
        this.list.itemRenderer = InfoBItem;
        // this.myscrollView.verticalScrollPolicy = 'off';
    };
    InfoB.prototype.show = function (data) {
        _super.prototype.show.call(this, data);
        this.touchInit();
        this.pop0.visible = this.pop1.visible = this.pop2.visible = false;
        wy.on(this.isChoose, 'isChoose', this);
        this.total = ["", "", "", "", "", "", "", "", "", "", ""];
        this.onMsg();
    };
    InfoB.prototype.isChoose = function (data) {
        this.pop0.visible = this.pop1.visible = this.pop2.visible = true;
    };
    /**刷新数据 */
    InfoB.prototype.onMsg = function () {
        this.list.dataProvider = this.total;
        this.list.updateDisplayList();
    };
    InfoB.prototype.onTouchTap = function (e) {
        switch (e.currentTarget) {
            case this.pop1:
                break;
            case this.pop2:
                break;
            default:
                break;
        }
    };
    InfoB.prototype.touchInit = function () {
        this.pop1.touchEnabled = true;
        this.pop1.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.pop2.touchEnabled = true;
        this.pop2.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    };
    InfoB.prototype.hide = function () {
        _super.prototype.hide.call(this);
        wy.off(this.isChoose, 'isChoose', this);
        this.pop1.touchEnabled = false;
        this.pop1.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.pop2.touchEnabled = false;
        this.pop2.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    };
    return InfoB;
}(InfoBUI));
__reflect(InfoB.prototype, "InfoB");
