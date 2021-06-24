package ru.sibiryakov.project.DAO;

import ru.sibiryakov.project.model.InfoAboutSecurities;
import ru.sibiryakov.project.model.TradingHistory;

import java.util.List;

public interface ProjectDAO {

     List <InfoAboutSecurities> getAllSecurities();

     void saveHistory(TradingHistory history);

     void saveSecurities(InfoAboutSecurities securities);

     InfoAboutSecurities findBySecId(String secId);

     InfoAboutSecurities findById(int id);

     void deleteSecurity(int id);

     List <TradingHistory> findHistoryBySecId(String secId);

     void updateSecurity(InfoAboutSecurities securities);



}
