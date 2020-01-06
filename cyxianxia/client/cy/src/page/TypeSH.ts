/**
 *
 *@author
 *
 */
class TypeSH extends TypeSHUI {
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
		this.myscrollView = MyTools.createSrollView(100, 300, 750, 960, this);
		this.myscrollView.setContent(this.scrollCon);
		this.list = MyTools.createList(0, 0, 750, 2, -46, 15, this.scrollCon);
		this.list.itemRenderer = TypeSHItem;
		this.myscrollView.horizontalScrollPolicy = 'off';
	}

	public show(data?): void {
		super.show(data);

		this.touchInit();

		this.btn1_1.visible = false;
		this.btn1_2.visible = true;
		this.btn2_1.visible = true;
		this.btn2_2.visible = false;

		this.circle1.alpha = 1;
		this.circle2.alpha = 0;

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
			case this.btn1_1:
				this.btn1_1.visible = false; this.btn1_2.visible = true;
				this.btn2_1.visible = true; this.btn2_2.visible = false;
				this.sex0.visible = this.sex1.visible = this.circle1.visible = this.circle2.visible = true;

				break;
			case this.btn2_1:
				this.btn1_1.visible = true; this.btn1_2.visible = false;
				this.btn2_1.visible = false; this.btn2_2.visible = true;
				this.sex0.visible = this.sex1.visible = this.circle1.visible = this.circle2.visible = false;
				break;
			case this.sex1:
				this.circle1.alpha = 1;
				this.circle2.alpha = 0;
				break;
			case this.sex0:
				this.circle1.alpha = 0;
				this.circle2.alpha = 1;
				break;
			default:
				break;
		}
	}


	private btnArr: any = ['backBtn', 'btn1_1', 'btn2_1', 'sex1', 'sex0'];
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