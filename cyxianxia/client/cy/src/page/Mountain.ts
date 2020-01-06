/**
 *
 *@author
 * 华山论剑
 */
class Mountain extends MountainUI {
	constructor() {
		super();
	}

	protected createChildren(): void {
		super.createChildren();
	}

	public show(data?): void {
		super.show(data);

		this.touchInit();

	}



	private onTouchTap(e: egret.TouchEvent): void {
		switch (e.currentTarget) {
			case this.backBtn:
				wy.hideView();
				break;
			case this.btn1_1://华山论剑4人
				MyTools.hintMethod('华山论剑4人');
				break;
			case this.btn1_2://华山论剑6人
				MyTools.hintMethod('华山论剑6人');
				break;
			case this.btn1_3://华山论剑8人
				MyTools.hintMethod('华山论剑8人');
				break;
			case this.btn2_1://好友对战2v2
				MyTools.hintMethod('好友对战2v2');
				break;
			case this.btn2_2://好友对战3v3
				MyTools.hintMethod('好友对战3v3');
				break;
			default:
				break;
		}
	}

	private btnArr: any = ['backBtn', 'btn1_1', 'btn1_2', 'btn1_3', 'btn2_1', 'btn2_2'];
	private touchInit() {
		this.mc.touchEnabled = true;
		for (let i = 0; i < this.btnArr.length; i++) {
			this[this.btnArr[i]].touchEnabled = true;
			this[this.btnArr[i]].addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
		}
	}
	public hide(): void {
		super.hide();
		this.mc.touchEnabled = false;
		for (let i = 0; i < this.btnArr.length; i++) {
			this[this.btnArr[i]].touchEnabled = false;
			this[this.btnArr[i]].removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
		}
	}
}