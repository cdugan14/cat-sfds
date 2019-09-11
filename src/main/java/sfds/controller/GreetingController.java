package sfds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sfds.adapter.SocrataAdapter;
import sfds.domain.Project;

import java.util.List;

@Controller
public class GreetingController {

    private final SocrataAdapter socrataAdapter;

    public GreetingController(SocrataAdapter socrataAdapter) {
        this.socrataAdapter = socrataAdapter;
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        List<Project> projectList = socrataAdapter.getAllProjects();
        String projectId = projectList.get(0).getProjectId();
        String streetNumber = projectList.get(0).getStreetNumber();
        model.addAttribute("projectList", projectList);
        model.addAttribute("name", name);
        model.addAttribute("projectId1", projectId);
        model.addAttribute("streetNumber1", streetNumber);

        return "table";
    }

}
