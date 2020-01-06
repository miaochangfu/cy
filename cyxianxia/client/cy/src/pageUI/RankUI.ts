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
class RankUI extends wy.BaseSprite {
	constructor() {
		super();
		this.width = 750;
		this.height = 1334;
		this.createChildren();
	}

	public mc:egret.Bitmap;
	public ele0:egret.Bitmap;
	public upBtn:egret.Bitmap;
	public nextBtn:egret.Bitmap;
	public rankTxt:egret.TextField;
	public self1:egret.Bitmap;
	public self3:egret.Bitmap;
	public self4:egret.TextField;
	public self5:egret.TextField;
	public self6:egret.TextField;
	public self2:egret.TextField;
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

		this.ele0 = new egret.Bitmap(RES.getRes("Rank_ele0_png"));
		this.ele0.x = 0;
		this.ele0.y = 125;
		this.addChild(this.ele0);

		this.upBtn = new egret.Bitmap(RES.getRes("Rank_upBtn_png"));
		this.upBtn.x = 107;
		this.upBtn.y = 939;
		this.upBtn.name = "btn";
		this.addChild(this.upBtn);

		this.nextBtn = new egret.Bitmap(RES.getRes("Rank_nextBtn_png"));
		this.nextBtn.x = 480;
		this.nextBtn.y = 939;
		this.nextBtn.name = "btn";
		this.addChild(this.nextBtn);

		this.rankTxt = new egret.TextField();
		this.rankTxt.text = "label";
		this.rankTxt.textAlign = "center";
		this.rankTxt.size = 25;
		this.rankTxt.textColor = 0xffffff;
		this.rankTxt.x = 271;
		this.rankTxt.y = 958;
		this.rankTxt.width = 200;
		this.rankTxt.height = 30;
		this.addChild(this.rankTxt);

		this.self1 = new egret.Bitmap(RES.getRes("Rank_self1_png"));
		this.self1.x = 52;
		this.self1.y = 1026;
		this.addChild(this.self1);

		this.self3 = new egret.Bitmap(RES.getRes("Rank_self3_png"));
		this.self3.x = 153;
		this.self3.y = 1029;
		this.addChild(this.self3);

		this.self4 = new egret.TextField();
		this.self4.text = "label";
		this.self4.textAlign = "left";
		this.self4.size = 23;
		this.self4.textColor = 0xffffff;
		this.self4.x = 250;
		this.self4.y = 1053;
		this.self4.width = 146;
		this.self4.height = 25;
		this.addChild(this.self4);

		this.self5 = new egret.TextField();
		this.self5.text = "label";
		this.self5.textAlign = "left";
		this.self5.size = 18;
		this.self5.textColor = 0xcb6534;
		this.self5.x = 250;
		this.self5.y = 1087;
		this.self5.width = 118;
		this.self5.height = 20;
		this.addChild(this.self5);

		this.self6 = new egret.TextField();
		this.self6.text = "label";
		this.self6.textAlign = "center";
		this.self6.size = 25;
		this.self6.textColor = 0xf6cb52;
		this.self6.x = 474;
		this.self6.y = 1066;
		this.self6.width = 195;
		this.self6.height = 27;
		this.addChild(this.self6);

		this.self2 = new egret.TextField();
		this.self2.text = "label";
		this.self2.textAlign = "center";
		this.self2.size = 30;
		this.self2.textColor = 0xfdeaaa;
		this.self2.x = 82;
		this.self2.y = 1063;
		this.self2.width = 50;
		this.self2.height = 31;
		this.addChild(this.self2);

		this.btn1_1 = new egret.Bitmap(RES.getRes("Rank_btn1_1_png"));
		this.btn1_1.x = 62;
		this.btn1_1.y = 184;
		this.btn1_1.name = "btn";
		this.addChild(this.btn1_1);

		this.btn2_1 = new egret.Bitmap(RES.getRes("Rank_btn2_1_png"));
		this.btn2_1.x = 214;
		this.btn2_1.y = 184;
		this.btn2_1.name = "btn";
		this.addChild(this.btn2_1);

		this.btn3_1 = new egret.Bitmap(RES.getRes("Rank_btn3_1_png"));
		this.btn3_1.x = 366;
		this.btn3_1.y = 184;
		this.btn3_1.name = "btn";
		this.addChild(this.btn3_1);

		this.btn1_2 = new egret.Bitmap(RES.getRes("Rank_btn1_2_png"));
		this.btn1_2.x = 1;
		this.btn1_2.y = 175;
		this.btn1_2.name = "btn";
		this.addChild(this.btn1_2);

		this.btn2_2 = new egret.Bitmap(RES.getRes("Rank_btn2_2_png"));
		this.btn2_2.x = 153;
		this.btn2_2.y = 175;
		this.btn2_2.name = "btn";
		this.addChild(this.btn2_2);

		this.btn3_2 = new egret.Bitmap(RES.getRes("Rank_btn3_2_png"));
		this.btn3_2.x = 306;
		this.btn3_2.y = 175;
		this.btn3_2.name = "btn";
		this.addChild(this.btn3_2);

		this.backBtn = new egret.TextField();
		this.backBtn.text = "";
		this.backBtn.x = 699;
		this.backBtn.y = 153;
		this.backBtn.width = 50;
		this.backBtn.height = 50;
		this.backBtn.textAlign = "center";
		this.addChild(this.backBtn);



		//动画
	}
}