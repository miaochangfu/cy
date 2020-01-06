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
class SetPUI extends wy.BaseSprite {
	constructor() {
		super();
		this.width = 750;
		this.height = 1334;
		this.createChildren();
	}

	public mc:egret.Bitmap;
	public ele:egret.Bitmap;
	public musciB_2:egret.Bitmap;
	public musciB_1:egret.Bitmap;
	public musciA_2:egret.Bitmap;
	public musciA_1:egret.Bitmap;
	public kfBtn:egret.Bitmap;
	public backBtn:egret.Bitmap;

	protected createChildren():void {
		this.mc = new egret.Bitmap(RES.getRes("mc_png"));
		this.mc.x = 1;
		this.mc.y = 0;
		this.addChild(this.mc);

		this.ele = new egret.Bitmap(RES.getRes("SetP_ele_png"));
		this.ele.x = 68;
		this.ele.y = 371;
		this.addChild(this.ele);

		this.musciB_2 = new egret.Bitmap(RES.getRes("SetP_musicB_2_png"));
		this.musciB_2.x = 353;
		this.musciB_2.y = 563;
		this.addChild(this.musciB_2);

		this.musciB_1 = new egret.Bitmap(RES.getRes("SetP_musicB_1_png"));
		this.musciB_1.x = 433;
		this.musciB_1.y = 563;
		this.addChild(this.musciB_1);

		this.musciA_2 = new egret.Bitmap(RES.getRes("SetP_musicA_2_png"));
		this.musciA_2.x = 353;
		this.musciA_2.y = 501;
		this.addChild(this.musciA_2);

		this.musciA_1 = new egret.Bitmap(RES.getRes("SetP_musicA_1_png"));
		this.musciA_1.x = 433;
		this.musciA_1.y = 501;
		this.addChild(this.musciA_1);

		this.kfBtn = new egret.Bitmap(RES.getRes("SetP_kfBtn_png"));
		this.kfBtn.x = 340;
		this.kfBtn.y = 643;
		this.kfBtn.name = "btn";
		this.addChild(this.kfBtn);

		this.backBtn = new egret.Bitmap(RES.getRes("backBtn_png"));
		this.backBtn.x = 553;
		this.backBtn.y = 377;
		this.backBtn.name = "btn";
		this.addChild(this.backBtn);



		//动画
	}
}