package com.khushal.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    public HelloServlet(){
        System.out.println("HelloServlet Constructor called");
    }

    @Override
    public void init(){
        System.out.println("init() CALLED");
    }

    @Override
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res) throws IOException {
        res.setStatus(200);
        res.setContentType("text/plain");
        res.getWriter().write("Hello World");
    }

    @Override
    public void destroy(){
        System.out.println("Destroy method called");
    }
}
