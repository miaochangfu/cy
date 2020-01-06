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
var GameUtils = (function (_super) {
    __extends(GameUtils, _super);
    function GameUtils() {
        return _super.call(this) || this;
    }
    GameUtils.prototype.createChildren = function () {
        _super.prototype.createChildren.call(this);
        for (var i = 0; i < 16; i++) {
            this['game0_' + i].alpha = 0;
        }
    };
    GameUtils.prototype.show = function (data) {
        _super.prototype.show.call(this, data);
    };
    return GameUtils;
}(Game0UI));
__reflect(GameUtils.prototype, "GameUtils");
/**单个item */
var GameItem = (function (_super) {
    __extends(GameItem, _super);
    function GameItem() {
        var _this = _super.call(this) || this;
        _this.init();
        return _this;
    }
    GameItem.prototype.init = function () {
        this.bottomImg = new egret.Bitmap();
        this.addChild(this.bottomImg);
        this.bottomImg.width = this.bottomImg.height = 70;
        this.idiomTxt = new egret.TextField();
        this.addChild(this.idiomTxt);
        MyTools.getItemTxt(this.idiomTxt, '', 50, 0x000000, 0, 0, 70, 70, 0, 0x276ba9, 'center');
    };
    /**改变底图纹理 */
    GameItem.prototype.changeTexture = function (type) {
        this.type = type;
        this.bottomImg.texture = RES.getRes("Game_rectImg" + type + "_png");
    };
    /**改变文字 */
    GameItem.prototype.changeTxt = function (str) {
        this._text = str;
        this.idiomTxt.text = str;
    };
    return GameItem;
}(egret.DisplayObjectContainer));
__reflect(GameItem.prototype, "GameItem");
// /**单个item */
// class GameItem extends egret.DisplayObjectContainer {
// 	constructor(type, _text) {
// 		super();
// 		this.init(type, _text);
// 	}
// 	public bottomImg: egret.Bitmap;//底图
// 	public idiomTxt: egret.TextField;//昵称
// 	public type: number;
// 	public _text: string;
// 	private init(type, _text) {
// 		this.type = type;
// 		this.bottomImg = MyTools.createBitmapByName("Game_rectImg" + type + "_png");
// 		this.addChild(this.bottomImg);
// 		this.bottomImg.width = this.bottomImg.height = 70;
// 		this.idiomTxt = new egret.TextField();
// 		this.addChild(this.idiomTxt);
// 		this._text = _text;
// 		MyTools.getItemTxt(this.idiomTxt, _text, 50, 0x000000, 0, 0, 70, 70, 0, 0x276ba9, 'center');
// 	}
// 	/**改变底图纹理 */
// 	public changeTexture(type) {
// 		this.type = type;
// 		this.bottomImg.texture = RES.getRes("Game_rectImg" + type + "_png");
// 	}
// 	/**改变文字 */
// 	public changeTxt(str) {
// 		this.idiomTxt.text = str;
// 	}
// }
/**单个item */
// class BoxItem extends egret.DisplayObjectContainer {
// 	constructor(type, arr) {
// 		super();
// 		this.init(type, arr);
// 	}
// 	public type: number;
// 	private init(type, arr) {
// 		this.type = type;
// 		for (let j = 0; j < 4; j++) {
// 			let item = new GameItem(0, arr[j]);
// 			this.addChild(item);
// 			if (type == 0) {//横
// 				item.x = 70 * j;
// 				item.y = 0;
// 			}
// 			else {//竖
// 				item.x = 0;
// 				item.y = 70 * j;
// 			}
// 		}
// 	}
// }
