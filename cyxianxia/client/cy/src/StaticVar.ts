
/**
 *全局静态量类
 *
 *@version 0.0.1
 *@platform egret3.0.3
 */
class StaticVar {
    /**默认头像 */
    public static defaultHeadImgUrl = 'http://wx.qlogo.cn/mmopen/JUvAvnJSpXADD7HxXhh8866bbibVAkabWP41MqsRZlUm1oePib2vVIhKbu4WWicGEPDKh4nbyGSuSjgMcJ756ANEHS023qPwmH5/132';
    /**默认昵称 */
    public static defaultNickname = '昵称';
    /**背景音乐:0--默认播放 */
    public static MUSIC_A: boolean = true;
    /**音效：0--默认播放 */
    public static MUSIC_B: boolean = true;


    /**测试成语 */
    public static testCyArr: any =
    ["豁达大度", "暗度陈仓", "官仓老鼠", "鼠目寸光", "愁肠寸断"];
    // ["漏网之鱼", "网开一面", "满面春风", "春回大地", "天南地北", "怨天尤人", "任劳任怨", "不辞劳苦"];
    // ["关怀备至", "闭关锁国", "祸国殃民", "民不聊生", "百无聊赖", "百般刁难", "天理难容", "鸡犬升天", "旭日东升", "暗无天日"];



    /**成语json */
    public static idiomJson: any = [];



    public static STAGE_W: number = 0;
    public static STAGE_H: number = 0;
    /**适配y值 */
    public static FIT_Y: number = 0;


    public static createBitmapByName(name: string) {
        let result = new egret.Bitmap();
        let texture: egret.Texture = RES.getRes(name);
        result.texture = texture;
        return result;
    }


    public static getRandomIntFull(a, b) {
        let num = Math.floor(Math.random() * b + a);
        return num;
    }

    public static getRandomArrayElements(a, b) {
        // console.log('ab', a, b);
        let arr: any[] = [];
        return arr;
    }
}