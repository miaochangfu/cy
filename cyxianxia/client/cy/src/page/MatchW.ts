/**
 *
 *@author
 *
 */
class MatchW extends MatchWUI {
	constructor() {
		super();
	}

	private chat: Chat;
	private infoxyArr_four: any;
	private infoxyArr_six: any;
	private infoxyArr_eight: any;
	/**4, 6,8 */
	private four_or_six_or_eight; number;
	private personArr: any;
	protected createChildren(): void {
		super.createChildren();

		this.theme1.alpha = this.theme2.alpha = 0;

		this.chat = new Chat(); this.addChild(this.chat); this.chat.show(); this.chat.x = 39; this.chat.y = 1218;

		this.timeTxt.verticalAlign = 'middle';

		this.infoxyArr_four = [{ x: 91, y: 91 }, { x: 413, y: 91 }, { x: 91, y: 797 }, { x: 413, y: 797 }];

		this.infoxyArr_six = [{ x: 13, y: 91 }, { x: 255, y: 91 }, { x: 495, y: 91 }, { x: 13, y: 797 }, { x: 255, y: 797 }, { x: 495, y: 797 }];

		this.infoxyArr_eight = [{ x: 13, y: 91 }, { x: 255, y: 91 }, { x: 495, y: 91 }, { x: 13, y: 443 }, { x: 495, y: 443 }, { x: 13, y: 797 }, { x: 255, y: 797 }, { x: 495, y: 797 }];
	}


	public show(data?): void {
		super.show(data);

		this.touchInit();

		this.personArr = [];
		this.four_or_six_or_eight = 8;

		this.four_or_six_or_eight == 4 ? this.theme1.alpha = 1 : this.theme2.alpha = 1;

		let arr = this.four_or_six_or_eight == 4 ? this.infoxyArr_four : (this.four_or_six_or_eight == 6 ? this.infoxyArr_six : this.infoxyArr_eight);
		console.log(arr);

		for (var i = 0; i < this.four_or_six_or_eight; i++) {
			let type = i < this.four_or_six_or_eight / 2 ? 'item0' : 'item0';
			let Imgtype = 'item1';
			let item = new MatchWItem(type, Imgtype, StaticVar.defaultNickname, true);
			this.addChild(item);
			item.x = arr[i].x;
			item.y = arr[i].y;
			this.personArr.push(item);
		}
	}

	private onTouchTap(e: egret.TouchEvent): void {
		switch (e.currentTarget) {
			case this.backBtn:
				wy.changeScene(Home);
				break;
			case this.shareBtn:

				break;
			default:
				break;
		}
	}

	private touchInit() {
		this.bg.touchEnabled = true;
		this.backBtn.touchEnabled = true;
		this.backBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
		this.shareBtn.touchEnabled = true;
		this.shareBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
	}
	public hide(): void {
		super.hide();
		this.bg.touchEnabled = false;
		this.backBtn.touchEnabled = false;
		this.backBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
		this.shareBtn.touchEnabled = false;
		this.shareBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
	}
}

/**单个item */
class MatchWItem extends egret.DisplayObjectContainer {
	constructor(type, Imgtype, nickname, isEnter) {
		super();
		this.init(type, Imgtype, nickname, isEnter);
	}
	public bottomImg: egret.Bitmap;//底图
	public perImg: egret.Bitmap;//底图
	public shareBtn: egret.Bitmap;//底图
	private nickname: egret.TextField;//昵称
	private init(type, Imgtype, nickname, isEnter) {
		this.bottomImg = MyTools.createBitmapByName("MatchW_" + type + "_png");
		this.addChild(this.bottomImg);

		this.perImg = MyTools.createBitmapByName("MatchW_" + Imgtype + "_png");
		this.addChild(this.perImg);
		wy.Tools.setAnchor(this.perImg, this.perImg.width / 2, this.perImg.height);
		this.perImg.x = 115;
		this.perImg.y = 265;

		if (isEnter) {
			this.shareBtn = MyTools.createBitmapByName("MatchW_item3_png");
			this.addChild(this.shareBtn);
			this.shareBtn.x = 58;
			this.shareBtn.y = 308;
		}
		else {
			this.nickname = new egret.TextField();
			this.addChild(this.nickname);
			MyTools.getItemTxt(this.nickname, nickname, 20, 0xffffff, 40, 308, 158, 23, 0, 0x276ba9, 'center');
		}
	}
}