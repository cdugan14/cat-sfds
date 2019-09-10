package sfds.domain;

public class Project {
    private final String projectId;
    private final String projectName;
    private final String streetNumber;
    private final String streetName;
    private final String streetType;

    public Project(String projectId, String projectName, String streetNumber, String streetName, String streetType) {
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
}
