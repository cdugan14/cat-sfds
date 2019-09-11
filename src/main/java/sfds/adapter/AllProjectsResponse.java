package sfds.adapter;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Set;

public class AllProjectsResponse {
    private final Set<ProjectResponse> projects;

    @JsonCreator
    public AllProjectsResponse(Set<ProjectResponse> projects) {
        this.projects = projects;
    }

    public Set<ProjectResponse> getProjects() {
        return projects;
    }
}
