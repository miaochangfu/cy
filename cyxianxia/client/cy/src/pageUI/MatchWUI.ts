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
class MatchWUI extends wy.BaseSprite {
	constructor() {
		super();
		this.width = 750;
		this.height = 1334;
		this.createChildren();
	}

	public bg:egret.Bitmap;
	public matchImg:egret.Bitmap;
	public timeTxt:egret.TextField;
	public themeK:egret.Bitmap;
	public theme3:egret.Bitmap;
	public theme2:egret.Bitmap;
	public theme1:egret.Bitmap;
	public backBtn:egret.Bitmap;
	public shareBtn:egret.Bitmap;

	protected createChildren():void {
		this.bg = new egret.Bitmap(RES.getRes("MatchW_bg_jpg"));
		this.bg.x = 0;
		this.bg.y = 0;
		this.addChild(this.bg);

		this.matchImg = new egret.Bitmap(RES.getRes("MatchW_matchImg_png"));
		this.matchImg.x = 247;
		this.matchImg.y = 507;
		this.addChild(this.matchImg);

		this.timeTxt = new egret.TextField();
		this.timeTxt.text = "label";
		this.timeTxt.textAlign = "center";
		this.timeTxt.size = 52;
		this.timeTxt.textColor = 0xffd299;
		this.timeTxt.x = 300;
		this.timeTxt.y = 575;
		this.timeTxt.width = 150;
		this.timeTxt.height = 55;
		this.addChild(this.timeTxt);

		this.themeK = new egret.Bitmap(RES.getRes("MatchW_themeK_png"));
		this.themeK.x = 247;
		this.themeK.y = 13;
		this.addChild(this.themeK);

		this.theme3 = new egret.Bitmap(RES.getRes("MatchW_theme3_png"));
		this.theme3.x = 291;
		this.theme3.y = 35;
		this.addChild(this.theme3);

		this.theme2 = new egret.Bitmap(RES.getRes("MatchW_theme2_png"));
		this.theme2.x = 291;
		this.theme2.y = 34;
		this.addChild(this.theme2);

		this.theme1 = new egret.Bitmap(RES.getRes("MatchW_theme1_png"));
		this.theme1.x = 291;
		this.theme1.y = 36;
		this.addChild(this.theme1);

		this.backBtn = new egret.Bitmap(RES.getRes("backBtn_png"));
		this.backBtn.x = 21;
		this.backBtn.y = 19;
		this.backBtn.name = "btn";
		this.addChild(this.backBtn);

		this.shareBtn = new egret.Bitmap(RES.getRes("MatchW_shareBtn_png"));
		this.shareBtn.x = 272;
		this.shareBtn.y = 1147;
		this.shareBtn.name = "btn";
		this.addChild(this.shareBtn);



		//动画
	}
}