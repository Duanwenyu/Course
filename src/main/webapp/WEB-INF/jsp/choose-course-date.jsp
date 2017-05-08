<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div id="choose-date" style="line-height: 120px; text-align: center;">
		<c:if test="${null == startDate}">
			<label>请设置开始时间：</label>
			<input class="easyui-datetimebox"
				data-options="required:true,showSeconds:false">
			<script type="text/javascript">
				var setChooseCourseDate = function(cb) {
					var date = $("#choose-date input").datetimebox('getValue');
					if ('' === date.trim()) {
						$.messager.alert('WARN', '请选择选课开始时间！');
						return;
					}
					$.ajax({
						url : "set-choose-course-date",
						type : "POST",
						data : {
							date : date
						},
						success : function(ret) {
							cb(ret);
						}
					});
				}
			</script>
		</c:if>
		<c:if test="${null != startDate}">
			<label>选课开始时间：</label>
			<fmt:formatDate value="${startDate }" pattern="yyyy-MM-dd HH:mm:ss" />
			<script type="text/javascript">
				var setChooseCourseDate = function(cb,close_fn) {
					close_fn();
				}
			</script>
		</c:if>
	</div>
</body>
</html>