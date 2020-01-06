/**
 *
 *@author
 *
 */
class ResultF extends ResultFUI {
	constructor() {
		super();
	}

	protected createChildren():void {
		super.createChildren();
	}

	public show(data?):void {
		super.show(data);

		this.mc.touchEnabled = true;
		this.mc.addEventListener(egret.TouchEvent.TOUCH_TAP,this.onTouchTap,this);
		this.bg.touchEnabled = true;
		this.bg.addEventListener(egret.TouchEvent.TOUCH_TAP,this.onTouchTap,this);
		this.txt3.touchEnabled = true;
		this.txt3.addEventListener(egret.TouchEvent.TOUCH_TAP,this.onTouchTap,this);
		this.txt2.touchEnabled = true;
		this.txt2.addEventListener(egret.TouchEvent.TOUCH_TAP,this.onTouchTap,this);
		this.txt1.touchEnabled = true;
		this.txt1.addEventListener(egret.TouchEvent.TOUCH_TAP,this.onTouchTap,this);
		this.btn1.touchEnabled = true;
		this.btn1.addEventListener(egret.TouchEvent.TOUCH_TAP,this.onTouchTap,this);
		this.btn2.touchEnabled = true;
		this.btn2.addEventListener(egret.TouchEvent.TOUCH_TAP,this.onTouchTap,this);
		this.win1.touchEnabled = true;
		this.win1.addEventListener(egret.TouchEvent.TOUCH_TAP,this.onTouchTap,this);
		this.win0.touchEnabled = true;
		this.win0.addEventListener(egret.TouchEvent.TOUCH_TAP,this.onTouchTap,this);
		this.theme2.touchEnabled = true;
		this.theme2.addEventListener(egret.TouchEvent.TOUCH_TAP,this.onTouchTap,this);
		this.theme1.touchEnabled = true;
		this.theme1.addEventListener(egret.TouchEvent.TOUCH_TAP,this.onTouchTap,this);

		wy.Tween.do(this);
	}

	public hide():void {
		super.hide();

		this.mc.touchEnabled = false;
		this.mc.removeEventListener(egret.TouchEvent.TOUCH_TAP,this.onTouchTap,this);
		this.bg.touchEnabled = false;
		this.bg.removeEventListener(egret.TouchEvent.TOUCH_TAP,this.onTouchTap,this);
		this.txt3.touchEnabled = false;
		this.txt3.removeEventListener(egret.TouchEvent.TOUCH_TAP,this.onTouchTap,this);
		this.txt2.touchEnabled = false;
		this.txt2.removeEventListener(egret.TouchEvent.TOUCH_TAP,this.onTouchTap,this);
		this.txt1.touchEnabled = false;
		this.txt1.removeEventListener(egret.TouchEvent.TOUCH_TAP,this.onTouchTap,this);
		this.btn1.touchEnabled = false;
		this.btn1.removeEventListener(egret.TouchEvent.TOUCH_TAP,this.onTouchTap,this);
		this.btn2.touchEnabled = false;
		this.btn2.removeEventListener(egret.TouchEvent.TOUCH_TAP,this.onTouchTap,this);
		this.win1.touchEnabled = false;
		this.win1.removeEventListener(egret.TouchEvent.TOUCH_TAP,this.onTouchTap,this);
		this.win0.touchEnabled = false;
		this.win0.removeEventListener(egret.TouchEvent.TOUCH_TAP,this.onTouchTap,this);
		this.theme2.touchEnabled = false;
		this.theme2.removeEventListener(egret.TouchEvent.TOUCH_TAP,this.onTouchTap,this);
		this.theme1.touchEnabled = false;
		this.theme1.removeEventListener(egret.TouchEvent.TOUCH_TAP,this.onTouchTap,this);
	}

	private onTouchTap(e:egret.TouchEvent):void {
		switch(e.currentTarget) {
			case this.mc:
			
				break;
			case this.bg:
			
				break;
			case this.txt3:
			
				break;
			case this.txt2:
			
				break;
			case this.txt1:
			
				break;
			case this.btn1:
			
				break;
			case this.btn2:
			
				break;
			case this.win1:
			
				break;
			case this.win0:
			
				break;
			case this.theme2:
			
				break;
			case this.theme1:
			
				break;
			default:
				break;
		}
	}
}