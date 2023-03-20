package com.example.film001;


import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class FilmDao {
    public void saveFilm(Film film){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(film);
            transaction.commit();
        } catch (Exception e){
            if (transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateFilm(Film film){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(film);
            transaction.commit();
        } catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteFilm(int id){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Film film = session.get(Film.class, id);
            if (film !=null){
                session.delete(film);
                System.out.println("film deleted");
            }
            transaction.commit();
        } catch (Exception e){
            if (transaction !=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Film getFilm(int id){
        Transaction transaction = null;
        Film film = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            film = session.get(Film.class, id);
            transaction.commit();
        } catch (Exception e){
            if (transaction !=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return film;
    }

    @SuppressWarnings("unchecked")
    public List <Film> getAllFilm(){
        Transaction transaction = null;
        List<Film> listOfFilm = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            listOfFilm = session.createQuery("FROM Film").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfFilm;


    }
}

