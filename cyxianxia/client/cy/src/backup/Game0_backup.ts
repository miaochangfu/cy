// /**
//  *
//  *@author
//  *
//  */
// class Game0_backup extends Game0UI {
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
// 		for (let i = 0; i < 16; i++) { this['game0_' + i].alpha = 0; }
// 	}

// 	private starArray: any[][];//对象数组
// 	public show(data?): void {
// 		super.show(data);

// 		this.starArray = [];
// 		let _eleCon = new egret.Sprite();
// 		this.addChild(_eleCon);
// 		_eleCon.x = 60;
// 		_eleCon.y = 220 - 90;
// 		for (let i = 0; i < 7; i++) {
// 			this.starArray[i] = [];
// 			for (let j = 0; j < 7; j++) {
// 				let _index = Math.floor(Math.random() * 5);
// 				let star = StaticVar.createBitmapByName(`Game_rectImg0_png`);
// 				star.width = 85;
// 				star.height = 80;
// 				star.x = 90 * i;
// 				star.y = 85 * (j + 1);
// 				_eleCon.addChild(star);
// 			}
// 		}


// 		this.touchInit();
// 		this.getIdiom();
// 	}

// 	private getIdiom() {
// 		/**相同字号在成语当中的索引 */
// 		let sameArr_1 = [3, 3, 3, 2];//前
// 		let sameArr_2 = [1, 1, 0, 2];//后
// 		wy.on(this.create_succ, 'create_succ', this);
// 		MyTools.createIdiom(StaticVar.idiomJson, sameArr_1, sameArr_2);
// 	}
// 	private create_succ(idiomJson) {
// 		wy.off(this.create_succ, 'create_succ', this)
// 		console.log('idiomJson', idiomJson);

// 		//删除 6,10，13,19-----[5=6-1,8=10-2,10=13-3,15=19-4]
// 		let str = MyTools.createIdiomStr(idiomJson, 5, 8, 10, 15);
// 		console.log('str===', str);

// 		//留空 
// 		let numA = 5;//留空几个数
// 		let randNumArr = [3, 6, 9, 11];// [2, 8, 9, 15];// MyTools.randNum(numA, str.length, 0);
// 		console.log('randNumArr---', randNumArr);

// 		//0-4分别对应：初始，留空，选中，答错，某个成语完成
// 		this.totalArr = [];
// 		this.itemTopArr = [];
// 		this.itemBottomArr = [];

// 		for (let i = 0; i < str.length; i++) {
// 			let strTxt = str[i];
// 			let nullTxt = '';
// 			let type = 0;
// 			for (let j = 0; j < randNumArr.length; j++) {
// 				if (i == randNumArr[j]) {
// 					strTxt = '';
// 					type = 1;
// 					nullTxt = str[i];
// 					this.createBootomItem(i, j, nullTxt);//创建下面的单词
// 				}
// 			}

// 			let item = new GameItem(type, strTxt);
// 			this.addChild(item);
// 			item.x = this['game0_' + i].x;
// 			item.y = this['game0_' + i].y;
// 			this.totalArr.push(item);
// 			if (strTxt == '') {
// 				console.log('nullTxt', nullTxt);
// 				this.itemTopArr.push(item);
// 				item['index'] = i;
// 				item.touchEnabled = true;
// 				item.addEventListener(egret.TouchEvent.TOUCH_TAP, this.itemTopTouch, this);
// 			}
// 		}
// 		this.chooseIndex = this.itemTopArr[0].index;
// 		this.itemTopArr[0].changeTexture(2);

// 		wy.on(this.game_hint, 'game_hint', this)
// 	}

// 	/**如果能点击，可撤回 */
// 	private itemTopTouch(e: egret.TouchEvent) {
// 		console.log('itemTopTouch---', e.currentTarget.index);
// 		for (let i = 0; i < this.itemTopArr.length; i++) {
// 			console.log('type==' + this.itemTopArr[i].type);
// 			if (this.itemTopArr[i].type == 2) {
// 				this.itemTopArr[i].changeTexture(1);
// 			}
// 		}
// 		e.currentTarget.changeTexture(2);

// 		this.chooseIndex = e.currentTarget.index;
// 		for (let i = 0; i < this.itemBottomArr.length; i++) {
// 			if (e.currentTarget.idiomTxt.text == this.itemBottomArr[i].idiomTxt.text) {
// 				this.itemBottomArr[i].visible = true;
// 				e.currentTarget.idiomTxt.text = '';
// 			}
// 		}
// 	}


// 	private itemBottomTouch(e: egret.TouchEvent) {
// 		console.log('itemBottomTouch---', e.currentTarget.index, e.currentTarget.idiomTxt.text);

// 		e.currentTarget.visible = false;//底部对象---隐藏
// 		this.totalArr[this.chooseIndex].changeTxt(e.currentTarget.idiomTxt.text);//改变文字
// 		this.totalArr[this.chooseIndex].changeTexture(1);//改变顶部对象纹理
// 		//改变索引
// 		for (let i = 0; i < this.itemTopArr.length; i++) {
// 			if (this.itemTopArr[i].idiomTxt.text == '') {
// 				this.chooseIndex = this.itemTopArr[i].index;
// 				this.totalArr[this.chooseIndex].changeTexture(2);//console.log('i===' + i, this.chooseIndex);
// 				break;
// 			}
// 		}


