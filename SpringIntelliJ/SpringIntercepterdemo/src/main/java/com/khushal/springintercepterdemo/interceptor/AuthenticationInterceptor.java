package com.khushal.springintercepterdemo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor
{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String apiKey = request.getHeader("X-Api-Key");

        if(apiKey == null || !apiKey.equals("secret123")){
            response.setContentType("application/json");
            response.getWriter().write("{\n" + " \"messsage\" : \"Failed in Authorize\"\n" + "}");
            return false;
        }

        return true;
    }
}
