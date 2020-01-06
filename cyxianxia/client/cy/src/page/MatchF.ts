/**
 *
 *@author
 *
 */
class MatchF extends MatchFUI {
	constructor() {
		super();
	}

	private chat: Chat;
	private infoxyArr_four: any;
	private infoxyArr_six: any;
	/**2v2 or 3v3 */
	private four_or_six; number;
	private personArr: any;
	protected createChildren(): void {
		super.createChildren();

		this.theme1.alpha = this.theme2.alpha = 0;

		this.chat = new Chat(); this.addChild(this.chat); this.chat.show(); this.chat.x = 39; this.chat.y = 1218;

		this.timeTxt.verticalAlign = 'middle';

		this.infoxyArr_four = [{ x: 56, y: 112 }, { x: 397, y: 112 }, { x: 56, y: 757 }, { x: 397, y: 757 }];

		this.infoxyArr_six = [{ x: -10, y: 112 }, { x: 229, y: 112 }, { x: 472, y: 112 }, { x: -10, y: 757 }, { x: 229, y: 757 }, { x: 472, y: 757 }];
	}


	public show(data?): void {
		super.show(data);

		this.touchInit();

		this.personArr = [];
		this.four_or_six = 6;

		this.four_or_six == 4 ? this.theme1.alpha = 1 : this.theme2.alpha = 1;
		let arr = this.four_or_six == 4 ? this.infoxyArr_four : this.infoxyArr_six;
		for (var i = 0; i < this.four_or_six; i++) {
			let type = i < this.four_or_six / 2 ? 'blueImg' : 'redImg';
			let Imgtype = 'item0';
			let item = new MatchFItem(type, Imgtype, StaticVar.defaultNickname, true);
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
			default:
				break;
		}
	}

	private touchInit() {
		this.bg.touchEnabled = true;
		this.backBtn.touchEnabled = true;
		this.backBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
	}
	public hide(): void {
		super.hide();

		this.bg.touchEnabled = false;
		this.backBtn.touchEnabled = false;
		this.backBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
	}
}

/**单个item */
class MatchFItem extends egret.DisplayObjectContainer {
	constructor(type, Imgtype, nickname, isBtn) {
		super();
		this.init(type, Imgtype, nickname, isBtn);
	}
	public bottomImg: egret.Bitmap;//底图
	public perImg: egret.Bitmap;//底图
	public shareBtn: egret.Bitmap;//底图
	private nickname: egret.TextField;//昵称
	private init(type, Imgtype, nickname, isBtn) {
		this.bottomImg = MyTools.createBitmapByName("MatchF_" + type + "_png");
		this.addChild(this.bottomImg);

		this.perImg = MyTools.createBitmapByName("MatchF_" + Imgtype + "_png");
		this.addChild(this.perImg);
		wy.Tools.setAnchor(this.perImg, this.perImg.width / 2, this.perImg.height);
		this.perImg.x = 150;
		this.perImg.y = 280;

		if (isBtn) {
			this.shareBtn = MyTools.createBitmapByName("MatchF_item2_png");
			this.addChild(this.shareBtn);
			this.shareBtn.x = 67;
			this.shareBtn.y = 320;
		}
		else {
			this.nickname = new egret.TextField();
			this.addChild(this.nickname);
			MyTools.getItemTxt(this.nickname, nickname, 20, 0xffffff, 67, 330, 158, 23, 0, 0x276ba9, 'center');
		}
	}
}