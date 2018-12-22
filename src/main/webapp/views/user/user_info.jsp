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
    <div class="col-sm-12" style=" padding-left: 0; padding-bottom: 20px;">
        <div class="col-sm-12" style=" padding-top: 15px;">
            <label class="col-md-2 control-label front-label text-right">用户</label>
            <label class="col-md-10 control-label front-label">${user.userName}</label>
        </div>
        <div class="col-sm-12" style=" padding-top: 15px; ">
            <label class="col-md-2 control-label front-label text-right">邮箱</label>
            <label class="col-md-10 control-label front-label">${user.email}</label>
        </div>
        <div class="col-sm-12" style=" padding-top: 15px;">
            <label class="col-md-2 control-label front-label text-right">个人简介</label>
            <label class="col-md-10 control-label front-label">${user.resume}</label>
        </div>
    </div>
</div>
</html>
