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
    <c:if test="${attention.size() == 0}">
        无
    </c:if>
    <table class="table table-striped front-table" style="margin-bottom: 0">
        <tbody>
        <c:forEach var="user" items="${attention}">
            <tr>
                <td>
                    <div class="media">
                        <div class="media-left">
                            <a href="#">
                                <img class="media-object img-circle img-avatar-50" src="../../image/user.png">
                            </a>
                        </div>
                        <div class="media-body">
                            <h5 class="media-heading">
                                <a href="user/${user.id}">
                                        ${user.userName}
                                </a>
                                <div class="pull-right">
                                    <a href="javascript:void(0);" data-toggle="front-modal" data-title="选择项目" data-href="user/preInvite?userId=${user.id}" >邀请加入项目</a>
                                    <a href="user/disAttention?userId=${user.id}">取消关注</a>
                                </div>
                            </h5>
                            <div class="front-text-overflow">
                                    ${user.resume}
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
