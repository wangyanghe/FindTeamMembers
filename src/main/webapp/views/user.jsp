<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/12/18
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/"/>
    <title>个人资料管理 - 找队友</title>
    <%@ include file="common/_include_css.jsp" %>
</head>
<body class="front-body">
<c:import url="common/_nav.jsp?act="/>
<div class="front-inner front-inner-media">
    <div class="container">
        <div class="front-toolbar other">
            <div class="front-toolbar-header clearfix">
                <button type="button" class="front-toolbar-toggle navbar-toggle" data-toggle="collapse"
                        data-target="#freeshare-group" aria-expanded="false" aria-controls="freeshare-group">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div id="freeshare-group" class="front-btn-group collapse" data-toggle="buttons">
                <label class="btn btn-default active" id="info" style="box-shadow: none">
                    <input type="radio" name="options" autocomplete="off" checked><span
                        class="glyphicon glyphicon-th"></span>&nbsp;基本信息
                </label>
                <label class="btn btn-default" id="skill" style="box-shadow: none">
                    <input type="radio" name="options" autocomplete="off" checked><span
                        class="glyphicon glyphicon-thumbs-up"></span>&nbsp;技能
                </label>
                <label class="btn btn-default" id="need" style="box-shadow: none">
                    <input type="radio" name="options" autocomplete="off" checked><span
                        class="glyphicon glyphicon-king"></span>&nbsp;需求
                </label>
                <c:if test="${root}">
                    <label class="btn btn-default" id="my_theme" style="box-shadow: none">
                        <input type="radio" name="options" autocomplete="off" checked><span
                            class="glyphicon glyphicon-heart"></span>&nbsp;我的主题
                    </label>
                </c:if>
                <label class="btn btn-default" id="attention" style="box-shadow: none">
                    <input type="radio" name="options" autocomplete="off" checked><span
                        class="glyphicon glyphicon-eye-open"></span>&nbsp;关注
                </label>
                <label class="btn btn-default" id="fans" style="box-shadow: none">
                    <input type="radio" name="options" autocomplete="off" checked><span
                        class="glyphicon glyphicon-star"></span>&nbsp;粉丝
                </label>
                <label class="btn btn-default" id="friend" style="box-shadow: none">
                    <input type="radio" name="options" autocomplete="off" checked><span
                        class="glyphicon glyphicon-user"></span>&nbsp;相互关注
                </label>
            </div>
            <a href="user/toEdit" class="btn btn-primary pull-right">编辑信息</a>
        </div>
        <div class="panel panel-default front-panel">

            <div class="panel-body " id="tab" style="position: relative;">
               <c:import url="user/user_info.jsp"/>
            </div>

        </div>
    </div>
    <c:import url="common/_footer.jsp"/>
</div>
</body>
<%@ include file="common/_include_js.jsp" %>
<script>
$("#info").click(function () {
    console.log("click info");
    $.get(
        "user/info",
        {},
        function (data) {
            $("#tab").html(data)
        }
    )
});
$("#skill").click(function () {
    console.log("click info");
    $.get(
        "user/skill",
        {},
        function (data) {
            $("#tab").html(data)
        }
    )
});
$("#need").click(function () {
    console.log("click info");
    $.get(
        "user/need",
        {},
        function (data) {
            $("#tab").html(data)
        }
    )
});
$("#attention").click(function () {
    console.log("click info");
    $.get(
        "user/attention",
        {},
        function (data) {
            $("#tab").html(data)
        }
    )
});
$("#fans").click(function () {
    console.log("click info");
    $.get(
        "user/fans",
        {},
        function (data) {
            $("#tab").html(data)
        }
    )
});
$("#my_theme").click(function () {
    console.log("click info");
    $.get(
        "user/theme",
        {},
        function (data) {
            $("#tab").html(data)
        }
    )
});
$("#friend").click(function () {
    console.log("click info");
    $.get(
        "user/friend",
        {},
        function (data) {
            $("#tab").html(data)
        }
    )
})
</script>
</html>
