package com.ustcjin.servlet;

import com.ustcjin.domain.Order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mi on 2017/1/23.
 */
@WebServlet(name = "CreateOrder")
public class CreateOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String userName = request.getParameter("userName");
        String goodName = request.getParameter("goodName");
        int count = Integer.valueOf(request.getParameter("count"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String orderId = sdf.format(new Date());
        Order order = new Order(orderId, userName, goodName, count);
        String[] friends = request.getParameterValues("friends");
        if (friends !=null)
        {
            for(String s:friends){
                System.out.println(s);
            }
        }

        request.setAttribute("order", order);
        request.setAttribute("friends", friends);
        InputStream in = request.getInputStream();
        byte[] buffer = new byte[1024];
        in.read(buffer);
        System.out.println(new String(buffer));
        RequestDispatcher view = request.getRequestDispatcher("/jsp/order_info.jsp");
        view.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
