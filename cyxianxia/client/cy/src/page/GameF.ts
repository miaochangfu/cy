/**
 *
 *@author
 * 好友对战
 */
class GameF extends GameFUI {
	constructor() {
		super();
	}

	private gameFM: GameFM;
	private chat: Chat;
	private infoxyArr_four: any;
	private infoxyArr_six: any;
	/**2v2 or 3v3 */
	private four_or_six; number;
	protected createChildren(): void {
		super.createChildren();

		this.gameFM = new GameFM(); this.addChild(this.gameFM); this.gameFM.show(); this.gameFM.x = 66; this.gameFM.y = 412;
		this.chat = new Chat(); this.addChild(this.chat); this.chat.show(); this.chat.x = 39; this.chat.y = 1156;

		this.fhTxt.verticalAlign = 'middle';

		this.infoxyArr_four = [{ x: 50, y: 158 }, { x: 525, y: 158 }, { x: 50, y: 865 }, { x: 525, y: 865 }];
		this.infoxyArr_six = [{ x: 50, y: 158 }, { x: 287, y: 158 }, { x: 525, y: 158 }, { x: 50, y: 865 }, { x: 287, y: 865 }, { x: 525, y: 865 }];
	}


	public show(data?): void {
		super.show(data);

		this.touchInit();

		this.four_or_six = 6;
		let arr = this.four_or_six == 4 ? this.infoxyArr_four : this.infoxyArr_six;
		for (var i = 0; i < this.four_or_six; i++) {
			let type = i < this.four_or_six / 2 ? 'blueImg' : 'redImg';
			let item = new GameFItem(type, StaticVar.defaultHeadImgUrl, StaticVar.defaultNickname);
			this.addChild(item);
			item.x = arr[i].x;
			item.y = arr[i].y;
		}
	}

	private onTouchTap(e: egret.TouchEvent): void {
		switch (e.currentTarget) {
			case this.backBtn:
				wy.changeScene(Home);
				break;
			case this.fhBtn:

				break;
			default:
				break;
		}
	}

	private touchInit() {
		this.bg.touchEnabled = true;
		this.backBtn.touchEnabled = true;
		this.backBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
		this.fhBtn.touchEnabled = true;
		this.fhBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
	}
	public hide(): void {
		super.hide();
		this.bg.touchEnabled = false;
		this.backBtn.touchEnabled = false;
		this.backBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
		this.fhBtn.touchEnabled = false;
		this.fhBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
	}
}

/**单个item */
class GameFItem extends egret.DisplayObjectContainer {
	constructor(type, source, nickname) {
		super();
		this.init(type, source, nickname);
	}
	public bottomImg: egret.Bitmap;//底图
	private headImg: wy.HeadImg;//头像
	private nickname: egret.TextField;//昵称
	private init(type, source, nickname) {
		this.bottomImg = MyTools.createBitmapByName("GameF_" + type + "_png");
		this.addChild(this.bottomImg);
		this.headImg = new wy.HeadImg(55, true, 88, 88);
		this.addChild(this.headImg);
		this.headImg.source = source ? source : "resource/assets/Common/headBit.png";
		this.headImg.x = 34 + 55;
		this.headImg.y = 27 + 55;
		this.nickname = new egret.TextField();
		this.addChild(this.nickname);
		MyTools.getItemTxt(this.nickname, nickname, 21, 0xffffff, 26, 157, 128, 23, 0, 0x276ba9, 'center');
	}

}