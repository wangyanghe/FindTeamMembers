<%--
  Created by IntelliJ IDEA.
  User: 81417
  Date: 2018/12/20
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="http://newfront.free4inno.com/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://newfront.free4inno.com/css/front.css">
    <base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/"/>
    <title>项目</title>
    <%@ include file="common/_include_css.jsp" %>
</head>
<body class="front-body">
<c:import url="common/_nav.jsp?act=project"/>
<div class="front-inner">
    <div class="container">
        <div class="front-toolbar other">
            <div class="text-right">
                <a class="btn btn-primary" href="/project/newProject">新建项目</a>
            </div>
        </div>
        <div id="show-data-area">
            <c:forEach items="${projects}" var="project">
                <div class="panel panel-default  front-panel" style="margin-bottom: 10px">
                    <div class="panel-body front-no-padding">
                        <table class="table table-striped front-table" style="margin-bottom: 0px">
                            <tbody>
                            <tr>
                                <td>
                                    <div class="media front-overflow-visible">
                                        <div class="media-left">
                                            <a>
                                                <img src="static/img/group.png">
                                            </a>
                                        </div>
                                        <div class="media-body front-overflow-visible">
                                            <h5 class="media-heading" style="position: relative">
                                                <div class="front-text-title">
                                                    <a style="white-space: pre-wrap"
                                                       href="/project/detail?id=${project.id}">${project.name}</a>
                                                </div>
                                                <div class="front-top-right">
                                                    <a href="/project/detail?id=${project.id}"
                                                       style="float: right">详情</a>
                                                </div>
                                            </h5>
                                            <div class="front-text-break">
                                                    ${project.description}
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>

                            </tbody>
                        </table>

                    </div>
                </div>
                <%--<a>${project.name}</a>--%>
                <%--<a>${project.description}</a>--%>

            </c:forEach>
        </div>
    </div>
</div>
<c:import url="common/_footer.jsp"/>
</body>
<%@ include file="common/_include_js.jsp" %>
<script src="http://newfront.free4inno.com/js/jquery/jquery.min.js"></script>
<script src="http://newfront.free4inno.com/bootstrap/js/bootstrap.min.js"></script>
<script src="http://newfront.free4inno.com/js/plugin/front.js"></script>
</html>
