/**
 *
 *@author
 *
 */
class GameUtils extends Game0UI {
	constructor() {
		super();
	}
	protected createChildren(): void {
		super.createChildren();
		for (let i = 0; i < 16; i++) { this['game0_' + i].alpha = 0; }
	}
	public show(data?): void {
		super.show(data);
	}
}


/**单个item */
class GameItem extends egret.DisplayObjectContainer {
	constructor() {
		super();
		this.init();
	}
	public bottomImg: egret.Bitmap;//底图
	public idiomTxt: egret.TextField;//昵称
	public type: number;
	public _text: string;
	private init() {

		this.bottomImg = new egret.Bitmap();
		this.addChild(this.bottomImg);
		this.bottomImg.width = this.bottomImg.height = 70;

		this.idiomTxt = new egret.TextField();
		this.addChild(this.idiomTxt);

		MyTools.getItemTxt(this.idiomTxt, '', 50, 0x000000, 0, 0, 70, 70, 0, 0x276ba9, 'center');
	}
	/**改变底图纹理 */
	public changeTexture(type) {
		this.type = type;
		this.bottomImg.texture = RES.getRes("Game_rectImg" + type + "_png");
	}
	/**改变文字 */
	public changeTxt(str) {
		this._text = str;
		this.idiomTxt.text = str;
	}
}


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

