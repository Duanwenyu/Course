<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="css/techLoginStyle.css">
    <script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
    <script src="js/jquery-validation-1.15.1.js" type="text/javascript"></script>
    <script>
        //手机号格式验证
        function checkPhone(){
            var phone = document.getElementById("iphone").value;
            var codePhone = document.getElementById("check_iphone");
            var regPhone = /\b\d{6}\b/;
            if(regPhone.test(phone) == false){
                codePhone.innerHTML = "请输入正确的教师编号(教师编号为6位数字)";
                return false;
            }
            codePhone.innerHTML = "";
            return true;
        }
        
    </script>
</head>
<body>
<div id="main">
    <div id="head">
        <div id="head_text">青 岛 大 学 海 星 选 课 系 统</div>
    </div>
    <div id="window">
        <form action="techLogins" method="post">
        <div id="w_img"></div>
        <div id="w_iphone">
            <div id="iphone_img"></div>
            <input  id="iphone" type="text" name="techNo" value="请输入账号"
                    onFocus="if (value =='请输入账号'){value =''}" onBlur="if (value ==''){value='请输入账号'} checkPhone()"/>
        </div>
            <div id="check_iphone"></div>
        <div id="w_password">
            <div id="password_img"></div>
            <input  id="password" type="text" name="techPassword"  value="请输入密码"
                    onfocus="if(this.value==defaultValue) {this.value='';this.type='password'}"
                    onblur="if(!value) {value=defaultValue; this.type='text';}"/>
        </div>
        <div id="remember_pass">
            <input class="check" type="checkbox" name="check" >记住密码
            <span>找回密码</span>
        </div>
        <div id="login">
            <input id="submit" type="submit" name="submit" value="教     师     登     录">
        </div>
        </form>
    </div>
    <div id="last">
        <div id="l_first">地址: 青岛市宁夏路 308 号 邮编: 266071 </div>
        <div id="l_second">© 青岛大学 ® COPYRIGHT QINGDAO UNIVERSITY</div>
        <div id="l_third">鲁 ICP 备案 05001947 号 - 1</div>
    </div>
</div>
</body>
</html>