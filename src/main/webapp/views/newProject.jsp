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
    <%@ include file="common/_include_css.jsp" %>
    <title>新建项目</title>
</head>
<body>
<c:import url="common/_nav.jsp?act=project"/>
<c:import url="common/_footer.jsp"/>
</body>
<%@ include file="common/_include_js.jsp" %>
<script src="http://newfront.free4inno.com/js/jquery/jquery.min.js"></script>
<script src="http://newfront.free4inno.com/bootstrap/js/bootstrap.min.js"></script>
<script src="http://newfront.free4inno.com/js/plugin/front.js"></script>
</html>
