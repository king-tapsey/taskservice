package com.todo.taskservice.config;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(1)
@Component
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ((HttpServletResponse)response).addHeader("Access-Control-Allow-Methods","*");
        ((HttpServletResponse)response).addHeader("Access-Control-Allow-Headers","*");
        ((HttpServletResponse)response).addHeader("Access-Control-Allow-Origin","*");
        chain.doFilter(request,response);
    }
}