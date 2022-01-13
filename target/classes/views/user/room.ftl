<!DOCTYPE html>
<html>
<head>
    <title>房型信息</title>
    <#include "../common.ftl">
</head>
<body class="childrenBody">
<form class="layui-form" >
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form">
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="date" name="entryDate" class="layui-input searchVal" placeholder="入住日期" />
                </div>
                <a class="layui-btn search_btn" data-type="reload">
                    <i class="layui-icon">&#xe615;</i>
                    搜索
                </a>
            </div>
        </form>
    </blockquote>
    <table id="orderList" class="layui-table"  lay-filter="users"></table>
    <!--操作-->
    <script id="userListBar" type="text/html">
        <a class="layui-btn layui-btn-xs" id="order" lay-event="order">立即预定</a>
    </script>
<script type="text/javascript" src="${ctx}/js/user/room.js"></script>
</form>
</body>
</html>