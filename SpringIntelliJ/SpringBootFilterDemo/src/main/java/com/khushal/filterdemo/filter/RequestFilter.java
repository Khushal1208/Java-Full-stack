package com.khushal.filterdemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.UUID;

//@Component
public class RequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        BufferedReader reader = httpServletRequest.getReader();

        StringBuilder body = new StringBuilder();

        String line = reader.readLine();

        while(line != null){
            body.append(line);
            line = reader.readLine();
        }

        System.out.println(body);

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
