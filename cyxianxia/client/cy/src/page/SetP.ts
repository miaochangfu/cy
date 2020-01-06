/**
 *
 *@author
 *
 */
class SetP extends SetPUI {
	constructor() {
		super();
	}

	protected createChildren(): void {
		super.createChildren();
	}

	public show(data?): void {
		super.show(data);

		this.touchInit();

		this.showSet();
	}

	private onTouchTap(e: egret.TouchEvent): void {
		switch (e.currentTarget) {
			case this.backBtn:
				wy.hideView();
				break;
			case this.musciA_1:
				StaticVar.MUSIC_A = false;
				this.showSet();
				break;
			case this.musciA_2:
				StaticVar.MUSIC_A = true;
				this.showSet();
				break;
			case this.musciB_1:
				StaticVar.MUSIC_B = false;
				this.showSet();
				break;
			case this.musciB_2:
				StaticVar.MUSIC_B = true;
				this.showSet();
				break;
			case this.kfBtn:
				MyTools.hintMethod('客服');
				// if (!wx.openCustomerServiceConversation) {
				// 	return wy.Toast.setContent("您的微信版本过低，建议升级~");
				// }
				// wx.openCustomerServiceConversation({
				// 	sessionFrom: '',
				// 	showMessageCard: true,
				// 	sendMessageTitle: '玩游戏，捡红包',
				// 	sendMessagePath: '',
				// 	sendMessageImg: StaticVar.RESOURCE_LINKS + 'shareImg/share1.jpg',
				// 	success: (res) => {
				// 		//console.log('res---', res);
				// 	},
				// 	fail: err => {
				// 	},
				// 	complete: () => {
				// 	}
				// })
				break;
			default:
				break;
		}
	}

	private showSet() {
		this.musciA_1.alpha = StaticVar.MUSIC_A ? 0 : 1;
		this.musciA_2.alpha = StaticVar.MUSIC_A ? 1 : 0;
		this.musciB_1.alpha = StaticVar.MUSIC_B ? 0 : 1;
		this.musciB_2.alpha = StaticVar.MUSIC_B ? 1 : 0;
	}

	private btnArr: any = ['backBtn', 'musciA_1', 'musciA_2', 'musciB_1', 'musciB_2', 'kfBtn'];
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