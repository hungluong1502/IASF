package com.example.loginsvl.controller;

import com.example.loginsvl.dao.EmployeeDao;
import com.example.loginsvl.dao.EmployeeDaoImpl;
import com.example.loginsvl.entity.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "employee", value = "/employee")
public class EmployeeController extends HttpServlet {
    private EmployeeDao dao = new EmployeeDaoImpl();
    Employee employee;
    List<Employee> list;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        list = dao.findAll();
        req.setAttribute("listEmployee", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("employee.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        if (method.equals("DELETE")) {
            Integer id = Integer.valueOf(req.getParameter("idEmployee"));
            Integer delete = dao.delete(id);
            if (delete != null) resp.sendRedirect("employee");
        } else {

            employee = new Employee();
            Integer id = Integer.valueOf(req.getParameter("id"));
            if (id != null) employee.setId(id);
            employee.setName(req.getParameter("name"));
            employee.setAge(req.getParameter("age"));
            employee.setAddress(req.getParameter("salary"));
            dao.createOrUpdate(employee);

            resp.sendRedirect("employee");
        }
    }

}
