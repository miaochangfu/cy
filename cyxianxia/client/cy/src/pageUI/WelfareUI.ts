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
class WelfareUI extends wy.BaseSprite {
	constructor() {
		super();
		this.width = 750;
		this.height = 1334;
		this.createChildren();
	}

	public mc:egret.Bitmap;
	public bg:egret.Bitmap;
	public btn1:egret.Bitmap;
	public btn2:egret.Bitmap;
	public backBtn:egret.Bitmap;

	protected createChildren():void {
		this.mc = new egret.Bitmap(RES.getRes("mc_png"));
		this.mc.x = 0;
		this.mc.y = 0;
		this.addChild(this.mc);

		this.bg = new egret.Bitmap(RES.getRes("Welfare_bg_png"));
		this.bg.x = 15;
		this.bg.y = 202;
		this.addChild(this.bg);

		this.btn1 = new egret.Bitmap(RES.getRes("Welfare_btn1_1_png"));
		this.btn1.x = 113;
		this.btn1.y = 299;
		this.btn1.name = "btn";
		this.addChild(this.btn1);

		this.btn2 = new egret.Bitmap(RES.getRes("Welfare_btn2_1_png"));
		this.btn2.x = 387;
		this.btn2.y = 299;
		this.btn2.name = "btn";
		this.addChild(this.btn2);

		this.backBtn = new egret.Bitmap(RES.getRes("Welfare_backBtn_png"));
		this.backBtn.x = 654;
		this.backBtn.y = 267;
		this.backBtn.name = "btn";
		this.addChild(this.backBtn);



		//动画
	}
}