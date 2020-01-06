
/**
 *全局静态量类
 *
 * @version 0.0.1
 *@platform egret3.0.3
 *
 */
class Net {
    public static urlIP: string;
    public static doReqPost(thisObj: any, callback: Function, rtype: string, value: string, type: string = egret.HttpResponseType.TEXT) {
        var req = new egret.HttpRequest();
        req.responseType = type;
        req.open(Net.urlIP + rtype, egret.HttpMethod.POST);
        req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        req.send(value);
        req.addEventListener(egret.Event.COMPLETE, callback, thisObj);
    }

    /**注册---https://XXXX/getWeiXinInsert.json*/
    public static getWeiXinInsert(thisObj: any, callback: Function, openId: string, name: string, img: string): void {
        let _obj = { "openId": openId, "name": name, "img": img };
        var value: any = JSON.stringify(_obj);
        Net.doReqPost(thisObj, callback, 'getWeiXinInsert.json?', value);
    }

    /**登录---https://XXXX/getPlayerUserLoginAPI.json*/
    public static getPlayerUserLoginAPI(thisObj: any, callback: Function, openid: string, playerId: number): void {
        let _obj = { "openid": openid, "playerId": playerId };
        // var value: any = JSON.stringify(_obj);
        var value = Net.getValue(_obj);
        Net.doReqPost(thisObj, callback, 'getPlayerUserLoginAPI.json?', value);
    }

    /**用户上传分数---https://XXXX/getPlayerUpdateScoreAPI.json*/
    public static getPlayerUpdateScoreAPI(thisObj: any, callback: Function, playerId: number, score: number): void {
        let _obj = { "playerId": playerId, "score": score };
        // var value: any = JSON.stringify(_obj);
        var value = Net.getValue(_obj);
        Net.doReqPost(thisObj, callback, 'getPlayerUpdateScoreAPI.json?', value);
    }

    /**用户设置背景音乐音效---https://XXXX/getPlayerSetInfoAPI.json*/
    // public static getPlayerSetInfoAPI(thisObj: any, callback: Function, music_set: number, sound_set: number, playerId: number): void {
    //     let _obj = { "music_set": music_set, "sound_set": sound_set, "playerId": playerId };
    //     var value: any = JSON.stringify(_obj);
    //     Net.doReqPost(thisObj, callback, 'getPlayerSetInfoAPI.json?', value);
    // }

    /**用户获得当前局剩余次数(游戏结束调用)----https://XXXX/getPlayerReviveCountAPI.json*/
    public static getPlayerReviveCountAPI(thisObj: any, callback: Function, playerId: number): void {
        let _obj = { "playerId": playerId };
        // var value: any = JSON.stringify(_obj);
        var value = Net.getValue(_obj);
        Net.doReqPost(thisObj, callback, 'getPlayerReviveCountAPI.json?', value);
    }
    /**用户重置复活次数(游戏前调用)----https://XXXX/getPlayerGameStartAPI.json*/
    public static getPlayerGameStartAPI(thisObj: any, callback: Function, playerId: number): void {
        let _obj = { "playerId": playerId };
        // var value: any = JSON.stringify(_obj);
        var value = Net.getValue(_obj);
        Net.doReqPost(thisObj, callback, 'getPlayerGameStartAPI.json?', value);
    }

    /**设置,显示，修改用户地址----https://XXXX/getPlayerUpdateInfoAPI.json*/
    public static getPlayerUpdateInfoAPI(thisObj: any, callback: Function, playerId: number, name: string, telephone: string, empno: string, city: string, address: string): void {
        let _obj = { "playerId": playerId, "name": name, "telephone": telephone, "empno": empno, "city": city, "address": address };
        // var value: any = JSON.stringify(_obj);
        var value = Net.getValue(_obj);
        Net.doReqPost(thisObj, callback, 'getPlayerUpdateInfoAPI.json?', value);
    }
    public static getPlayerUpdateInfoAPI_Before(thisObj: any, callback: Function, playerId: number): void {
        let _obj = { "playerId": playerId };
        // var value: any = JSON.stringify(_obj);
        var value = Net.getValue(_obj);
        Net.doReqPost(thisObj, callback, 'getPlayerUpdateInfoAPI.json?', value);
    }

    /**用户排名list----https://XXXX/getPlayerRankingAPI.json*/
    public static getPlayerRankingAPI(thisObj: any, callback: Function, playerId: number, page: number, type: number): void {
        let _obj = { "playerId": playerId, "page": page, "type": type };
        // var value: any = JSON.stringify(_obj);
        var value = Net.getValue(_obj);
        Net.doReqPost(thisObj, callback, 'getPlayerRankingAPI.json?', value);
    }

    /**用户成就数据----https://XXXX/getPlayerTaksInfoAPI.json*/
    public static getPlayerTaksInfoAPI(thisObj: any, callback: Function, playerId: number): void {
        let _obj = { "playerId": playerId };
        // var value: any = JSON.stringify(_obj);
        var value = Net.getValue(_obj);
        Net.doReqPost(thisObj, callback, 'getPlayerTaksInfoAPI.json?', value);
    }

    /**复活减少当局次数----https://XXXX/getPlayerReviveAPI.json*/
    public static getPlayerReviveAPI(thisObj: any, callback: Function, playerId: number): void {
        let _obj = { "playerId": playerId };
        // var value: any = JSON.stringify(_obj);
        var value = Net.getValue(_obj);
        Net.doReqPost(thisObj, callback, 'getPlayerReviveAPI.json?', value);
    }

    /**继续游戏的接口----https://XXXX/getPlayerUpdateGameInfoAPI.json*/
    public static getPlayerUpdateGameInfoAPI(thisObj: any, callback: Function, playerId: number, game_info: string): void {
        let _obj = { "playerId": playerId, "game_info": game_info };
        // var value: any = JSON.stringify(_obj);
        var value = Net.getValue(_obj);
        Net.doReqPost(thisObj, callback, 'getPlayerUpdateGameInfoAPI.json?', value);
    }


    public static getValue(obj) {
        console.log('obj===', obj);
        let originalStr: string = JSON.stringify(obj);
        let bytes: egret.ByteArray = new egret.ByteArray();
        bytes.writeUTFBytes(originalStr);
        let value = egret.Base64Util.encode(bytes.buffer);

        let _getChar = Net.getRandStr();
        console.log('value2====', value, _getChar);
        value = _getChar + value;
        return value;
    }
    public static getRandStr() {
        var result = '';
        for (var i = 0; i < 1; i++) {
            var ranNum = Math.ceil(Math.random() * 25); //生成一个0到25的数字
            //大写字母'A'的ASCII是65,A~Z的ASCII码就是65 + 0~25;然后调用String.fromCharCode()传入ASCII值返回相应的字符并push进数组里
            result += (String.fromCharCode(65 + ranNum));
        }
        return result;
    }


}