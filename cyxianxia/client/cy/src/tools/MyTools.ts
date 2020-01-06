/**
 *
 * @author 
 *本项目的工具类
 */
class MyTools {
    public constructor() {

    }

    /**创建图片*/
    public static setBitmap(srcName: string, _x: number, _y: number, picParent: any, isCenter: boolean = false): egret.Bitmap {
        var pic: egret.Bitmap = MyTools.createBitmapByName(srcName);
        pic.x = _x;
        pic.y = _y;
        if (isCenter) {
            pic.anchorOffsetX = pic.width >> 1;
            pic.anchorOffsetY = pic.height >> 1;
        }
        picParent.addChild(pic);
        return pic;
    }
    /**加载图片名 */
    public static createBitmapByName(name: string): egret.Bitmap {
        var result: egret.Bitmap = new egret.Bitmap();
        var texture: egret.Texture = RES.getRes(name);
        result.texture = texture;
        return result;
    }

    /**加载头像 */
    public static setHeadImg(picParent: any, obj2: any, cir, bol, w, h) {
        let headImg = new wy.HeadImg(cir, bol, w, h);
        picParent.addChild(headImg);
        wy.Tools.center(obj2);
        headImg.x = obj2.x;
        headImg.y = obj2.y;
        return headImg;
    }


    /**加载链接图片 */
    public static loadUrlBitmap(obj: any, parent: any, x: number, y: number, w: number, h: number, imgUrl: string) {
        obj = new wy.HeadImg(0, false, w, h);
        obj.source = imgUrl;
        obj.x = x;
        obj.y = y;
        parent.addChild(obj);
    }

    /**滑动控件：ScrollView */
    public static createSrollView(x: number, y: number, w: number, h: number, picParent: any): egret.ScrollView {
        //平移滚动
        var myscrollView: egret.ScrollView = new egret.ScrollView();
        myscrollView.width = w;
        myscrollView.height = h;
        myscrollView.x = x;
        myscrollView.y = y;
        //myscrollView.bounces = false;
        picParent.addChild(myscrollView);
        return myscrollView;
    }
    /**列表List */
    public static createList(x: number, y: number, w: number, _cols: number, _right: number, _bottom: number, picParent: any) {
        let list = new wy.List();
        list.x = x;
        list.y = y;
        list.width = w;
        list.cols = _cols;
        // list.rows = 10;
        list.right = _right;
        list.bottom = _bottom;
        // list.dataProvider = [];
        list.updateDisplayList();
        picParent.addChild(list);
        return list;
    }

    /**item文本 ---value:值*/
    public static getItemTxt(txt: any, value: string, size: number, col: number, x: number, y: number, w: number, h: number, num1: number, col2: number, _type: string, bol = false) {
        txt.text = value;
        txt.size = size;
        txt.textColor = col;
        txt.x = x;
        txt.y = y;
        txt.width = w;
        txt.height = h;
        txt.stroke = num1;
        txt.strokeColor = col2;
        txt.textAlign = _type;
        txt.bold = bol;
        txt.verticalAlign = egret.VerticalAlign.MIDDLE;
    }

    /**item文本 ---value:值*/
    public static getItemTxt2(txt: any, value: string, size: number, col: number, x: number, y: number, w: number, h: number, num1: number, col2: number, _type: string, bol = false) {
        txt.text = value;
        txt.size = size;
        txt.textColor = col;
        txt.x = x;
        txt.y = y;
        txt.width = w;
        // txt.height = h;
        txt.stroke = num1;
        txt.strokeColor = col2;
        txt.textAlign = _type;
        txt.bold = bol;
        txt.verticalAlign = egret.VerticalAlign.MIDDLE;
    }

    /**item文本 ---value:值*/
    public static getItemTxt3(txt: any, value: string, size: number, col: number, x: number, y: number, w: number, h: number, num1: number, col2: number, _type: string, bol = false) {
        txt.text = value;
        txt.size = size;
        txt.textColor = col;
        txt.x = x;
        txt.y = y;
        // txt.width = w;
        // txt.height = h;
        txt.stroke = num1;
        txt.strokeColor = col2;
        txt.textAlign = _type;
        txt.bold = bol;
        txt.verticalAlign = egret.VerticalAlign.MIDDLE;
    }

