package orange.com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import orange.com.DB.DB_Operations;
import orange.com.user.User;

import javax.swing.*;
import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class user_servlet extends HttpServlet {
    DB_Operations db_operations = new DB_Operations();
    User user_message = new User();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        if (type.equals("logIn")) {
            String user = req.getParameter("user");
            String password = req.getParameter("password");
            logIn(user, password, req);
            if (user_message.getUser() != null) {
                req.getRequestDispatcher("personalInterface.jsp").forward(req, resp);
            } else {

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    //µÇÂ¼ÏµÍ³
    protected void logIn(String user, String password, HttpServletRequest req) {
        ResultSet rs = db_operations.logIn(user, password);

        try {
            user_message.setUser(rs.getString(1));
            user_message.setName(rs.getString(2));
            user_message.setSex(rs.getString(3));
            user_message.setPassword(rs.getString(4));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("user", user_message.getUser());
        req.setAttribute("name", user_message.getName());
        req.setAttribute("sex", user_message.getSex());
        req.setAttribute("password", user_message.getPassword());
    }
}
