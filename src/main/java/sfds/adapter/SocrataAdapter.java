package sfds.adapter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sfds.domain.Project;

import java.util.Arrays;
import java.util.List;

@Component
public class SocrataAdapter {
    private static final String GET_PROJECTS_URL = "/resource/9rdx-httc.json";
//    private static final String GET_PROJECTS_URL = "https://data.sfgov.org/resource/9rdx-httc.json";

    private final RestTemplate restTemplate;

    public SocrataAdapter(@Qualifier("socrataRestTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Project> getAllProjects() {
        Project[] allProjectsResponse = restTemplate.getForObject(GET_PROJECTS_URL, Project[].class);

        List<Project> projects = Arrays.asList(allProjectsResponse);
        return projects;
    }
}
