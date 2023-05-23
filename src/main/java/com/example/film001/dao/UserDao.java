package com.example.film001.dao;

import com.example.film001.util.HibernateUtil;
import com.example.film001.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao {

    public void saveUser(User user){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public boolean validate (String email, String password){
        Transaction transaction = null;
        User user = null;
        try
            (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            user = (User) session.createQuery("FROM User U WHERE U.email = :email").setParameter("email", email).uniqueResult();

            if (user !=null && user.getPassword().equals(password)){
                return true;
            }
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }



}
