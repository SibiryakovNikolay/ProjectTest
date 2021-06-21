package ru.sibiryakov.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.sibiryakov.project.controller.test.SaxMyParser;
import ru.sibiryakov.project.model.Names;
import ru.sibiryakov.project.service.TestService;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static ru.sibiryakov.project.controller.test.SaxParserHandler.list;

@Controller
public class MainController {
    private final TestService testService;
    @Autowired
    public MainController(TestService testService) {
        this.testService = testService;
    }

    private static String UPLOADED_FOLDER = "D://temp//";

    @GetMapping("/")
    public String index() {
        return "new";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }
        try {

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            String fileName = (UPLOADED_FOLDER + file.getOriginalFilename());
            SaxMyParser parser = new SaxMyParser();
            Names names = parser.parse(fileName);
            for (Names name : list) {
                testService.saveName(name);
            }
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");


        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
    @GetMapping("/start")
    public String testMethod(Model model) {
        List<Names> listNames = testService.getAllNames();
        model.addAttribute("allNames", listNames);
        return "start-page";
    }
}


