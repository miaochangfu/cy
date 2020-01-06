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
class GameFUI extends wy.BaseSprite {
	constructor() {
		super();
		this.width = 750;
		this.height = 1334;
		this.createChildren();
	}

	public bg:egret.Bitmap;
	public backBtn:egret.Bitmap;
	public fhBtn:egret.Bitmap;
	public fhImg:egret.Bitmap;
	public fhTxt:egret.TextField;
	public theme2:egret.Bitmap;
	public theme:egret.Bitmap;

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

		this.fhBtn = new egret.Bitmap(RES.getRes("GameFM_fhBtn_png"));
		this.fhBtn.x = 627;
		this.fhBtn.y = 1065;
		this.fhBtn.name = "btn";
		this.addChild(this.fhBtn);

		this.fhImg = new egret.Bitmap(RES.getRes("GameF_fhImg_png"));
		this.fhImg.x = 697;
		this.fhImg.y = 1123;
		this.addChild(this.fhImg);

		this.fhTxt = new egret.TextField();
		this.fhTxt.text = "3";
		this.fhTxt.textAlign = "center";
		this.fhTxt.size = 18;
		this.fhTxt.textColor = 0xffffff;
		this.fhTxt.x = 697;
		this.fhTxt.y = 1124;
		this.fhTxt.width = 22;
		this.fhTxt.height = 20;
		this.addChild(this.fhTxt);

		this.theme2 = new egret.Bitmap(RES.getRes("GameF_theme2_png"));
		this.theme2.x = 295;
		this.theme2.y = 365;
		this.addChild(this.theme2);

		this.theme = new egret.Bitmap(RES.getRes("GameF_theme_png"));
		this.theme.x = 265;
		this.theme.y = 15;
		this.addChild(this.theme);



		//动画
	}
}