/**
 *
 * @author 
 *  流水
 */
class MailAItem extends wy.ItemRenderer {
    public constructor() {
        super();

        this.init();
    }


    /**流水 */
    private lsTxt: egret.TextField;
    private init(): void {

        this.lsTxt = new egret.TextField();
        this.addChild(this.lsTxt);

    }

    public dataChanged(data?): void {
        super.dataChanged();

        MyTools.getItemTxt(this.lsTxt, 'this.data.name', 20, 0x000000, 0, 5, 500, 25, 0, 0x276ba9, 'left');

    }

}
