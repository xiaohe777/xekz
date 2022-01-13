layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;
    /**
     * 用户列表展示
     */
    var  tableIns = table.render({
        elem: '#orderList',
        url : ctx+'/order/clist',
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
            {field: 'entryDate', title: '入住日期', minWidth:50, align:"center"},
            {field: 'orderTel', title: '联系电话', minWidth:100, align:'center'},
            {field: 'orderDate', title: '预定日期', minWidth:100, align:'center'},
            {field: 'orderPrice', title: '价格', align:'center',minWidth:150}
        ]]
    });


});