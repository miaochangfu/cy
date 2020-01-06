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
var LoadingUI = (function (_super) {
    __extends(LoadingUI, _super);
    function LoadingUI() {
        var _this = _super.call(this) || this;
        var load = document.getElementById('loading');
        if (load && load.parentNode) {
            load.parentNode.removeChild(load);
        }
        document.body.style.background = '#0E0E0E';
        return _this;
    }
    LoadingUI.prototype.createChildren = function () {
        _super.prototype.createChildren.call(this);
        this.shape = wy.Tools.createMovieClip('loadA');
        this.addChild(this.shape);
        this.shape.play(-1);
        wy.Tools.center(this.shape);
        this.shape.x = 152;
        this.shape.y = 573;
        this.textField.text = '';
        //this.textField.size = 15;
        this.textField.y = this.shape.y + this.shape.anchorOffsetY + 10;
    };
    LoadingUI.prototype.hide = function () {
        _super.prototype.hide.call(this);
    };
    LoadingUI.prototype.setProgress = function (cur, total) {
        var perc = Math.round(cur * 100 / total);
        this.textField.text = '' + perc + '%';
        this.textField.x = this.width / 2 - this.textField.width / 2;
    };
    return LoadingUI;
}(LoadingUIUI));
__reflect(LoadingUI.prototype, "LoadingUI");
