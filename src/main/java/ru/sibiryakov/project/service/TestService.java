package ru.sibiryakov.project.service;

import org.springframework.stereotype.Service;
import ru.sibiryakov.project.model.Names;

import java.util.List;

public interface TestService {
    List<Names> getAllNames();
    void saveName(Names name);

}
