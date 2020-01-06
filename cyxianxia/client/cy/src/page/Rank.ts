/**
 *
 *@author
 *
 */
class Rank extends RankUI {
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
		this.myscrollView = MyTools.createSrollView(52, 270, 750, 660, this);
		this.myscrollView.setContent(this.scrollCon);
		this.list = MyTools.createList(0, 0, 750, 1, 0, 8, this.scrollCon);
		this.list.itemRenderer = RankItem;
		this.myscrollView.verticalScrollPolicy = 'off';
	}

	public show(data?): void {
		super.show(data);

		this.touchInit();
		this.btn1_1.visible = false; this.btn1_2.visible = true;
		this.btn2_1.visible = true; this.btn2_2.visible = false;
		this.btn3_1.visible = true; this.btn3_2.visible = false;

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
				wy.hidePopUpView();
				wy.hideView();
				break;
			case this.btn1_1:
				this.btn1_1.visible = false; this.btn1_2.visible = true;
				this.btn2_1.visible = true; this.btn2_2.visible = false;
				this.btn3_1.visible = true; this.btn3_2.visible = false;

				break;
			case this.btn2_1:
				this.btn1_1.visible = true; this.btn1_2.visible = false;
				this.btn2_1.visible = false; this.btn2_2.visible = true;
				this.btn3_1.visible = true; this.btn3_2.visible = false;

				break;
			case this.btn3_1:
				this.btn1_1.visible = true; this.btn1_2.visible = false;
				this.btn2_1.visible = true; this.btn2_2.visible = false;
				this.btn3_1.visible = false; this.btn3_2.visible = true;

				break;
			case this.upBtn:

				break;
			case this.nextBtn:

				break;
			default:
				break;
		}
	}

	private btnArr: any = ['backBtn', 'btn1_1', 'btn2_1', 'btn3_1', 'nextBtn', 'upBtn'];
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