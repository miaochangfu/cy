/**
 *
 *@author
 *
 */
class InfoA extends InfoAUI {
	constructor() {
		super();
	}

	/**个人头像 */
	private headImg: wy.HeadImg;
	protected createChildren(): void {
		super.createChildren();
		this.txt1.verticalAlign = this.txt2.verticalAlign = this.txt3.verticalAlign = this.txt4.verticalAlign = 'middle';

		this.headImg = MyTools.setHeadImg(this, this.headBit, 53, true, 0, 0);
		this.headImg.source = StaticVar.defaultHeadImgUrl;

		this.nickname.text = StaticVar.defaultNickname;

		this.sex0.alpha = this.sex1.alpha = 0;

	}

	public show(data?): void {
		super.show(data);

		this.touchInit();

		let sex = 1;
		sex == 0 ? this.sex0.alpha = 1 : this.sex1.alpha = 1;

	}

	private onTouchTap(e: egret.TouchEvent): void {
		switch (e.currentTarget) {
			case this.hbBtn://生成海报

				break;
			default:
				break;
		}
	}

	private touchInit() {
		this.hbBtn.touchEnabled = true;
		this.hbBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
	}
	public hide(): void {
		super.hide();
		this.hbBtn.touchEnabled = false;
		this.hbBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
	}

}