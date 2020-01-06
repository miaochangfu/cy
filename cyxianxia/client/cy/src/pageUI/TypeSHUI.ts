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
class TypeSHUI extends wy.BaseSprite {
	constructor() {
		super();
		this.width = 750;
		this.height = 1334;
		this.createChildren();
	}

	public mc:egret.Bitmap;
	public bg:egret.Bitmap;
	public sex1:egret.Bitmap;
	public sex0:egret.Bitmap;
	public circle2:egret.Bitmap;
	public circle1:egret.Bitmap;
	public btn1_1:egret.Bitmap;
	public btn2_1:egret.Bitmap;
	public btn2_2:egret.Bitmap;
	public btn1_2:egret.Bitmap;
	public backBtn:egret.TextField;

	protected createChildren():void {
		this.mc = new egret.Bitmap(RES.getRes("mc_png"));
		this.mc.x = 0;
		this.mc.y = 0;
		this.addChild(this.mc);

		this.bg = new egret.Bitmap(RES.getRes("TypeSH_bg_png"));
		this.bg.x = 0;
		this.bg.y = 35;
		this.addChild(this.bg);

		this.sex1 = new egret.Bitmap(RES.getRes("TypeSH_sex1_png"));
		this.sex1.x = 118;
		this.sex1.y = 252;
		this.addChild(this.sex1);

		this.sex0 = new egret.Bitmap(RES.getRes("TypeSH_sex0_png"));
		this.sex0.x = 243;
		this.sex0.y = 251;
		this.addChild(this.sex0);

		this.circle2 = new egret.Bitmap(RES.getRes("TypeSH_circle1_png"));
		this.circle2.x = 289;
		this.circle2.y = 258;
		this.addChild(this.circle2);

		this.circle1 = new egret.Bitmap(RES.getRes("TypeSH_circle1_png"));
		this.circle1.x = 159;
		this.circle1.y = 258;
		this.addChild(this.circle1);

		this.btn1_1 = new egret.Bitmap(RES.getRes("TypeSH_btn1_1_png"));
		this.btn1_1.x = 84;
		this.btn1_1.y = 184;
		this.btn1_1.name = "btn";
		this.addChild(this.btn1_1);

		this.btn2_1 = new egret.Bitmap(RES.getRes("TypeSH_btn2_1_png"));
		this.btn2_1.x = 235;
		this.btn2_1.y = 184;
		this.btn2_1.name = "btn";
		this.addChild(this.btn2_1);

		this.btn2_2 = new egret.Bitmap(RES.getRes("TypeSH_btn2_2_png"));
		this.btn2_2.x = 176;
		this.btn2_2.y = 180;
		this.btn2_2.name = "btn";
		this.addChild(this.btn2_2);

		this.btn1_2 = new egret.Bitmap(RES.getRes("TypeSH_btn1_2_png"));
		this.btn1_2.x = 28;
		this.btn1_2.y = 180;
		this.btn1_2.name = "btn";
		this.addChild(this.btn1_2);

		this.backBtn = new egret.TextField();
		this.backBtn.text = "";
		this.backBtn.x = 676;
		this.backBtn.y = 147;
		this.backBtn.width = 60;
		this.backBtn.height = 60;
		this.addChild(this.backBtn);



		//动画
	}
}