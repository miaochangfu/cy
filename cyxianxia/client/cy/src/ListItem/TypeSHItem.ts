/**
 *
 * @author 
 *
 */
class TypeSHItem extends wy.ItemRenderer {
    public constructor() {
        super();

        this.init();
    }


    /**底图---线 */
    private bottomImg: egret.Bitmap;
    /**任务 */
    private taskTxt: egret.TextField;
    /**元宝或者视频 */
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
        this.bottomImg.texture = RES.getRes("TypeSH_item4_png");
        this.bottomImg.x = -46;
        this.bottomImg.y = 0;

        MyTools.getItemTxt(this.taskTxt, 'this.data.name', 23, 0xffffff, 151-46, 342 + 5, 70, 25, 0, 0x276ba9, 'left');

        let type = 1;
        if (type == 1) {
            this.goldImg.texture = RES.getRes("TypeSH_item2_png");
        }
        else {
            this.goldImg.texture = RES.getRes("TypeSH_item3_png");
        }
        this.goldImg.x = 108 - 46;
        this.goldImg.y = 336;


        this.btn.texture = RES.getRes("TypeSH_item1_png");
        this.btn.x = 88 - 46;
        this.btn.y = 324;

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
