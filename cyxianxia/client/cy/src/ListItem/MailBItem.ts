/**
 *
 * @author 
 *
 */
class MailBItem extends wy.ItemRenderer {
    public constructor() {
        super();

        this.init();
    }


    /**底图---线 */
    private bottomImg: egret.Bitmap;
    /**积分流水 */
    private lsTxt: egret.TextField;
    private init(): void {
        this.bottomImg = new egret.Bitmap();
        this.addChild(this.bottomImg);

        this.lsTxt = new egret.TextField();
        this.addChild(this.lsTxt);
    }

    public dataChanged(data?): void {
        super.dataChanged();
        this.bottomImg.texture = RES.getRes("MailB_line_png");
        this.bottomImg.x = 0;
        this.bottomImg.y = 42;

        MyTools.getItemTxt(this.lsTxt, 'this.data.name', 20, 0x000000, 0, 0, 500, 25, 0, 0x276ba9, 'left');

    }

}
