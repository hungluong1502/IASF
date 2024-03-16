<%@ page import="com.example.loginsvl.entity.Employee" %><%--


--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<form action="student" method="post" accept-charset="UTF-8">
    <input type="hidden" name="id" value="<%= request.getParameter("employeeId")%>">
    <label for="name">Name:</label>
    <input class="form-input" type="text" id="name" name="name" value="<%=request.getParameter("employeeName") %>">
    <label for="age">Age:</label>
    <input class="form-input" type="text" id="age" name="age" value="<%=request.getParameter("employeeAge") %>">
    <label for="salary">Salary:</label>
    <input class="form-input" type="text" id="salary" name="salary" value="<%=request.getParameter("employeeSalary") %>">
    <button type="submit" name="method" value="update"> Update</button>
</form>
</body>
</html>
