/**
 *常用动画类
 */
class MyTween {
    /**
     *将obj的锚点设置在中心点
     * @param obj 要设置的对象
     */
    public static center(obj: egret.DisplayObject): void {
        obj.x -= obj.anchorOffsetX;
        obj.y -= obj.anchorOffsetY;
        obj.anchorOffsetX = obj.width >> 1;
        obj.anchorOffsetY = obj.height >> 1;
        obj.x += obj.anchorOffsetX;
        obj.y += obj.anchorOffsetY;
    }

    /**
   *将obj的锚点设置在右上
   * @param obj 要设置的对象
   */
    public static rightTop(obj: egret.DisplayObject): void {
        obj.x -= obj.anchorOffsetX;
        obj.y -= obj.anchorOffsetY;
        obj.anchorOffsetX = obj.width;
        obj.anchorOffsetY = 0;
        obj.x += obj.anchorOffsetX;
        obj.y += obj.anchorOffsetY;
    }

    /**
   *将obj的锚点设置在右下
   * @param obj 要设置的对象
   */
    public static rightButtom(obj: egret.DisplayObject): void {
        obj.x -= obj.anchorOffsetX;
        obj.y -= obj.anchorOffsetY;
        obj.anchorOffsetX = obj.width;
        obj.anchorOffsetY = obj.height;
        obj.x += obj.anchorOffsetX;
        obj.y += obj.anchorOffsetY;
    }

    /**
   *将obj的锚点设置在左上
   * @param obj 要设置的对象
   */
    public static leftTop(obj: egret.DisplayObject): void {
        obj.x -= obj.anchorOffsetX;
        obj.y -= obj.anchorOffsetY;
        obj.anchorOffsetX = 0;
        obj.anchorOffsetY = 0;
        obj.x += obj.anchorOffsetX;
        obj.y += obj.anchorOffsetY;
    }

    /**
       *将obj的锚点设置在左下
       * @param obj 要设置的对象
       */
    public static leftButtom(obj: egret.DisplayObject): void {
        obj.x -= obj.anchorOffsetX;
        obj.y -= obj.anchorOffsetY;
        obj.anchorOffsetX = 0;
        obj.anchorOffsetY = obj.height;
        obj.x += obj.anchorOffsetX;
        obj.y += obj.anchorOffsetY;
    }

    /**
    *将obj的锚点设置在中上
    * @param obj 要设置的对象
    */
    public static centerTop(obj: egret.DisplayObject): void {
        obj.x -= obj.anchorOffsetX;
        obj.y -= obj.anchorOffsetY;
        obj.anchorOffsetX = obj.width >> 1;
        obj.anchorOffsetY = 0;
        obj.x += obj.anchorOffsetX;
        obj.y += obj.anchorOffsetY;
    }

    /**
    *将obj的锚点设置在中心点
    * @param obj 要设置的对象
    */
    public static centerButtom(obj: egret.DisplayObject): void {
        obj.x -= obj.anchorOffsetX;
        obj.y -= obj.anchorOffsetY;
        obj.anchorOffsetX = obj.width >> 1;
        obj.anchorOffsetY = obj.height;
        obj.x += obj.anchorOffsetX;
        obj.y += obj.anchorOffsetY;
    }

    /** 抖动动画 */
    public static doudong(obj: any) {
        wy.Tools.center(obj);
        egret.Tween.get(obj, { loop: true }).to({ scaleX: 0.9, scaleY: 0.9 }, 50).to({ scaleX: 1.1, scaleY: 1.1 }, 200).
            to({ rotation: 8 }, 70).to({ rotation: -8 }, 140).to({ rotation: 8 }, 140).to({ rotation: -8 }, 140).
            to({ rotation: 0 }, 70).to({ scaleX: 1, scaleY: 1 }, 100).wait(500);
    }

    /**摇一摇动画【调用方法：  Tween.yaoyiyao(this.qian,this.shijian,this);】*/
    public static yaoyiyao(obj: any, compFunc: Function, thisObject: any) {
        egret.Tween.get(obj).wait(100).to({ rotation: 5 }, 100).to({ rotation: -5 }, 200).to({ rotation: 0 }, 100)
            .to({ rotation: 5 }, 100).to({ rotation: -5 }, 200).to({ rotation: 0 }, 100).wait(100).call(() => {
                //动画完成执行的事件
                compFunc.call(thisObject);
            }, this);
    }

