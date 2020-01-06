var __reflect = (this && this.__reflect) || function (p, c, t) {
    p.__class__ = c, t ? t.push(c) : t = [c], p.__types__ = p.__types__ ? t.concat(p.__types__) : t;
};
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
/**
 *
 *@author
 *
 */
var Game = (function (_super) {
    __extends(Game, _super);
    function Game() {
        var _this = _super.call(this) || this;
        _this.btnArr = ['backBtn', 'btn1', 'btn2', 'btn3', 'btn4'];
        return _this;
    }
    Game.prototype.createChildren = function () {
        _super.prototype.createChildren.call(this);
        this.hintTxt.verticalAlign = 'middle';
    };
    Game.prototype.show = function (data) {
        var _this = this;
        _super.prototype.show.call(this, data);
        this.touchInit();
        this.totalArr = [];
        this.itemTopArr = [];
        this.itemBottomArr = [];
        this.idiomArr = [];
        this.completeArr = [];
        this.idiomCon = new egret.Sprite();
        this.addChild(this.idiomCon);
        this.idiomCon.x = 60;
        this.idiomCon.y = 200;
        wy.on(this.getArr, 'getArr', this);
        wy.LoadingData.open();
        new GameLogic().getWordData();
        egret.setTimeout(function () {
            console.log('sss', _this.idiomArr);
        }, this, 2000);
    };
    Game.prototype.getArr = function (idiomArr, arr, str) {
        wy.LoadingData.close();
        console.log('arr====', '\n', idiomArr, '\n', '\n', arr, '\n', str, '\n');
        for (var k = 0; k < idiomArr.length; k++) {
            var obj = idiomArr[k];
            this.idiomArr.push(obj);
        }
        for (var i = 0; i < 9; i++) {
            this.totalArr[i] = [];
            for (var j = 0; j < 9; j++) {
                var item = new GameItem();
                if (arr[i][8 - j].type > 0) {
                    if (arr[i][8 - j].type == 3) {
                        item.changeTexture(1);
                        item.changeTxt('');
                        this.itemTopArr.push(item);
                        item.touchEnabled = true;
                        item.addEventListener(egret.TouchEvent.TOUCH_TAP, this.itemTopTouch, this);
                        var bottomItem = new GameItem();
                        this.addChild(bottomItem);
                        bottomItem.changeTexture(0);
                        bottomItem.changeTxt(arr[i][8 - j].word);
                        this.itemBottomArr.push(bottomItem);
                        this.createBootomItem(this.itemBottomArr); //创建下面的单词
                    }
                    else {
                        item.changeTexture(0);
                        item.changeTxt(arr[i][8 - j].word);
                    }
                }
                else {
                    item.changeTexture(-1);
                    item.changeTxt('');
                    item.alpha = 0.1;
                }
                item.width = 70;
                item.height = 70;
                item.x = 70 * i;
                item.y = 70 * j;
                this.idiomCon.addChild(item);
                item['index'] = j * 9 + (i + 1);
                this.totalArr[i].push(item);
            }
        }
        console.log('totalArr', this.totalArr);
        this.curTouchTop = this.itemTopArr[0];
        this.curTouchTop.changeTexture(2);
    };
    Game.prototype.itemTopTouch = function (e) {
        console.log('itemTopTouch---', e.currentTarget, e.currentTarget.index);
        this.curTouchTop = e.currentTarget;
        for (var i = 0; i < this.itemTopArr.length; i++) {
            if (this.itemTopArr[i].type == 2) {
                this.itemTopArr[i].changeTexture(1);
            }
        }
        this.curTouchTop.changeTexture(2);
        this.curTouchTop.changeTxt(''); //改变文字
        //还原下方item
        this.backBottomItem();
    };
    /**下面词语点击 */
    Game.prototype.itemBottomTouch = function (e) {
        console.log('itemBottomTouch---', e.currentTarget, this.curTouchTop.type);
        //删除或隐藏下面的item
        e.currentTarget.visible = false;
        e.currentTarget.type = this.curTouchTop.index;
        this.curTouchTop.changeTxt(e.currentTarget.idiomTxt.text); //改变文字
        if (this.curTouchTop.type == 2) {
            this.curTouchTop.changeTexture(1);
        }
        //将移动对象移到到下一个
        this.curTouchTopMove();
        //横向搜索
        var str_row = "";
        var arr_row = [];
        for (var i = 0; i < 9; i++) {
            for (var j = 0; j < 9; j++) {
                var obj = this.totalArr[j][i];
                if (obj._text == "") {
                    str_row = "";
                    arr_row = [];
                    continue;
                }
                str_row += obj._text;
                arr_row.push(obj);
                if (str_row.length == 4) {
                    console.log('str_row==', str_row, this.idiomArr);
                    for (var _a = 0; _a < this.idiomArr.length; _a++) {
                        if (str_row == this.idiomArr[_a] && this.completeArr.indexOf(str_row) == -1) {
                            console.log('完成一个成语');
                            this.completeArr.push(str_row);
                            this.succeedMethod(arr_row);
                        }
                        else {
                            // console.log('成语错误');
                            this.failMethod(arr_row);
                        }
                    }
                    str_row = "";
                    arr_row = [];
                }
            }
        }
        //纵向搜索
        var str_col = "";
        var arr_col = [];
        for (var i = 0; i < 9; i++) {
            for (var j = 0; j < 9; j++) {
                var obj = this.totalArr[i][j];
                if (obj._text == "") {
                    str_col = "";
                    arr_col = [];
                    continue;
                }
                str_col += obj._text;
                arr_col.push(obj);
                if (str_col.length == 4) {
                    console.log('str_row==', str_col, this.idiomArr);
                    for (var _a = 0; _a < this.idiomArr.length; _a++) {
                        if (str_col == this.idiomArr[_a] && this.completeArr.indexOf(str_col) == -1) {
                            console.log('完成一个成语2');
                            this.completeArr.push(str_col);
                            this.succeedMethod(arr_col);
                        }
                        else {
                            // console.log('成语错误2');
                            this.failMethod(arr_col);
                        }
                    }
                    str_col = "";
                    arr_col = [];
                }
            }
        }
    };
    Game.prototype.backBottomItem = function () {
        for (var i = 0; i < this.itemBottomArr.length; i++) {
            if (this.itemBottomArr[i].type == this.curTouchTop.index) {
                this.itemBottomArr[i].visible = true;
                return;
            }
        }
    };
    Game.prototype.failMethod = function (arr_row) {
        for (var _b = 0; _b < arr_row.length; _b++) {
            for (var i = 0; i < 9; i++) {
                for (var j = 0; j < 9; j++) {
                    var obj = this.totalArr[j][i];
                    if (obj.index == arr_row[_b].index && obj.type != 0 && obj.type != 4) {
                        obj.changeTexture(3);
                    }
                }
            }
        }
    };
    Game.prototype.succeedMethod = function (arr_row) {
        for (var _b = 0; _b < arr_row.length; _b++) {
            for (var i = 0; i < 9; i++) {
                for (var j = 0; j < 9; j++) {
                    var obj = this.totalArr[j][i];
                    if (obj.index == arr_row[_b].index) {
                        obj.touchEnabled = false;
                        obj.changeTexture(4);
                        wy.Tools.center(arr_row[_b]);
                        egret.Tween.get(arr_row[_b]).to({ scaleX: 1.1, scaleY: 1.1 }, 300).to({ scaleX: 1, scaleY: 1 }, 300);
                    }
                }
            }
        }
    };
    Game.prototype.curTouchTopMove = function () {
        for (var i = 0; i < this.itemTopArr.length; i++) {
            if (this.itemTopArr[i]._text == '') {
                this.curTouchTop = this.itemTopArr[i];
                this.curTouchTop.changeTexture(2);
                return;
            }
        }
    };
    /**创建下面的单词 */
    Game.prototype.createBootomItem = function (itemBottomArr) {
        for (var i = 0; i < itemBottomArr.length; i++) {
            var bottomItem = itemBottomArr[i];
            bottomItem.x = 70 + 90 * (i % 7);
            var _yNum = Math.floor(i / 7) % 7;
            bottomItem.y = 975 + _yNum * 90;
            bottomItem.touchEnabled = true;
            bottomItem.addEventListener(egret.TouchEvent.TOUCH_TAP, this.itemBottomTouch, this);
        }
    };
    Game.prototype.onTouchTap = function (e) {
        switch (e.currentTarget) {
            case this.backBtn:
                wy.changeScene(Home);
                break;
            case this.btn1:
                break;
            case this.btn2:
                break;
            case this.btn3:
                break;
            case this.btn4:
                break;
            default:
                break;
        }
    };
    Game.prototype.touchInit = function () {
        this.bg.touchEnabled = true;
        for (var i = 0; i < this.btnArr.length; i++) {
            this[this.btnArr[i]].touchEnabled = true;
            this[this.btnArr[i]].addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        }
    };
    Game.prototype.hide = function () {
        _super.prototype.hide.call(this);
        this.bg.touchEnabled = false;
        for (var i = 0; i < this.btnArr.length; i++) {
            this[this.btnArr[i]].touchEnabled = false;
            this[this.btnArr[i]].removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        }
    };
    return Game;
}(GameUI));
__reflect(Game.prototype, "Game");
