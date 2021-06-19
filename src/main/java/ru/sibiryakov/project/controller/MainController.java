package ru.sibiryakov.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/start")
public String testMethod(){
    return "start-page";
}

}
