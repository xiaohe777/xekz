<!DOCTYPE html>
<html>
<head>
    <#include "../common.ftl">
</head>
<body class="childrenBody">
<form class="layui-form" style="width:80%;">
    <input name="userId" type="hidden" value="${(user.userId)!}"/>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" style="border-radius:20px" class="layui-input realName" lay-verify="required" name="realName" id="realName"
                   value="${(user.realName)!}" placeholder="请输入用户名">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="text" style="border-radius:20px" class="layui-input userPwd"
                   lay-verify="userPwd" name="userPwd"
                   value="${(user.userPwd)!}" id="userEmail" placeholder="请输入密码">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">地址</label>
        <div class="layui-input-block">
            <input type="text" style="border-radius:20px" class="layui-input realName"
                   lay-verify="required" name="userAddress" id="userAddress"
                   value="${(user.userAddress)!}" placeholder="请输入用户地址">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">手机号</label>
        <div class="layui-input-block">
            <input type="text" style="border-radius:20px" class="layui-input userTel" lay-verify="userTel" name="userTel"
                   value="${(user.userTel)!}"
                   id="userTel" placeholder="请输入手机号">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-block">
            <input type="text" style="border-radius:20px" class="layui-input userEmail"
                   lay-verify="userEmail" name="userEmail"
                   value="${(user.userEmail)!}" id="userEmail" placeholder="请输入邮箱">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">身份证信息</label>
        <div class="layui-input-block">
            <input type="text" style="border-radius:20px" class="layui-input idNo"
                   lay-verify="idNo" name="idNo"
                   value="${(user.idNo)!}" id="userEmail" placeholder="请输入身份证信息">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal layui-btn-radius" lay-submit="" lay-filter="addOrUpdateUser">确认
            </button>
            <button class="layui-btn layui-btn-normal layui-btn-radius">取消
            </button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${ctx}/js/user/add_update.js"></script>
</body>
</html>