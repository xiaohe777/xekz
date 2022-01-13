layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;
    /**
     * 用户列表展示
     */
    var  tableIns = table.render({
        elem: '#orderList',
        url : ctx+'/order/room',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        toolbar: "#toolbarDemo",
        id : "userListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: "roomId", title:'房间号',fixed:"true", width:80},
            {field: 'roomType', title: '房型', minWidth:50, align:"center"},
            {field: 'roomArea', title: '面积', minWidth:100, align:'center'},
            {field: 'roomIntroduction', title: '房间介绍', minWidth:100, align:'center'},
            {field: 'roomPrice', title: '价格', align:'center',minWidth:150},
            {title: '操作', minWidth:150,
                templet:'#userListBar',fixed:"right",align:"center"}
        ]]
    });

    /**
     * 绑定搜索按钮的点击事件
     */
    $(".search_btn").click(function () {

        table.reload('userListTable', {
            where: { //设定异步数据接口的额外参数，任意设
                entryDate: $("input[name='entryDate']").val()//入住日期
            }
            ,page: {
                curr: 1 // 重新从第 1 页开始
            }
        }); // 只重载数据
    });

    //行内工具栏的绑定
//监听行工具事件
    table.on('tool(users)', function(obj){
        var data = obj.data;
        if(obj.event === 'order'){
            var title = "<h2>住户选择</h2>";
            var url = ctx + "/order/hotelOrder";
            layui.layer.open({
                title:title,
                type:2,
                content: url,
                area:["500px","620px"],
                maxmin:true
            });
        }
    });
});