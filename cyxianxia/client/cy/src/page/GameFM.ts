/**
 *
 *@author
 *
 */
class GameFM extends GameFMUI {
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
			case this.bg:

				break;
			case this.chooseA:

				break;
			case this.chooseB:

				break;
			default:
				break;
		}
	}

	private touchInit() {
		this.bg.touchEnabled = true;
		this.chooseA.touchEnabled = true;
		this.chooseA.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
		this.chooseB.touchEnabled = true;
		this.chooseB.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
	}
	public hide(): void {
		super.hide();
		this.bg.touchEnabled = false;
		this.chooseA.touchEnabled = false;
		this.chooseA.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
		this.chooseB.touchEnabled = false;
		this.chooseB.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
	}

}