    /**创建文本 */
    public static createTextField(strTxt: string, x: number, y: number, w: number, h: number, size: number, color: number, type: string, picParent: any): egret.TextField {
        var txt: egret.TextField = new egret.TextField;
        txt.x = x;
        txt.y = y;
        txt.width = w;
        txt.height = h;
        txt.fontFamily = "微软雅黑";
        txt.size = size;
        txt.textAlign = type;
        txt.textColor = color;
        txt.textAlign = egret.HorizontalAlign.CENTER;
        txt.verticalAlign = egret.VerticalAlign.MIDDLE;
        txt.text = strTxt;
        picParent.addChild(txt);
        return txt;
    }

    /**创建提示文本 */
    public static createHintTxt(strTxt: string, x: number, y: number, w: number, h: number, size: number, color: number, type: string, picParent: any): egret.TextField {
        var txt: egret.TextField = new egret.TextField;
        txt.x = x;
        txt.y = y;
        txt.width = w;
        txt.height = h;
        txt.fontFamily = "微软雅黑";
        txt.size = size;
        txt.textAlign = type;
        txt.textColor = color;
        txt.stroke = 5;
        txt.strokeColor = 0;
        txt.alpha = 0;
        txt.scaleX = txt.scaleY = 1.2;
        txt.textAlign = egret.HorizontalAlign.CENTER;
        txt.verticalAlign = egret.VerticalAlign.MIDDLE;
        txt.text = strTxt;
        wy.Tools.center(txt);
        picParent.addChild(txt);
        return txt;
    }
    /**提示 */
    public static hintMethod(str) {
        var hintTxt = MyTools.createHintTxt(str, 0, StaticVar.STAGE_H / 2.5, StaticVar.STAGE_W, 50, 46, 0xeec207, 'center', egret.MainContext.instance.stage);
        egret.Tween.get(hintTxt).to({ y: hintTxt.y + 80 }).to({ y: hintTxt.y, alpha: 1, scaleX: 1, scaleY: 1 }, 500).wait(300).to({ alpha: 0 }, 500);
    }

    /**时间转换 */
    public static formatTime(dt) {
        var h, m, s, r;
        if (h > 0) {
            r += (h > 9 ? h.toString() : "0" + h.toString()) + ":";
        }
        r += (m > 9 ? m.toString() : "0" + m.toString()) + ":"
        r += (s > 9 ? s.toString() : "0" + s.toString());
        return r;
    }


    /**适配 */
    public static fitMethod(obj, num2) {
        var num = obj.numChildren;
        for (let i = 0; i < num; i++) {
            if (i < num2) {
                console.log('1=s==' + StaticVar.STAGE_W);
                obj.getChildAt(i).width = StaticVar.STAGE_W;
                obj.getChildAt(i).height = StaticVar.STAGE_H;
            }
            else {
                obj.getChildAt(i).x += (StaticVar.STAGE_W - 750) / 2;
                obj.getChildAt(i).y += (StaticVar.STAGE_H - 1334) / 2;
            }
        }
    }

    public static compare(property, desc) {
        return function (a, b) {
            var value1 = a[property];
            var value2 = b[property];
            if (desc == true) {
                // 升序排列
                return value1 - value2;
            } else {
                // 降序排列
                return value2 - value1;
            }
        }
    }

