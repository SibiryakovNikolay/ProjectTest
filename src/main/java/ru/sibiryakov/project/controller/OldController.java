package ru.sibiryakov.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.sibiryakov.project.service.TestService;

@Controller
public class OldController {

    private final TestService testService;
    @Autowired
    public OldController(TestService testService) {
        this.testService = testService;
    }

//    @GetMapping("/start")
//    public String testMethod(Model model) {
//        List<Names> listNames = testService.getAllNames();
//        model.addAttribute("allNames", listNames);
//        return "start-page";
//    }


}
