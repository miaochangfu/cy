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
class ChatUI extends wy.BaseSprite {
	constructor() {
		super();
		this.width = 675;
		this.height = 53;
		this.createChildren();
	}

	public ele1:egret.Bitmap;
	public chatTxt:egret.TextField;
	public ele2:egret.Bitmap;

	protected createChildren():void {
		this.ele1 = new egret.Bitmap(RES.getRes("Chat_ele1_png"));
		this.ele1.x = 0;
		this.ele1.y = 0;
		this.addChild(this.ele1);

		this.chatTxt = new egret.TextField();
		this.chatTxt.type = "input";
		this.chatTxt.text = "label";
		this.chatTxt.textAlign = "center";
		this.chatTxt.size = 37;
		this.chatTxt.textColor = 0xffffff;
		this.chatTxt.x = 116;
		this.chatTxt.y = 6;
		this.chatTxt.width = 440;
		this.chatTxt.height = 43;
		this.addChild(this.chatTxt);

		this.ele2 = new egret.Bitmap(RES.getRes("Chat_ele2_png"));
		this.ele2.x = 564;
		this.ele2.y = 5;
		this.addChild(this.ele2);



		//动画
	}
}