    /**更简化的生成成语---待优化 */
    public static createIdiom000(arr?, numA?, numB?) {
        let randArr: any = [];
        let randNum: number = Math.floor(Math.random() * arr.length);
        for (let i = 0; i < arr.length; i++) {
            if (arr[i].key != arr[randNum].key && arr[i].key[1] == arr[randNum].key[3]) {
                randArr.push(arr[i]);
            }
        }
        if (randArr.length == 0) {
            MyTools.createIdiom000();
            return;
        }
        return [randArr, randNum];
    }
    /**生成成语数组 */
    public static createIdiom(idiomJsonArr, sameArr_1, sameArr_2) {

        let randA = [];
        let randNumA = Math.floor(Math.random() * idiomJsonArr.length);
        console.log('randNumA===', randNumA, idiomJsonArr[randNumA].key);
        for (let i = 0; i < idiomJsonArr.length; i++) {
            if (idiomJsonArr[i].key != idiomJsonArr[randNumA].key && idiomJsonArr[i].key[sameArr_2[0]] == idiomJsonArr[randNumA].key[sameArr_1[0]]) {
                //  console.log(idiomJsonArr[i].key, idiomJsonArr[i].key[sameArr_2[0]], idiomJsonArr[randNumA].key[sameArr_1[0]]);
                randA.push(idiomJsonArr[i]);
            }
        }
        if (randA.length == 0) {
            MyTools.createIdiom(idiomJsonArr, sameArr_1, sameArr_2);
            return;
        }


        let randB = [];
        let randNumB = Math.floor(Math.random() * randA.length);
        console.log('randNumB===', randA.length, randNumB, randA[randNumB].key);
        for (let i = 0; i < idiomJsonArr.length; i++) {
            if (idiomJsonArr[i].key != randA[randNumB].key && idiomJsonArr[i].key[sameArr_2[1]] == randA[randNumB].key[sameArr_1[1]]) {
                //   console.log(idiomJsonArr[i].key, idiomJsonArr[i].key[sameArr_2[1]], randA[randNumB].key[sameArr_1[1]]);
                randB.push(idiomJsonArr[i]);
            }
        }
        if (randB.length == 0) {
            MyTools.createIdiom(idiomJsonArr, sameArr_1, sameArr_2);
            return;
        }


        let randC = [];
        let randNumC = Math.floor(Math.random() * randB.length);
        console.log('randNumC===', randB.length, randNumC, randB[randNumC].key);
        for (let i = 0; i < idiomJsonArr.length; i++) {
            if (idiomJsonArr[i].key != randB[randNumC].key && idiomJsonArr[i].key[sameArr_2[2]] == randB[randNumC].key[sameArr_1[2]]) {
                //   console.log(idiomJsonArr[i].key, idiomJsonArr[i].key[sameArr_2[2]], randB[randNumC].key[sameArr_1[2]]);
                randC.push(idiomJsonArr[i]);
            }
        }
        if (randC.length == 0) {
            MyTools.createIdiom(idiomJsonArr, sameArr_1, sameArr_2);
            return;
        }


        let randD = [];
        let randNumD = Math.floor(Math.random() * randC.length);
        console.log('randNumD===', randC.length, randNumD, randC[randNumD].key);
        for (let i = 0; i < idiomJsonArr.length; i++) {
            if (idiomJsonArr[i].key != randC[randNumD].key && idiomJsonArr[i].key[sameArr_2[3]] == randC[randNumD].key[sameArr_1[3]]) {
                //  console.log(idiomJsonArr[i].key, idiomJsonArr[i].key[sameArr_2[3]], randC[randNumD].key[sameArr_1[3]]);
                randD.push(idiomJsonArr[i]);
            }
        }
        if (randD.length == 0) {
            MyTools.createIdiom(idiomJsonArr, sameArr_1, sameArr_2);
            return;
        }

        let randNumE = Math.floor(Math.random() * randD.length);
        console.log('randNumE===', randD.length, randNumE, randD[randNumE].key);
        let totalArr = [];
        totalArr.push(idiomJsonArr[randNumA].key);
        totalArr.push(randA[randNumB].key);
        totalArr.push(randB[randNumC].key);
        totalArr.push(randC[randNumD].key);
        totalArr.push(randD[randNumE].key);
        // console.log('totalArr-------', totalArr);

        if (totalArr != undefined) wy.notify('create_succ', totalArr);
    }

    /**生成成语字符串 */
    public static createIdiomStr(idiomJson, num1, num2, num3, num4) {
        let str = ''
        for (let i = 0; i < 5; i++) {
            str += idiomJson[i];
        }
        //删除
        let arr = str.split('');
        for (var i = 0; i < arr.length; i++) {
            if (i == num1 || i == num2 || i == num3 || i == num4) {
                arr.splice(i, 1);
            }
        }
        str = '';
        for (let i = 0; i < arr.length; i++) {
            str += arr[i];
        }
        return str;
    }
    /**随机几个数*/
    public static randNum(num1: number, num2: number, num3: number) {
        let arr: any = [];
        while (arr.length < num1) {
            var bFlag = true;
            var number = Math.floor(Math.random() * num2 + num3);

            console.log('number===' + number);

            if (arr.length == 0) {
                arr.push(number);
            }
            for (var i = 0; i < arr.length; i++) {
                if (number == arr[i]) {
                    bFlag = false;
                }
            }
            if (bFlag) {
                arr.push(number);
            }
        }
        return arr;
    }
}
