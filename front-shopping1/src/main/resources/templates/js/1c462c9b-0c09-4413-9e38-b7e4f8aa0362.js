(function(window, document){
    var template = '<div>\n    <div style=\"z-index:100000;position:fixed;_position:absolute;left:0;top:0;width:100%;height:100%;background:#000;opacity:0.4;filter:alpha(opacity = 20);\"></div>\n    <div style=\"z-index:100001;position:fixed;_position:absolute;left:50%;top:50%;width:800px;height:800px;margin-left: -400px;margin-top:-225px;background:url(https://haitao.nos.netease.com/d70650a5-d4d8-4012-9b9a-b8167f98aa59_2400_1350.png?imageView&thumbnail=800x0) no-repeat\">\n        <div style=\"margin-top:85px; margin-left: 60px; margin-right: 380px;font-size:16px;color:#333;text-align:center;\">\n            <p style=\"margin:0;line-height: 1.6;font-size: 20px;font-weight:bold;\">您的浏览器该退休啦！</p>\n            <p style=\"margin:0;line-height: 1.6;font-size: 16px;\">为了您的购物安全，请升级浏览器</p>\n            <a href=\"https://haitao.nos.netease.com/847394e6-bf2c-4456-8783-5071d8b92ef0.exe\" style=\"color: #ff1e32;line-height: 30px;\" target=\"_blank\" title=\"70%用户的选择，点击下载Chrome浏览器\">Chrome浏览器</a>\n            <a href=\"https://www.firefox.com.cn/\" style=\"color: #ff1e32;line-height: 30px;\" target=\"_blank\" title=\"点击下载火狐浏览器\">火狐浏览器</a>\n            <a href=\"https://support.microsoft.com/zh-cn/help/17621/internet-explorer-downloads\" style=\"color: #ff1e32;line-height: 30px;\" target=\"_blank\"  title=\"点击下载IE浏览器最新版\">IE浏览器最新版</a>\n            <p style=\"margin:0;margin-top:30px;line-height: 2;font-size: 20px;font-weight:bold;color:#333\">您也可以手机扫码下载网易考拉App</p>\n            <img style=\"margin-top:10px;\" src=\"https://haitao.nos.netease.com/880b10ac-5714-4c1b-89a9-e24c2302ac79.png\" alt=\"\">\n        </div>\n    </div>\n</div>';
    var anchorNode = document.createElement('div');
    anchorNode.innerHTML = template;
    function tryInsert(){
        if (document.body) {
            document.body.appendChild(anchorNode);
        }else{
            setTimeout(function(){
                tryInsert();
            }, 200);
        }
    }
    tryInsert();
})(window, document)