package com.software.FindTeamMember.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * created by wangzhi 2018-12-03 23:12
 **/
@WebFilter(urlPatterns = "/*", filterName = "loginFilter")
public class LoginFilter implements Filter {

    private String[] excludedMapping = {"/landing", "/login", "/image/", "/static/", "/toRegister", "/register"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        boolean isExcludedMapping = false;
        String servletPath = request.getServletPath();
        for(String url : excludedMapping) {
            if(servletPath.startsWith(url)) {
                isExcludedMapping = true;
                break;
            }
        }
        if(isExcludedMapping || request.getSession().getAttribute("username") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/landing");
        }
    }

    @Override
    public void destroy() {

    }
}
