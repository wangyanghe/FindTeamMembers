<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/10/31
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/"/>
    <title>home</title>
    <%@ include file="common/_include_css.jsp" %>
</head>
<body>
    <c:import url="common/_nav.jsp?act=home"/>
    <h1>Hello world!</h1>
    <c:import url="common/_footer.jsp"/>
</body>
    <%@ include file="common/_include_js.jsp" %>
<script>

</script>
</html>
