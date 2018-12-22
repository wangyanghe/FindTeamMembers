<%--
  Created by IntelliJ IDEA.
  User: 81417
  Date: 2018/12/20
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="http://newfront.free4inno.com/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://newfront.free4inno.com/css/front.css">
    <base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/"/>
    <%@ include file="common/_include_css.jsp" %>
    <title>项目详情</title>
</head>

<body class="front-body">
<c:import url="common/_nav.jsp?act=project"/>
<div class="front-inner front-inner-media">
<div class="container">
    <div>
        <div class="media">
            <div class="media-left text-center">
                <p>
                  <img id = "group-avatar" class="media-object img-circle img-avatar-100" src="static/img/group.png">
                </p>
                <p>
                    <!-- 这个p标签的作用是保持上下间距一致 -->
                </p>
            </div>
            <div class="media-body media-middle" >
                <h4 class="media-heading">
                    <span>${project.name}</span>
                </h4>
                <div style="word-wrap:break-word;word-break: break-all;">
                    ${project.description}
                </div>
            </div>
        </div>
    </div>

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
        <label class="btn btn-default active" id="notice" style="box-shadow: none">
            <input type="radio" name="options" autocomplete="off" checked><span
                class="glyphicon glyphicon-bullhorn"></span>&nbsp;通知
        </label>
        <label class="btn btn-default" id="member" style="box-shadow: none">
            <input type="radio" name="options" autocomplete="off" checked><span
                class="glyphicon glyphicon-comment"></span>&nbsp;成员
        </label>
    </div>
</div>
<div id = "tab">
    <c:import url="project/project_notice.jsp"/>
</div>
</div>
</div>
<c:import url="common/_footer.jsp"/>
</body>
<%@ include file="common/_include_js.jsp" %>
<script src="http://newfront.free4inno.com/js/jquery/jquery.min.js"></script>
<script src="http://newfront.free4inno.com/bootstrap/js/bootstrap.min.js"></script>
<script src="http://newfront.free4inno.com/js/plugin/front.js"></script>
<script>
    $("#notice").click(function () {
        $.get(
            "project/notice",
            {id: ${project.id}},
            function (data) {
                $("#tab").html(data)
            }
        )
    });
    $("#posts").click(function () {
        $.get(
            "project/member",
            {id: ${project.id}},
            function (data) {
                $("#tab").html(data)
            }
        )
    });
</script>
</html>
