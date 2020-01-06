/**
 *
 *@author
 *
 */
class LoadingUI extends LoadingUIUI {
	constructor() {
		super();
		let load = document.getElementById('loading');
		if (load && load.parentNode) { load.parentNode.removeChild(load); }
		document.body.style.background = '#0E0E0E';
	}

	private shape: egret.MovieClip;//loading动画
	protected createChildren(): void {
		super.createChildren();

		this.shape = wy.Tools.createMovieClip('loadA');
		this.addChild(this.shape);
		this.shape.play(-1);
		wy.Tools.center(this.shape);
		this.shape.x = 152;
		this.shape.y = 573;

		this.textField.text = '';
		//this.textField.size = 15;
		this.textField.y = this.shape.y + this.shape.anchorOffsetY + 10;
	}


	public hide(): void {
		super.hide();
	}

	public setProgress(cur, total): void {
		var perc: number = Math.round(cur * 100 / total);
		this.textField.text = '' + perc + '%';
		this.textField.x = this.width / 2 - this.textField.width / 2;


	}
}