var __reflect = (this && this.__reflect) || function (p, c, t) {
    p.__class__ = c, t ? t.push(c) : t = [c], p.__types__ = p.__types__ ? t.concat(p.__types__) : t;
};
var GameLogic = (function () {
    function GameLogic() {
    }
    GameLogic.prototype.init = function () {
        this.showWordArr = [];
        this.selectWordArr = [];
        this.word = [];
        this.barrier = [];
        this.idiom = [];
        this.posx = [];
        this.posy = [];
        this.answer = [];
        this.id = -1;
        this.createWordArr = [];
        this.moveNum = 0;
        this.nodeArr = [];
    };
    // {x,y,state:0：不可扩展，1：横向扩展，2:纵向扩展 3:节点}
    //判断arr中单词哪些可以扩展，设置到createWordArr
    GameLogic.prototype.checkWordAdd = function (arr) {
        //先整理下arr
        this.createWordArr = [];
        var tempArr = []; //非节点数组
        var nodeArr = []; //节点数组
        for (var i = 0; i < arr.length; i++) {
            for (var j = 0; j < arr.length; j++) {
                if (arr[i][j].word.length > 0) {
                    if (arr[i][j].type == 3) {
                        nodeArr.push(arr[i][j]);
                    }
                    else {
                        tempArr.push(arr[i][j]);
                    }
                }
            }
        }
        //console.log(tempArr);
        //console.log('nodeArr======', nodeArr);
        this.createWordArr = tempArr;
        this.nodeArr = nodeArr;
    };
    //只负责写进去，不负责确定是不是有冲突 data{x:开始位置,y:开始位置,word:四字成语}
    GameLogic.prototype.setXWord = function (data, arr) {
        var word = data.word;
        var x = data.x;
        var y = data.y;
        for (var i = 0; i < 4; i++) {
            if (arr[x + i][y].word.length > 0) {
                arr[x + i][y].type = 3;
            }
            else {
                arr[x + i][y].word = word[i];
                arr[x + i][y].type = 1;
            }
        }
    };
    // data{x:开始位置,y:开始位置,word:四字成语}
    GameLogic.prototype.setYWord = function (data, arr) {
        var word = data.word;
        var x = data.x;
        var y = data.y;
        for (var i = 0; i < 4; i++) {
            if (arr[x][y - i].word.length > 0) {
                arr[x][y - i].type = 3;
            }
            else {
                arr[x][y - i].word = word[i];
                arr[x][y - i].type = 2;
            }
        }
    };
    GameLogic.prototype.logArr = function (arr) {
        //console.log('arr-------', this.createWordArr);
        var str = "";
        for (var i = 0; i < arr.length; i++) {
            for (var j = 0; j < arr.length; j++) {
                if (arr[i][j].word.length > 0) {
                    str = str + arr[i][j].word;
                }
            }
        }
        //console.log(str);
        wy.notify('getArr', this.idiom, arr, str);
    };
    //在createWordArr中随机取一个词进行扩展
    GameLogic.prototype.getOneWord = function (arr) {
        if (this.createWordArr.length == 0) {
            if (5 == this.moveNum) {
                if (this.idiom.length <= this.idiomNum) {
                    this.getWordData();
                    return;
                }
                // this.logArr(arr);
                //console.log(this.idiom);
                this.setWordDate(arr);
                return;
            }
            this.moveNum++;
            this.sortArr1(arr);
            return;
        }
        var indexArr = [];
        var num = 0;
        if (this.createWordArr.length > 1) {
            num = StaticVar.getRandomIntFull(0, this.createWordArr.length - 1);
        }
        var data = this.createWordArr[num];
        // {x:i,y:j,word:"",type:0}
        var minNum = 0;
        var maxNum = 0;
        if (data.type == 1) {
            //这个词是横向，只能纵向扩展
            if (data.y - 1 >= 0) {
                for (var i = data.y - 1; i >= 0; i--) {
                    if (arr[data.x][i].word.length > 0) {
                        break;
                    }
                    if (data.x - 1 >= 0) {
                        if (arr[data.x - 1][i].word.length > 0) {
                            break;
                        }
                    }
                    if (data.x + 1 < arr.length) {
                        if (arr[data.x + 1][i].word.length > 0) {
                            break;
                        }
                    }
                    if (i - 1 >= 0) {
                        if (arr[data.x][i - 1].word.length > 0) {
                            break;
                        }
                    }
                    minNum++;
                }
            }
            if (data.y + 1 < arr.length) {
                for (var i = data.y + 1; i < arr.length; i++) {
                    if (arr[data.x][i].word.length > 0) {
                        break;
                    }
                    if (data.x - 1 >= 0) {
                        if (arr[data.x - 1][i].word.length > 0) {
                            break;
                        }
                    }
                    if (data.x + 1 < arr.length) {
                        if (arr[data.x + 1][i].word.length > 0) {
                            break;
                        }
                    }
                    if (i + 1 < arr.length) {
                        if (arr[data.x][i + 1].word.length > 0) {
                            break;
                        }
                    }
                    maxNum++;
                }
            }
        }
        else if (data.type == 2) {
            //这个词是纵向，只能横向扩展
            if (data.x - 1 >= 0) {
                for (var i = data.x - 1; i >= 0; i--) {
                    if (arr[i][data.y].word.length > 0) {
                        break;
                    }
                    if (data.y - 1 >= 0) {
                        if (arr[i][data.y - 1].word.length > 0) {
                            break;
                        }
                    }
                    if (data.y + 1 < arr.length) {
                        if (arr[i][data.y + 1].word.length > 0) {
                            break;
                        }
                    }
                    if (i - 1 >= 0) {
                        if (arr[i - 1][data.y].word.length > 0) {
                            break;
                        }
                    }
                    minNum++;
                }
            }
            if (data.x + 1 < arr.length) {
                for (var i = data.x + 1; i < arr.length; i++) {
                    if (arr[i][data.y].word.length > 0) {
                        break;
                    }
                    if (data.y - 1 >= 0) {
                        if (arr[i][data.y - 1].word.length > 0) {
                            break;
                        }
                    }
                    if (data.y + 1 < arr.length) {
                        if (arr[i][data.y + 1].word.length > 0) {
                            break;
                        }
                    }
                    if (i + 1 < arr.length) {
                        if (arr[i + 1][data.y].word.length > 0) {
                            break;
                        }
                    }
                    maxNum++;
                }
            }
        }
        if (maxNum + minNum < 4) {
            // 这个字不能扩展
            this.createWordArr.splice(num, 1);
            this.getOneWord(arr);
            return;
        }
        if (maxNum > 3) {
            maxNum = 3;
        }
        if (minNum > 3) {
            minNum = 3;
        }
        var length = minNum + maxNum + 1;
        var roundNum = length - 4;
        for (var i = 0; i <= roundNum; i++) {
            if (data.type == 2) {
                indexArr.push(4 - maxNum - 1 + roundNum);
            }
            else {
                indexArr.push(4 - minNum - 1 + roundNum);
            }
        }
        var word = this.seachWordWithArr(data.word, indexArr);
        if (null == word) {
            //这里断了，重新找
            this.createWordArr.splice(num, 1);
            return this.getOneWord(arr);
        }
        var index = word.search(data.word);
        if (data.type == 1) {
            if (data.x < 0 || data.x >= arr.length || data.y + index < 0 || data.y + index >= arr.length) {
                //这里断了，重新找
                this.createWordArr.splice(num, 1);
                return this.getOneWord(arr);
            }
            this.setYWord({ x: data.x, y: data.y + index, word: word }, arr);
        }
        else if (data.type == 2) {
            if (data.x - index < 0 || data.x - index >= arr.length || data.y < 0 || data.y >= arr.length) {
                //这里断了，重新找
                this.createWordArr.splice(num, 1);
                return this.getOneWord(arr);
            }
            this.setXWord({ x: data.x - index, y: data.y, word: word }, arr);
        }
        this.idiom.push(word);
        if (this.idiom.length == this.idiomNum) {
            // console.log('this.idiom====', this.idiom);
            this.logArr(arr);
            return this.setWordDate(arr);
        }
        return this.sortArr(arr);
    };
    //设置返回数据
    GameLogic.prototype.setWordDate = function (arr) {
        var wordArr = [];
        var num = 0;
        for (var i = 0; i < arr.length; i++) {
            for (var j = arr[i].length - 1; j >= 0; j--) {
                if (arr[i][j].type > 0) {
                    this.posx.push(i);
                    this.posy.push(j);
                    this.word.push(arr[i][j].word);
                    wordArr.push(num);
                    num++;
                }
            }
        }
        var minNum = Math.floor(wordArr.length * 0.4);
        var maxNum = Math.floor(wordArr.length * 0.7);
        console.log('wordArr', wordArr, wordArr.length, minNum, maxNum);
        this.answer = StaticVar.getRandomArrayElements(wordArr, StaticVar.getRandomIntFull(minNum, maxNum));
        console.log('this.answer', this.answer);
        for (var i = 0; i < this.posx.length - 1; i++) {
            var word = this.posx[i];
            if (this.posx[i] == this.posx[i + 1] && this.posx[i + 1] == this.posx[i + 2] && this.posx[i + 2] == this.posx[i + 3]) {
                var isAdd = true;
                for (var j = 0; j < this.answer.length; j++) {
                    if (this.answer[j] >= i && this.answer[j] <= i + 3) {
                        isAdd = false;
                        break;
                    }
                }
                if (isAdd == true) {
                    this.answer.push(i);
                }
                break;
            }
        }
        for (var i = 0; i < this.posy.length - 1; i++) {
            var word = this.posy[i];
            if (this.posy[i] == this.posy[i + 1] && this.posy[i + 1] == this.posy[i + 2] && this.posy[i + 2] == this.posy[i + 3]) {
                var isAdd = true;
                for (var j = 0; j < this.answer.length; j++) {
                    if (this.answer[j] >= i && this.answer[j] <= i + 3) {
                        isAdd = false;
                        break;
                    }
                }
                if (isAdd == true) {
                    this.answer.push(i);
                }
                break;
            }
        }
        console.log('this.answer2', this.answer);
        return true;
    };
    GameLogic.prototype.getData = function () {
        return { word: this.word, idiom: this.idiom, posx: this.posx, posy: this.posy, answer: this.answer };
    };
    //按字符和indexArr搜索字
    GameLogic.prototype.seachWordWithArr = function (str, indexArr) {
        var allWords = StaticVar.idiomJson; // GameData.getInstance().getAllWords();
        var min = indexArr[0];
        var max = indexArr[0];
        for (var i = 0; i < indexArr.length; i++) {
            if (indexArr[i] < min) {
                min = indexArr[i];
            }
            if (indexArr[i] > max) {
                max = indexArr[i];
            }
        }
        //先找所有含有这个字的单词
        var wordArr = [];
        for (var i = 0; i < allWords.length; i++) {
            if (allWords[i].word.search(str) >= min && allWords[i].word.search(str) <= max) {
                wordArr.push(allWords[i]);
            }
        }
        if (wordArr.length == 0) {
            return null;
        }
        var num = StaticVar.getRandomIntFull(0, wordArr.length - 1);
        var data = wordArr[num];
        for (var i = 0; i < this.idiom.length; i++) {
            if (data.word == this.idiom[i]) {
                wordArr.splice(num, 1);
                if (wordArr.length == 0) {
                    return null;
                }
                num = StaticVar.getRandomIntFull(0, wordArr.length - 1);
                data = wordArr[num];
                break;
            }
        }
        return data.word;
    };
    //获得arr的四个极值
    GameLogic.prototype.getArrMinAndMax = function (arr) {
        var tempArr = []; //非节点数组
        for (var i = 0; i < arr.length; i++) {
            for (var j = 0; j < arr.length; j++) {
                if (arr[i][j].word.length > 0) {
                    tempArr.push(arr[i][j]);
                }
            }
        }
        var numArr = [];
        for (var i = 0; i < arr.length; i++) {
            var temp = [];
            for (var j = 0; j < arr[i].length; j++) {
                temp.push({ x: i, y: j, word: "", type: 0 });
            }
            numArr.push(temp);
        }
        var minX = tempArr[0].x;
        var maxX = tempArr[0].x;
        var minY = tempArr[0].y;
        var maxY = tempArr[0].y;
        for (var i = 0; i < tempArr.length; i++) {
            if (tempArr[i].x < minX) {
                minX = tempArr[i].x;
            }
            if (tempArr[i].x > maxX) {
                maxX = tempArr[i].x;
            }
            if (tempArr[i].y < minY) {
                minY = tempArr[i].y;
            }
            if (tempArr[i].y > maxY) {
                maxY = tempArr[i].y;
            }
        }
        return { numArr: numArr, minX: minX, maxX: maxX, minY: minY, maxY: maxY, tempArr: tempArr };
    };
    //整理arr,把位置调到中间
    GameLogic.prototype.sortArr = function (arr) {
        var length = arr.length;
        var data = this.getArrMinAndMax(arr);
        var numArr = data.numArr;
        var minX = data.minX;
        var maxX = data.maxX;
        var minY = data.minY;
        var maxY = data.maxY;
        if (minX - (length - 1 - maxX) > 2) {
            //前面比后面多。整体往左挪一位
            //console.log('前面比后面多。整体往左挪一位');
            for (var i = 0; i < numArr.length - 1; i++) {
                for (var j = 0; j < numArr[i].length; j++) {
                    numArr[i][j].word = arr[i + 1][j].word;
                    numArr[i][j].type = arr[i + 1][j].type;
                }
            }
            arr = numArr;
            return this.sortArr(arr);
        }
        else if (length - 1 - maxX - minX > 2) {
            //后面比前面多。整体往右挪一位
            //console.log('后面比前面多。整体往右挪一位');
            for (var i = 1; i < numArr.length; i++) {
                for (var j = 0; j < numArr[i].length; j++) {
                    numArr[i][j].word = arr[i - 1][j].word;
                    numArr[i][j].type = arr[i - 1][j].type;
                }
            }
            arr = numArr;
            return this.sortArr(arr);
        }
        if (minY - (length - 1 - maxY) > 2) {
            //下面比上面多。整体往下挪一位
            //console.log('下面比上面多。整体往下挪一位');
            for (var i = 0; i < numArr.length; i++) {
                for (var j = 0; j < numArr[i].length - 1; j++) {
                    numArr[i][j].word = arr[i][j + 1].word;
                    numArr[i][j].type = arr[i][j + 1].type;
                }
            }
            arr = numArr;
            return this.sortArr(arr);
        }
        else if (length - 1 - maxY - minY > 2) {
            //上面比下面多。整体往上挪一位
            //console.log('上面比下面多。整体往上挪一位');
            for (var i = 0; i < numArr.length; i++) {
                for (var j = 1; j < numArr[i].length; j++) {
                    numArr[i][j].word = arr[i][j - 1].word;
                    numArr[i][j].type = arr[i][j - 1].type;
                }
            }
            arr = numArr;
            return this.sortArr(arr);
        }
        // this.logArr(arr);
        this.checkWordAdd(arr);
        this.getOneWord(arr);
    };
    //往空地方移动然后再判断一下
    GameLogic.prototype.sortArr1 = function (arr) {
        var length = arr.length;
        var data = this.getArrMinAndMax(arr);
        var numArr = data.numArr;
        var minX = data.minX;
        var maxX = data.maxX;
        var minY = data.minY;
        var maxY = data.maxY;
        if (minX > 0) {
            //前面比后面多。整体往左挪
            //console.log('前面比后面多。整体往左挪');
            for (var i = 0; i < numArr.length - minX; i++) {
                for (var j = 0; j < numArr[i].length; j++) {
                    numArr[i][j].word = arr[i + minX][j].word;
                    numArr[i][j].type = arr[i + minX][j].type;
                }
            }
            for (var i = numArr.length - minX; i < numArr.length; i++) {
                for (var j = 0; j < numArr[i].length; j++) {
                    numArr[i][j].word = "";
                    numArr[i][j].type = 0;
                }
            }
            arr = numArr;
            // this.logArr(arr);
            this.checkWordAdd(arr);
            this.getOneWord(arr);
            return;
        }
        else if (length - maxX > 0) {
            var num = length - maxX - 1;
            //后面比前面多。整体往右挪
            //console.log('后面比前面多。整体往右挪');
            for (var i = num; i < numArr.length; i++) {
                for (var j = 0; j < numArr[i].length; j++) {
                    numArr[i][j].word = arr[i - num][j].word;
                    numArr[i][j].type = arr[i - num][j].type;
                }
            }
            for (var i = 0; i < num; i++) {
                for (var j = 0; j < numArr[i].length; j++) {
                    numArr[i][j].word = "";
                    numArr[i][j].type = 0;
                }
            }
            arr = numArr;
            // this.logArr(arr);
            this.checkWordAdd(arr);
            this.getOneWord(arr);
            return;
        }
        if (minY > 0) {
            //下面比上面多。整体往下挪
            //console.log('下面比上面多。整体往下挪');
            for (var i = 0; i < numArr.length; i++) {
                for (var j = 0; j < numArr[i].length - minY; j++) {
                    numArr[i][j].word = arr[i][j + minY].word;
                    numArr[i][j].type = arr[i][j + minY].type;
                }
            }
            for (var i = 0; i < numArr.length; i++) {
                for (var j = numArr[i].length - minY; j < numArr[i].length; j++) {
                    numArr[i][j].word = "";
                    numArr[i][j].type = 0;
                }
            }
            arr = numArr;
            // this.logArr(arr);
            this.checkWordAdd(arr);
            this.getOneWord(arr);
            return;
        }
        else if (length - maxY > 0) {
            var num = length - maxX - 1;
            //上面比下面多。整体往上挪
            //console.log('上面比下面多。整体往上挪');
            for (var i = 0; i < numArr.length; i++) {
                for (var j = num; j < numArr[i].length; j++) {
                    numArr[i][j].word = arr[i][j - num].word;
                    numArr[i][j].type = arr[i][j - num].type;
                }
            }
            for (var i = 0; i < numArr.length; i++) {
                for (var j = 0; j < num; j++) {
                    numArr[i][j].word = "";
                    numArr[i][j].type = 0;
                }
            }
            arr = numArr;
            // this.logArr(arr);
            this.checkWordAdd(arr);
            this.getOneWord(arr);
            return;
        }
    };
    //在这开始
    GameLogic.prototype.getWordData = function () {
        this.init();
        //自己造数据
        this.idiomNum = StaticVar.getRandomIntFull(8, 13);
        var maxLength = 9;
        var posXArr = [];
        var arr = [];
        for (var i = 0; i < maxLength; i++) {
            var tempArr = [];
            for (var j = 0; j < maxLength; j++) {
                tempArr.push({ x: i, y: j, word: "", type: 0 });
            }
            arr.push(tempArr);
        }
        //此处为创建单词流程选词后的第一步
        return this.startSetWord({ x: 0, y: 0, word: "" }, 9, arr);
    };
    //开始设置
    GameLogic.prototype.startSetWord = function (data, length, arr) {
        var allWords = StaticVar.idiomJson; //GameData.getInstance().getAllWords();
        //随机取一个成语
        var firstNum = StaticVar.getRandomIntFull(0, allWords.length - 1);
        var wordData = allWords[firstNum];
        if (data.word.length == 0) {
            if (StaticVar.getRandomIntFull(0, 100) > 50) {
                // 先是横着
                this.setXWord({ x: 3, y: 4, word: wordData.word }, arr);
            }
            else {
                //先是竖着
                this.setYWord({ x: 4, y: 5, word: wordData.word }, arr);
            }
        }
        // this.logArr(arr);
        this.idiom.push(wordData.word);
        return this.sortArr(arr);
    };
    return GameLogic;
}());
__reflect(GameLogic.prototype, "GameLogic");
