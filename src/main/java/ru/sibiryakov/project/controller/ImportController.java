package ru.sibiryakov.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.sibiryakov.project.controller.test.SaxMyParser;
import ru.sibiryakov.project.model.InfoAboutSecurities;
import ru.sibiryakov.project.model.TradingHistory;
import ru.sibiryakov.project.service.ProjectService;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static ru.sibiryakov.project.controller.test.SaxParserHandler.*;

/*Controller for import data*/


@Controller
public class ImportController {

    private final ProjectService projectService;
    @Autowired
    public ImportController(ProjectService projectService) {
        this.projectService = projectService;
    }

    //path for save date
    private static String UPLOADED_FOLDER = "C://temp//";

     {
        try {
            if(Files.notExists(Paths.get(UPLOADED_FOLDER)))
                Files.createDirectory(Paths.get(UPLOADED_FOLDER));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    //import of data
    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            return "dont-load";
        }
        try {
            String fileName = file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            String fileNameFull = (UPLOADED_FOLDER + file.getOriginalFilename());

            if(fileName.startsWith("his")){
            SaxMyParser <TradingHistory> parser = new SaxMyParser();
            TradingHistory history = parser.parse(fileNameFull);
            for (TradingHistory his : listHistory) {
                projectService.saveHistory(his); }
            }
            else if(fileName.startsWith("sec")){
                SaxMyParser <InfoAboutSecurities> parser = new SaxMyParser();
                InfoAboutSecurities securities = parser.parse(fileNameFull);
                for (InfoAboutSecurities sec : listSecurities) {
                    projectService.saveSecurities(sec); }
                }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "dont-load";
    }
}


