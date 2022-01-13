layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;
    /**
     * 用户列表展示
     */
    var  tableIns = table.render({
        elem: '#userList',
        url : ctx+'/book/list',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        toolbar: "#toolbarDemo",
        id : "bookListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: "bookId", title:'编号',fixed:"true", width:80},
            {field: 'cateringId', title: '菜品', minWidth:50, align:"center"},
            {field: 'createDate', title: '下单时间', minWidth:100, align:'center'},
            {field: 'roomId', title: '房间号', minWidth:100, align:'center'},
            {title: '操作', minWidth:150, templet:'#bookListBar',fixed:"right",align:"center"}
        ]]
    });




    /*头部工具栏绑定*/
    //头工具栏事件
    table.on('toolbar(books)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        switch(obj.event){
            case 'add':
                //layer.msg("添加订单");
                openAddOrUpdateBookPage();
                break;
            case 'del':
                // layer.msg("删除");
                deleteBook(checkStatus.data);
                break;

        };
    });



    function deleteBook(datas){
        console.log(datas)
        if(datas.length==0){
            layer.msg("请选择要要删除的数据");
            return ;
        }
        layer.confirm("主人，你确定狠心删除数据吗?",{
            btn:["确认","取消"]
        },function(index){
            //关闭
            layer.close(index);
            //收集数据
            var ids="&ids=";
            for (var i = 0; i < datas.length ; i++) {
                if(i< datas.length -1){
                    ids=ids+datas[i].bookId+"&ids=";
                }else{
                    ids=ids+datas[i].bookId;
                }
            }
            //发送ajax删除数据
            $.post(ctx+"/book/delete",ids,function(result){
                if(result.code==200){
                    //重新加载数据
                    tableIns.reload();
                }else{
                    //提示一下
                    layer.msg(result.msg,{icon:5 });
                }
            },"json");
        });
    }

    /**
     * 添加-更新的
     * @param userId
     */
    function openAddOrUpdateBookPage(bookId){
        var title="<h2>订单模块---添加</h2>";
        var url=ctx+"/book/addOrUpdatePage";

        //判断是否修改还是添加
        if(bookId){
            title="<h2>订单模块---更新</h2>";
            url=url+"?bookId="+bookId;
        }
        //
        layer.open({
            title:title,
            content:url,
            type:2,//iframe
            area:["650px","400px"],
            maxmin:true,
        })
    }


    /*行内工具栏的绑定*/
    //监听行工具事件
    table.on('tool(books)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
            layer.confirm("主人，你确定狠心删除数据吗?",{
                btn:["确认","取消"]
            },function(index){
                //关闭
                layer.close(index);
                //发送ajax删除数据
                $.post(ctx+"/book/delete",{ids:data.bookId},function(result){
                    if(result.code==200){
                        //重新加载数据
                        tableIns.reload();
                    }else{
                        //提示一下
                        layer.msg(result.msg,{icon:5 });
                    }
                },"json");
            });
        } else if(obj.event === 'edit'){
            console.log(data.bookId)
            openAddOrUpdateBookPage(data.bookId);
        }
    });
});