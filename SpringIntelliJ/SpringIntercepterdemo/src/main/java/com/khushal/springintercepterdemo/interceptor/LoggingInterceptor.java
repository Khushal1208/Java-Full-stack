package com.khushal.springintercepterdemo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoggingInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception
    {
        System.out.println("Incoming Request.......");

        System.out.println("HTTP Method: " + request.getMethod());
        System.out.println("Request URI: "+ request.getRequestURI());
        System.out.println("Request Parameters: " + request.getQueryString());
        System.out.println("Client IP: "+ request.getRemoteAddr());
        System.out.println("Token Header: " + request.getHeader("token") );


//        HandlerMethod method = (HandlerMethod) handler;
        if(handler instanceof HandlerMethod handlerMethod ){
            String controllerName = handlerMethod.getBeanType().getName();
            String methodName = handlerMethod.getMethod().getName();

            System.out.println("preHandle called");
            System.out.println("Controller name :" + controllerName);
            System.out.println("Method name :" + methodName);
        }

        return true;
    }

//    @Override
//    public void postHandle(HttpServletRequest request,
//                           HttpServletResponse response,
//                           Object handler, ModelAndView modelAndView) throws Exception
//    {
//        System.out.println("postHandle called");
//    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception ex) throws Exception
    {
        System.out.println("afterCompletion called");
        System.out.println("Response status: "+ response.getStatus());

        if(ex != null){
            System.out.println(ex.getMessage());
        }

    }
}
