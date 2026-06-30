package com.khushal.springwebapp.controller;

import com.khushal.springwebapp.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller // Search for a view/page named "welcome" for example templates/welcome.html we dont want this
//To print Body we need to @ResponseBody also. @ResponseBody tells Spring: Don't look for a view/page. Whatever the method returns, send it directly to the client.

@RestController // Output in browser:Welcome , does not search for any HTML page. Instead it sends the string directly in the HTTP response.
// Internally @RestController is equivalent to: @Controller with @ResponseBody
public class HomeController {
    @RequestMapping("/")  // ByDefault its Method is "Get"
    public String greet(){
        return "Welcome";
    }

//    @Controller
// Treats returned String as a View/Page name

//    @RestController
// Returns data directly (String, JSON, XML, Object, etc.)
// Does NOT search for a View/Page

//    @Controller is used for Spring MVC applications where methods return view names (HTML/JSP/Thymeleaf pages).
//    @RestController is used for REST APIs and automatically returns data as the HTTP response body.
//    Internally, @RestController = @Controller + @ResponseBody.


    @GetMapping("/student")
    public Student getStudent() {
        return new Student(1, "Bhagwan Krishna"); // returns JSON
//        Spring automatically converts the Java object into JSON using the Jackson library.
    }

    // Q. When we have Multiple Controller then how spring knows we request to send to particular Controller?
    // A. Spring Provides us 'Front Controller' which handles this thing. It creates the Request Mapping for the Controllers.
    //    That's how it knows which request send to Particular Controller.
}
