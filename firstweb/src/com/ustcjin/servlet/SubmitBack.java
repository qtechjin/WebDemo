package com.ustcjin.servlet;

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
        String gender = request.getParameter("gender");
        out.println("你选择的是:" + gender);

        request.setAttribute("name", gender);
        String context = request.getContextPath().toString();
        request.setAttribute("context", context);
        RequestDispatcher view = request.getRequestDispatcher("/jsp/result.jsp");
        view.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
