<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/3/20
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<nav class="navbar navbar-default navbar-fixed-top front-nav">
    <div class="container">
        <div>
            <!-- 左侧栏移动端触发：可选  -->
            <%--<img class="nav-toggle-left" id="front-nav-toggle-left" alt="SidebarToggle"/>--%>
            <!-- 品牌图片大小为150 * 30：宽度不定，高度固定30px -->
            <div class="nav-brand"><a href="#"><img src="image/logo.png" alt="brand" class="img-responsive"/></a></div>
        </div>
        <div class="nav-collapse collapse" id="nav-collapse-demo">
            <ul class="nav navbar-nav">
                <li id="home" class="${param.act == "home" ? "front-active" : ""}"><a href="">首页</a></li>
                <li id="project" class="${param.act == "project" ? "front-active" : ""}"><a href="project">项目</a></li>
                <li id="theme" class="${param.act == "theme" ? "front-active" : ""}"><a href="theme">主题</a></li>
            </ul>
        </div>
        <div class="nav-right">
            <!-- 导航栏用户头像 -->
            <%--<div class="area area-avatar area-media"><img src="" class="img-circle nav-avatar" alt="avatar" data-toggle="front-popover-bottom" data-target="#nav-user-demo"/></div>--%>
            <div class="area area-media"><span style="font-size: 14px;">
                <a href="user/">个人管理</a>
                <a href="logout">退出</a>
            </span></div>
            <!-- 横向导航栏移动端触发：可选 -->
            <div class="area visible-xs visible-sm nav-toggle-down" data-toggle="collapse"
                 data-target="#nav-collapse-demo" aria-expanded="false">
                <span class="glyphicon glyphicon-menu-hamburger" id="front-nav-toggle-down-demo"></span>
            </div>
        </div>
    </div>
</nav>