package ru.sibiryakov.project.service;

import ru.sibiryakov.project.model.InfoAboutSecurities;
import ru.sibiryakov.project.model.TradingHistory;

import java.util.List;

public interface ProjectService {

    List<InfoAboutSecurities> getAllSecurities();

    void saveHistory(TradingHistory history);

    void saveSecurities(InfoAboutSecurities securities);

    InfoAboutSecurities findBySecId(String secId);

    void deleteSecurity(int id);

    InfoAboutSecurities findById(int id);

    List <TradingHistory> findHistoryBySecId(String secId);

    boolean updateSecurity(InfoAboutSecurities securities);

}