// 		/**判断是否能组成成语，如果能，则改变纹理，删掉itemTopArr，itemTopArr*/
// 		if (this.itemTopArr[0].idiomTxt.text != '') {//是否为空
// 			if (this.itemTopArr[0].idiomTxt.text == this.itemBottomArr[0].idiomTxt.text) {//正确
// 				console.log('成语1完成---改变纹理');
// 				this.itemTopArr[0].touchEnabled = false;
// 				this.totalArr[0].changeTexture(4); this.totalArr[1].changeTexture(4); this.totalArr[2].changeTexture(4); this.totalArr[3].changeTexture(4);
// 			}
// 			else {
// 				this.itemTopArr[0].changeTexture(3);
// 			}
// 		}

// 		if (this.itemTopArr[0].idiomTxt.text != '' && this.itemTopArr[1].idiomTxt.text != '') {//是否为空
// 			if (this.itemTopArr[0].idiomTxt.text == this.itemBottomArr[0].idiomTxt.text && this.itemTopArr[1].idiomTxt.text == this.itemBottomArr[1].idiomTxt.text) {
// 				this.itemTopArr[0].touchEnabled = this.itemTopArr[1].touchEnabled = false;
// 				console.log('成语2完成---改变纹理');
// 				this.totalArr[4].changeTexture(4); this.totalArr[3].changeTexture(4); this.totalArr[5].changeTexture(4); this.totalArr[6].changeTexture(4);
// 			}
// 			else {
// 				if (this.itemTopArr[0].touchEnabled) this.itemTopArr[0].changeTexture(3);
// 				this.itemTopArr[1].changeTexture(3);
// 			}
// 		}

// 		if (this.itemTopArr[1].idiomTxt.text != '' && this.itemTopArr[2].idiomTxt.text != '') {//是否为空
// 			if (this.itemTopArr[1].idiomTxt.text == this.itemBottomArr[1].idiomTxt.text && this.itemTopArr[2].idiomTxt.text == this.itemBottomArr[2].idiomTxt.text) {
// 				this.itemTopArr[1].touchEnabled = this.itemTopArr[2].touchEnabled = false;
// 				console.log('成语3完成---改变纹理');
// 				this.totalArr[7].changeTexture(4); this.totalArr[6].changeTexture(4); this.totalArr[8].changeTexture(4); this.totalArr[9].changeTexture(4);
// 			}
// 			else {
// 				if (this.itemTopArr[1].touchEnabled) this.itemTopArr[0].changeTexture(3);
// 				this.itemTopArr[2].changeTexture(3);
// 			}
// 		}
// 		if (this.itemTopArr[2].idiomTxt.text != '' && this.itemTopArr[3].idiomTxt.text != '') {//是否为空
// 			if (this.itemTopArr[2].idiomTxt.text == this.itemBottomArr[2].idiomTxt.text && this.itemTopArr[3].idiomTxt.text == this.itemBottomArr[3].idiomTxt.text) {
// 				this.itemTopArr[2].touchEnabled = this.itemTopArr[3].touchEnabled = false;
// 				console.log('成语4完成---改变纹理');
// 				this.totalArr[9].changeTexture(4); this.totalArr[10].changeTexture(4); this.totalArr[11].changeTexture(4); this.totalArr[12].changeTexture(4);
// 			}
// 			else {
// 				if (this.itemTopArr[2].touchEnabled) this.itemTopArr[0].changeTexture(3);
// 				this.itemTopArr[3].changeTexture(3);
// 			}
// 		}

// 		if (this.itemTopArr[3].idiomTxt.text != '') {//是否为空
// 			if (this.itemTopArr[3].idiomTxt.text == this.itemBottomArr[3].idiomTxt.text) {//正确
// 				console.log('成语5完成---改变纹理');
// 				this.itemTopArr[3].touchEnabled = false;
// 				this.totalArr[13].changeTexture(4); this.totalArr[14].changeTexture(4); this.totalArr[11].changeTexture(4); this.totalArr[15].changeTexture(4);
// 			}
// 			else {
// 				this.itemTopArr[3].changeTexture(3);
// 			}
// 		}

// 		let isComplete: boolean = true;
// 		for (var i = 0; i < this.totalArr.length; i++) {
// 			if (this.totalArr[i].type != 4) {
// 				isComplete = false;
// 				break;
// 			}
// 		}
// 		if (isComplete) {
// 			console.log('过关');
// 		}
// 	}

// 	private game_hint() {

// 	}

// 	/**创建下面的单词 */
// 	private createBootomItem(i, j, nullTxt) {
// 		let bottomItem = new GameItem(0, nullTxt);
// 		this.addChild(bottomItem);
// 		bottomItem.x = 60 + 108 * j;
// 		bottomItem.y = 975;
// 		bottomItem['index'] = i;
// 		this.itemBottomArr.push(bottomItem);
// 		bottomItem.touchEnabled = true;
// 		bottomItem.addEventListener(egret.TouchEvent.TOUCH_TAP, this.itemBottomTouch, this);
// 	}

// 	private onTouchTap(e: egret.TouchEvent): void {
// 	}
// 	private touchInit() {
// 		this.game0_0.touchEnabled = true;
// 		this.game0_0.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
// 	}
// 	public hide(): void {
// 		super.hide();
// 		this.game0_0.touchEnabled = false;
// 		this.game0_0.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
// 	}

// 	// private getIdiom() {
// 	// 	/**相同字号在成语当中的索引 */
// 	// 	let sameArr_1 = MyTools.randNum(4, 4, 0); //[3, 3, 3, 2];//前
// 	// 	let sameArr_2 = MyTools.randNum(4, 4, 0);// [1, 1, 0, 2];//后
// 	// 	console.log('交叉点数组---', sameArr_1, sameArr_2);

// 	// 	wy.on(this.create_succ, 'create_succ', this);
// 	// 	MyTools.createIdiom(StaticVar.idiomJson, sameArr_1, sameArr_2);
// 	// }

// }



