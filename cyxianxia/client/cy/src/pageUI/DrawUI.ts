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
class DrawUI extends wy.BaseSprite {
	constructor() {
		super();
		this.width = 750;
		this.height = 1334;
		this.createChildren();
	}

	public mc:egret.Bitmap;
	public bg:egret.Bitmap;
	public chooseImg0:egret.Bitmap;
	public chooseImg1:egret.Bitmap;
	public chooseImg2:egret.Bitmap;
	public chooseImg3:egret.Bitmap;
	public chooseImg4:egret.Bitmap;
	public chooseImg5:egret.Bitmap;
	public chooseImg6:egret.Bitmap;
	public chooseImg7:egret.Bitmap;
	public prizeImg:egret.Bitmap;
	public startBtn:egret.Bitmap;
	public chanceImg:egret.Bitmap;
	public chanceTxt:egret.TextField;
	public startImg:egret.Bitmap;
	public backBtn:egret.Bitmap;

	protected createChildren():void {
		this.mc = new egret.Bitmap(RES.getRes("mc_png"));
		this.mc.x = 0;
		this.mc.y = 0;
		this.addChild(this.mc);

		this.bg = new egret.Bitmap(RES.getRes("Draw_bg_png"));
		this.bg.x = 8;
		this.bg.y = 282;
		this.addChild(this.bg);

		this.chooseImg0 = new egret.Bitmap(RES.getRes("Draw_chooseImg_png"));
		this.chooseImg0.x = 310;
		this.chooseImg0.y = 327;
		this.addChild(this.chooseImg0);

		this.chooseImg1 = new egret.Bitmap(RES.getRes("Draw_chooseImg_png"));
		this.chooseImg1.x = 450;
		this.chooseImg1.y = 381;
		this.addChild(this.chooseImg1);

		this.chooseImg2 = new egret.Bitmap(RES.getRes("Draw_chooseImg_png"));
		this.chooseImg2.x = 506;
		this.chooseImg2.y = 519;
		this.addChild(this.chooseImg2);

		this.chooseImg3 = new egret.Bitmap(RES.getRes("Draw_chooseImg_png"));
		this.chooseImg3.x = 450;
		this.chooseImg3.y = 657;
		this.addChild(this.chooseImg3);

		this.chooseImg4 = new egret.Bitmap(RES.getRes("Draw_chooseImg_png"));
		this.chooseImg4.x = 310;
		this.chooseImg4.y = 711;
		this.addChild(this.chooseImg4);

		this.chooseImg5 = new egret.Bitmap(RES.getRes("Draw_chooseImg_png"));
		this.chooseImg5.x = 173;
		this.chooseImg5.y = 655;
		this.addChild(this.chooseImg5);

		this.chooseImg6 = new egret.Bitmap(RES.getRes("Draw_chooseImg_png"));
		this.chooseImg6.x = 120;
		this.chooseImg6.y = 516;
		this.addChild(this.chooseImg6);

		this.chooseImg7 = new egret.Bitmap(RES.getRes("Draw_chooseImg_png"));
		this.chooseImg7.x = 174;
		this.chooseImg7.y = 385;
		this.addChild(this.chooseImg7);

		this.prizeImg = new egret.Bitmap(RES.getRes("Draw_prizeImg_png"));
		this.prizeImg.x = 190;
		this.prizeImg.y = 349;
		this.addChild(this.prizeImg);

		this.startBtn = new egret.Bitmap(RES.getRes("Draw_startBtn_png"));
		this.startBtn.x = 376.5;
		this.startBtn.y = 582;
		this.startBtn.anchorOffsetX = 58;
		this.startBtn.anchorOffsetY = 106;
		this.startBtn.name = "btn";
		this.addChild(this.startBtn);

		this.chanceImg = new egret.Bitmap(RES.getRes("Draw_chanceImg_png"));
		this.chanceImg.x = 286;
		this.chanceImg.y = 646;
		this.addChild(this.chanceImg);

		this.chanceTxt = new egret.TextField();
		this.chanceTxt.text = "label";
		this.chanceTxt.textAlign = "center";
		this.chanceTxt.size = 20;
		this.chanceTxt.textColor = 0;
		this.chanceTxt.x = 300;
		this.chanceTxt.y = 654;
		this.chanceTxt.width = 150;
		this.chanceTxt.height = 21;
		this.addChild(this.chanceTxt);

		this.startImg = new egret.Bitmap(RES.getRes("Draw_startImg_png"));
		this.startImg.x = 344;
		this.startImg.y = 565;
		this.addChild(this.startImg);

		this.backBtn = new egret.Bitmap(RES.getRes("backBtn2_png"));
		this.backBtn.x = 592;
		this.backBtn.y = 258;
		this.backBtn.name = "btn";
		this.addChild(this.backBtn);



		//动画
	}
}