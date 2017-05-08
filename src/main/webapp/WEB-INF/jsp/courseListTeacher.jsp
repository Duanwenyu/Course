<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>青岛大学选课系统</title>
<link rel="stylesheet" type="text/css"
	href="easyui/themes/metro/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="css/courseListTeacherStyle.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<style type="text/css">
#t_course:hover {
	cursor: pointer;
	color: #00bbee;
}

a:hover {
	text-decoration: none;
}
</style>
</head>
<body class="easyui-layout">
	<div id="north" data-options="region:'north',split:true"
		style="height: 110px;">
		<div id="n_login_img"></div>
		<div id="n_login_name" onclick="showName()">
			<a>${teacher.techName}</a>
		</div>
		<div id="n_login_no" hidden="true">${teacher.techNo}</div>
		<div id="n_right">明德 博学 守正 出奇</div>
	</div>
	<div id="south" data-options="region:'south',split:true">
		<div id="s_last">
			<div id="weixin_logo">
				<img src="image/weixin_logo.jpg"> <img src="image/blue.png">
			</div>
			<div id="sl_first">地址: 青岛市宁夏路 308 号 邮编: 266071</div>
			<div id="sl_second">© 青岛大学 ® COPYRIGHT QINGDAO UNIVERSITY</div>
			<div id="sl_third">鲁 ICP 备案 05001947 号 - 1</div>
		</div>
	</div>
	<!--<div id="east" data-options="region:'east',split:true" style="width:100px;"></div> -->
	<div id="west" data-options="region:'west',title:'菜单',split:true"
		style="width: 180px;">
		<ul class="nav nav-pills nav-stacked">
			<li data-toggle="collapse" data-target="#song" href="#"
				style="font-family: 'Microsoft yahei'; font-size: 16px; padding: 25px 0px 0px 15px;">
				<a id="t_course">课程管理</a>
				<div id="song" class="collapse list-group-div">
					<ul style="margin-bottom: 0px; padding-bottom: 0px;"
						class="list-group">
						<c:forEach items="${courseList}" var="courseList">
							<li class="list-group-item"
								style="font-family: 'Microsoft yahei'; font-size: 10px; padding: 15px 0px 0px 0px; list-style-type: none;">
								<a href="#" onclick="showCourseMess('${courseList.courseNo}')">
									${ courseList.courseName }</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</li>
			<li
				style="font-family: 'Microsoft yahei'; font-size: 16px; padding: 25px 0px 0px 15px;">
				<a href="#" onclick="showTeacherMess()">个人信息</a>
			</li>
			<li
				style="font-family: 'Microsoft yahei'; font-size: 16px; padding: 25px 0px 0px 15px;">
				<a href="#" onclick="changePassword()">修改密码</a>
			</li>
		</ul>
	</div>
	<div id="center" data-options="region:'center',title:'选课列表'"
		style="background: #eee;">
		<div id="c_title"></div>
		<div id="dg"></div>
	</div>
	<div id="dd">
		<div id="dgl"></div>
	</div>
	<div id="ee">
		<div id="egl"></div>
	</div>
	<div id="ff"></div>
</body>
<script>
	//退出
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

	$('#dg').datagrid({
		// 		data:jsdata,
		url : 'course/showList',
		rownumbers : true,
		pagination : true,
		fit : true,
		pageNumber : 1,
		pageSize : 20,
		pageList : [ 20, 30, 50, 100 ],
		singleSelect : true,
		columns : [ [ {
			field : 'courseNo',
			title : '课程编号',
			width : 150,
			align : 'center'
		}, {
			field : 'courseName',
			title : '课程名称',
			width : 150,
			align : 'center'
		}, {
			field : 'teacherNo',
			title : '教师编号',
			width : 150,
			hidden : true
		}, {
			field : 'teachermess',
			title : '任课教师',
			width : 150,
			align : 'center',
			formatter : function(value) {
				return value.techName;
			}
		}, {
			field : 'courseTime',
			title : '学时',
			width : 150,
			align : 'center'
		}, {
			field : 'courseScore',
			title : '学分',
			width : 150,
			align : 'center'
		}, {
			field : 'courseDescribe',
			title : '课程描述',
			width : 150,
			align : 'center'
		}, {
			field : 'courseNumber',
			title : '剩余人数',
			width : 150,
			align : 'center'
		}, ] ]
	});
	//分页内容发中文显示
	var p = $('#dg').datagrid('getPager');
	$(p).pagination({
		beforePageText : '第',//页数文本框前显示的汉字
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',
	});

	function option(value, row, index) {
		if (row.courseStatus == "1") {
			return '<div id="choosed">已选</div>';
		} else {
			return '<a id="achoose" href="#" onclick="choose(' + index
					+ ')">选课</a>';
		}
	}

	function showTeacherMess() {
		$("#ee").show();
		$('#ee').dialog({
			title : '个人信息',
			width : 800,
			height : 500,
			closed : false,
			cache : false,
			inline : true,
			modal : true,
			collapsible : true,
			draggable : false,
			href : 'showTechMess',
			maximizable : true,
			resizable : true,
			//	 		fit:true,
			modal : true,
			buttons : [ {
				text : '返回',
				iconCls : 'icon-back',
				handler : function() {
					$('#ee').dialog('close');
					$('#dg').datagrid('reload');
				}
			} ],
		});
	}

	function showCourseMess(courseNo) {
		$("#dd").show();
		$('#dd').dialog({
			title : '学生信息',
			width : 800,
			height : 400,
			closed : false,
			cache : false,
			inline : true,
			modal : true,
			collapsible : true,
			draggable : false,
			maximizable : true,
			resizable : true,
			//	 		fit:true,
			modal : true,
			buttons : [ {
				text : '返回',
				iconCls : 'icon-back',
				handler : function() {
					$('#dd').dialog('close');
				}
			} ],
		});

		$('#dgl').datagrid({
			url : 'selectStuNoForTeacher?courseNo=' + courseNo,
			rownumbers : true,
			// 			pagination: true,
			fit : true,
			// 			pageNumber : 1,
			// 			pageSize : 20,
			// 			pageList : [ 20, 30, 50, 100 ],
			singleSelect : true,
			columns : [ [ {
				field : 'stuNo',
				title : '学号',
				width : 150,
				align : 'center'
			}, {
				field : 'stuName',
				title : '姓名',
				width : 150,
				align : 'center'
			}, {
				field : 'stuMajor',
				title : '专业',
				width : 150,
				align : 'center'
			}, {
				field : 'stuSex',
				title : '性别',
				width : 120,
				align : 'center'
			}, {
				field : 'stuGrade',
				title : '年级',
				width : 120,
				align : 'center'
			}, ] ]
		});

		//分页内容发中文显示
		var q = $('#dgl').datagrid('getPager');
		$(q).pagination({
			beforePageText : '第',//页数文本框前显示的汉字
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',
		});
	}

	var changePassword = function() {
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
					alterPassword("alter-tea-pass");
				}
			}, {
				text : '返回',
				iconCls : 'icon-back',
				handler : function() {
					$('#ff').dialog('close');
					$('#dg').datagrid('reload');
				}
			} ],
		});
	}
</script>
</html>