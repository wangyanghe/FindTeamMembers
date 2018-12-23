<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/12/22
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/"/>
    <title>编辑个人信息 - 找队友</title>
    <%@ include file="../common/_include_css.jsp" %>
</head>
<body class="front-body">
<c:import url="../common/_nav.jsp"/>
<div class="front-inner">
    <div class="container">
        <div class="panel panel-default front-panel">
            <div class="panel-heading">基本信息</div>
            <div class="panel-body front-last-no-margin">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="userName">用户名</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="userName" name="userName"
                                   value="${user.userName}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="resume">简介</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="resume" name="resume" value="${user.resume}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="email">邮箱</label>
                        <div class="col-md-6">
                            <input type="email" class="form-control" id="email" name="email" value="${user.email}">
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div class="panel panel-default front-panel">
            <div class="panel-heading">技能</div>
            <div class="panel-body front-last-no-margin">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-md-2 control-label">
                            <span class="badge" style="padding-top:5px;padding-bottom:5px;border-radius:7px">擅长</span>
                        </label>
                    </div>
                    <c:forEach items="${skills}" var="skill">
                        <div class="form-group">
                            <label class="col-md-2 control-label" for="${skill.name}">${skill.name}</label>
                            <div class="col-md-6">
                                <input type="number" class="form-control" data-type="skill" id="${skill.name}"
                                       name="${skill.id}"
                                <c:forEach items="${mySkills}" var="mySkill">
                                <c:if test="${mySkill.skill.id == skill.id}">
                                       value="${mySkill.familiarity}"
                                </c:if>
                                </c:forEach>
                                >
                            </div>
                        </div>
                    </c:forEach>

                    <div class="form-group">
                        <label class="col-md-2 control-label">
                            <span class="badge" style="padding-top:5px;padding-bottom:5px;border-radius:7px">需求</span>
                        </label>
                    </div>
                    <c:forEach items="${skills}" var="skill">
                        <div class="form-group">
                            <label class="checkbox col-md-offset-2 col-md-10"> <input type="checkbox" data-type="need"
                                                                                      value="${skill.id}"
                            <c:forEach items="${needs}" var="need">
                            <c:if test="${need.id == skill.id}">
                                                                                      checked
                            </c:if>
                            </c:forEach>
                            >${skill.name} </label>
                        </div>
                    </c:forEach>

                </form>
            </div>
        </div>
        <form class="form-horizontal">
            <fieldset>
                <div class="form-group">
                    <div class="col-lg-offset-1 col-lg-11 text-right">
                        <a class="btn btn-default" href="user/toEdit">重置</a>
                        <a class="btn btn-primary" id="create" onclick="commit()">确定</a>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
    <c:import url="../common/_footer.jsp"/>
</div>
</body>
<%@ include file="../common/_include_js.jsp" %>
<script>
function commit() {
    var userName = $("#userName").val();
    if (userName==""){
        $.fillTipBox({type:'danger', icon:'glyphicon-alert', content:'用户名不能为空'})
        return
    }
    var resume  = $("#resume").val();
    var email = $("#email").val();
    var skills = {};
    var need = [];
    $("[data-type='skill']").each(function () {
        if ($(this).val() !== "") {
            skills[''+$(this).attr("name")] = $(this).val();
        }
    });
    console.info(skills);
    $("[data-type='need']:checked").each(function () {
        need.push($(this).val())
    });
    console.info(need);

    $.post("user/update",{
        userName:userName,
        resume:resume,
        email:email,
        skills:JSON.stringify(skills),
        need:need
        },function (data) {
            if(data == "ok"){
                window.location.href = "/user";
            }
        }
    )
}
</script>
</html>
