<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script src="js/jquery-validation-1.15.1.js" type="text/javascript"></script>
</head>
<body>
	<style>
.info {
	padding: 27px;
	font-family: "Microsoft YaHei", Arial, Helvetica, sans-serif, "SimSun";
}

.info-item div {
	padding: 9px;
	font-size: 27px;
	display: inline-block;
}

.title {
	width: 33%;
	text-align: right;
	color: #333;
	font-weight: bold;
}

.value {
	color: #666;
}

.value input {
	font-size: 27px;
}

.line {
	width: 87%;
	height: 1px;
	background: #ccc;
	padding: 0 !important;
	margin: 3px auto;
	display: block !important;
}

.error-mess {
	text-align: center;
	color: red;
}
</style>
	<form>
		<div class="info">
			<div class="info-item">
				<div class="title">当前密码 :</div>
				<div class="pass value">
					<input id="nowPass" name="nowPass" type="password" />
				</div>
				<div class="line"></div>
			</div>
			<div class="info-item">
				<div class="title">新密码 :</div>
				<div class="pass value">
					<input id="newPass" name="newPass" type="password" />
				</div>
				<div class="line"></div>
			</div>
			<div class="info-item">
				<div class="title">确认密码 :</div>
				<div class="pass value">
					<input id="newPassRe" name="newPassRe" type="password"
						onBlur="findPass()" />
				</div>
			</div>
			<div id="newPassReText" class="error-mess"></div>
		</div>
	</form>
	<script type="text/javascript">
		function findPass() {
			var newPassRe = document.getElementById("newPassRe").value;
			var newPass = document.getElementById("newPass").value;
			var newPassReText = document.getElementById("newPassReText");
			if (newPassRe != newPass) {
				newPassReText.innerHTML = "两次密码输入不一致";
			} else {
				newPassReText.innerHTML = "";
			}
		}
		var alterPassword = function(url) {
			findPass();
			if ($("#newPassReText.error-mess").text() !== '')
				return;
			var form = $("form")[0];
			var nowPass = form.nowPass.value;
			var newPass = form.newPass.value;
			var newPassRe = form.newPassRe.value;
			if (nowPass === '' || newPass === '' || newPassRe === '') {
				$.messager.alert('WARN', '请填写完整的数据');
				return;
			}
			$.ajax({
				url : url,
				type : "POST",
				data : {
					oldPass : nowPass,
					newPass : newPass
				},
				success : function(ret) {
					var reload = function() {
						location.reload();
					};
					if (ret === 're-login') {
						$.messager.alert({
							title : 'WARN',
							msg : '请重新登录后，再进行密码修改',
							fn : reload
						});
					} else if (ret === 'pass-error') {
						$.messager.alert('WARN', '当前密码填写错误');
					} else if (ret == 'SUCCESS') {
						$.messager.alert({
							title : 'SUCCESS',
							msg : '修改成功，请重新登录',
							fn : reload
						});
					} else {
						$.messager.alert('ERROR', '修改失败');
					}
				}
			});
		}
	</script>
</body>
</html>