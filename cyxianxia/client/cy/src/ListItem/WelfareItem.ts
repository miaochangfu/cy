/**
 *
 * @author 
 *
 */
class WelfareItem extends wy.ItemRenderer {
    public constructor() {
        super();

        this.init();
    }


    /**底图---线 */
    private bottomImg: egret.Bitmap;
    /**任务 */
    private taskTxt: egret.TextField;
    /**元宝 */
    private goldImg: egret.Bitmap;
    /**按钮 */
    private btn: egret.Bitmap;
    private init(): void {
        this.bottomImg = new egret.Bitmap();
        this.addChild(this.bottomImg);

        this.taskTxt = new egret.TextField();
        this.addChild(this.taskTxt);

        this.goldImg = new egret.Bitmap();
        this.addChild(this.goldImg);

        this.btn = new egret.Bitmap();
        this.addChild(this.btn);
    }

    public dataChanged(data?): void {
        super.dataChanged();
        this.bottomImg.texture = RES.getRes("Welfare_item0_png");
        this.bottomImg.x = 0;
        this.bottomImg.y = 56;

        MyTools.getItemTxt(this.taskTxt, 'this.data.name', 23, 0xffffff, 19, 16 + 5, 180, 25, 0, 0x276ba9, 'left');

        this.goldImg.texture = RES.getRes("Welfare_item9_png");
        this.goldImg.x = 290;
        this.goldImg.y = 5;


        this.btn.texture = RES.getRes("Welfare_item1_png");
        this.btn.x = 405;
        this.btn.y = 0;

        this.btn.touchEnabled = true;
        this.btn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    }



    private onTouchTap(e: egret.TouchEvent): void {
        switch (e.currentTarget) {
            case this.btn:
                MyTools.hintMethod('click');
                break;
            default:
                break;
        }
    }
}
