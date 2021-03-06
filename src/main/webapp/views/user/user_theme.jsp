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
    <c:if test="${themes.size() == 0}">
        无
    </c:if>
    <table class="table table-striped front-table" style="margin-bottom: 0">
        <tbody>
        <c:forEach var="theme" items="${themes}">
            <tr>
                <td>
                    <div class="media">
                        <div class="media-left">
                            <a href="#">
                                <img class="media-object img-circle img-avatar-50" src="image/theme.png">
                            </a>
                        </div>
                        <div class="media-body">
                            <h5 class="media-heading">
                                <a href="theme/${theme.id}">
                                    ${theme.content}
                                </a>
                                <div class="pull-right">
                                    <a href="theme/${theme.id}">详情</a>
                                </div>
                            </h5>
                            <div class="front-text-overflow">
                                    发起人：${theme.author.userName}
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</html>
