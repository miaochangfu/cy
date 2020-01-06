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
class GameMUI extends wy.BaseSprite {
	constructor() {
		super();
		this.width = 750;
		this.height = 1334;
		this.createChildren();
	}

	public bg:egret.Bitmap;
	public backBtn:egret.Bitmap;
	public selfImg:egret.Bitmap;
	public ele0:egret.Bitmap;
	public fhBtn:egret.Bitmap;
	public fhImg:egret.Bitmap;
	public fhTxt:egret.TextField;
	public theme:egret.Bitmap;
	public nickname:egret.TextField;
	public headBit:egret.Bitmap;

	protected createChildren():void {
		this.bg = new egret.Bitmap(RES.getRes("GameFM_bg_jpg"));
		this.bg.x = 0;
		this.bg.y = 0;
		this.addChild(this.bg);

		this.backBtn = new egret.Bitmap(RES.getRes("backBtn_png"));
		this.backBtn.x = 21;
		this.backBtn.y = 13;
		this.backBtn.name = "btn";
		this.addChild(this.backBtn);

		this.selfImg = new egret.Bitmap(RES.getRes("GameM_selfImg_png"));
		this.selfImg.x = 283;
		this.selfImg.y = 967;
		this.addChild(this.selfImg);

		this.ele0 = new egret.Bitmap(RES.getRes("GameM_ele0_png"));
		this.ele0.x = 299;
		this.ele0.y = 476;
		this.addChild(this.ele0);

		this.fhBtn = new egret.Bitmap(RES.getRes("GameFM_fhBtn_png"));
		this.fhBtn.x = 590;
		this.fhBtn.y = 1051;
		this.fhBtn.name = "btn";
		this.addChild(this.fhBtn);

		this.fhImg = new egret.Bitmap(RES.getRes("GameFM_fhImg_png"));
		this.fhImg.x = 660;
		this.fhImg.y = 1109;
		this.addChild(this.fhImg);

		this.fhTxt = new egret.TextField();
		this.fhTxt.text = "3";
		this.fhTxt.textAlign = "center";
		this.fhTxt.size = 18;
		this.fhTxt.textColor = 0xffffff;
		this.fhTxt.x = 662;
		this.fhTxt.y = 1110;
		this.fhTxt.width = 20;
		this.fhTxt.height = 20;
		this.addChild(this.fhTxt);

		this.theme = new egret.Bitmap(RES.getRes("GameM_theme_png"));
		this.theme.x = 265;
		this.theme.y = 13;
		this.addChild(this.theme);

		this.nickname = new egret.TextField();
		this.nickname.text = "label";
		this.nickname.x = 301.25;
		this.nickname.y = 1112.6;
		this.nickname.width = 150;
		this.nickname.height = 25;
		this.nickname.textAlign = "center";
		this.nickname.textColor = 0xfffffff;
		this.nickname.size = 22;
		this.addChild(this.nickname);

		this.headBit = new egret.Bitmap(RES.getRes("headBit_png"));
		this.headBit.x = 334;
		this.headBit.y = 1001.85;
		this.addChild(this.headBit);



		//动画
	}
}