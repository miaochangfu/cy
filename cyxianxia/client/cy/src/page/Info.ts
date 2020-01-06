/**
 *
 *@author
 *
 */
class Info extends InfoUI {
	constructor() {
		super();
	}

	protected createChildren(): void {
		super.createChildren();
	}

	public show(data?): void {
		super.show(data);

		this.touchInit();

		this.btn1_1.visible = false; this.btn1_2.visible = true;
		this.btn2_1.visible = true; this.btn2_2.visible = false;
		this.btn3_1.visible = true; this.btn3_2.visible = false;
		wy.openPopUpView(InfoA);
	}

	private onTouchTap(e: egret.TouchEvent): void {
		switch (e.currentTarget) {
			case this.backBtn:
				wy.hidePopUpView();
				wy.hideView();
				break;
			case this.btn1_1:
				this.btn1_1.visible = false; this.btn1_2.visible = true;
				this.btn2_1.visible = true; this.btn2_2.visible = false;
				this.btn3_1.visible = true; this.btn3_2.visible = false;
				wy.openPopUpView(InfoA);
				break;
			case this.btn2_1:
				this.btn1_1.visible = true; this.btn1_2.visible = false;
				this.btn2_1.visible = false; this.btn2_2.visible = true;
				this.btn3_1.visible = true; this.btn3_2.visible = false;
				wy.openPopUpView(InfoB);
				break;
			case this.btn3_1:
				this.btn1_1.visible = true; this.btn1_2.visible = false;
				this.btn2_1.visible = true; this.btn2_2.visible = false;
				this.btn3_1.visible = false; this.btn3_2.visible = true;
				wy.openPopUpView(InfoC);
				break;
			default:
				break;
		}
	}

	private btnArr: any = ['backBtn', 'btn1_1', 'btn2_1', 'btn3_1'];
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