<%--
  Created by IntelliJ IDEA.
  User: heyu
  Date: 2018/12/20
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal-body">
    <form class="form-horizontal">
            <p>请选择一个主题：</p>
            <span>
            <c:forEach items="${themes}" var="theme">
                <p><input type="radio" name="theme" value="${theme.id}">${theme.content}</p>
            </c:forEach>
            </span>
    </form>
</div>

<div class="modal-footer">
    <a href="javascript:void(0);" class="btn btn-default" data-dismiss="modal">取消</a>
    <a href="javascript:void(0);" class="btn btn-primary" onclick="submit()">确定</a>
</div>

<script>
    function submit() {
        console.info("sdfadsfasdfas");
        var content = "${content}";
        var id = $("input:radio:checked").val();
        $.post("/submit",{
            content:content,
            id:id,
            },function (data) {
                 if(data == "ok"){
                     window.location.href = "/";
                 }
            }
        )
    }
</script>
