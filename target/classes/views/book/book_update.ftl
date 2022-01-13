<!DOCTYPE html>
<html>
<head>
    <#include "../common.ftl">
</head>
<body class="childrenBody">
<form class="layui-form" style="width:80%;">
    <input id="bookId" name="bookId" type="hidden" value="${(caterBook.bookId)!}"/>

    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">房间号</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input userName"
                   lay-verify="required" name="roomId" id="roomId"
                   value="${(caterBook.roomId)!}" placeholder="请输入房间号">
        </div>
    </div>

    <div class="magb15 layui-col-md4 layui-col-xs12">
        <label class="layui-form-label">菜单</label>
        <div class="layui-input-block">
            <select  name="cateringId" id="cateringId" xm-select="selectId">
            </select>
        </div>
    </div>

    <br/>
    <div class="layui-form-item layui-row layui-col-xs12">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-lg" lay-submit="" lay-filter="addOrUpdateUser">确认
            </button>
            <button class="layui-btn layui-btn-lg layui-btn-normal" id="closeBtn">取消
            </button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${ctx}/js/book/book_update.js"></script>
</body>
</html>