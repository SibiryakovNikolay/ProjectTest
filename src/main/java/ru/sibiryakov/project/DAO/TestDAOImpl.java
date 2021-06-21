package ru.sibiryakov.project.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sibiryakov.project.model.Names;

import java.util.List;
@Repository
public class TestDAOImpl implements TestDAO {

    private final SessionFactory sessionFactory;
    @Autowired
    public TestDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Names> getAllNames() {
        Session session = sessionFactory.getCurrentSession();
        List<Names> list =
                session.createQuery("from Names", Names.class).getResultList();
        return list;
    }

    @Override
    public void saveName(Names name) {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(name);
        }
    }



