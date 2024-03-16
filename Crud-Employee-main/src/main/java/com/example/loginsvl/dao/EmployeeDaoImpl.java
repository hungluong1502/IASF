package com.example.loginsvl.dao;

import com.example.loginsvl.entity.Employee;
import com.example.loginsvl.exception.UncheckedException;
import com.example.loginsvl.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;
import java.util.Queue;

public class EmployeeDaoImpl implements EmployeeDao {
    Session session;


    @Override
    public List<Employee> findAll() {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            String query = " FROM Employee";
            session.beginTransaction();
            List<Employee> list = session.createQuery(query).getResultList();
            return list;
        }catch (Exception e){
            e.getStackTrace();
            return  null;
        }finally {
            session.close();
        }
    }


    @Override
    public Employee createOrUpdate(Employee employee) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
           if (employee.getId() == null){
               session.beginTransaction();
               session.save(employee);
           }else {
               session.beginTransaction();
               session.update(employee);
           }
           session.getTransaction().commit();
           return employee;
        }catch (UncheckedException e){
            e.getStackTrace();
            session.getTransaction().rollback();
            return null;
        }finally {
            session.close();
        }

    }

    @Override
    public Integer delete(int id) {
        try{
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("delete  from Employee where id = :id").setParameter("id",id);
            query.executeUpdate();
            session.getTransaction().commit();
            return query.getFirstResult();
        }catch (UncheckedException e){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public Employee finById(int id) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            Query<Employee> found = session.createQuery(" FROM Employee WHERE id = :id").setParameter("id",id);
            session.getTransaction().commit();
            return found.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException("Khong xoa duoc");

        }finally {
            session.close();
        }
    }
}
