package com.khushal.filterdemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(2)
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        long startTime = System.currentTimeMillis();

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String uuid = UUID.randomUUID().toString();

        httpResponse.setHeader("UUID", uuid);

        // Request Log
        System.out.println("Incoming Request: "
                + httpRequest.getMethod()+" "
                + httpRequest.getRequestURI());

        try{
            filterChain.doFilter(httpRequest, httpResponse);
        }
        finally {
            long duration = System.currentTimeMillis() - startTime;

            // Response status log
            System.out.println("Response status: "
                    + httpResponse.getStatus());

            System.out.println("API Response Time: " + duration);
        }



    }

}
