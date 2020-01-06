/**
 *
 *@author
 *
 */
class Draw extends DrawUI {
	constructor() {
		super();
	}

	protected createChildren(): void {
		super.createChildren();
		this.startBtn.name = "";
	}

	public show(data?): void {
		super.show(data);

		this.touchInit();
		// wy.Tools.setAnchor(this.startBtn, 58, 116);

	}

	private onTouchTap(e: egret.TouchEvent): void {
		switch (e.currentTarget) {
			case this.backBtn:
				wy.hideView();
				break;
			case this.startBtn:
				this.startBtn.touchEnabled = false;
				this.getPrize();
				break;
			default:
				break;
		}
	}
	private prize: number = 0;
	private prize_type: number = 0;
	/**抽奖 */
	private getPrize() {
		// wy.LoadingData.open();
		// Net.getPlayerGachaAPI(this, (e: egret.Event) => {
		// 	wy.LoadingData.close();
		// 	console.log(e.target.response);
		// 	var data = JSON.parse(e.target.response);
		// 	if (data.status == 'SUCCESS') {
		// this.prize = Number(data.playerGetRewardRes.index);
		this.prize = 3;
		console.log("prizeIndex====" + this.prize);
		var angle: number = 0;//旋转的角度  [￥10代金券]
		switch (this.prize) {
			case 1://奖品1
				angle = 0;
				break;
			case 2://奖品2
				angle = 45;
				break;
			case 3://奖品3
				angle = 90;
				break;
			case 4://奖品4
				angle = 135;
				break;
			case 5://奖品5
				angle = 180;
				break;
			case 6://奖品6
				angle = 225;
				break;
			case 7://奖品7
				angle = 270;
				break;
			case 8://奖品8
				angle = 315;
				break;
		}
		egret.Tween.get(this.startBtn).wait(1).to({ rotation: 1800 + angle }, 3000, egret.Ease.cubicOut).wait(500).call(() => {

		}, this)
		// 	}
		// 			else {
		// 	this.startBtn.touchEnabled = true;
		// 	// ('没有抽奖机会');
		// 	MyTools.hintMethod('抽奖次数不足');
		// }
		// 		}, Number(StaticVar.USER_PLAYERID));
	}



	private touchInit() {
		this.mc.touchEnabled = true;
		this.startBtn.touchEnabled = true;
		this.startBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
		this.backBtn.touchEnabled = true;
		this.backBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
	}

	public hide(): void {
		super.hide();
		this.mc.touchEnabled = false;
		this.startBtn.touchEnabled = false;
		this.startBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
		this.backBtn.touchEnabled = false;
		this.backBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
	}

}