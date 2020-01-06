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
class GameFMUI extends wy.BaseSprite {
	constructor() {
		super();
		this.width = 624;
		this.height = 432;
		this.createChildren();
	}

	public bg:egret.Bitmap;
	public timeTxt:egret.TextField;
	public eleImg1:egret.Bitmap;
	public eleImg2:egret.Bitmap;
	public eleImg3:egret.Bitmap;
	public eleImg0:egret.Bitmap;
	public chooseA:egret.Bitmap;
	public chooseB:egret.Bitmap;

	protected createChildren():void {
		this.bg = new egret.Bitmap(RES.getRes("GameFM_bg_png"));
		this.bg.x = 0;
		this.bg.y = 0;
		this.addChild(this.bg);

		this.timeTxt = new egret.TextField();
		this.timeTxt.text = "label";
		this.timeTxt.textAlign = "center";
		this.timeTxt.size = 30;
		this.timeTxt.textColor = 0xffffff;
		this.timeTxt.x = 253;
		this.timeTxt.y = 32;
		this.timeTxt.width = 100;
		this.timeTxt.height = 34;
		this.addChild(this.timeTxt);

		this.eleImg1 = new egret.Bitmap(RES.getRes("GameFM_eleImgB_png"));
		this.eleImg1.x = 230;
		this.eleImg1.y = 104;
		this.addChild(this.eleImg1);

		this.eleImg2 = new egret.Bitmap(RES.getRes("GameFM_eleImgB_png"));
		this.eleImg2.x = 317;
		this.eleImg2.y = 104;
		this.addChild(this.eleImg2);

		this.eleImg3 = new egret.Bitmap(RES.getRes("GameFM_eleImgB_png"));
		this.eleImg3.x = 405;
		this.eleImg3.y = 104;
		this.addChild(this.eleImg3);

		this.eleImg0 = new egret.Bitmap(RES.getRes("GameFM_eleImgA_png"));
		this.eleImg0.x = 143;
		this.eleImg0.y = 104;
		this.addChild(this.eleImg0);

		this.chooseA = new egret.Bitmap(RES.getRes("GameFM_eleImgC_png"));
		this.chooseA.x = 180;
		this.chooseA.y = 232;
		this.addChild(this.chooseA);

		this.chooseB = new egret.Bitmap(RES.getRes("GameFM_eleImgC_png"));
		this.chooseB.x = 342;
		this.chooseB.y = 232;
		this.addChild(this.chooseB);



		//动画
	}
}