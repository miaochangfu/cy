/**
 *
 *@author
 *
 */
class Welfare extends WelfareUI {
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
		this.myscrollView = MyTools.createSrollView(107, 385, 750, 460, this);
		this.myscrollView.setContent(this.scrollCon);
		this.list = MyTools.createList(0, 0, 750, 1, 0, 7, this.scrollCon);
		this.list.itemRenderer = WelfareItem;
		// this.myscrollView.verticalScrollPolicy = 'off';
	}

	public show(data?): void {
		super.show(data);

		this.touchInit();

		this.btn1.touchEnabled = false;
		this.btn2.texture = RES.getRes('Welfare_btn2_2_png');

		this.total = ["", "", "", "", ""];
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
				this.btn1.touchEnabled = false;
				this.btn2.touchEnabled = true;
				this.btn1.texture = RES.getRes('Welfare_btn1_1_png');
				this.btn2.texture = RES.getRes('Welfare_btn2_2_png');
				this.total = ["", "", "", "", ""];
				this.onMsg();
				break;
			case this.btn2:
				this.btn2.touchEnabled = false;
				this.btn1.touchEnabled = true;
				this.btn1.texture = RES.getRes('Welfare_btn1_2_png');
				this.btn2.texture = RES.getRes('Welfare_btn2_1_png');
				this.total = ["", "", "", "", "", "", "", "", "", "", ""];
				this.onMsg();
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