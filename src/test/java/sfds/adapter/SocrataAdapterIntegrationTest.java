package sfds.adapter;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;
import sfds.domain.Project;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class SocrataAdapterIntegrationTest {
    private RestTemplate restTemplate;

    private SocrataAdapter adapter;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        adapter = new SocrataAdapter(restTemplate);
    }

    @Ignore
    @Test
    public void getAllProjects_shouldReturnOneProject() {
        List<Project> actual = adapter.getAllProjects();

        System.out.print(actual);

        assertThat(actual.get(0).getProjectId(), is("1969-001"));
        assertThat(actual.get(0).getProjectName(), is("Martin Luther King-Marcus Garvey Square Cooperative Apartments"));
        assertThat(actual.get(0).getStreetNumber(), is("1680"));
        assertThat(actual.get(0).getStreetName(), is("Eddy"));
        assertThat(actual.get(0).getStreetType(), is("St"));
    }
    @Ignore
    @Test
    public void getAllProjects_shouldReturnListOfTwoProjects() {
        Project project1 = new Project(
                "1969-001",
                "Martin Luther King-Marcus Garvey Square Cooperative Apartments",
                "1680",
                "Eddy",
                "St"
        );

        Project project2 = new Project(
                "1970-001",
                "Ridgeview Terrace Apartments",
                "140",
                "Cashmere",
                "St"
        );

        List<Project> actual = adapter.getAllProjects();


        assertThat(actual.get(0), is(project1));
        assertThat(actual.get(1), is(project2));

        assertThat(actual.get(0).getProjectId(), is("1969-001"));
        assertThat(actual.get(0).getProjectName(), is("Martin Luther King-Marcus Garvey Square Cooperative Apartments"));
        assertThat(actual.get(0).getStreetNumber(), is("1680"));
        assertThat(actual.get(0).getStreetName(), is("Eddy"));
        assertThat(actual.get(0).getStreetType(), is("St"));

        assertThat(actual.get(1).getProjectId(), is("1970-001"));
        assertThat(actual.get(1).getProjectName(), is("Ridgeview Terrace Apartments"));
        assertThat(actual.get(1).getStreetNumber(), is("140"));
        assertThat(actual.get(1).getStreetName(), is("Cashmere"));
        assertThat(actual.get(1).getStreetType(), is("St"));
    }

    //    TODO: Add tests to drive error handling
}