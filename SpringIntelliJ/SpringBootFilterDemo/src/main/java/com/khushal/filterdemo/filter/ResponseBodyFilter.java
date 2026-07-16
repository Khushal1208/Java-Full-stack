package com.khushal.filterdemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

//@Component
//@Order(1)
public class ResponseBodyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;

        ContentCachingResponseWrapper wrapperResponse =
                new ContentCachingResponseWrapper(httpServletResponse);

        filterChain.doFilter(httpServletRequest, wrapperResponse);

        byte[] originalBodyBytes =
                wrapperResponse.getContentAsByteArray();

        String originalBody = new String(originalBodyBytes);

        String modifiedBody =
                """
                        {
                        "originalResponse" : %s,
                        "appName" : "Student Management System  
                        }
                        """.formatted(originalBody);

        wrapperResponse.resetBuffer();

        wrapperResponse.getWriter().write(modifiedBody);

        wrapperResponse.copyBodyToResponse();

    }
}
