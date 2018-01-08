package com.usping.kdsn.util.filter;

import com.usping.kdsn.util.config.CONFIG;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(filterName = "authCheck", urlPatterns = "/api/*")
public class AuthCheckFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(AuthCheckFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("filter启动");
    }

    /**
     * 通过验证jjwt产生的token, 校验其中包含的信息
     * 用于验证用户token是否有效
     * 后期应该改为interceptor
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        if (req.getMethod().equals("OPTIONS")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        try{
            logger.info("获取token："+req.getHeader("Authorization"));
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(CONFIG.getTokenPass()))
                    .parseClaimsJws(req.getHeader("Authorization")).getBody();

        }catch (IllegalArgumentException e) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            logger.info("获取token异常, 禁止请求");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
