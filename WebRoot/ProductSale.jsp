<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'ProductSale.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<link href="css/JqueryPlugIn/AlertDialogs/AlertDialogs.css"
	rel="stylesheet" type="text/css" />
<link href="css/JqueryPlugIn/Easydiologue/easydialog.css"
	rel="stylesheet" type="text/css" />
<link href="css/lib/bootstrap/css/bootstrap-modify.css" rel="stylesheet" />
<link href="css/App_Themes/Mobile/fontawesome/css/font-awesome.min.css"
	rel="stylesheet" />
<link href="css/App_Themes/iconfont/iconfont.css" rel="stylesheet" />
<link href="css/JqueryPlugIn/Select2/select2.css" rel="stylesheet" />

<script src="js/Jquery/jquery-1.12.3.min.js" type="text/javascript"></script>

<script src="js/Jquery/jquery-browser.js" type="text/javascript"></script>

<script src="js/JqueryPlugIn/Select2/select2.min.js"
	type="text/javascript"></script>

<script src="js/JqueryPlugIn/AlertDialogs/AlertDialogs.min.js"
	type="text/javascript"></script>

<script src="js/JqueryPlugIn/Cookie/jquery.cookie.js"
	type="text/javascript"></script>

<script src="js/script/Dialog.js" type="text/javascript"></script>

<script src="js/Calender/jsdate.js" type="text/javascript"></script>

<script src="js/script/common.js" type="text/javascript"></script>

<script type="text/javascript" src="js/jquery.min.js"></script>
<link rel="stylesheet" href="css/bootstrap/3.3.6/bootstrap.min.css" />
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<script type="text/javascript" src="<%=path%>/dwr/util.js"></script>
<script type="text/javascript" src="<%=path%>/dwr/engine.js"></script>
<script type="text/javascript" src="<%=path%>/dwr/interface/test.js"></script>
<style type="text/css">
a {
	text-decoration: none;
}

div.topDiv {
	margin: 10px;
	border: 1px solid #52915E;
	padding: 50px;
}

div.tableDiv {
	margin: 10px;
	border: 1px solid #D0D0D0;
}

span.num {
	/*颜色*/
	color: #C40000;
	/*字体大小*/
	font-size: 14px;
	font-weight: bold;
}

/*  导出功能*/
span#import:hover {
	/*变为手*/
	cursor: pointer;
}

/* 导出字样 */
span#import {
	color: #C40000;
	font-size: 30px;
	font-weight: bold;
}

span.addOrder:hover {
	/*变为手*/
	cursor: pointer;
}

/*库存商品表*/
table#inventoryTable td, th {
	/*高*/
	height: 35px;
	/*文本水平居中*/
	text-align: center;
	/*文本竖直居中*/
	line-height: 35px;
}

/*商品出售表*/
table#tableProductBySuppUnit td, th {
	/*文本水平居中*/
	text-align: center;
}
</style>

