// /**
//  *
//  *@author
//  *
//  */
// class Game0_backup2 extends Game0UI {
// 	constructor() {
// 		super();
// 	}

// 	/**非留空和留空总数组 */
// 	private totalArr: any;
// 	/**上面留空对象的数组 */
// 	private itemTopArr: any;
// 	/**下面留空对象的数组 */
// 	private itemBottomArr: any;
// 	/**选中留空的索引 */
// 	private chooseIndex: number;
// 	protected createChildren(): void {
// 		super.createChildren();
// 	}

// 	private idiomJsonArr: any = [];
// 	private resultLen: number = 5;
// 	public show(data?): void {
// 		super.show(data);

// 		// this.getIdiom(StaticVar.idiomJson, StaticVar.idiomJson);

// 		//  ["豁达大度", "暗度陈仓", "官仓老鼠", "鼠目寸光", "愁肠寸断"];
// 		this.createUI(this.idiomJsonArr);

// 	}

// 	private _w: number = 0;
// 	private _h: number = 0;
// 	private createUI(arr) {
// 		let _eleCon = new egret.Sprite();
// 		this.addChild(_eleCon);


// 		let boxArr: any = [];

// 		for (let i = 0; i < arr.length; i++) {
// 			//第一个成语横放
// 			let arrI = arr[i].split('');
// 			let item = new BoxItem(i % 2, arrI);
// 			_eleCon.addChild(item);

// 			boxArr.push(item);
// 			if (i == 0) {
// 				// for (let j = 0; j < arrI.length; j++) {
// 				// 	let item = new GameItem(1, arrI[j]);
// 				// 	this.addChild(item);
// 				// 	item.x = 60 + 90 * j;
// 				// 	item.y = 220;
// 				// 	this._w++;
// 				// }
// 				item.x = 60;
// 				item.y = 220;

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
// 						}
// 					}
// 				}
// 				console.log('ab==', a, b);

// 				for (let j = 0; j < arrI.length; j++) {
// 					// let item = new GameItem(1, arrI[j]);
// 					// this.addChild(item);
// 					if (i % 2 == 0) {//横
// 						item.x = boxArr[i - 1].x - b * 90;
// 						item.y = boxArr[i - 1].y + a * 90;
// 						this._w++;
// 					}
// 					else {//竖
// 						item.x = boxArr[i - 1].x + a * 90;
// 						item.y = boxArr[i - 1].y - b * 90;
// 						this._h++;
// 					}
// 				}
// 			}


// 			// 相交点[3,2]
// 			// if (i == 1) {
// 			// 	for (let j = 0; j < arrI.length; j++) {
// 			// 		let item = new GameItem(1, arrI[j]);
// 			// 		this.addChild(item);
// 			// 		item.x = 60 + 90 * 2;
// 			// 		item.y = 220 - 90 * 1 + j * 90;
// 			// 		this._h++;
// 			// 	}
// 			// }


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

// }

// for (let i = 0; i < 16; i++) { this['game0_' + i].alpha = 0; }
// this.starArray = [];
// let _eleCon = new egret.Sprite();
// this.addChild(_eleCon);
// _eleCon.x = 60;
// _eleCon.y = 220 - 90;
// for (let i = 0; i < 7; i++) {
//     this.starArray[i] = [];
//     for (let j = 0; j < 7; j++) {
//         let _index = Math.floor(Math.random() * 5);
//         let star = StaticVar.createBitmapByName(`Game_rectImg0_png`);
//         star.width = 85;
//         star.height = 85;
//         star.x = 90 * i;
//         star.y = 90 * (j + 1);
//         _eleCon.addChild(star);
//     }
// }


		//找出boxArr对象中x,y的最小值，然后与地第一个相比较
		// for (let j = 0; j < boxArr.length; j++) {
		// 	let obj = boxArr[j];
		// 	if (obj.x < boxArr[0].x) {
		// 		_eleCon.x += boxArr[0].x - obj.x;
		// 	}
		// 	if (obj.y < boxArr[0].y) {
		// 		_eleCon.y += boxArr[0].y - obj.y;
		// 	}
		// }

		// let newArr_X= boxArr.sort(compare('x'));
		// let newArr_Y: any[] = boxArr.sort(compare('y'));
		// console.log(newArr_X[0].x, newArr_Y[0].y, boxArr.sort(compare('x'))[0].x, boxArr.sort(compare('y'))[0].y, boxArr);


		// function compare(property) {
		// 	return function (obj1, obj2) {
		// 		return obj1[property] - obj2[property];
		// 	}
		// }


