<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/12/3
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/"/>
    <title>用户登陆 - 找队友</title>
    <link rel="stylesheet" href="http://newfront.free4inno.com/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://newfront.free4inno.com/css/front.css">
</head>
<body class="front-body">
<nav class="navbar navbar-default navbar-fixed-top front-nav">
    <div class="container">
        <div>
            <%-- 左侧栏移动端触发：可选  --%>
            <%--<img class="nav-toggle-left" id="front-nav-toggle-left" alt="SidebarToggle"/>--%>
            <%-- 品牌图片大小为150 * 30：宽度不定，高度固定30px --%>
            <div class="nav-brand">
                <a href=""> <img class="img-responsive" src="image/logo.png"  style="height: 30px"/> </a>
            </div>
        </div>
        <%--导航栏右侧区域--%>
        <div class="nav-right">
            <div class="area area-media" style="font-size: 14px">您好，请先登录！或<a href="register">注册</a></div>
        </div>
    </div>
</nav>
<div class="front-inner">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="panel panel-default front-panel" style="background: #e7e7e7; border: 0;">
                    <div class="panel-body" style="height: 100%;padding: 0px;">
                        <img src="image/banner.png" class="change-img"  style="width: 120%;max-width: 100%; display: block;">
                        <%--height: 271px;width: 847.5px;--%>
                    </div>
                </div>
            </div>
            <div class="col-md-3" style="padding-left: 6px">
                <div class="panel panel-default front-panel" style=" border: 0;">
                    <div class="panel-heading">
                        <img src="image/landing.png">
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" method="post" action="login" onsubmit="return preSubmit()" style="margin-right: auto; margin-left: auto; width: 90%;">
                            <div class="form-group" style="margin-left: -5%;color:#337ab7;" >
                                找队友
                            </div>
                            <div class="form-group" id="username-div">
                                <input type="text" class="form-control login-input" id="username-input" name="username" placeholder="用户名" >
                            </div>
                            <div class="form-group" id="pwd-div">
                                <input type="password" class="form-control login-input" id="pwd-input" name="password" placeholder="密码">
                            </div>
                            <div class="form-group">
                                <%--<div class="col-md-offset-0 col-md-10 col-sm-offset-1">--%>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" id="rmb-username"> 记住用户名
                                    </label>
                                </div>
                                <%--</div>--%>
                            </div>
                            <div class="form-group" style="margin-bottom: 6px;">
                                <button type="submit" class="btn btn-info btn-block login-input">登录</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="common/_footer.jsp"%>
</div>
<%@ include file="common/_include_js.jsp"%>
<script>
    $(function () {
        if($.cookie('username') != undefined) {
            $('#username-input').val($.cookie('username'));
            $('#rmb-username').attr('checked', 'true');
        }
        $('#username-input').blur(telInputBlur);
        $('#pwd-input').blur(pswInputBlur);
        if("${wrongOfTelOrPsw}" === "true"){
            $.fillTipBox({type:'danger', icon:'glyphicon-alert', content:'用户名或密码错误！'});
        }
    });

    function telInputBlur() {
        if($('#username-div').hasClass("has-error")) {
            $('#username-div').removeClass("has-error");
            $('#username-help-block').hide();
        }
        if($('#username-input').val()==="") {
            $('#username-div').addClass("has-error");
            $('#username-help-block').show();
        }
    }

    function pswInputBlur() {
        if($('#pwd-div').hasClass("has-error")) {
            $('#pwd-div').removeClass("has-error");
            $('#pwd-help-block').hide();
        }
        if($('#pwd-input').val() === "") {
            $('#pwd-div').addClass("has-error");
            $('#pwd-help-block').show();
        }
    }

    function preSubmit() {
        $('#username-input').blur();
        $('#pwd-input').blur();
        if($('#rmb-username').is(':checked')) {
            $.cookie('username', $('#username-input').val());
        } else {
            $.removeCookie('username');
        }
        if($('#username-div').hasClass("has-error") || $('#pwd-div').hasClass("has-error")) {
            return false;
        } else {
             $('#pwd-input').val($.md5($('#pwd-input').val()));
            return true;
        }
    }
</script>
</body>
</html>
