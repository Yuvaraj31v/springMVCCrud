package com.ideas2it.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.ideas2it.dao.UserDao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;


import com.ideas2it.model.Employee;
import com.ideas2it.model.Trainee;
import com.ideas2it.model.Trainer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Repository
@EnableTransactionManagement
@Component
public class UserDaoImpl<T extends Employee> implements UserDao {

    private T t;

    public  UserDaoImpl(T t) {
        this.t = t;
    }

    @Autowired
    DataSource datasource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void register(Employee employee) {
        if (employee instanceof Trainer) {
            Session session = sessionFactory.getCurrentSession();
            session.persist((Trainer)employee);
        } else {
            Session session = sessionFactory.getCurrentSession();
            session.persist((Trainee)employee);
        }
    }

    @Transactional
    public boolean update(Employee user) {
        if (user instanceof Trainer) {
            boolean isactive = false;
            try {
                Session session = sessionFactory.getCurrentSession();
                session.update(user);
                isactive = true;
            }
            catch(NoResultException noResultException) {
                isactive= false;
            }
            return isactive;
        } else {
            boolean isactive = false;
            try {
                Session session = sessionFactory.getCurrentSession();
                session.update(user);
                isactive = true;
            } catch (Exception exception) {
                isactive = false;
            }
            return isactive;

        }
    }

    @Transactional
    public Trainer retrieveTrainerById(String employeeId) {
        Trainer trainer = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            TypedQuery query = session.getNamedQuery("findTrainerById");
            query.setParameter("isActive",1);
            query.setParameter("employeeId", employeeId);
             trainer = (Trainer) query.getSingleResult();
            return trainer;
        }
        catch(NoResultException noResultException){
            return trainer;
        }
    }

    @Transactional
    public Trainee retrieveTraineeById(String employeeId) {
        Trainee trainee = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            TypedQuery query = session.getNamedQuery("findTraineeById");
            query.setParameter("isActive",1);
            query.setParameter("employeeId", employeeId);
             trainee = (Trainee) query.getSingleResult();
            return trainee;
        }
        catch(NoResultException noResultException){
           return trainee;
        }
    }




    @Transactional
    public List<Trainer> getTrainers() {
        List<Trainer> user = new ArrayList<>();

        Session session = sessionFactory.getCurrentSession();

        TypedQuery query = session.getNamedQuery("findTrainer");
        query.setParameter("isActive",1);
        user = query.getResultList();
        return user;
    }
    @Transactional
    public List<Trainee>  getTrainees() {

        List<Trainee> user = new ArrayList<>();
        Session session = sessionFactory.getCurrentSession();
        TypedQuery query = session.getNamedQuery("findTrainee");
        query.setParameter("isActive",1);
        user = query.getResultList();
        return user;
    }


    /*public Employee getEmpById(String username){
        String sql="select * from users where username =?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username},new BeanPropertyRowMapper<Employee>(Employee.class));
    }*/
}


