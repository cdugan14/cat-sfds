package sfds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sfds.adapter.SocrataAdapter;
import sfds.domain.Project;

import java.util.List;

@Controller
public class AffordableProjectController {

    private final SocrataAdapter socrataAdapter;

    public AffordableProjectController(SocrataAdapter socrataAdapter) {
        this.socrataAdapter = socrataAdapter;
    }

    @GetMapping("/housing")
    public String getAffordableProjects(Model model) {
        List<Project> projectList = socrataAdapter.getAllProjects();
        model.addAttribute("projectList", projectList);
        return "housing";
    }

}
