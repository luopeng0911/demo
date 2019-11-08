package com.example.demo;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author: 111
 * @Date: 2019/6/24 0024 上午 10:01
 * @Description:
 */
@Order(2)
@WebFilter(filterName = "myfilter2", urlPatterns = "/*")
public class IndexFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if("madan".equals(servletRequest.getParameter("ojj"))){
            servletResponse.getWriter().write("madan is iv!");
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