<script type="text/javascript">


	//jquery加载文档
	$(function() {
		//下拉框中添加数据库中的客户
		test.getCustomer(function(data) {
			//添加客户
			dwr.util.addOptions("customer", data);
		});

		//下拉框中添加产品的类型
		test.getType(function(data) {
			//添加产品
			dwr.util.addOptions("productType", data);
		});

		//获取表格的行数
		var table1 = $("#inventoryTable");
		var rows1 = table1.find("tr").length - 1;
		//显示数量
		$("#InvetoryNum").html(rows1);

		/*打开模态窗口*/
		$("#open").click(function() {
			$("#myModal").modal('show');
		});

		//数量输入框只能输入数字切小于库存
		$(".numInput").keyup(function() {
			//得到当前所在行
			var tr = $(this).parent().parent();
			//得到所在行的库存
			var stock = parseInt(tr.children("td").get(4).textContent);

			//获取输入数量
			var num = $(this).val();
			//不为空
			if (num != "") {
				//转为数字类型
				num = parseInt(num);
				//如果不是数字,或者小于等于0，或者大于库存数量
				if (isNaN(num)) {
					num = 1;
				}

				if (num <= 0) {
					num = 1;
				}

				if (num > stock) {
					num = stock;
				}
				$(this).val(num);
			}
		});

		//根据商品类型换库存表格显示的数据
		$("#productType").change(function() {
			//获取下拉框的值
			var value = parseInt($(this).val());

			//获取界面临时订单号
			var orderItem = $("#litSellID").html();
			//执行回调函数
			test.getInventoryByType(value, function(data) {
				//清空表格数据
				$("#inventoryProductList").html("");
				//用strhtml代码
				var str = "";

				//遍历集合
				for (var i = 0; i < data.length; i++) {
					str = "<tr>" +
						"<td>" + data[i].pId + "</td>" +
						"<td>" + data[i].pName + "</td>" +
						"<td>" + data[i].pUnit + "</td>" +
						"<td>" + data[i].pSalePrice + "</td>" +
						"<td>" + data[i].iNum + "</td>" +
						"<td width='10%'>" +
						"<input type='text' name='numInput' id='p" + data[i].pId + "' class='form-control numInput' value='1' />" +
						"</td>" +
						"<td>" +
						"<button type='button' onclick='addOrderItem(" + data[i].pId + "," + orderItem + ")' class='btn btn-info' style='height: 35px'>" +
						"<span class='glyphicon glyphicon-plus addOrder'></span>" +
						"</button>" +
						"</td>" +
						"</tr>";
					//向tbody中添加数据
					$("#inventoryProductList").append(str);
				}

				//下方显示的数量也要跟着变化
				//获取表格的行数
				var table1 = $("#inventoryTable");
				var rows1 = table1.find("tr").length - 1;
				//显示数量
				$("#InvetoryNum").html(rows1);
			});
		});


		//根据关键字搜索商品（模糊查询）
		$("#searchBtn").click(function() {
			//获取输入框的内容
			var searchWords = $("#searchInput").val();

			//获取界面临时订单号
			var orderItem = $("#litSellID").html();

			//输入不为空
			if (searchWords != "") {
				//执行回调函数
				test.getInventoryByWords(searchWords, function(data) {
					//data不为空查到了数据
					if (data != null) {
						//清空表格数据
						$("#inventoryProductList").html("");
						//用strhtml代码
						var str = "";
						//遍历集合
						for (var i = 0; i < data.length; i++) {
							str = "<tr>" +
								"<td>" + data[i].pId + "</td>" +
								"<td>" + data[i].pName + "</td>" +
								"<td>" + data[i].pUnit + "</td>" +
								"<td>" + data[i].pSalePrice + "</td>" +
								"<td>" + data[i].iNum + "</td>" +
								"<td width='10%'>" +
								"<input type='text' name='numInput' id='p" + data[i].pId + "' class='form-control numInput' value='1' />" +
								"</td>" +
								"<td>" +
								"<button type='button' onclick='addOrderItem(" + data[i].pId + "," + orderItem + ")' class='btn btn-info' style='height: 35px'>" +
								"<span class='glyphicon glyphicon-plus addOrder'></span>" +
								"</button>" +
								"</td>" +
								"</tr>";
							//向tbody中添加数据
							$("#inventoryProductList").append(str);
						}
						//下方显示的数量也要跟着变化
						//获取表格的行数
						var table1 = $("#inventoryTable");
						var rows1 = table1.find("tr").length - 1;
						//显示数量
						$("#InvetoryNum").html(rows1);
					}
				});
			}
		});

	});

	//添加到临时订单的方法
	function addOrderItem(pid, orderId) {
		//获取数量输入框的值
		var num = document.getElementById("p" + pid).value;
		window.location.href = "addOrderItem?pid=" + pid + "&num=" + num + "&orderId=" + orderId;
	}
</script>
</head>

