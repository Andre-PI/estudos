package com.login;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Logout extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();

        session.removeAttribute("userData");
        session.invalidate();
    }
}