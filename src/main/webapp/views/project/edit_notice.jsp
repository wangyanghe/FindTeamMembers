<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/12/21
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal-body">
    <form>
        <div class="form-group">
            <label for="content" class="control-label col-sm-2">内容</label>
            <textarea class="form-control" id="content" name="content">${param.content}</textarea>
        </div>
    </form>
</div>

<div class="modal-footer">
    <a href="javascript:void(0);" class="btn btn-default" data-dismiss="modal">取消</a>
    <a href="javascript:void(0);" class="btn btn-primary" onclick="submit()">确定</a>
</div>

<script>
    function submit() {
        var noticeId = ${param.noticeId};
        var content = $("#content").val().trim();
        $.post("/projectNotice/edit", {
                content: content,
                noticeId: noticeId
            }, function (data) {
                if (data == "ok") {
                    window.location.href = "/project/detail?id=${param.projectId}";
                }
            }
        )
    }
</script>
