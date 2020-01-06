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
class GameUI extends wy.BaseSprite {
	constructor() {
		super();
		this.width = 750;
		this.height = 1334;
		this.createChildren();
	}

	public bg:egret.Bitmap;
	public headK:egret.Bitmap;
	public headBit:egret.Bitmap;
	public cgTxt:egret.TextField;
	public btn4:egret.Bitmap;
	public btn2:egret.Bitmap;
	public btn1:egret.Bitmap;
	public btn3:egret.Bitmap;
	public hintImg:egret.Bitmap;
	public hintTxt:egret.TextField;
	public levelImg:egret.Bitmap;
	public levelTxt:egret.TextField;
	public backBtn:egret.Bitmap;

	protected createChildren():void {
		this.bg = new egret.Bitmap(RES.getRes("Game_bg_jpg"));
		this.bg.x = 0;
		this.bg.y = 0;
		this.addChild(this.bg);

		this.headK = new egret.Bitmap(RES.getRes("Game_headK_png"));
		this.headK.x = 37;
		this.headK.y = 841;
		this.addChild(this.headK);

		this.headBit = new egret.Bitmap(RES.getRes("headBit_png"));
		this.headBit.x = 38;
		this.headBit.y = 845;
		this.headBit.scaleX = 0.8;
		this.headBit.scaleY = 0.8;
		this.addChild(this.headBit);

		this.cgTxt = new egret.TextField();
		this.cgTxt.text = "label";
		this.cgTxt.textAlign = "left";
		this.cgTxt.size = 20;
		this.cgTxt.textColor = 0x1d6a69;
		this.cgTxt.x = 114;
		this.cgTxt.y = 868;
		this.cgTxt.width = 200;
		this.cgTxt.height = 25;
		this.addChild(this.cgTxt);

		this.btn4 = new egret.Bitmap(RES.getRes("Game_btn4_png"));
		this.btn4.x = 614;
		this.btn4.y = 839;
		this.btn4.name = "btn";
		this.addChild(this.btn4);

		this.btn2 = new egret.Bitmap(RES.getRes("Game_btn2_png"));
		this.btn2.x = 438;
		this.btn2.y = 839;
		this.btn2.name = "btn";
		this.addChild(this.btn2);

		this.btn1 = new egret.Bitmap(RES.getRes("Game_btn1_png"));
		this.btn1.x = 349;
		this.btn1.y = 839;
		this.btn1.name = "btn";
		this.addChild(this.btn1);

		this.btn3 = new egret.Bitmap(RES.getRes("Game_btn3_png"));
		this.btn3.x = 526;
		this.btn3.y = 839;
		this.btn3.name = "btn";
		this.addChild(this.btn3);

		this.hintImg = new egret.Bitmap(RES.getRes("Game_hintImg_png"));
		this.hintImg.x = 596;
		this.hintImg.y = 893;
		this.addChild(this.hintImg);

		this.hintTxt = new egret.TextField();
		this.hintTxt.text = "3";
		this.hintTxt.textAlign = "center";
		this.hintTxt.size = 18;
		this.hintTxt.textColor = 0xffffff;
		this.hintTxt.x = 597;
		this.hintTxt.y = 894;
		this.hintTxt.width = 20;
		this.hintTxt.height = 20;
		this.addChild(this.hintTxt);

		this.levelImg = new egret.Bitmap(RES.getRes("Game_levelImg_png"));
		this.levelImg.x = 247;
		this.levelImg.y = 42;
		this.addChild(this.levelImg);

		this.levelTxt = new egret.TextField();
		this.levelTxt.text = "label";
		this.levelTxt.textAlign = "center";
		this.levelTxt.size = 30;
		this.levelTxt.textColor = 0xffffff;
		this.levelTxt.x = 293;
		this.levelTxt.y = 51;
		this.levelTxt.width = 200;
		this.levelTxt.height = 31;
		this.addChild(this.levelTxt);

		this.backBtn = new egret.Bitmap(RES.getRes("backBtn_png"));
		this.backBtn.x = 21;
		this.backBtn.y = 40;
		this.backBtn.name = "btn";
		this.addChild(this.backBtn);



		//动画
	}
}