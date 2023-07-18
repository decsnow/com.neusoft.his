<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chenggangma
  Date: 2023/7/15
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.ruan.dao.BaseDao" %>

<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - 注册</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

<%--    <link rel="shortcut icon" href="favicon.ico"> --%>
    <link href="static/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="static/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css?v=4.0.0" rel="stylesheet">
    <link rel="stylesheet" href="static/css/general.css" type="text/css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/crypto-js.min.js"></script>
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>

</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen   animated fadeInDown">
    <div>
        <div>

            <h5 class="logo-name">HIS</h5>

        </div>
        <h3>欢迎注册 Neusoft HIS</h3>
        <p>创建一个新账户</p>
        <form class="m-t" action="user?action=register" method="post" accept-charset="UTF-8" onsubmit="verify();encryptPassword()">
            <div class="form-group">
                <label for="realname"><input type="text" id="realname" class="form-control" name="realname" placeholder="请输入用户名" required><br>
                </label>
            </div>
            <div class="form-group">
                <label for="password"><input type="password" id="password" class="form-control" name="password" placeholder="请输入密码" required><br>
                </label>
            </div>
            <div class="form-group">
                <label>
                    <input type="password" id="password2" class="form-control" placeholder="请再次输入密码" required>
                </label>
            </div>
            <label for="deptment_id">科室：</label>
            <div class="select-wrapper">
            <select id="deptment_id" name="deptment_id">
                <option value="none" selected disabled hidden>请选择科室</option>
                <c:forEach items="${deptlist}" var="dept">
                    <option value="${dept.id}">${dept.dept_name}</option>
                </c:forEach>
            </select> <br>
            </div>
            <br>
            <label for="regist_level_id">职称：</label>
            <div class="select-wrapper">
            <select id="regist_level_id" name="regist_level_id">
                <option value="none" selected disabled hidden>请选择职称</option>
                <option value="1">专家号</option>
                <option value="2">普通号</option>
                <option value="3">主任医生号</option>
            </select><br>
            </div>
            <br>
            <label for="scheduling_id">排班：</label>
            <div class="select-wrapper">
            <select id="scheduling_id" name="scheduling_id">
                <option value="none" selected disabled hidden>请选择排班</option>
                <option value="1">星期一三五上午</option>
                <option value="2">星期一三五下午</option>
                <option value="3">星期二四六上午</option>
                <option value="4">星期二四六下午</option>
                <option value="5">周六周日全天</option>
            </select><br>
            </div>
            <input type="hidden" id="encryptedPassword" name="encryptedPassword">

            <div class="form-group text-left">
                <div class="checkbox i-checks">
                    <label class="no-padding">
                        <input type="checkbox" id="agreement_check"><i></i> 我同意注册协议</label>
                </div>
            </div>
            <input type="submit" value="注册"><br><br>

            <p class="text-muted text-center"><small>已经有账户了？</small><a href="index.jsp" target="_self">点此登录</a>
            </p>

        </form>
        <span class="status-message">${status}</span>
    </div>
</div>
<script src="static/js/jquery.min.js?v=2.1.4"></script>
<script src="static/js/bootstrap.min.js?v=3.3.5"></script>
<script src="static/js/plugins/iCheck/icheck.min.js"></script>
<script>
    $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
</script>
<script src="static/js/crypto.js"></script>
<script>
     function verify(){
         const password = document.getElementById("password").value;
         const password2 = document.getElementById("password2").value;
         const agreementCheck = document.getElementById('agreement_check').checked;
         if (password !== password2) {
            alert("两次输入的密码不一致！");
            event.preventDefault();
        }else if(!agreementCheck){
            alert("请同意注册协议！");
            event.preventDefault();
        }
    }
</script>
</body>
</html>