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
    .pass{
    	 padding:27px;
         font-family: "Microsoft yahei";
         font-size: 18px;
    }
    .pass input {
    	height: 20px;	
    }
</style>
<form>
   <div class="pass">
            当前密码 : <input id="nowPass" name="nowPass" type="password" />
   </div>
   <div class="pass">
            新密码 : <input id="newPass" name="newPass" type="password" />
   </div>
   <div class="pass">
            重复新密码 : <input id="newPassRe" name="newPassRe" type="password" onBlur="findPass()" />
              <span id="newPassReText">ss</span>
   </div>
</form>
<script type="text/javascript">
	function findPass(){
		var newPassRe = document.getElementById("newPassRe").value;
		var newPass = document.getElementById("newPass").value;
		var newPassReText = document.getElementById("newPassReText");
		if(newPassRe != newPass){
			newPassReText.innerHTML("两次密码输入不一致");
		}
		newPassReText.innerHTML("");
	}
</script>
</body>
</html>