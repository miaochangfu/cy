/**
 *
 * @author 
 *
 */
class InfoBItem extends wy.ItemRenderer {
    public constructor() {
        super();

        this.init();
    }


    /**底图 */
    private bottomImg: egret.Bitmap;
    /**装备图片 */
    private zbImg: egret.Bitmap;
    /**选中标识 */
    private chooseImg: egret.Bitmap;
    private init(): void {
        this.bottomImg = new egret.Bitmap();
        this.addChild(this.bottomImg);

        this.zbImg = new egret.Bitmap();
        this.addChild(this.zbImg);

        this.chooseImg = new egret.Bitmap();
        this.addChild(this.chooseImg);
    }

    public dataChanged(data?): void {
        super.dataChanged();
        this.bottomImg.texture = RES.getRes("InfoB_item1_png");
        this.bottomImg.x = 0;
        this.bottomImg.y = 0;

        this.zbImg.texture = RES.getRes("InfoB_item4_png");
        this.zbImg.x = 52;
        this.zbImg.y = 9;

        this.chooseImg.texture = RES.getRes("InfoB_item3_png");
        this.chooseImg.x = 172;
        this.chooseImg.y = 0;


        this.touchEnabled = true;
        this.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    }



    private onTouchTap(e: egret.TouchEvent): void {
        switch (e.currentTarget) {
            case this:
                this.bottomImg.texture = RES.getRes("InfoB_item2_png");
                break;
            default:
                break;
        }
    }
}
