/**
 *
 * @author 
 *
 */
class MailCItem extends wy.ItemRenderer {
    public constructor() {
        super();

        this.init();
    }


    /**底图---线 */
    private bottomImg: egret.Bitmap;
    /**人物头像 */
    private headImg: wy.HeadImg;
    /**昵称 */
    private nickname: egret.TextField;
    /**按钮1 */
    private btn1: egret.Bitmap;
    /**按钮2 */
    private btn2: egret.Bitmap;
    private init(): void {
        this.bottomImg = new egret.Bitmap();
        this.addChild(this.bottomImg);

        this.headImg = new wy.HeadImg(28, true, 80, 80);
        this.addChild(this.headImg);

        this.nickname = new egret.TextField();
        this.addChild(this.nickname);

        this.btn1 = new egret.Bitmap();
        this.addChild(this.btn1);

        this.btn2 = new egret.Bitmap();
        this.addChild(this.btn2);
    }

    public dataChanged(data?): void {
        super.dataChanged();

        let type = Math.floor(Math.random() * 2);//添加or请求添加:0 or 1

        if (type == 0) {//请求添加
            this.bottomImg.texture = RES.getRes("MailC_item2_png");
        }
        else {
            this.btn1.visible = this.btn2.visible = false;
            this.bottomImg.texture = RES.getRes("MailC_item1_png");
        }
        this.bottomImg.x = 0;
        this.bottomImg.y = 0;

        this.headImg.source = this.data.img ? this.data.img : StaticVar.defaultHeadImgUrl;

        let nicknameStr = this.data.name;
        if (this.data.name == '' || this.data.name == 'null' || this.data.name == null || this.data.name == undefined
            || (this.data.name.length > 0 && this.data.name.trim().length == 0)) {
            nicknameStr = '游客';
        }

        if (type == 0) {//请求添加
            this.headImg.x = 3 + 28;
            this.headImg.y = 1 + 28;
            MyTools.getItemTxt(this.nickname, nicknameStr, 18, 0x2c8f93, 63, 20 + 3, 90, 22, 0, 0x276ba9, 'center');
        }
        else {
            this.headImg.x = 78 + 28;
            this.headImg.y = 0 + 28;
            MyTools.getItemTxt(this.nickname, nicknameStr, 18, 0x2c8f93, 140, 20 + 3, 100, 22, 0, 0x276ba9, 'center');
        }


        this.btn1.texture = RES.getRes("MailC_item3_png");
        this.btn1.x = 295;
        this.btn1.y = 0;

        this.btn2.texture = RES.getRes("MailC_item4_png");
        this.btn2.x = 405;
        this.btn2.y = 0;

        this.btn1.touchEnabled = true;
        this.btn1.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        this.btn2.touchEnabled = true;
        this.btn2.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
    }



    private onTouchTap(e: egret.TouchEvent): void {
        switch (e.currentTarget) {
            case this.btn1://拒绝
                MyTools.hintMethod('拒绝');
                break;
            case this.btn2://同意
                MyTools.hintMethod('同意');
                break;
            default:
                break;
        }
    }
}
