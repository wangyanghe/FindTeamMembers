<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/12/18
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<div>
    <c:choose>
        <c:when test="${need.size() == 0}">
            无
        </c:when>
        <c:otherwise>
            <div class="col-sm-12" style=" padding-top: 15px;">
                <label class="col-md-2 control-label front-label text-right">技能名</label>
                <label class="col-md-10 control-label front-label">熟悉程度</label>
            </div>
            <c:forEach items="${need}" var="skill">
                <div class="col-sm-12" style=" padding-top: 15px;">
                    <label class="col-md-2 control-label front-label text-right">${skill.name}</label>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>
</html>
