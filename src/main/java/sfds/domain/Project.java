package sfds.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {
    private final String projectId;
    private final String projectName;
    private final String streetNumber;
    private final String streetName;
    private final String streetType;

    @JsonCreator
    public Project(@JsonProperty("project_id") String projectId,
                   @JsonProperty("project_name") String projectName,
                   @JsonProperty("street_number") String streetNumber,
                   @JsonProperty("street_name") String streetName,
                   @JsonProperty("street_type") String streetType) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.streetType = streetType;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetType() {
        return streetType;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId='" + projectId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetType='" + streetType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(projectId, project.projectId) &&
                Objects.equals(projectName, project.projectName) &&
                Objects.equals(streetNumber, project.streetNumber) &&
                Objects.equals(streetName, project.streetName) &&
                Objects.equals(streetType, project.streetType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, projectName, streetNumber, streetName, streetType);
    }


}
