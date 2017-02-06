<%@ page import="com.ustcjin.domain.Order" %><%--
  Created by IntelliJ IDEA.
  User: mi
  Date: 2017/1/24
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单详情</title>
</head>
<body>
    <% Order order = (Order)request.getAttribute("order");
        String orderId = order.getOrderId();
        String userName = order.getUserName();
        String goodName = order.getGoodName();
        int count = order.getCount();
        String[] friends = (String[]) request.getAttribute("friends");
    %>
    <table border="1">
        <tr><td>订单号：</td> <td> <%=orderId%> </td></tr>
        <tr><td>用户名：</td> <td> <%=userName%> </td></tr>
        <tr><td>商品名：</td> <td> <%=goodName%> </td></tr>
        <tr><td>数  量：</td> <td> <%=count%> </td></tr>
    </table>
    推荐给的好友：
    <%
        if(friends != null){
            int i = 0;
            for(String friend : friends){
                if (i!=0){
                    %>,<%
                }
                %><%=friend%><%
                i++;
            }
        } else {
            %>没有推荐的朋友<%
        }
    %>
</body>
</html>
