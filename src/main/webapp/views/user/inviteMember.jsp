<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/12/22
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal-body">
    <form class="form-horizontal">
        <p>请选择一个项目：</p>
        <span>
            <c:forEach items="${projects}" var="project">
                <p><input type="radio" name="project" value="${project.id}">${project.name}</p>
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
        var projectId = $("input[name='project']:radio:checked").val();
        console.info(projectId);
        $.post("/project/invite",{
                memberId:${memberId},
                projectId:projectId
            },function (data) {
                if(data == "ok"){
                    window.location.href = "/";
                }
            }
        )
    }
</script>
