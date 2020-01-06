/**
 *
 *@author
 *
 */
class MailC extends MailCUI {
	constructor() {
		super();
	}

	private list: wy.List;
	private myscrollView: egret.ScrollView;//滑动
	private scrollCon: egret.Sprite;//加载在滑动上的容器
	/**存储数据的数组 */
	private total: any[];
	protected createChildren(): void {
		super.createChildren();
		//添加一个容器到上面
		this.scrollCon = new egret.Sprite();
		this.myscrollView = MyTools.createSrollView(127, 535, 750, 500, this);
		this.myscrollView.setContent(this.scrollCon);
		this.list = MyTools.createList(0, 0, 750, 1, 0, 10, this.scrollCon);
		this.list.itemRenderer = MailCItem;
		this.myscrollView.horizontalScrollPolicy = 'off';
	}

	public show(data?): void {
		super.show(data);

		this.touchInit();

		this.total = ["", "", "", "", "", "", "", "", "", "", ""];
		this.onMsg();
	}

	/**刷新数据 */
	private onMsg(): void {
		this.list.dataProvider = this.total;
		this.list.updateDisplayList();
	}



	private onTouchTap(e: egret.TouchEvent): void {
		switch (e.currentTarget) {
			case this.backBtn:
				wy.hideView();
				break;
			case this.btn1:
				wy.changeView(MailA);
				break;
			case this.btn2:
				wy.changeView(MailB);
				break;
			default:
				break;
		}
	}

	private btnArr: any = ['backBtn', 'btn1', 'btn2'];
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