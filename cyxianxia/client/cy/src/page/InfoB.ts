/**
 *
 *@author
 *
 */
class InfoB extends InfoBUI {
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
		this.myscrollView = MyTools.createSrollView(52, 255, 750, 835, this);
		this.myscrollView.setContent(this.scrollCon);
		this.list = MyTools.createList(0, 0, 750, 3, -40, 22, this.scrollCon);
		this.list.itemRenderer = InfoBItem;
		// this.myscrollView.verticalScrollPolicy = 'off';
	}

	public show(data?): void {
		super.show(data);

		this.touchInit();

		this.pop0.visible = this.pop1.visible = this.pop2.visible = false;
		wy.on(this.isChoose, 'isChoose', this);

		this.total = ["", "", "", "", "", "", "", "", "", "", ""];
		this.onMsg();
	}
	private isChoose(data) {
		this.pop0.visible = this.pop1.visible = this.pop2.visible = true;
	}

	/**刷新数据 */
	private onMsg(): void {
		this.list.dataProvider = this.total;
		this.list.updateDisplayList();
	}



	private onTouchTap(e: egret.TouchEvent): void {
		switch (e.currentTarget) {
			case this.pop1:

				break;
			case this.pop2:

				break;
			default:
				break;
		}
	}



	private touchInit() {
		this.pop1.touchEnabled = true;
		this.pop1.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
		this.pop2.touchEnabled = true;
		this.pop2.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
	}
	public hide(): void {
		super.hide();
		wy.off(this.isChoose, 'isChoose', this);
		this.pop1.touchEnabled = false;
		this.pop1.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
		this.pop2.touchEnabled = false;
		this.pop2.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
	}

}