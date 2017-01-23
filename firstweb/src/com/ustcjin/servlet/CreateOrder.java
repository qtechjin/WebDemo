package com.ustcjin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mi on 2017/1/23.
 */
@WebServlet(name = "CreateOrder")
public class CreateOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String bookName = request.getParameter("bookName");
        int count = Integer.valueOf(request.getParameter("count"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String orderId = sdf.format(new Date());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
