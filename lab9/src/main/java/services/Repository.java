package services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class Repository<T> implements IRepository<T> {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    private final String type;

    public Repository(Class<T> type) {
        this.type = type.getTypeName().split("\\.")[1];
    }

    @Override
    public List<T> getAll() {
        List<T> comps;
        Session session = null;
        Transaction transaction = null;

        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            comps = session.createQuery("from " + type).getResultList();
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            comps = null;
            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }
        return comps;
    }

    @Override
    public T getById(int id) {
        T comp = null;
        Session session = null;
        Transaction transaction = null;

        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            comp = (T)session.createQuery("from " + type +" where id = :id")
                    .setParameter(id,id)
                    .getResultList();
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            comp = null;
            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }
        return comp;
    }

    @Override
    public Boolean add(T comp) {
        Boolean added = true;
        Session session = null;
        Transaction transaction = null;

        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(comp);
            transaction.commit();
        } catch (Exception e){
            added = false;
            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }
        return added;
    }


}
