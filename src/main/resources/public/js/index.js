layui.use(['form','jquery','jquery_cookie','layer'], function () {
    var form = layui.form,
        layer = layui.layer,
        $ = layui.jquery,
        $ = layui.jquery_cookie($);


    //监听提交
    form.on('submit(login)', function(data){
        var fieldData=data.field;

        console.log("hahhahahha")
        if(fieldData.username=='undefinded' || fieldData.username.trim()==''){
            layer.msg("用户名不能为空");
            return false;
        }

        if(fieldData.password=='undefinded' || fieldData.password.trim()==''){
            layer.msg("密码不能为空");
            return false ;
        }
        //发送ajax
        $.ajax({
            type:"post",
            url:ctx+"/admin/login",
            data:{
                "userName":fieldData.username,
                "userPwd":fieldData.password
            },
            dataType:"json",
            success:function (msg){
                //resultInfo
                if(msg.code==200){

                    layer.msg("登录成功了",function(){
                        //将用户的数据存储到Cookie
                        $.cookie("userId",msg.result.id);
                        $.cookie("userName",msg.result.userName);


                        //判断是否选中记住我
                        if($("input[type='checkbox']").is(":checked")){
                            $.cookie("userId",msg.result.id,{expires:7});
                            $.cookie("userName",msg.result.userName,{expires:7});

                        }

                        //跳转页面
                        window.location.href=ctx+"/main";
                    });
                }else{
                    //失败的提示
                    layer.msg(msg.msg);
                }
            }
        });
        //取消默认行为
        return false;
    });


});