    public static jtTween(obj: any, time: number = 1000) {
        egret.Tween.get(obj, { loop: true }).to({ alpha: 0, y: obj.y + 15 }, time).to({ alpha: 1, y: obj.y }, 1);
    }

    /**上下闪动*/
    public static upDown(obj: any, num1: number, num2: number, time: number) {
        egret.Tween.get(obj, { loop: true }).to({ y: num1 }, time).to({ y: num2 }, time);
    }

    /**摆动动画*/
    public static swing(obj: any) {
        egret.Tween.get(obj, { loop: true }).to({ rotation: 10 }, 350).to({ rotation: 0 }, 350).to({ rotation: -10 }, 350).to({ rotation: 0 }, 350);
    }

    /**闪动*/
    public static flicker(obj: any, num1: number, num2: number, time: number) {
        wy.Tools.center(obj);
        egret.Tween.get(obj, { loop: true }).to({ scaleX: num1, scaleY: num1 }, time).to({ scaleX: num2, scaleY: num2 }, time);
    }

    /**横向翻转*/
    public static changeScaleX(obj: any) {
        egret.Tween.get(obj, { loop: true }).to({ scaleX: -1 }, 200).to({ scaleX: 1 }, 200);
    }

    /**竖向翻转*/
    public static changeScaleY(obj: any) {
        egret.Tween.get(obj, { loop: true }).to({ scaleY: -1 }, 200).to({ scaleY: 1 }, 200);
    }

    /**云朵*/
    public static yunduo(obj1: any, obj2: any, obj3: any) {
        egret.Tween.get(obj1, { loop: true }).to({ x: 10, y: 100, scaleX: 0.8, scaleY: 0.6, alpha: 0.6 }, 8000).to({ x: 262, y: 280 }, 7000)
            .to({ x: 90, y: 260, scaleX: 0.8, scaleY: 0.8, alpha: 0.8 }, 6000).to({ x: 50, y: 150, scaleX: 1, scaleY: 1, alpha: 1 }, 5000);
        egret.Tween.get(obj2, { loop: true }).to({ x: 190, y: 1000 }, 8000).to({ x: 457, y: 799 }, 5000)
            .to({ x: 380, y: 700 }, 7000).to({ x: 38, y: 134 }, 8000);
        egret.Tween.get(obj3, { loop: true }).to({ x: 600, y: 1000 }, 8000).to({ x: 457, y: 799 }, 5000)
            .to({ x: 300, y: 925 }, 4000).to({ x: 550, y: 925 }, 6000);
    }

    /**云朵*/
    public static yunduo1(obj1: any) {
        egret.Tween.get(obj1, { loop: true }).to({ x: 10, y: 100, scaleX: 0.5, scaleY: 0.5, alpha: 0.5 }, 8000).to({ x: 600, y: 280, scaleX: 0.7, scaleY: 0.7, alpha: 0.7 }, 7000)
            .to({ x: 1000, y: 260, scaleX: 1, scaleY: 1, alpha: 1 }, 6000).to({ x: 500, y: 150, scaleX: 0.8, scaleY: 0.8, alpha: 0.8 }, 5000)
            .to({ x: 150, y: 150, scaleX: 0.5, scaleY: 0.5, alpha: 0.5 }, 5000);
    }

    /**左右摇摆动画
      */
    public static zuoyouyaobai(bmp: egret.Bitmap, time: number = 800, sudu: number = 300) {
        var thisobj = bmp.parent
        egret.setTimeout(() => { wy.Tools.center(bmp); egret.Tween.get(bmp, { loop: true }).to({ x: bmp.x + 25 }, sudu).to({ x: bmp.x - 25 }, sudu * 2) }, thisobj, time)
    }


    public static lianxu(bmp: egret.Bitmap[], time: number = 0, sudu: number = 50) {
        var thisobj = bmp[0].parent
        var a = bmp[0].x;
        egret.setTimeout(() => {
            for (let i = 0; i < bmp.length; i++) {
                wy.Tools.center(bmp[i]);
            }
            egret.setInterval(() => {
                for (let i = 0; i < bmp.length; i++) {
                    egret.Tween.get(bmp[i]).wait(500 * i).to({ scaleX: 0.95, scaleY: 0.95 }, sudu, egret.Ease.backOut).to({ scaleX: 1, scaleY: 1 }, sudu, egret.Ease.backOut)
                }


            }, thisobj, 2 * sudu * bmp.length)



        }, thisobj, time)
    }
}
