/**
 *
 * @author 
 *
 */
class InfoCItem extends wy.ItemRenderer {
    public constructor() {
        super();

        this.init();
    }


    /**底图 */
    private bottomImg: egret.Bitmap;
    /**人物头像 */
    private headImg: wy.HeadImg;
    /**昵称 */
    private nickname: egret.TextField;
    /**选中标识 */
    private chooseImg: egret.Bitmap;
    private init(): void {
        this.bottomImg = new egret.Bitmap();
        this.addChild(this.bottomImg);

        this.headImg = new wy.HeadImg(38, true, 80, 80);
        this.addChild(this.headImg);

        this.nickname = new egret.TextField();
        this.addChild(this.nickname);

        this.chooseImg = new egret.Bitmap();
        this.addChild(this.chooseImg);
    }

    public dataChanged(data?): void {
        super.dataChanged();
        this.bottomImg.texture = RES.getRes("InfoC_item1_png");
        this.bottomImg.x = 0;
        this.bottomImg.y = 0;

        if (this.data.img) {
            this.headImg.source = this.data.img;
        }
        else {
            this.headImg.source = StaticVar.defaultHeadImgUrl;
        }

        this.headImg.x = 63 + 38;
        this.headImg.y = 17 + 38;

        if (this.data.name == '' || this.data.name == 'null' || this.data.name == null || this.data.name == undefined
            || (this.data.name.length > 0 && this.data.name.trim().length == 0)) {
            MyTools.getItemTxt(this.nickname, '游客', 29, 0xffffff, 170, 41 + 5, 180, 32, 0, 0x276ba9, 'left');
        }
        else {
            MyTools.getItemTxt(this.nickname, this.data.name, 29, 0xffffff, 170, 41 + 5, 180, 32, 0, 0x276ba9, 'left');
        }

        this.chooseImg.texture = RES.getRes("InfoC_item2_png");
        this.chooseImg.x = 500;
        this.chooseImg.y = 0;


        this.touchEnabled = true;
        this.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    }



    private onTouchTap(e: egret.TouchEvent): void {
        switch (e.currentTarget) {
            case this:
                this.bottomImg.texture = RES.getRes("InfoC_item2_png");
                break;
            default:
                break;
        }
    }
}
