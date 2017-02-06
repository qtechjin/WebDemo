<%@ page import="com.ustcjin.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: mi
  Date: 2017/1/23
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp跳转页面</title>
</head>
<body>
    你的选择是 <%= request.getAttribute("name")%><br>
    <%= request.getAttribute("context")%>
    <%= request.getAttribute("email")%><br>
    <%= ((User)request.getAttribute("user")).getName()%><br>
    <%= ((User)request.getAttribute("user")).getGender()%>

</body>
</html>
