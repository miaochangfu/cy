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
class MountainUI extends wy.BaseSprite {
	constructor() {
		super();
		this.width = 750;
		this.height = 1334;
		this.createChildren();
	}

	public mc:egret.Bitmap;
	public bg:egret.Bitmap;
	public btn2_2:egret.Bitmap;
	public btn2_1:egret.Bitmap;
	public btn1_1:egret.Bitmap;
	public btn1_2:egret.Bitmap;
	public btn1_3:egret.Bitmap;
	public backBtn:egret.Bitmap;

	protected createChildren():void {
		this.mc = new egret.Bitmap(RES.getRes("mc_png"));
		this.mc.x = 0;
		this.mc.y = 0;
		this.addChild(this.mc);

		this.bg = new egret.Bitmap(RES.getRes("Mountain_bg_png"));
		this.bg.x = 0;
		this.bg.y = 280;
		this.addChild(this.bg);

		this.btn2_2 = new egret.Bitmap(RES.getRes("Mountain_btn2_2_png"));
		this.btn2_2.x = 386;
		this.btn2_2.y = 709;
		this.btn2_2.name = "btn";
		this.addChild(this.btn2_2);

		this.btn2_1 = new egret.Bitmap(RES.getRes("Mountain_btn2_1_png"));
		this.btn2_1.x = 166;
		this.btn2_1.y = 709;
		this.btn2_1.name = "btn";
		this.addChild(this.btn2_1);

		this.btn1_1 = new egret.Bitmap(RES.getRes("Mountain_btn1_1_png"));
		this.btn1_1.x = 162;
		this.btn1_1.y = 399;
		this.btn1_1.name = "btn";
		this.addChild(this.btn1_1);

		this.btn1_2 = new egret.Bitmap(RES.getRes("Mountain_btn1_2_png"));
		this.btn1_2.x = 345;
		this.btn1_2.y = 399;
		this.btn1_2.name = "btn";
		this.addChild(this.btn1_2);

		this.btn1_3 = new egret.Bitmap(RES.getRes("Mountain_btn1_3_png"));
		this.btn1_3.x = 524;
		this.btn1_3.y = 399;
		this.btn1_3.name = "btn";
		this.addChild(this.btn1_3);

		this.backBtn = new egret.Bitmap(RES.getRes("backBtn2_png"));
		this.backBtn.x = 655;
		this.backBtn.y = 329;
		this.backBtn.name = "btn";
		this.addChild(this.backBtn);



		//动画
	}
}