<body>
	<div class="main_div">
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="bk_table_main" align="center" id="basetbl">
			<tr class="bk_data_title">
				<td height="25" align="left" style="width: 34%">
					<div class="leftTitle">
						<span class="glyphicon glyphicon-tags"
							style="font-size: 18px; color: #008A8D"></span> <span
							style="color: black; font-size: 18px;">商品销售</span>
					</div>
				</td>
				<td height="25" align="right" colspan="2">出货日期： <input
					readonly="readonly" name="txtCHRQ" type="text" id="txtCHRQ"
					maxlength="20" class="srk_input"
					onfocus="SelectDate(this,'yyyy-MM-dd')"
					onclick="SelectDate(this, 'yyyy-MM-dd')"
					onkeydown="if(event.keyCode==13) {$('#ssje')[0].focus();return false;}"
					value="2018-08-18" /> 单号： <!--从数据库查出当前订单序列--> <span id="litSellID"
					style="color:Red;font-weight:bold;">${nextOid}</span>
				</td>
			</tr>
			<tr>

				<td class="bk_content" align="left">
					<table>
						<tr>
							<td>所属分店：</td>
							<td><select name="ddlfd" id="ddlfd" style="width: 150px;"
								class="form-control">
									<option selected="selected" value="1">总店</option>
									<option value="2">分店</option>
							</select></td>
						</tr>
					</table>
				</td>
				<td class="bk_content" align="center">
					<table width="100%">
						<tr>
							<td align="right">客户名称：</td>
							<td align="left">
								<!--从数据库中取客户数据--> <select name="customer" id="customer"
								class="form-control" style="width: 100px">
							</select>
							</td>
						</tr>
					</table>
				</td>
				<td class="bk_content" align="right">&nbsp;
					<table>
						<tr>
							<td>出货仓库：</td>
							<td><select name="ddlCK" id="ddlCK" style="width: 150px"
								class="form-control">
									<option selected="selected" value="1">总店仓库</option>
							</select></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<div id="khzm" class="div_zw_main"
			style="&lt;%=&quot;display:none&quot;%>;left:608px;display:;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="14px"></td>
				</tr>
			</table>
		</div>
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="bk_table_main" align="center">
			<tr>
				<td colspan="3" class="bk_content">
					<!--进一个新界面-->
					<button id="open" type="button" class="btn btn-info">
						<span class="glyphicon glyphicon-plus-sign"></span> 商品添加
					</button>
				</td>
			</tr>
		</table>

		<!--从确认销售界面拿数据-->
		<div id="divProductBySuppUnit"
			style="width: auto; min-width: 500px; height: auto; min-height: 300px; margin: 5px;">
			<table id="tableProductBySuppUnit" width="100%"
				class="table table-striped table-bordered table-hover ">
				<tr>
					<th>商品编号</th>
					<th>商品名称</th>
					<th>商品库存</th>
					<th>商品单位</th>
					<th>商品售价</th>
					<th>商品类别</th>
					<th>数量</th>
					<th>小计</th>
					<th>操作</th>
				</tr>
				<!--servlet取出订单项-->
				<c:forEach items="${orderItems }" var="orderItem">
					<tr>
						<td>  ${orderItem.inventory.pId}</td>
						<td>${orderItem.inventory.pName}</td>
						<td>${orderItem.inventory.iNum}</td>
						<td>${orderItem.inventory.pUnit}</td>
						<td>${orderItem.inventory.pSalePrice}</td>
						<td>${orderItem.inventory.type}</td>
						<td>${orderItem.num}</td>
						<!--如果客户是vip客户就会打折-->
						<%-- <c:if test="${ }">
							<td>${orderItem.num*orderItem.inventory.pSalePrice*0.8}</td>
						</c:if> --%>
						<!--如果为普通客户则不打折-->

						<td>${orderItem.num*orderItem.inventory.pSalePrice}</td>

						<!--删除-->
						<td><a href="delete?oId=${orderItem.oId}"> <span
								class="glyphicon glyphicon-trash"></span>
						</a></td>
					</tr>
				</c:forEach>

			</table>
		</div>

		<div style="padding: 3px;">
			<table id="tableTempList"></table>
		</div>
		<table border="0" cellpadding="0" cellspacing="0"
			class="bk_table_main" align="left" width="100%">
			<tr class="bk_data_white">
				<!--应收金额-->
				<td
					style="width: 230px; text-align: left; padding: 5px 0px 5px 10px; font-size: 21px;"
					class="MoneyFont">应收金额：￥<label id="labelTotal"
					style="color: red;">0</label>
				</td>
				<td style="width: 225px; text-align: left; font-size: 21px;"
					class="AmountFont">总数量：<label id="labelNumber"
					style="color: blue;">0</label>
				</td>
				<td align="right" style="padding-right: 20px;">
					<!--导出功能--> <span id="import"> 导出 </span>
				</td>
			</tr>
		</table>
		<table style="width: 100%; height: 40px;" border="0" cellspacing="0"
			cellpadding="0" align="center">
			<tr>
				<td style="padding-left: 10px; width: 230px; font-size: 21px;">
					<input name="ysje" type="text" value="￥0.0" id="ysje" class="srk "
					readonly="readonly"
					style="color:Black;font-weight:bold;width:100px;display: none;" />
					实付金额： <input name="ssje" type="text" value="￥0.0" id="ssje"
					class=""
					style="color:Red;font-size:13pt;font-weight:bold;width:100px;" />
				</td>
				<td style="width: 210px; font-size: 21px;">经办人： <!--从session中获取当前界面操作员-->
				</td>

				<!--销售按钮-->
				<td align="left"><input type="button"
					class="btn btn-success btn-lg" value="销售" id="btnSave"
					style="margin-left: 5px;" /></td>
			</tr>
		</table>
	</div>

	<!--弹出来的模态窗口-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button data-dismiss="modal" class="close" type="button">
						<span aria-hidden="true">×</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">添加商品</h4>
				</div>
				<div class="mainDiv">
					<!--左边上面-->
					<div class="leftDiv">
						<div class="topDiv">

							<select class="pull-left form-control"
								style="width: 20%; margin-right:90px ;" id="productType"
								name="productType">
								<option value="0">所有商品</option>
								<!--查询出数据库有的商品类别-->
								<!--更换商品类型就会更换下面的表格-->
							</select>

							<button id="searchBtn" class="btn btn-info  pull-right"
								style="margin-right: 50px; height: 35px">
								<span class="glyphicon glyphicon-search "></span>
							</button>
							<input id="searchInput" type="text" class="form-control"
								style="width: 40%;" placeholder="请输入商品关键字" />
						</div>

						<div class="tableDiv">
							<table class="table table-striped" id="inventoryTable">
								<thead>
									<tr>
										<th>商品编号</th>
										<th>商品名称</th>
										<th>单位</th>
										<th>售价</th>
										<th>库存</th>
										<th>数量</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody id="inventoryProductList">
									<!--从库存中取数据-->
									<c:forEach items="${inventoryProductList }" var="inventory">
										<tr>
											<td>${inventory.pId}</td>
											<td>${inventory.pName}</td>
											<td>${inventory.pUnit}</td>
											<td>${inventory.pSalePrice}</td>
											<td id="td${inventory.pId}">${inventory.iNum}</td>
											<td width="10%"><input type="text"
												class="form-control numInput" name="numInput" value="1"
												id="p${inventory.pId}" /></td>
											<td>
												<button class="btn btn-info addOrderBtn" type="button"
													style="height: 35px"
													onclick="addOrderItem(${inventory.pId},${nextOid})">
													<span class="glyphicon glyphicon-plus addOrder"></span>
												</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>

							</table>
							数量：<span id="InvetoryNum" class="num"></span>
						</div>
						<div style="clear: both;"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
