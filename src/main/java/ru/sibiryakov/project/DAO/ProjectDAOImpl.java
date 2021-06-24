package ru.sibiryakov.project.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.sibiryakov.project.model.InfoAboutSecurities;
import ru.sibiryakov.project.model.TradingHistory;

import java.util.List;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public ProjectDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<InfoAboutSecurities> getAllSecurities() {
        Session session = sessionFactory.getCurrentSession();
        List<InfoAboutSecurities> list =
                session.createQuery("from InfoAboutSecurities", InfoAboutSecurities.class).getResultList();
        return list;
    }

    @Override
    public void saveHistory(TradingHistory history) {
        Session session = sessionFactory.getCurrentSession();
        session.save(history);
        }


    @Override
    public void saveSecurities(InfoAboutSecurities securities) {
        Session session = sessionFactory.getCurrentSession();
        session.save(securities);
    }


    @Override
    public InfoAboutSecurities findBySecId(String secId) {
        Session session = sessionFactory.getCurrentSession();
        Query<InfoAboutSecurities> query = session.createQuery("from InfoAboutSecurities" +
                " where secId =:sec");
        query.setParameter("sec", secId);
        InfoAboutSecurities security = (InfoAboutSecurities) query.uniqueResult();
        return security;
    }


    @Override
    public List<TradingHistory> findHistoryBySecId(String secId) {
        Session session = sessionFactory.getCurrentSession();
        Query<TradingHistory> query = session.createQuery("from TradingHistory" +
                " where secId =:sec ");
        query.setParameter("sec", secId);
        List<TradingHistory> listHistory = query.getResultList();
        return listHistory;
    }


    @Override
    public InfoAboutSecurities findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<InfoAboutSecurities> query = session.createQuery("from InfoAboutSecurities" +
                " where id=:id");
        query.setParameter("id", id);
        InfoAboutSecurities security = (InfoAboutSecurities) query.uniqueResult();
        return security;

    }

    @Override
    public void deleteSecurity(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<InfoAboutSecurities> query = session.createQuery("delete from InfoAboutSecurities" +
                " where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void updateSecurity(InfoAboutSecurities security) {
        Session session = sessionFactory.getCurrentSession();
        saveSecurities(security);
    }


}




