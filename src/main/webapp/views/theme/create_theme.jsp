<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/12/22
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal-body">
    <form>
        <div class="form-group">
            <label for="content" class="control-label col-sm-2">内容</label>
            <textarea class="form-control" id="content" name="content"></textarea>
        </div>
    </form>
</div>

<div class="modal-footer">
    <a href="javascript:void(0);" class="btn btn-default" data-dismiss="modal">取消</a>
    <a href="javascript:void(0);" class="btn btn-primary" onclick="submit()">确定</a>
</div>

<script>
    function submit() {
        var content = $("#content").val().trim();
        $.post("/theme/create", {
                content: content
            }, function (data) {
                if (data == "ok") {
                    window.location.href = "/theme";
                }
            }
        )
    }
</script>
