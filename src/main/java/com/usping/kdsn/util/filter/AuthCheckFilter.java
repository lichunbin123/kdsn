package com.usping.kdsn.util.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "authCheck",urlPatterns = "/*")
public class AuthCheckFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter启动");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(servletRequest.getContentType());
        System.out.println("filter请求");
        System.out.println(servletRequest.getAttribute("token"));
    }

    @Override
    public void destroy() {

    }
}
