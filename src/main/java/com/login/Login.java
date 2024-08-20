package com.login;

import java.io.IOException;

import com.dbconnection.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class Login extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ConnectDB connect = new ConnectDB();
        HttpSession session = request.getSession();
        if(connect.confirmPassword(username, password)){
            session.setAttribute("userData", username+";"+connect.returnData(username).split(";")[1]);
            response.sendRedirect("welcome.jsp");
            return;
        }
        response.sendRedirect("index.jsp");
    
    }
}
