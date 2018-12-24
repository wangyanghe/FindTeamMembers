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
    <title>${user.userName} - 找队友</title>
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
            </div>
            <c:if test="${attention == false}">
                <a href="user/addAttention1?userId=${user.id}" class="btn btn-primary pull-right">关注</a>
            </c:if>
            <c:if test="${attention}">
                <a href="user/disAttention1?userId=${user.id}" class="btn btn-primary pull-right">取消关注</a>
            </c:if>
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

</script>
</html>
