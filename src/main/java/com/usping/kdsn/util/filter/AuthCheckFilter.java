package com.usping.kdsn.util.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;

@WebFilter(filterName = "authCheck", urlPatterns = "/api/*")
public class AuthCheckFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter启动");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        System.out.println(req.getMethod());
        if (req.getMethod().equals("OPTIONS")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        System.out.println(req.getHeader("token"));
        System.out.println("token parse:");

        System.out.println(req.getHeader("Authorization"));

        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary("woshinidebaba"))
                .parseClaimsJws(req.getHeader("Authorization")).getBody();

        System.out.println(claims.getIssuer());
        System.out.println(claims.getSubject());

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
