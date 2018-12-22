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
<c:if test="${posts.size() == 0}">
    无
</c:if>
<c:forEach items="${posts}" var="post">
    <div class="panel panel-default front-panel" style="margin-bottom:20px;">
        <div class="panel-body front-news-panel">
            <div class="media">
                <div class="media-body">
                    <h4 class="media-heading front-text-break">
                        <a href="#" data-toggle="front-modal" data-size="modal-sm"
                           data-href="">${post.author.userName}</a>
                        <span style="float: right;font-size: small">主题：${post.theme.content}</span>
                    </h4>
                    <p class="front-text-break">${post.content}</p>
                    <div>${post.createTime}</div>
                </div>
            </div>
        </div>
    </div>
</c:forEach>
</body>
</html>
