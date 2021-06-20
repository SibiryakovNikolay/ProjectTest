package ru.sibiryakov.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sibiryakov.project.DAO.TestDAO;
import ru.sibiryakov.project.model.Names;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    private final TestDAO testDAO;
    @Autowired
    public TestServiceImpl(TestDAO testDAO) {
        this.testDAO = testDAO;
    }


    @Override
    @Transactional
    public List<Names> getAllNames() {
        return testDAO.getAllNames();
    }



}
