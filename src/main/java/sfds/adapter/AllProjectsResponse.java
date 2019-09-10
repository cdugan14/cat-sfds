package sfds.adapter;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;

public class AllProjectsResponse {
    private final List<ProjectResponse> projects;

    @JsonCreator
    public AllProjectsResponse(List<ProjectResponse> projects) {
        this.projects = projects;
    }

    public List<ProjectResponse> getProjects() {
        return projects;
    }
}
