// private getIdiom() {
// 	/**相同字号在成语当中的索引 */
// 	let sameArr_1 = [3, 3, 3, 2];//前
// 	let sameArr_2 = [1, 1, 0, 2];//后
// 	let randA = [];
// 	let randNumA = Math.floor(Math.random() * StaticVar.idiomJson.length);
// 	console.log('randNumA===', randNumA, StaticVar.idiomJson[randNumA].key, StaticVar.idiomJson[randNumA].key[3]);
// 	for (let i = 0; i < StaticVar.idiomJson.length; i++) {
// 		if (StaticVar.idiomJson[i].key != StaticVar.idiomJson[randNumA].key && StaticVar.idiomJson[i].key[1] == StaticVar.idiomJson[randNumA].key[3]) {
// 			console.log(StaticVar.idiomJson[i].key, StaticVar.idiomJson[i].key[1]);
// 			randA.push(StaticVar.idiomJson[i]);
// 		}
// 	}
// 	if (randA.length == 0) {
// 		this.getIdiom();
// 		return;
// 	}
// 	let randB = [];
// 	let randNumB = Math.floor(Math.random() * randA.length);
// 	console.log('randNumB===', randA.length, randNumB, randA[randNumB].key, randA[randNumB].key[3]);
// 	for (let i = 0; i < StaticVar.idiomJson.length; i++) {
// 		if (StaticVar.idiomJson[i].key != randA[randNumB].key && StaticVar.idiomJson[i].key[1] == randA[randNumB].key[3]) {
// 			console.log(StaticVar.idiomJson[i].key, StaticVar.idiomJson[i].key[1]);
// 			randB.push(StaticVar.idiomJson[i]);
// 		}
// 	}
// 	if (randB.length == 0) {
// 		this.getIdiom();
// 		return;
// 	}
// 	let randC = [];
// 	let randNumC = Math.floor(Math.random() * randB.length);
// 	console.log('randNumC===', randB.length, randNumC, randB[randNumC].key, randB[randNumC].key[3]);
// 	for (let i = 0; i < StaticVar.idiomJson.length; i++) {
// 		if (StaticVar.idiomJson[i].key != randB[randNumC].key && StaticVar.idiomJson[i].key[0] == randB[randNumC].key[3]) {
// 			console.log(StaticVar.idiomJson[i].key, StaticVar.idiomJson[i].key[0]);
// 			randC.push(StaticVar.idiomJson[i]);
// 		}
// 	}
// 	if (randC.length == 0) {
// 		this.getIdiom();
// 		return;
// 	}
// 	let randD = [];
// 	let randNumD = Math.floor(Math.random() * randC.length);
// 	console.log('randNumD===', randC.length, randNumD, randC[randNumD].key, randC[randNumD].key[2]);
// 	for (let i = 0; i < StaticVar.idiomJson.length; i++) {
// 		if (StaticVar.idiomJson[i].key != randC[randNumD].key && StaticVar.idiomJson[i].key[2] == randC[randNumD].key[2]) {
// 			console.log(StaticVar.idiomJson[i].key, StaticVar.idiomJson[i].key[2]);
// 			randD.push(StaticVar.idiomJson[i]);
// 		}
// 	}
// 	if (randD.length == 0) {
// 		this.getIdiom();
// 		return;
// 	}
// 	let randNumE = Math.floor(Math.random() * randD.length);
// 	console.log('randNumE===', randD.length, randNumD, randD[randNumE].key, randD[randNumE].key[1]);
// 	let totalArr = [];
// 	totalArr.push(StaticVar.idiomJson[randNumA].key);
// 	totalArr.push(randA[randNumB].key);
// 	totalArr.push(randB[randNumC].key);
// 	totalArr.push(randC[randNumD].key);
// 	totalArr.push(randD[randNumE].key);
// 	console.log('totalArr-------', totalArr);
// }
