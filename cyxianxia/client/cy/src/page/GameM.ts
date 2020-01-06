/**
 *
 *@author
 *
 */
class GameM extends GameMUI {
	constructor() {
		super();
	}

	private gameFM: GameFM;
	private chat: Chat;
	private infoxyArr: any;
	/**3,5,7 */
	private four_or_six_or_eight: any;
	/**个人头像 */
	private headImg: wy.HeadImg;
	protected createChildren(): void {
		super.createChildren();
		this.gameFM = new GameFM(); this.addChild(this.gameFM); this.gameFM.show(); this.gameFM.x = 66; this.gameFM.y = 528;
		this.chat = new Chat(); this.addChild(this.chat); this.chat.show(); this.chat.x = 39; this.chat.y = 1156;

		this.headImg = MyTools.setHeadImg(this, this.headBit, 53, true, 0, 0);
		this.headImg.source = StaticVar.defaultHeadImgUrl;
		this.nickname.text = StaticVar.defaultNickname;

		this.fhTxt.verticalAlign = this.nickname.verticalAlign = 'middle';

		this.infoxyArr = [{ x: 63, y: 155 }, { x: 228, y: 155 }, { x: 395, y: 155 }, { x: 560, y: 155 }, { x: 146, y: 339 }, { x: 319, y: 339 }, { x: 479, y: 339 }];

	}

	public show(data?): void {
		super.show(data);

		this.touchInit();

		this.four_or_six_or_eight = 5;//3,5,7

		for (var i = 0; i < this.four_or_six_or_eight; i++) {
			let type = 'blueImg';
			let item = new GameMItem(type, StaticVar.defaultHeadImgUrl, StaticVar.defaultNickname);
			this.addChild(item);
			item.x = this.infoxyArr[i].x;
			item.y = this.infoxyArr[i].y;
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
class GameMItem extends egret.DisplayObjectContainer {
	constructor(type, source, nickname) {
		super();
		this.init(type, source, nickname);
	}
	public bottomImg: egret.Bitmap;//底图
	private headImg: wy.HeadImg;//头像
	private nickname: egret.TextField;//昵称
	private init(type, source, nickname) {
		this.bottomImg = MyTools.createBitmapByName("GameM_" + type + "_png");
		this.addChild(this.bottomImg);
		this.headImg = new wy.HeadImg(41, true, 88, 88);
		this.addChild(this.headImg);
		this.headImg.source = source ? source : "resource/assets/Common/headBit.png";
		this.headImg.x = 23 + 41;
		this.headImg.y = 15 + 41;
		this.nickname = new egret.TextField();
		this.addChild(this.nickname);
		MyTools.getItemTxt(this.nickname, nickname, 17, 0xffffff, 12, 112, 108, 20, 0, 0x276ba9, 'center');
	}

}