<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>个人信息</title>
 
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
            width: 47%;
            text-align: right;
            color: #333;
            font-weight: bold;
        }

        .value {
            color: #666;
        }

        .line {
            width: 87%;
            height: 1px;
            background: #ccc;
            padding: 0 !important;
            margin: 3px auto;
            display: block !important;
        }
    </style>
<div class="info">
    <div class="info-item">
        <div class="title">学号：</div>
        <div class="value">${stu.stuNo}</div>
        <div class="line"></div>
    </div>
    <div class="info-item">
        <div class="title">姓名：</div>
        <div class="value">${stu.stuName}</div>
        <div class="line"></div>
    </div>
    <div class="info-item">
        <div class="title">性别：</div>
        <div class="value">${stu.stuSex}</div>
        <div class="line"></div>
    </div>
    <div class="info-item">
        <div class="title">年级：</div>
        <div class="value">${stu.stuGrade}</div>
        <div class="line"></div>
    </div>
    <div class="info-item">
        <div class="title">专业：</div>
        <div class="value">${stu.stuMajor}</div>
    </div>
</div>
</body>
</html>