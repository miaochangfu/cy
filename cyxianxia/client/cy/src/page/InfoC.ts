/**
 *
 *@author
 *
 */
class InfoC extends InfoCUI {
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
		this.myscrollView = MyTools.createSrollView(55, 255, 750, 825, this);
		this.myscrollView.setContent(this.scrollCon);
		this.list = MyTools.createList(0, 0, 750, 1, 0, 12, this.scrollCon);
		this.list.itemRenderer = InfoCItem;
		// this.myscrollView.verticalScrollPolicy = 'off';
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

			default:
				break;
		}
	}



	private touchInit() {

	}
	public hide(): void {
		super.hide();


	}

}