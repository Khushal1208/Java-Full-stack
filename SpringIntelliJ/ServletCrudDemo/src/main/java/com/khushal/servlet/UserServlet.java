package com.khushal.servlet;

import com.khushal.model.User;
import com.khushal.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");

        if(id == null || email == null || name == null || mobile == null){
            res.setStatus(400);
            res.setContentType("application/json");
            res.getWriter().write(
                   " {\n" +
                           "    \"message\" : \"User Not Added, some fields are missing\" +\n" +
                    "}"
            );
            return;
        }
        User user = new User(id, name, email, mobile);
        User createdUser = userService.createUser(user);
        res.setStatus(201);
        res.setContentType("application/json");
        res.getWriter().write(
                " {\n" +
                        "    \"message\" : \"User Added successfully\" +\n" +
                        "}"
        );
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String idParam = req.getParameter("id");
        if(idParam == null){
            List<User> users = userService.getAllUsers();
            res.setStatus(200);
            res.setContentType("application/json");
            res.getWriter().write(usersToJson(users));
            return ;
        }
        Integer id = Integer.parseInt(idParam);

        User userResp = userService.getUserById(id);
        if(userResp == null){
            res.setStatus(404);
            res.setContentType("application/json");
            return;
        }

        res.setStatus(200);
        res.setContentType("application/json");
        res.getWriter().write(userToJson(userResp));

    }

    @Override
    public void doPut(HttpServletRequest req,
                      HttpServletResponse res) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");

        User user = new User(id, name, email, mobile);
        Boolean isChanged =  userService.updateUser(user);
        if(!isChanged){
            res.setStatus(404);
            res.setContentType("application/json");
            res.getWriter().write("User Not Found");
            return ;
        }
        res.setStatus(200);
        res.setContentType("application/json");
        res.getWriter().write("User Updated successfully");
    }

    @Override
    public void doDelete(HttpServletRequest req,
                         HttpServletResponse res) throws  IOException{
        Integer idParam = Integer.parseInt(req.getParameter("id"));
        Boolean isDeleted =  userService.deleteUser(idParam);
        if(!isDeleted){
            res.setStatus(400);
            res.setContentType("application/json");
            res.getWriter().write("User Not Found");
            return ;
        }
        res.setStatus(200);
        res.setContentType("application/json");
        res.getWriter().write("User Deleted successfully");
    }

    private String userToJson(User user){
        return "{"
                + "\"id\":" + user.getId() + ","
                + "\"name\":\"" + user.getName() + "\","
                + "\"email\":\"" + user.getEmail() + "\","
                + "\"mobile\":\"" + user.getMobile() + "\""
                + "}";
    }

    private String usersToJson(List<User> users){
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for(int i = 0 ; i<users.size() ; i++) {
            sb.append(userToJson(users.get(i)));
            if(i < users.size()-1)  sb.append(",");
        }

        sb.append("]");

        return sb.toString();
    }
}
