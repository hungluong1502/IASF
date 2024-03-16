<%@ page import="com.example.loginsvl.entity.Employee" %>
<%@ page import="java.util.List" %><%--
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link type="text/css" href="WEB-INF/style/Student.css">
</head>
<body>
<table border="1px solid #888" width="100%" align="center">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Salary</th>
    </tr>
    </thead>
    <tbody>
    <% request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        List<Employee> list = (List<Employee>) request.getAttribute("listEmployee");
        for (int i = 0; i < list.size(); i++) {
    %>
    <tr>
        <td><%= list.get(i).getId()%>
        </td>
        <td><%= list.get(i).getName()%>
        </td>
        <td><%= list.get(i).getAge()%>
        </td>
        <td><%= list.get(i).getSalary()%>
        </td>
        <td>
            <form action="updateEmployee.jsp" method="post" accept-charset="UTF-8">
                <input type="hidden" name="employeeId" value="<%= list.get(i).getId()%>"/>
                <input type="hidden" name="employeeName" value="<%= list.get(i).getName()%>"/>
                <input type="hidden" name="employeeAge" value="<%= list.get(i).getAge()%>"/>
                <input type="hidden" name="employeeSalary" value="<%= list.get(i).getSalary()%>"/>
                <button type="submit">UPDATE</button>
            </form>
        </td>
        <td>
            <form action="employee" method="post">
                <input type="hidden" name="idEmployee" value=<%=list.get(i).getId()%>>
                <input type="submit" name="method" value="DELETE">
            </form>
        </td>

    </tr>
    <% }%>
    <td></td>
    </tbody>
</table>
<h1>Add Student</h1>
<form action="employee" method="post">
    <label for="name">Name:</label>
    <input class="form-input" type="text" id="name" name="name">
    <label for="age">Age:</label>
    <input class="form-input" type="text" id="age" name="age">
    <label for="salary">Salary:</label>
    <input class="form-input" type="text" id="salary" name="salary">

    <input type="submit" name="method" value="Submit">
</form>
</body>
</html>
