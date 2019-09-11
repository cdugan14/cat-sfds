package sfds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sfds.adapter.SocrataAdapter;

@Controller
public class GreetingController {

    private final SocrataAdapter socrataAdapter;

    public GreetingController(SocrataAdapter socrataAdapter) {
        this.socrataAdapter = socrataAdapter;
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        socrataAdapter.getAllProjects();
        String projectId = socrataAdapter.getAllProjects().get(0).getProjectId();
        model.addAttribute("name", name + projectId );
        return "greeting";
    }

}
