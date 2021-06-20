package ru.sibiryakov.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.sibiryakov.project.model.Names;
import ru.sibiryakov.project.service.TestService;
import ru.sibiryakov.project.service.TestServiceImpl;

import java.util.List;

@Controller
public class MainController {

    private final TestService testService;
    @Autowired
    public MainController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/start")
    public String testMethod(Model model) {
        List<Names> listNames = testService.getAllNames();
        model.addAttribute("allNames", listNames);
        return "start-page";
    }
    @GetMapping("/")
    public String test() {

        return "new";
    }


}
