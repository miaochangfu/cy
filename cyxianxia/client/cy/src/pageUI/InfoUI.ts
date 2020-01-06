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
class InfoUI extends wy.BaseSprite {
	constructor() {
		super();
		this.width = 750;
		this.height = 1334;
		this.createChildren();
	}

	public mc:egret.Bitmap;
	public dkImg:egret.Bitmap;
	public btn1_1:egret.Bitmap;
	public btn2_1:egret.Bitmap;
	public btn3_1:egret.Bitmap;
	public btn1_2:egret.Bitmap;
	public btn2_2:egret.Bitmap;
	public btn3_2:egret.Bitmap;
	public backBtn:egret.TextField;

	protected createChildren():void {
		this.mc = new egret.Bitmap(RES.getRes("mc_png"));
		this.mc.x = 0;
		this.mc.y = 0;
		this.addChild(this.mc);

		this.dkImg = new egret.Bitmap(RES.getRes("Info_dkImg_png"));
		this.dkImg.x = 24;
		this.dkImg.y = 135;
		this.addChild(this.dkImg);

		this.btn1_1 = new egret.Bitmap(RES.getRes("Info_btn1_1_png"));
		this.btn1_1.x = 64;
		this.btn1_1.y = 184;
		this.btn1_1.name = "btn";
		this.addChild(this.btn1_1);

		this.btn2_1 = new egret.Bitmap(RES.getRes("Info_btn2_1_png"));
		this.btn2_1.x = 216;
		this.btn2_1.y = 184;
		this.btn2_1.name = "btn";
		this.addChild(this.btn2_1);

		this.btn3_1 = new egret.Bitmap(RES.getRes("Info_btn3_1_png"));
		this.btn3_1.x = 368;
		this.btn3_1.y = 184;
		this.btn3_1.name = "btn";
		this.addChild(this.btn3_1);

		this.btn1_2 = new egret.Bitmap(RES.getRes("Info_btn1_2_png"));
		this.btn1_2.x = 63;
		this.btn1_2.y = 175;
		this.btn1_2.name = "btn";
		this.addChild(this.btn1_2);

		this.btn2_2 = new egret.Bitmap(RES.getRes("Info_btn2_2_png"));
		this.btn2_2.x = 156;
		this.btn2_2.y = 175;
		this.btn2_2.name = "btn";
		this.addChild(this.btn2_2);

		this.btn3_2 = new egret.Bitmap(RES.getRes("Info_btn3_2_png"));
		this.btn3_2.x = 306;
		this.btn3_2.y = 175;
		this.btn3_2.name = "btn";
		this.addChild(this.btn3_2);

		this.backBtn = new egret.TextField();
		this.backBtn.text = "";
		this.backBtn.x = 681;
		this.backBtn.y = 164;
		this.backBtn.width = 50;
		this.backBtn.height = 50;
		this.backBtn.textAlign = "center";
		this.addChild(this.backBtn);



		//动画
	}
}