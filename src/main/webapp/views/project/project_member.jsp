<%--
  Created by IntelliJ IDEA.
  User: 81417
  Date: 2018/12/22
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
</head>
<body>
<c:if test="${members.size() == 0}">
    无
</c:if>
<c:forEach items="${members}" var="member">
    <div class="panel panel-default front-panel" style="margin-bottom:20px;">
        <div class="panel-body front-news-panel">
            <div class="media">
                <div class="media-left">
                    <a href="#">
                        <img class="media-object img-circle img-avatar-50" src="image/user.png">
                    </a>
                </div>
                <div class="media-body">
                    <h5 class="media-heading front-text-break">
                        <a href="user/${member.id}">${member.userName}</a>
                    </h5>
                </div>
            </div>
        </div>
    </div>
</c:forEach>
</body>
</html>
