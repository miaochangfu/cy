/**
 *
 *@author
 *
 */
class Home extends HomeUI {
	constructor() {
		super();
	}

	protected createChildren(): void {
		super.createChildren();
		this.hintRed.alpha = 0;
	}

	public show(data?): void {
		super.show(data);

		this.touchInit();
	}

	private onTouchTap(e: egret.TouchEvent): void {
		switch (e.currentTarget) {
			case this.leftBtn1://个人
				wy.changeView(Info);
				break;
			case this.leftBtn2://排行
				wy.changeView(Rank);
				break;
			case this.leftBtn3://免费福利
				wy.changeView(Welfare);
				break;
			case this.leftBtn4://设置
				wy.changeView(SetP);
				break;
			case this.rightBtn1://邮件
				wy.changeView(MailA);
				break;
			case this.rightBtn2://转盘
				wy.changeView(Draw);
				break;
			case this.rightBtn3://华山论剑
				wy.changeView(Mountain);
				break;
			case this.rightBtn4://裳帛轩
				wy.changeView(TypeSH);
				break;
			case this.startBtn://单人
				wy.changeScene(Game);
				break;
			default:
				break;
		}
	}

	private btnArr: any = ['startBtn', 'leftBtn1', 'leftBtn2', 'leftBtn3', 'leftBtn4', 'rightBtn1', 'rightBtn2', 'rightBtn3', 'rightBtn4'];
	private touchInit() {
		this.bg.touchEnabled = true;
		for (let i = 0; i < this.btnArr.length; i++) {
			this[this.btnArr[i]].touchEnabled = true;
			this[this.btnArr[i]].addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
		}
	}
	public hide(): void {
		super.hide();
		this.bg.touchEnabled = false;
		for (let i = 0; i < this.btnArr.length; i++) {
			this[this.btnArr[i]].touchEnabled = false;
			this[this.btnArr[i]].removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
		}
	}
}