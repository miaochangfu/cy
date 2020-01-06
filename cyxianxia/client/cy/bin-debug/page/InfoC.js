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
var InfoC = (function (_super) {
    __extends(InfoC, _super);
    function InfoC() {
        return _super.call(this) || this;
    }
    InfoC.prototype.createChildren = function () {
        _super.prototype.createChildren.call(this);
        //添加一个容器到上面
        this.scrollCon = new egret.Sprite();
        this.myscrollView = MyTools.createSrollView(55, 255, 750, 825, this);
        this.myscrollView.setContent(this.scrollCon);
        this.list = MyTools.createList(0, 0, 750, 1, 0, 12, this.scrollCon);
        this.list.itemRenderer = InfoCItem;
        // this.myscrollView.verticalScrollPolicy = 'off';
    };
    InfoC.prototype.show = function (data) {
        _super.prototype.show.call(this, data);
        this.touchInit();
        this.total = ["", "", "", "", "", "", "", "", "", "", ""];
        this.onMsg();
    };
    /**刷新数据 */
    InfoC.prototype.onMsg = function () {
        this.list.dataProvider = this.total;
        this.list.updateDisplayList();
    };
    InfoC.prototype.onTouchTap = function (e) {
        switch (e.currentTarget) {
            default:
                break;
        }
    };
    InfoC.prototype.touchInit = function () {
    };
    InfoC.prototype.hide = function () {
        _super.prototype.hide.call(this);
    };
    return InfoC;
}(InfoCUI));
__reflect(InfoC.prototype, "InfoC");
