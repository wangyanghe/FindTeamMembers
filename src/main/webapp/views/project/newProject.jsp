<%--
  Created by IntelliJ IDEA.
  User: 81417
  Date: 2018/12/20
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal-body">
    <form class="form-horizontal">
        <div class="form-group">
        <label class="col-lg-2 col-md-4 control-label">项目名称:</label>
        <div class="col-lg-7 col-md-6">
            <input class="form-control front-no-radius front-no-box-shadow" id="name"   type="text" placeholder="项目名称最大字数限制为20字">
        </div>
        </div>
        <div class="form-group">
            <label class="col-lg-2 col-md-4 control-label">项目描述:</label>
            <div class="col-lg-7 col-md-6">
                <textarea name="description" id="description" class="form-control front-no-radius front-no-box-shadow" rows="3" placeholder="项目描述最大字数限制为250字"></textarea>
            </div>
        </div>
        <p>请选择一个主题：</p>
        <span>
            <c:forEach items="${themes}" var="theme">
                <p><input type="radio" name="theme"  value="${theme.id}">${theme.content}</p>
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
        var name =$("#name").val();
        var description = $("#description").val();
        var id = $("input:radio:checked").val();
        $.post("/project/postProject",{
                name:name,
                description:description,
                theme_id:id
            },function (data) {
                if(data == "ok"){
                    window.location.href = "/project";
                }
            }
        )
    }
</script>