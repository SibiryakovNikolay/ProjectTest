package ru.sibiryakov.project.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sibiryakov.project.model.InfoAboutSecurities;
import ru.sibiryakov.project.model.TradingHistory;
import ru.sibiryakov.project.service.ProjectService;

import java.util.List;


/*Controller for CRUD methods
*
* */

@Controller
public class CrudController {

    private final ProjectService projectService;

    @Autowired
    public CrudController(ProjectService projectService) {
        this.projectService = projectService;
    }

    //show all list of securities
    @GetMapping("/")
    public String ShowAllSecurities(Model model) {
        List<InfoAboutSecurities> listSecurities = projectService.getAllSecurities();
        model.addAttribute("allSecurities", listSecurities);
        return "start-page";
    }
    //delete security by id
    @GetMapping("/delete/{id}")
    public String deleteSecurities(@PathVariable("id") int id) {
        projectService.deleteSecurity(id);
        return "redirect:/";
    }
    //show info about security
    @GetMapping("/info/{id}")
    public String infoAboutSecurity(@PathVariable("id") int id, Model modelForSecurity, Model modelForHistory) {
        InfoAboutSecurities security = projectService.findById(id);
        List<TradingHistory> listHistory = projectService.findHistoryBySecId(security.getSecId());
        modelForSecurity.addAttribute("info", security);
        modelForHistory.addAttribute("history", listHistory);
        return "info-page";

    }
    //form for create
    @GetMapping("/create")
    public String createForm(Model model) {
        InfoAboutSecurities security = new InfoAboutSecurities();
        model.addAttribute("formCreate", security);
        return "create-page";
    }

    //save one security
    @PostMapping
    public String createSecurity(@ModelAttribute("formCreate") InfoAboutSecurities security) {
        projectService.saveSecurities(security);
        return "redirect:/";
    }

    //form for update
    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") int id, Model model) {
        InfoAboutSecurities securities = projectService.findById(id);
        model.addAttribute("formUpdate", securities);
        return "update-page";
    }

    //update
    @PostMapping("/update")
    public String updateSecurities(@ModelAttribute("formUpdate") InfoAboutSecurities securities, Model model) {
        if (!projectService.updateSecurity(securities)){
            model.addAttribute("updateError", "Акция с таким названием уже существует уже существует");
            return "update-page";
        }
        projectService.updateSecurity(securities);
        return "redirect:/success";

    }
    @GetMapping("/success")
    public String success(){
        return "success-page";
    }
}

