package com.jwt.example.Jwt_demo.filters;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class FirstFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("check filter details here");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("during response time");
    }
}
