<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>酒店预订</title>
    <#include "../common.ftl">
</head>
<body>
<div class="detail-room">
    <div class="room-search ub ub-align-center">
        <div>入住</div>
        <div>
            <div class="ant-picker ant-picker-borderless datePicker">
                <div class="ant-picker-input"><input readonly="" placeholder="请选择日期" title="2022-01-05" size="12"
                                                     autocomplete="off" value="2022-01-05">
                    <span class="ant-picker-suffix">
						<span role="img" aria-label="calendar" class="anticon anticon-calendar">
							<svg viewBox="64 64 896 896" focusable="false" data-icon="calendar" width="1em" height="1em"
                                 fill="currentColor" aria-hidden="true">
								<path
                                        d="M880 184H712v-64c0-4.4-3.6-8-8-8h-56c-4.4 0-8 3.6-8 8v64H384v-64c0-4.4-3.6-8-8-8h-56c-4.4 0-8 3.6-8 8v64H144c-17.7 0-32 14.3-32 32v664c0 17.7 14.3 32 32 32h736c17.7 0 32-14.3 32-32V216c0-17.7-14.3-32-32-32zm-40 656H184V460h656v380zM184 392V256h128v48c0 4.4 3.6 8 8 8h56c4.4 0 8-3.6 8-8v-48h256v48c0 4.4 3.6 8 8 8h56c4.4 0 8-3.6 8-8v-48h128v136H184z">
								</path>
							</svg>
						</span>
					</span>
                    <span class="ant-picker-clear" role="button">
						<span role="img" aria-label="close-circle" class="anticon anticon-close-circle">
							<svg viewBox="64 64 896 896" focusable="false" data-icon="close-circle" width="1em"
                                 height="1em" fill="currentColor" aria-hidden="true">
								<path
                                        d="M512 64C264.6 64 64 264.6 64 512s200.6 448 448 448 448-200.6 448-448S759.4 64 512 64zm165.4 618.2l-66-.3L512 563.4l-99.3 118.4-66.1.3c-4.4 0-8-3.5-8-8 0-1.9.7-3.7 1.9-5.2l130.1-155L340.5 359a8.32 8.32 0 01-1.9-5.2c0-4.4 3.6-8 8-8l66.1.3L512 464.6l99.3-118.4 66-.3c4.4 0 8 3.5 8 8 0 1.9-.7 3.7-1.9 5.2L553.5 514l130 155c1.2 1.5 1.9 3.3 1.9 5.2 0 4.4-3.6 8-8 8z">
								</path>
							</svg>
						</span>
					</span>
                </div>
            </div>
            <div>-1晚 -</div>
            <div>离店</div>
            <div>
            </div>
            <div class="ant-picker ant-picker-borderless datePicker">
                <div class="ant-picker-input">
                    <input readonly="" placeholder="请选择日期" title="2022-01-06" size="12" autocomplete="off"
                           value="2022-01-06">
                    <span class="ant-picker-suffix">
						<span role="img" aria-label="calendar" class="anticon anticon-calendar">
							<svg viewBox="64 64 896 896" focusable="false" data-icon="calendar" width="1em" height="1em"
                                 fill="currentColor" aria-hidden="true">
								<path
                                        d="M880 184H712v-64c0-4.4-3.6-8-8-8h-56c-4.4 0-8 3.6-8 8v64H384v-64c0-4.4-3.6-8-8-8h-56c-4.4 0-8 3.6-8 8v64H144c-17.7 0-32 14.3-32 32v664c0 17.7 14.3 32 32 32h736c17.7 0 32-14.3 32-32V216c0-17.7-14.3-32-32-32zm-40 656H184V460h656v380zM184 392V256h128v48c0 4.4 3.6 8 8 8h56c4.4 0 8-3.6 8-8v-48h256v48c0 4.4 3.6 8 8 8h56c4.4 0 8-3.6 8-8v-48h128v136H184z">
								</path>
							</svg>
						</span>
					</span>
                    <span class="ant-picker-clear" role="button"><span role="img" aria-label="close-circle"
                                                                       class="anticon anticon-close-circle">
						<svg viewBox="64 64 896 896" focusable="false" data-icon="close-circle" width="1em" height="1em"
                             fill="currentColor" aria-hidden="true">
							<path
                                    d="M512 64C264.6 64 64 264.6 64 512s200.6 448 448 448 448-200.6 448-448S759.4 64 512 64zm165.4 618.2l-66-.3L512 563.4l-99.3 118.4-66.1.3c-4.4 0-8-3.5-8-8 0-1.9.7-3.7 1.9-5.2l130.1-155L340.5 359a8.32 8.32 0 01-1.9-5.2c0-4.4 3.6-8 8-8l66.1.3L512 464.6l99.3-118.4 66-.3c4.4 0 8 3.5 8 8 0 1.9-.7 3.7-1.9 5.2L553.5 514l130 155c1.2 1.5 1.9 3.3 1.9 5.2 0 4.4-3.6 8-8 8z">
							</path>
						</svg>
					</span>
					</span>
                </div>
            </div>
        </div>
        <div>搜索</div>
    </div>
    <div class="room-type">
        <div class="room-type-header ub ub-align-center">
            <div>房型</div>
            <div>早餐</div>
            <div>门市价 / 会员价</div>
            <div>房态</div>
            <div>优惠</div>
            <div></div>
        </div>
        <div class="room-type-lists">
            <div class="room-type-list">
                <div class="list-header ub ub-align-center">
                    <div class="ub">
                        <div>
                            <img
                                    src="http://a3.greentree.cn//UploadFiles/CRS/RoomTypeImg/005433/320_240px/005433_4_20211216172827s.jpg"
                                    alt="">
                        </div>
                        <div>
                            <div>特色套房</div>
                            <div>2米床/1张 有窗</div>
                            <div>房型详情</div>
                        </div>
                    </div>
                    <div class="no">不赠早</div>
                    <div><span class="no">¥639 /</span><span>¥543</span></div>
                    <div>有空房</div>
                    <div class="ub"></div>
                    <div>
                        <div class="nomal">预订</div>
                    </div>
                </div>
                <div class="list-contents"></div>
            </div>
            <div class="room-type-list">
                <div class="list-header ub ub-align-center">
                    <div class="ub">
                        <div>
                            <img src="http://a3.greentree.cn//UploadFiles/CRS/RoomTypeImg/005433/320_240px/005433_2_20211216173423s.jpg"
                                 alt="">
                        </div>
                        <div>
                            <div>特色双床房</div>
                            <div>1.2米床/2张 无窗</div>
                            <div>房型详情</div>
                        </div>
                    </div>
                    <div class="no">不赠早</div>
                    <div><span class="no">¥599 /</span><span>¥509</span></div>
                    <div>有空房</div>
                    <div class="ub"></div>
                    <div>
                        <div class="nomal">预订</div>
                    </div>
                </div>
                <div class="list-contents"></div>
            </div>
            <div class="room-type-list">
                <div class="list-header ub ub-align-center">
                    <div class="ub">
                        <div>
                            <img src="http://a3.greentree.cn//UploadFiles/CRS/RoomTypeImg/005433/320_240px/005433_1_20211216173001s.jpg"
                                 alt="">
                        </div>
                        <div>
                            <div>特色大床房</div>
                            <div>1.8米床/1张 过道窗</div>
                            <div>房型详情</div>
                        </div>
                    </div>
                    <div class="no">不赠早</div>
                    <div><span class="no">¥569 /</span><span>¥484</span></div>
                    <div>有空房</div>
                    <div class="ub"></div>
                    <div>
                        <div class="nomal">预订</div>
                    </div>
                </div>
                <div class="list-contents"></div>
            </div>
        </div>
    </div>
</div>
<table id="orderList" class="layui-table" lay-filter="users"></table>
<script type="text/javascript" src="${ctx}/js/user/order.js"></script>
</body>
</html>
