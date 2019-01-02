<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/12/21
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/"/>
    <title>主题详情 - 找队友</title>
    <%@ include file="common/_include_css.jsp" %>
</head>
<body class="front-body">
<c:import url="common/_nav.jsp?act=theme"/>
<div class="front-inner front-inner-media">
    <div class="container">
        <div class="row front-canvas" id="front-canvas">
            <div>
                <div class="media" style="padding-left: 5px">
                    <div class="media-left text-center">
                        <p>
                            <img id="group-avatar" class="media-object img-circle img-avatar-100" src="../image/theme.png">
                        </p>

                        <p>
                            <!-- 这个p标签的作用是保持上下间距一致 -->
                        </p>
                    </div>
                    <div class="media-body media-middle">
                        <h3 class="media-heading">
                            <span id="myThemeName">${theme.content}</span>
                        </h3>
                        <div id="author" style="word-wrap:break-word;word-break:break-all;padding-top: 2px;">
                            <a href="user/${theme.author.id}">发布人：${theme.author.userName}</a>
                            <a style="color: #8c8c8c; font-size: small"
                                                           href="mailto:${theme.author.email}">&lt;${theme.author.email}&gt;</a></div>
                        <div >
                        </div>
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
                <label class="btn btn-default" id="posts" style="box-shadow: none">
                    <input type="radio" name="options" autocomplete="off" checked><span
                        class="glyphicon glyphicon-comment"></span>&nbsp;帖子
                </label>
            </div>
        </div>
        <div id="tab">
            <c:import url="theme/theme_notice.jsp"/>
        </div>
    </div>
    <c:import url="common/_footer.jsp"/>
</div>


</body>
<%@ include file="common/_include_js.jsp" %>
<script>
    $("#notice").click(function () {
        console.log("click info");
        $.get(
            "theme/notice",
            {id: ${theme.id}},
            function (data) {
                $("#tab").html(data)
            }
        )
    });
    $("#posts").click(function () {
        console.log("click info");
        $.get(
            "theme/posts",
            {id: ${theme.id}},
            function (data) {
                $("#tab").html(data)
            }
        )
    });
</script>
</html>
