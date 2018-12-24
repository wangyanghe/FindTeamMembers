<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/10/31
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/"/>
    <title>首页 - 找队友</title>
    <%@ include file="common/_include_css.jsp" %>
</head>
<body class="front-body">
<c:import url="common/_nav.jsp?act=home"/>
<div class="front-inner">
    <div class="container">
        <div class="row">
            <div class="col-sm-9">
                <div class="panel panel-default front-panel" style="margin-bottom:20px;">
                    <div class="panel-body front-no-padding">
                        <div class="container-fluid">
                            <div class="row front-topic">
                                <div class="col-lg-11 col-md-11" style="padding-left: 0px;padding-right: 0px">
                                    <div id="postfield">
                                        <textarea id="post" name="post"
                                                  class="form-control front-no-radius front-no-box-shadow front-no-focus front-no-border front-topic-shrink"
                                                  placeholder="新建帖子"
                                                  style="resize:none;overflow-y:hidden;"></textarea>
                                    </div>
                                </div>
                                <div class="col-lg-1 col-md-1 text-center" style="padding-left: 10px">
                                    <button style="margin-top: 10px" class="btn btn-primary btn-md" onclick="modal()">确定
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="newscontainer">
                    <c:forEach items="${posts.content}" var="post">
                        <div class="panel panel-default front-panel" style="margin-bottom:20px;">
                            <div class="panel-body front-news-panel">
                                <div class="media">
                                    <div class="media-body">
                                        <h4 class="media-heading front-text-break">
                                            <a href="user/${post.author.id}">${post.author.userName}</a>
                                            <a href="theme/${post.theme.id}" style="float: right;font-size: small">主题：${post.theme.content}</a>
                                        </h4>
                                        <p class="front-text-break">${post.content}</p>
                                        <div>${post.createTime}</div>
                                    </div>
                                </div>
                                    <%--<div class="btn-group front-news-op">--%>
                                    <%--<a href="" class="btn btn-default"><span--%>
                                    <%--class="glyphicon glyphicon-plus"></span>关注此人</a>--%>
                                    <%--</div>--%>
                            </div>
                        </div>
                    </c:forEach>
                    <div id="page">
                        <div class="text-center">
                            <ul class="pagination">
                                <li class="disabled"><a aria-label="Previous">&laquo;</a></li>
                                <li><a aria-label="PreMore">...</a></li>
                                <li class="disabled"><a aria-label="Next">&raquo;</a></li>
                            </ul>
                        </div>
                    </div>

                </div>
            </div>
            <div class="col-sm-3">
                <div class="panel panel-default front-panel" style="margin-bottom:20px;">
                    <div class="panel-heading">热门主题</div>
                    <c:forEach items="${hotTheme}" var="hottheme">
                        <div class="panel-body front-last-no-margin"><a href="theme/${hottheme.id}">${hottheme.content}</a></div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
    <c:import url="common/_footer.jsp"/>
</div>
</body>
<%@ include file="common/_include_js.jsp" %>
<script>
    $("#page").html($.getDivPageHtml(${posts.pageable.pageNumber} + 1, ${posts.totalPages}, "getPosts"));

    function getPosts(page) {
        window.location.href="/home?page=" + (page-1)
    }

    function modal() {
        if ($('#postfield').hasClass("has-error")) {
            $('#postfield').removeClass("has-error");
            $('#post-help-block').hide();
        }
        if ($('#post').val() === "") {
            $('#postfield').addClass("has-error");
            $('#post-help-block').show();
        } else {
            var content = $('#post').val();
            var url = ("modal?content=" + content);
            $.frontModal({toggle: 'front-modal', size: 'modal-md', title: '选择主题', href: url}).on('shown.bs.modal')
        }
    }
</script>
</html>
