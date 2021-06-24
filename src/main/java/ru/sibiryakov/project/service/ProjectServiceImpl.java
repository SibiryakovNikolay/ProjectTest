package ru.sibiryakov.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sibiryakov.project.DAO.ProjectDAO;
import ru.sibiryakov.project.model.InfoAboutSecurities;
import ru.sibiryakov.project.model.TradingHistory;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectDAO testProjectDAO;
    @Autowired
    public ProjectServiceImpl(ProjectDAO testProjectDAO) {
        this.testProjectDAO = testProjectDAO;
    }


    @Override
    @Transactional
    public List<InfoAboutSecurities> getAllSecurities() {
        return testProjectDAO.getAllSecurities();
    }


    @Override
    @Transactional
    public void saveHistory(TradingHistory history) {
        InfoAboutSecurities sec = findBySecId(history.getSecId());
        if (sec!=null) {
            testProjectDAO.saveHistory(history);}}



    @Override
    @Transactional
    public void saveSecurities(InfoAboutSecurities securities) {
        InfoAboutSecurities sec = findBySecId(securities.getSecId());
        if (sec==null) {
        testProjectDAO.saveSecurities(securities);}
    }


    @Override
    @Transactional
    public InfoAboutSecurities findBySecId(String secId) {
       return testProjectDAO.findBySecId(secId);
    }

    @Override
    @Transactional
    public void deleteSecurity(int id) {
        testProjectDAO.deleteSecurity(id);
    }

    @Override
    @Transactional
    public InfoAboutSecurities findById(int id) {
        return testProjectDAO.findById(id);
    }

    @Override
    @Transactional
    public List<TradingHistory> findHistoryBySecId(String secId) {
        return testProjectDAO.findHistoryBySecId(secId);
    }


    @Override
    @Transactional
    public boolean updateSecurity(InfoAboutSecurities security) {
        InfoAboutSecurities newSec = security;
        deleteSecurity(security.getId());
        if(findBySecId(security.getSecId())!=null){
            return false;
        }
        else
        testProjectDAO.updateSecurity(security);
        return true;

    }


}
