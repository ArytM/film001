package com.film001.dao;

import com.film001.util.HibernateUtil;
import com.film001.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao {

    public void saveUser(User user) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    private User getUser(String email) {
        User user = null;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        user = (User) session.createQuery("FROM User U WHERE U.email = :email").setParameter("email", email).uniqueResult();
        transaction.commit();
        return user;
    }


    public boolean validate(String email, String password) {
        Transaction transaction = null;

        try {
            User user = getUser(email);
            if (user != null && user.getPassword().equals(password)) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean validateReg(String email) {
        Transaction transaction = null;

        try {
            User user = getUser(email);
                if (user == null){
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return false;
    }
}
