package services;

import entities.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class GenreModel {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public List<Genre> getAll(){
        List<Genre> genres;
        Session session = null;
        Transaction transaction = null;

        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            genres = session.createQuery("from entities.Genre").getResultList();
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            genres = null;
            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }
        return genres;
    }
}
