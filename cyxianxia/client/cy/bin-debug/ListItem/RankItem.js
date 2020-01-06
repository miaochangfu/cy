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
 * @author
 *
 */
var RankItem = (function (_super) {
    __extends(RankItem, _super);
    function RankItem() {
        var _this = _super.call(this) || this;
        _this.init();
        return _this;
    }
    RankItem.prototype.init = function () {
        this.bottomImg = new egret.Bitmap();
        this.addChild(this.bottomImg);
        this.rankImg = new egret.Bitmap();
        this.addChild(this.rankImg);
        this.rankIndex = new egret.TextField();
        this.addChild(this.rankIndex);
        this.headImg = new wy.HeadImg(36, true, 80, 80);
        this.addChild(this.headImg);
        this.nickname = new egret.TextField();
        this.addChild(this.nickname);
        this.levelTxt = new egret.TextField();
        this.addChild(this.levelTxt);
        this.score = new egret.TextField();
        this.addChild(this.score);
    };
    RankItem.prototype.dataChanged = function (data) {
        _super.prototype.dataChanged.call(this);
        this.bottomImg.texture = RES.getRes("Rank_item1_png");
        this.bottomImg.x = 0;
        this.bottomImg.y = 0;
        if (this.itemIndex < 3) {
            this.rankImg.texture = RES.getRes("Rank_index" + (this.itemIndex + 1) + "_png");
            this.rankImg.x = 30;
            this.rankImg.y = 30;
        }
        else {
            MyTools.getItemTxt(this.rankIndex, (this.itemIndex + 1) + '', 30, 0xfdeaaa, 18, 39, 80, 34, 0, 0x276ba9, 'center');
            this.rankIndex.bold = true;
        }
        this.headImg.source = this.data.img ? this.data.img : StaticVar.defaultHeadImgUrl;
        this.headImg.x = 107 + 38;
        this.headImg.y = 15 + 37;
        if (this.data.name == '' || this.data.name == 'null' || this.data.name == null || this.data.name == undefined
            || (this.data.name.length > 0 && this.data.name.trim().length == 0)) {
            MyTools.getItemTxt(this.nickname, '游客', 23, 0xffffff, 200, 30 + 5, 180, 25, 0, 0x276ba9, 'left');
        }
        else {
            MyTools.getItemTxt(this.nickname, this.data.name, 23, 0xffffff, 200, 30 + 5, 180, 25, 0, 0x276ba9, 'left');
        }
        MyTools.getItemTxt(this.levelTxt, 'this.data.level', 16, 0xffa752, 200, 62 + 5, 180, 20, 0, 0x276ba9, 'left');
        MyTools.getItemTxt(this.score, 'this.data.score', 28, 0xf1c55d, 422, 41 + 3, 200, 30, 2, 0x8d2912, 'left');
    };
    return RankItem;
}(wy.ItemRenderer));
__reflect(RankItem.prototype, "RankItem");
