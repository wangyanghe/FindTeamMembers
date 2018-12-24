<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/12/21
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
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
                    <h5 class="front-text-break">${notice.content}
                    </h5>

                    <div>${notice.createTime}</div>
                </div>
            </div>
        </div>
    </div>
</c:forEach>
</body>
</html>
