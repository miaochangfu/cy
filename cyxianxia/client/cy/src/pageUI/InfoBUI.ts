/**
 *
 *
 *
 *自动生成类
 *
 *请不要直接在此编码  重新生成会覆盖此类的
 *
 *如非必要请勿改动
 *
 *
 */
class InfoBUI extends wy.BaseSprite {
	constructor() {
		super();
		this.width = 750;
		this.height = 1334;
		this.createChildren();
	}

	public pop0:egret.Bitmap;
	public pop1:egret.Bitmap;
	public pop2:egret.Bitmap;

	protected createChildren():void {
		this.pop0 = new egret.Bitmap(RES.getRes("InfoB_pop0_png"));
		this.pop0.x = 137;
		this.pop0.y = 541;
		this.addChild(this.pop0);

		this.pop1 = new egret.Bitmap(RES.getRes("InfoB_pop1_png"));
		this.pop1.x = 176;
		this.pop1.y = 687;
		this.addChild(this.pop1);

		this.pop2 = new egret.Bitmap(RES.getRes("InfoB_pop2_png"));
		this.pop2.x = 426;
		this.pop2.y = 689;
		this.addChild(this.pop2);



		//动画
	}
}