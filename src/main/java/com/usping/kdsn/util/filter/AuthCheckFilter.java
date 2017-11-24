package com.usping.kdsn.util.filter;

import com.usping.kdsn.util.config.CONFIG;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter(filterName = "authCheck", urlPatterns = "/api/*")
public class AuthCheckFilter implements Filter {

    private Logger logger = Logger.getLogger(AuthCheckFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("filter启动");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        filterChain.doFilter(servletRequest,servletResponse);
//        return;
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        System.out.println(req.getMethod());
        if (req.getMethod().equals("OPTIONS")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        logger.info("获取token："+req.getHeader("Authorization"));

        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(CONFIG.getTokenPass()))
                .parseClaimsJws(req.getHeader("Authorization")).getBody();

        System.out.println(claims.getIssuer());
        System.out.println(claims.getSubject());

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
