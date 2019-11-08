package com.example.demo;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: 111
 * @Date: 2019/6/24 0024 上午 10:00
 * @Description:
 */
@Order(1)
@WebFilter(filterName = "myfilter1", urlPatterns = "/*")
public class IndexFilter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        if("dog".equals(servletRequest.getParameter("ujj"))){
            servletResponse.getWriter().write("dog is iv!");
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
