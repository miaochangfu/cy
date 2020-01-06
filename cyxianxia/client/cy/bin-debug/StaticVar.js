var __reflect = (this && this.__reflect) || function (p, c, t) {
    p.__class__ = c, t ? t.push(c) : t = [c], p.__types__ = p.__types__ ? t.concat(p.__types__) : t;
};
/**
 *全局静态量类
 *
 *@version 0.0.1
 *@platform egret3.0.3
 */
var StaticVar = (function () {
    function StaticVar() {
    }
    StaticVar.createBitmapByName = function (name) {
        var result = new egret.Bitmap();
        var texture = RES.getRes(name);
        result.texture = texture;
        return result;
    };
    StaticVar.getRandomIntFull = function (a, b) {
        var num = Math.floor(Math.random() * b + a);
        return num;
    };
    StaticVar.getRandomArrayElements = function (a, b) {
        // console.log('ab', a, b);
        var arr = [];
        return arr;
    };
    return StaticVar;
}());
/**默认头像 */
StaticVar.defaultHeadImgUrl = 'http://wx.qlogo.cn/mmopen/JUvAvnJSpXADD7HxXhh8866bbibVAkabWP41MqsRZlUm1oePib2vVIhKbu4WWicGEPDKh4nbyGSuSjgMcJ756ANEHS023qPwmH5/132';
/**默认昵称 */
StaticVar.defaultNickname = '昵称';
/**背景音乐:0--默认播放 */
StaticVar.MUSIC_A = true;
/**音效：0--默认播放 */
StaticVar.MUSIC_B = true;
/**测试成语 */
StaticVar.testCyArr = ["豁达大度", "暗度陈仓", "官仓老鼠", "鼠目寸光", "愁肠寸断"];
// ["漏网之鱼", "网开一面", "满面春风", "春回大地", "天南地北", "怨天尤人", "任劳任怨", "不辞劳苦"];
// ["关怀备至", "闭关锁国", "祸国殃民", "民不聊生", "百无聊赖", "百般刁难", "天理难容", "鸡犬升天", "旭日东升", "暗无天日"];
/**成语json */
StaticVar.idiomJson = [];
StaticVar.STAGE_W = 0;
StaticVar.STAGE_H = 0;
/**适配y值 */
StaticVar.FIT_Y = 0;
__reflect(StaticVar.prototype, "StaticVar");
