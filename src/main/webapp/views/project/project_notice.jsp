<%--
  Created by IntelliJ IDEA.
  User: 81417
  Date: 2018/12/22
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<c:if test="${notices.size() == 0}">
    无
</c:if>
<c:forEach items="${notices}" var="notice">
    <div class="panel panel-default front-panel" style="margin-bottom:20px;">
    <div class="panel-body front-news-panel">
    <div class="media">
    <div class="media-body">
    <p class="front-text-break">${notice.content}</p>
    <div>${notice.createTime}</div>
    </div>
    </div>
    </div>
    </div>
</c:forEach>
</body>
</html>
