/**
 *
 *@author
 *
 */
class Chat extends ChatUI {
	constructor() {
		super();
	}

	protected createChildren(): void {
		super.createChildren();
		this.chatTxt.verticalAlign = 'middle';
		this.ele2.name = 'btn';
	}

	public show(data?): void {
		super.show(data);

		this.touchInit();
	}

	private onTouchTap(e: egret.TouchEvent): void {
		switch (e.currentTarget) {
			case this.ele2://发送聊天

				break;
			default:
				break;
		}
	}

	private touchInit() {
		this.ele2.touchEnabled = true;
		this.ele2.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
	}
	public hide(): void {
		super.hide();
		this.ele2.touchEnabled = false;
		this.ele2.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
	}
}