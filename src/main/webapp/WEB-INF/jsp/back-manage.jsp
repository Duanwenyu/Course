<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>青岛大学选课系统（后台管理）</title>
<link rel="stylesheet" type="text/css"
	href="easyui/themes/metro/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/courseListStyle.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
</head>
<body class="easyui-layout">
	<div id="north" data-options="region:'north',split:true"
		style="height: 110px;">
		<div id="n_login_img"></div>
		<div id="n_login_name" onclick="showName()">
			<a>${manager.name}</a>
		</div>
		<div id="n_right">明德 博学 守正 出奇</div>
	</div>
	<div id="south" data-options="region:'south',split:true"
		style="height: 70px;">
		<div id="s_last">
			<div id="weixin_logo">
				<img src="image/weixin_logo.jpg"> <img src="image/blue.png">
			</div>
			<div id="sl_first">地址: 青岛市宁夏路 308 号 邮编: 266071</div>
			<div id="sl_second">© 青岛大学 ® COPYRIGHT QINGDAO UNIVERSITY</div>
			<div id="sl_third">鲁 ICP 备案 05001947 号 - 1</div>
		</div>
	</div>
	<div id="west" data-options="region:'west',title:'菜单',split:true"
		style="width: 150px;">
		<li id="w_choosedCourse" class="w_text" onclick="students()">学生列表</li>
		<li id="w_persionInfo" class="w_text" onclick="teachers()">教师列表</li>
		<li id="w_password" class="w_text" onclick="changePassword()">修改密码</li>
		<li class="w_text" onclick="showChooseCourseDate()">选课时间</li>
	</div>
	<div id="center-tabs" class="easyui-tabs"
		data-options="region:'center',title:''" style="background: #eee;">
		<div title="Home" style="text-align: center; padding-top: 27px">
			<h1>欢迎进入青岛大学选课系统（后台管理）</h1>
		</div>
	</div>
	<div id="ff"></div>
	<div id="change-pass"
		style="line-height: 120px; text-align: center; display: none">
		<label>请输入新密码：</label><input type="password">
	</div>
	<div id="choose_date"></div>

	<script>
		var students = function() {
			var columns = [
					{
						field : 'stuNo',
						title : '学号',
						width : 200,
						align : 'center'
					},
					{
						field : 'stuName',
						title : '姓名',
						width : 200,
						align : 'center'
					},
					{
						field : 'stuSex',
						title : '性别',
						width : 150,
						align : 'center'
					},
					{
						field : 'stuMajor',
						title : '专业',
						width : 270,
						align : 'center'
					},
					{
						field : 'stuGrade',
						title : '年级',
						width : 150,
						align : 'center'
					},
					{
						field : 'stuPassword',
						title : '操作',
						formatter : function(val, row, index) {
							return "<a href='javascript:_changePassword(\"student\",\""
									+ row.stuNo + "\");'>重置密码</a>";
						},
						width : 200,
						align : 'center'
					} ];
			addTab("学生列表", "students", columns);
		}

		var teachers = function() {
			var columns = [
					{
						field : 'techNo',
						title : '编号',
						width : 150,
						align : 'center'
					},
					{
						field : 'techName',
						title : '姓名',
						width : 200,
						align : 'center'
					},
					{
						field : 'techSex',
						title : '性别',
						width : 150,
						align : 'center'
					},
					{
						field : 'techMajor',
						title : '专业',
						width : 270,
						align : 'center'
					},
					{
						field : 'techTitle',
						title : '职称',
						width : 150,
						align : 'center'
					},
					{
						field : 'techPassword',
						title : '操作',
						formatter : function(val, row, index) {
							return "<a href='javascript:_changePassword(\"teacher\",\""
									+ row.techNo + "\");'>重置密码</a>";
						},
						width : 200,
						align : 'center'
					} ];
			addTab("教师列表", "teachers", columns);
		}

		var _changePassword = function(type, _no) {
			var type_url_map = {
				student : "alter-stu-pass-by-manager",
				teacher : "alter-tea-pass-by-manager"
			};
			var url = type_url_map[type];
			$('#change-pass').dialog({
				title : '重置密码',
				width : 400,
				height : 200,
				closed : false,
				cache : false,
				inline : true,
				modal : true,
				collapsible : true,
				draggable : false,
				maximizable : true,
				resizable : true,
				buttons : [ {
					text : '确定',
					iconCls : 'icon-ok',
					handler : function() {
						var pass = $("#change-pass input").val();
						$.ajax({
							url : url,
							type : "POST",
							data : {
								_no : _no,
								pass : pass
							},
							success : function(ret) {
								if (ret === 'SUCCESS') {
									$.messager.alert('SUCCESS', '密码已重置！');
									$('#change-pass').dialog('close');
								} else {
									$.messager.alert('Error', '重置密码失败！');
								}
							}
						});
					}
				} ],
				onClose : function() {
					$("#change-pass input").val("");
				}
			});

		}

		var addTab = function(title, url, columns) {
			if ($('#center-tabs').tabs('exists', title)) {
				$('#center-tabs').tabs('select', title);
			} else {
				var content = $('<div style="width:100%;height:100%"></div>');
				$('#center-tabs').tabs('add', {
					title : title,
					content : content,
					closable : true
				});
				content.datagrid({
					url : url,
					fit : true,
					rownumbers : true,
					pagination : true,
					pageNumber : 1,
					pageSize : 20,
					pageList : [ 20, 30, 50, 100 ],
					singleSelect : true,
					columns : [ columns ]
				});
				var p = content.datagrid('getPager');
				$(p).pagination({
					beforePageText : '第',//页数文本框前显示的汉字
					afterPageText : '页    共 {pages} 页',
					displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',
				});
			}
		}

		function showName() {
			parent.$.messager.confirm('退出', '确认退出登录？', function(data) {
				if (data) {
					$.ajax({
						type : 'POST',
						url : 'exits',
						success : function(data) {
							if (data == "success") {
								location.reload();
							} else {
								$.messager.alert('Error', data);
							}
						}
					});
				}
			});
		}

		function changePassword() {
			$("#ff").show();
			$('#ff').dialog({
				title : '修改密码',
				width : 800,
				height : 350,
				href : 'changeStuPass',
				closed : false,
				cache : false,
				inline : true,
				modal : true,
				collapsible : true,
				draggable : false,
				maximizable : true,
				resizable : true,
				modal : true,
				buttons : [ {
					text : '确定',
					iconCls : 'icon-ok',
					handler : function() {
						alterPassword("alter-man-pass");
					}
				}, {
					text : '返回',
					iconCls : 'icon-back',
					handler : function() {
						$('#ff').dialog('close');
					}
				} ],
			});
		}

		var showChooseCourseDate = function() {
			$("#choose_date").show();
			$("#choose_date").dialog({
				title : '设置选课时间',
				width : 400,
				height : 200,
				href : 'show-choose-course-date',
				closed : false,
				cache : false,
				inline : true,
				modal : true,
				collapsible : true,
				draggable : false,
				maximizable : true,
				resizable : true,
				modal : true,
				buttons : [ {
					text : '确定',
					iconCls : 'icon-ok',
					handler : function() {
						setChooseCourseDate(function(ret) {
							if (ret === 'SUCCESS') {
								$('#choose_date').dialog('close');
								$.messager.alert('SUCCESS', '设置选课时间成功');
							} else {
								$.messager.alert('ERROR', ret);
							}
						},function(){
							$('#choose_date').dialog('close');
						})
					}
				}, {
					text : '返回',
					iconCls : 'icon-back',
					handler : function() {
						$('#choose_date').dialog('close');
					}
				} ],
			});
		}
	</script>
</body>
</html>