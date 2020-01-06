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
var Home = (function (_super) {
    __extends(Home, _super);
    function Home() {
        var _this = _super.call(this) || this;
        _this.btnArr = ['startBtn', 'leftBtn1', 'leftBtn2', 'leftBtn3', 'leftBtn4', 'rightBtn1', 'rightBtn2', 'rightBtn3', 'rightBtn4'];
        return _this;
    }
    Home.prototype.createChildren = function () {
        _super.prototype.createChildren.call(this);
        this.hintRed.alpha = 0;
    };
    Home.prototype.show = function (data) {
        _super.prototype.show.call(this, data);
        this.touchInit();
    };
    Home.prototype.onTouchTap = function (e) {
        switch (e.currentTarget) {
            case this.leftBtn1:
                wy.changeView(Info);
                break;
            case this.leftBtn2:
                wy.changeView(Rank);
                break;
            case this.leftBtn3:
                wy.changeView(Welfare);
                break;
            case this.leftBtn4:
                wy.changeView(SetP);
                break;
            case this.rightBtn1:
                wy.changeView(MailA);
                break;
            case this.rightBtn2:
                wy.changeView(Draw);
                break;
            case this.rightBtn3:
                wy.changeView(Mountain);
                break;
            case this.rightBtn4:
                wy.changeView(TypeSH);
                break;
            case this.startBtn:
                wy.changeScene(Game);
                break;
            default:
                break;
        }
    };
    Home.prototype.touchInit = function () {
        this.bg.touchEnabled = true;
        for (var i = 0; i < this.btnArr.length; i++) {
            this[this.btnArr[i]].touchEnabled = true;
            this[this.btnArr[i]].addEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        }
    };
    Home.prototype.hide = function () {
        _super.prototype.hide.call(this);
        this.bg.touchEnabled = false;
        for (var i = 0; i < this.btnArr.length; i++) {
            this[this.btnArr[i]].touchEnabled = false;
            this[this.btnArr[i]].removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onTouchTap, this);
        }
    };
    return Home;
}(HomeUI));
__reflect(Home.prototype, "Home");
