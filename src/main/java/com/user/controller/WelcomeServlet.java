package com.user.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/welcome")
public class WelcomeServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect("WEB-INF/Welcome.jsp");
        HttpSession session = req.getSession();
        String val =  session.getAttribute("user")+"";
        System.out.println(val);

        if(session.getAttribute("user")==null){

            resp.sendRedirect("login");
        }else{


            RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/WEB-INF/views/Welcome.jsp" );
            dispatcher.forward( req, resp );
        }

    }
}
