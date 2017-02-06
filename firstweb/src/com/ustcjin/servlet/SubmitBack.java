package com.ustcjin.servlet;

import com.ustcjin.domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by mi on 2017/1/22.
 */
public class SubmitBack extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        out.println("你选择的是:" + gender);

        User user = (User)getServletContext().getAttribute("user");
        String context = request.getContextPath().toString();

        String email = getServletContext().getInitParameter("email");

        request.setAttribute("name", name);
        request.setAttribute("gender", gender);
        request.setAttribute("user", user);
        request.setAttribute("context", context);
        request.setAttribute("email", email);
        RequestDispatcher view = request.getRequestDispatcher("/jsp/result.jsp");
        view.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
