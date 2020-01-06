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
class MatchFUI extends wy.BaseSprite {
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
	public theme1:egret.Bitmap;
	public theme2:egret.Bitmap;
	public backBtn:egret.Bitmap;

	protected createChildren():void {
		this.bg = new egret.Bitmap(RES.getRes("MatchF_bg_jpg"));
		this.bg.x = 0;
		this.bg.y = 0;
		this.addChild(this.bg);

		this.matchImg = new egret.Bitmap(RES.getRes("MatchF_matchImg_png"));
		this.matchImg.x = 245;
		this.matchImg.y = 547;
		this.addChild(this.matchImg);

		this.timeTxt = new egret.TextField();
		this.timeTxt.text = "30s";
		this.timeTxt.textAlign = "left";
		this.timeTxt.size = 39;
		this.timeTxt.textColor = 0xf6d562;
		this.timeTxt.x = 412;
		this.timeTxt.y = 707;
		this.timeTxt.width = 105;
		this.timeTxt.height = 39;
		this.timeTxt.stroke = 2;
		this.timeTxt.strokeColor = 0x87785d;
		this.addChild(this.timeTxt);

		this.themeK = new egret.Bitmap(RES.getRes("MatchF_themeK_png"));
		this.themeK.x = 245;
		this.themeK.y = 19;
		this.addChild(this.themeK);

		this.theme1 = new egret.Bitmap(RES.getRes("MatchF_theme1_png"));
		this.theme1.x = 289;
		this.theme1.y = 42;
		this.addChild(this.theme1);

		this.theme2 = new egret.Bitmap(RES.getRes("MatchF_theme2_png"));
		this.theme2.x = 289;
		this.theme2.y = 41;
		this.addChild(this.theme2);

		this.backBtn = new egret.Bitmap(RES.getRes("backBtn_png"));
		this.backBtn.x = 19;
		this.backBtn.y = 18;
		this.backBtn.name = "btn";
		this.addChild(this.backBtn);



		//动画
	}
}