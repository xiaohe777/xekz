<!DOCTYPE html>
<html>
<head>
    <title>用户管理</title>
    <#include "../common.ftl">
</head>
<body class="childrenBody">
<form class="layui-form">
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form">
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" name="realName" style="border-radius:20px" class="layui-input searchVal" placeholder="用户名"/>
                </div>
                <div class="layui-input-inline">
                    <input type="text" name="idNo" style="border-radius:20px" class="layui-input searchVal" placeholder="身份证号"/>
                </div>
                <div class="layui-input-inline">
                    <input type="text" name="userTel" style="border-radius:20px" class="layui-input searchVal" placeholder="手机号"/>
                </div>
                <div class="layui-input-inline">
                    <input type="text" name="userAddress" style="border-radius:20px" class="layui-input searchVal" placeholder="地址"/>
                </div>
                <a class="layui-btn layui-btn-radius search_btn" data-type="reload">
                    <i class="layui-icon">&#xe615;</i>搜索</a>
            </div>
        </form>
    </blockquote>
    <table id="userList" class="layui-table" lay-filter="users">
    </table>
    <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container">
            <a class="layui-btn layui-btn-radius addNews_btn" lay-event="add">
                <i class="layui-icon">&#xe608;</i>添加用户</a>
            <a class="layui-btn layui-btn-radius delNews_btn" lay-event="del">
                <i class="layui-icon">&#xe608;</i>删除用户</a>
        </div>
    </script>
    <!--操作-->
    <script id="userListBar" type="text/html">
        <a class="layui-btn layui-btn-xs layui-btn-radius" id="edit" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-xs layui-btn-radius" lay-event="del">删除</a>
    </script>
</form>
<script type="text/javascript" src="${ctx}/js/user/user.js"></script>
</body>
</html>