var __reflect = (this && this.__reflect) || function (p, c, t) {
    p.__class__ = c, t ? t.push(c) : t = [c], p.__types__ = p.__types__ ? t.concat(p.__types__) : t;
};
/**
 *全局静态量类
 *
 * @version 0.0.1
 *@platform egret3.0.3
 *
 */
var Net = (function () {
    function Net() {
    }
    Net.doReqPost = function (thisObj, callback, rtype, value, type) {
        if (type === void 0) { type = egret.HttpResponseType.TEXT; }
        var req = new egret.HttpRequest();
        req.responseType = type;
        req.open(Net.urlIP + rtype, egret.HttpMethod.POST);
        req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        req.send(value);
        req.addEventListener(egret.Event.COMPLETE, callback, thisObj);
    };
    /**注册---https://XXXX/getWeiXinInsert.json*/
    Net.getWeiXinInsert = function (thisObj, callback, openId, name, img) {
        var _obj = { "openId": openId, "name": name, "img": img };
        var value = JSON.stringify(_obj);
        Net.doReqPost(thisObj, callback, 'getWeiXinInsert.json?', value);
    };
    /**登录---https://XXXX/getPlayerUserLoginAPI.json*/
    Net.getPlayerUserLoginAPI = function (thisObj, callback, openid, playerId) {
        var _obj = { "openid": openid, "playerId": playerId };
        // var value: any = JSON.stringify(_obj);
        var value = Net.getValue(_obj);
        Net.doReqPost(thisObj, callback, 'getPlayerUserLoginAPI.json?', value);
    };
    /**用户上传分数---https://XXXX/getPlayerUpdateScoreAPI.json*/
    Net.getPlayerUpdateScoreAPI = function (thisObj, callback, playerId, score) {
        var _obj = { "playerId": playerId, "score": score };
        // var value: any = JSON.stringify(_obj);
        var value = Net.getValue(_obj);
        Net.doReqPost(thisObj, callback, 'getPlayerUpdateScoreAPI.json?', value);
    };
    /**用户设置背景音乐音效---https://XXXX/getPlayerSetInfoAPI.json*/
    // public static getPlayerSetInfoAPI(thisObj: any, callback: Function, music_set: number, sound_set: number, playerId: number): void {
    //     let _obj = { "music_set": music_set, "sound_set": sound_set, "playerId": playerId };
    //     var value: any = JSON.stringify(_obj);
    //     Net.doReqPost(thisObj, callback, 'getPlayerSetInfoAPI.json?', value);
    // }
    /**用户获得当前局剩余次数(游戏结束调用)----https://XXXX/getPlayerReviveCountAPI.json*/
    Net.getPlayerReviveCountAPI = function (thisObj, callback, playerId) {
        var _obj = { "playerId": playerId };
        // var value: any = JSON.stringify(_obj);
        var value = Net.getValue(_obj);
        Net.doReqPost(thisObj, callback, 'getPlayerReviveCountAPI.json?', value);
    };
    /**用户重置复活次数(游戏前调用)----https://XXXX/getPlayerGameStartAPI.json*/
    Net.getPlayerGameStartAPI = function (thisObj, callback, playerId) {
        var _obj = { "playerId": playerId };
        // var value: any = JSON.stringify(_obj);
        var value = Net.getValue(_obj);
        Net.doReqPost(thisObj, callback, 'getPlayerGameStartAPI.json?', value);
    };
    /**设置,显示，修改用户地址----https://XXXX/getPlayerUpdateInfoAPI.json*/
    Net.getPlayerUpdateInfoAPI = function (thisObj, callback, playerId, name, telephone, empno, city, address) {
        var _obj = { "playerId": playerId, "name": name, "telephone": telephone, "empno": empno, "city": city, "address": address };
        // var value: any = JSON.stringify(_obj);
        var value = Net.getValue(_obj);
        Net.doReqPost(thisObj, callback, 'getPlayerUpdateInfoAPI.json?', value);
    };
    Net.getPlayerUpdateInfoAPI_Before = function (thisObj, callback, playerId) {
        var _obj = { "playerId": playerId };
        // var value: any = JSON.stringify(_obj);
        var value = Net.getValue(_obj);
        Net.doReqPost(thisObj, callback, 'getPlayerUpdateInfoAPI.json?', value);
    };
    /**用户排名list----https://XXXX/getPlayerRankingAPI.json*/
    Net.getPlayerRankingAPI = function (thisObj, callback, playerId, page, type) {
        var _obj = { "playerId": playerId, "page": page, "type": type };
        // var value: any = JSON.stringify(_obj);
        var value = Net.getValue(_obj);
        Net.doReqPost(thisObj, callback, 'getPlayerRankingAPI.json?', value);
    };
    /**用户成就数据----https://XXXX/getPlayerTaksInfoAPI.json*/
    Net.getPlayerTaksInfoAPI = function (thisObj, callback, playerId) {
        var _obj = { "playerId": playerId };
        // var value: any = JSON.stringify(_obj);
        var value = Net.getValue(_obj);
        Net.doReqPost(thisObj, callback, 'getPlayerTaksInfoAPI.json?', value);
    };
    /**复活减少当局次数----https://XXXX/getPlayerReviveAPI.json*/
    Net.getPlayerReviveAPI = function (thisObj, callback, playerId) {
        var _obj = { "playerId": playerId };
        // var value: any = JSON.stringify(_obj);
        var value = Net.getValue(_obj);
        Net.doReqPost(thisObj, callback, 'getPlayerReviveAPI.json?', value);
    };
    /**继续游戏的接口----https://XXXX/getPlayerUpdateGameInfoAPI.json*/
    Net.getPlayerUpdateGameInfoAPI = function (thisObj, callback, playerId, game_info) {
        var _obj = { "playerId": playerId, "game_info": game_info };
        // var value: any = JSON.stringify(_obj);
        var value = Net.getValue(_obj);
        Net.doReqPost(thisObj, callback, 'getPlayerUpdateGameInfoAPI.json?', value);
    };
    Net.getValue = function (obj) {
        console.log('obj===', obj);
        var originalStr = JSON.stringify(obj);
        var bytes = new egret.ByteArray();
        bytes.writeUTFBytes(originalStr);
        var value = egret.Base64Util.encode(bytes.buffer);
        var _getChar = Net.getRandStr();
        console.log('value2====', value, _getChar);
        value = _getChar + value;
        return value;
    };
    Net.getRandStr = function () {
        var result = '';
        for (var i = 0; i < 1; i++) {
            var ranNum = Math.ceil(Math.random() * 25); //生成一个0到25的数字
            //大写字母'A'的ASCII是65,A~Z的ASCII码就是65 + 0~25;然后调用String.fromCharCode()传入ASCII值返回相应的字符并push进数组里
            result += (String.fromCharCode(65 + ranNum));
        }
        return result;
    };
    return Net;
}());
__reflect(Net.prototype, "Net");
