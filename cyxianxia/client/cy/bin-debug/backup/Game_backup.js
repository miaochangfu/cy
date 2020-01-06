// /**
//  *
//  *@author
//  *
//  */
// class Game_backup extends GameUI {
// 	constructor() {
// 		super();
// 	}
// 	/**上面留空对象的数组 */
// 	private itemTopArr: any;
// 	/**下面留空对象的数组 */
// 	private itemBottomArr: any;
// 	protected createChildren(): void {
// 		super.createChildren();
// 		this.hintTxt.verticalAlign = 'middle';
// 	}
// 	private idiomJsonArr: any = [];
// 	private resultLen: number = 5;
// 	public show(data?): void {
// 		super.show(data);
// 		this.touchInit();
// 		this.itemTopArr = [];
// 		this.itemBottomArr = [];
// 		// this.getIdiom(StaticVar.idiomJson, StaticVar.idiomJson);
// 		//  ["豁达大度", "暗度陈仓", "官仓老鼠", "鼠目寸光", "愁肠寸断"];
// 		this.createUI(StaticVar.testCyArr);
// 	}
// 	private getArr(idiom, nodeArr, arr, str) {
// 		wy.LoadingData.close();
// 		console.log('arr====', '\n', idiom, '\n', nodeArr, '\n', arr, '\n', str, '\n');
// 		let starArray: any;
// 		starArray = [];
// 		let _eleCon = new egret.Sprite();
// 		this.addChild(_eleCon);
// 		_eleCon.x = 60;
// 		_eleCon.y = 220;
// 		for (let i = 0; i < 9; i++) {
// 			starArray[i] = [];
// 			for (let j = 0; j < 9; j++) {
// 				let _index = Math.floor(Math.random() * 5);
// 				if (arr[i][8 - j].type != 0) {
// 					let star: GameItem;
// 					if (arr[i][8 - j].type == 3) {
// 						star = new GameItem(1, '');
// 					}
// 					else {
// 						star = new GameItem(0, arr[i][8 - j].word);
// 					}
// 					star.width = 70;
// 					star.height = 70;
// 					star.x = 70 * i;
// 					star.y = 70 * j;
// 					_eleCon.addChild(star);
// 				}
// 			}
// 		}
// 	}
// 	private createUI(arr) {
// 		//第一步：创建UI
// 		let _eleCon = new egret.Sprite();
// 		this.addChild(_eleCon);
// 		_eleCon.x = 60;
// 		_eleCon.y = 200;
// 		let boxArr: any = [];
// 		let nullArr: any = [];
// 		for (let i = 0; i < arr.length; i++) {
// 			//第一个成语横放
// 			let arrI = arr[i].split('');
// 			let item = new BoxItem(i % 2, arrI);
// 			_eleCon.addChild(item);
// 			boxArr.push(item);
// 			if (i == 0) {
// 				item.x = 0;
// 				item.y = 0;
// 			}
// 			else {
// 				let strArr1 = arr[i - 1].split('');
// 				let strArr2 = arr[i].split('');
// 				let a, b;//交汇点索引
// 				for (let i = 0; i < 4; i++) {
// 					for (let j = 0; j < 4; j++) {
// 						if (strArr1[i] == strArr2[j]) {
// 							a = i;
// 							b = j;
// 							break;
// 						}
// 					}
// 				}
// 				console.log('ab==', a, b);
// 				let ab = { a: a, b: b };
// 				nullArr.push(ab);
// 				if (i % 2 == 0) {//横
// 					// console.log('ab_1==', a, b);
// 					item.x = boxArr[i - 1].x - b * 70;
// 					item.y = boxArr[i - 1].y + a * 70;
// 				}
// 				else {//竖
// 					// console.log('ab_4==', a, b);
// 					item.x = boxArr[i - 1].x + a * 70;
// 					item.y = boxArr[i - 1].y - b * 70;
// 				}
// 			}
// 		}
// 		//判断容器宽高，如果大于630，则递归重来
// 		if (_eleCon.width > 630 || _eleCon.height > 630) {
// 			//递归，重新选词
// 		}
// 		//还有重叠的可能性，横的判断y值是否相等，竖的判断x值是否相等
// 		//第二步：容器位置调整
// 		let newArr = [];
// 		for (let j = 0; j < boxArr.length; j++) {
// 			newArr.push(boxArr[j]);
// 		}
// 		let w = boxArr[0].x - newArr.sort(MyTools.compare("x", true))[0].x;
// 		let h = boxArr[0].y - newArr.sort(MyTools.compare("y", true))[0].y;
// 		console.log('wh===', w, h, 630 - _eleCon.width, 630 - _eleCon.height);
// 		_eleCon.x += (w + (630 - _eleCon.width) / 2);
// 		_eleCon.y += (h + (630 - _eleCon.height) / 2);
// 		console.log('whss===', _eleCon.x, _eleCon.y, _eleCon.width, _eleCon.height);
// 		//第三步：留空
// 		console.log(nullArr, nullArr.length, boxArr.length);
// 		for (let j = 0; j < boxArr.length; j++) {
// 			let a, b;
// 			if (j < nullArr.length) {
// 				a = nullArr[j].a;
// 				let txtArr = boxArr[j].getChildAt(a);
// 				console.log('txtArr1==', a, txtArr._text);
// 			}
// 			if (j > 0) {
// 				b = nullArr[j - 1].b;
// 				let txtArr = boxArr[j].getChildAt(b);
// 				// console.log('txtArr3==', b, txtArr._text);
// 			}
// 		}
// 	}
// 	private xjArr: any = [];
// 	private getIdiom(idiomJson, arr) {
// 		let idiom = arr[Math.floor(Math.random() * arr.length)];
// 		//随机相交的索引
// 		let rand = Math.floor(Math.random() * 4);
// 		this.xjArr.push(rand);//待做
// 		let randArr = [];
// 		for (let i = 0; i < idiomJson.length; i++) {
// 			if (idiomJson[i].indexOf(idiom[rand]) > 0) {
// 				randArr.push(idiomJson[i]);
// 			}
// 		}
// 		// console.log('randArr', randArr, randArr.length, this.idiomJsonArr.length);
// 		if (this.idiomJsonArr.length < this.resultLen) {
// 			if (randArr.length == 0) {
// 				this.createUI(this.idiomJsonArr);
// 				console.log('idiomJsonArr_1===', this.idiomJsonArr);
// 			}
// 			else {
// 				this.idiomJsonArr.push(idiom);
// 				this.getIdiom(StaticVar.idiomJson, randArr);
// 			}
// 		}
// 		else {
// 			console.log('idiomJsonArr_3===', this.idiomJsonArr);
// 			this.createUI(this.idiomJsonArr);
// 		}
// 	}
// 	private onTouchTap(e: egret.TouchEvent): void {
// 		switch (e.currentTarget) {
// 			case this.backBtn:
// 				wy.changeScene(Home);
// 				break;
// 			case this.btn1://跳过
// 				break;
// 			case this.btn2://怎么玩
// 				break;
// 			case this.btn3://提示
// 				break;
// 			case this.btn4://重玩
// 				break;
// 			default:
// 				break;
// 		}
// 	}
// 	private btnArr: any = ['backBtn', 'btn1', 'btn2', 'btn3', 'btn4'];
// 	private touchInit() {
// 		this.bg.touchEnabled = true;
// 		for (let i = 0; i < this.btnArr.length; i++) {
// 			this[this.btnArr[i]].touchEnabled = true;
// 			this[this.btnArr[i]].addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
// 		}
// 	}
// 	public hide(): void {
// 		super.hide();
// 		this.bg.touchEnabled = false;
// 		for (let i = 0; i < this.btnArr.length; i++) {
// 			this[this.btnArr[i]].touchEnabled = false;
// 			this[this.btnArr[i]].removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
// 		}
// 	}
// }
