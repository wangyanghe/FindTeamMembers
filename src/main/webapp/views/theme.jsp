<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/12/21
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/"/>
    <title>主题 - 找队友</title>
    <%@ include file="common/_include_css.jsp" %>
</head>
<body class="front-body">
<c:import url="common/_nav.jsp?act=theme"/>
<div class="front-inner">
    <div class="container">
        <div class="front-toolbar other">
            <c:if test="${root}">
                <div class="text-right">
                    <a href="javascript:void(0)" data-toggle="front-modal" data-title="发布主题" class="btn btn-primary" data-href="/views/theme/create_theme.jsp">发布主题</a>
                </div>
            </c:if>
        </div>
        <div id="show-data-area">
            <c:forEach items="${themes.content}" var="theme">
                <div class="panel panel-default  front-panel" style="margin-bottom: 10px">
                    <div class="panel-body front-no-padding">
                        <table class="table table-striped front-table" style="margin-bottom: 0px">
                            <tbody>
                            <tr>
                                <td>
                                    <div class="media front-overflow-visible">
                                        <div class="media-left">
                                            <a>
                                                <img class="media-object img-circle img-avatar-50" src="image/theme.png">
                                            </a>
                                        </div>
                                        <div class="media-body front-overflow-visible">
                                            <h5 class="media-heading" style="position: relative">
                                                <div class="front-text-title">
                                                    <a style="white-space: pre-wrap"
                                                       href="theme/${theme.id}">${theme.content}</a>
                                                </div>
                                                <div class="front-top-right">
                                                    <a href="theme/${theme.id}"
                                                       style="float: right">详情</a>
                                                </div>
                                            </h5>
                                        </div>
                                    </div>
                                </td>
                            </tr>

                            </tbody>
                        </table>

                    </div>
                </div>
                <%--<a>${project.name}</a>--%>
            </c:forEach>
        </div>
        <div id="page">
            <div class="text-center">
                <ul class="pagination">
                    <li class="disabled"><a aria-label="Previous">&laquo;</a></li>
                    <li><a aria-label="PreMore">...</a></li>
                    <li class="disabled"><a aria-label="Next">&raquo;</a></li>
                </ul>
            </div>
        </div>
    </div>
    <c:import url="common/_footer.jsp"/>
</div>
</body>
<%@ include file="common/_include_js.jsp" %>
<script>
    $("#page").html($.getDivPageHtml(${themes.pageable.pageNumber} + 1, ${themes.totalPages}, "getThemes"));
    function getThemes(page) {
        window.location.href="/theme?page=" + (page-1)
    }
</script>
</html>
