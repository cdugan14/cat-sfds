package sfds.adapter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sfds.domain.Project;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class SocrataAdapter {
    private static final String GET_PROJECTS_URL = "/resource/9rdx-httc.json";

    private final RestTemplate restTemplate;

    public SocrataAdapter(@Qualifier("socrataRestTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Project> getAllProjects() {
        AllProjectsResponse allProjectsResponse = restTemplate.getForObject(GET_PROJECTS_URL, AllProjectsResponse.class);

        List<Project> projects = allProjectsResponse
                .getProjects()
                .stream()
                .map(
                        projectResponse ->
                                new Project(
                                projectResponse.getProjectId(),
                                projectResponse.getProjectName(),
                                projectResponse.getStreetNumber(),
                                projectResponse.getStreetName(),
                                projectResponse.getStreetType()
                                )
                ).collect(toList());

        return projects;
    }
}
