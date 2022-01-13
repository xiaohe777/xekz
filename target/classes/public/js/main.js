layui.use(['element', 'layer', 'layuimini','jquery','jquery_cookie'], function () {
    var $ = layui.jquery,
        layer = layui.layer,
        $ = layui.jquery_cookie($);

    // 菜单初始化
    $('#layuiminiHomeTabIframe').html('<iframe width="100%" height="100%" frameborder="0"  src="welcome"></iframe>')
    layuimini.initTab();

    //退出
    $(".login-out").click(function (){
        //清空cookie
        $.removeCookie("userId",{domain:"localhost",path:"/xekz"});
        $.removeCookie("userName",{domain:"localhost",path:"/xekz"});
        //跳转
        window.parent.location.href = ctx + "/index";
    });
});