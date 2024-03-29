package sfds.adapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;
import sfds.domain.Project;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SocrataAdapterTest {
    private static final String GET_PROJECTS_URL = "/resource/9rdx-httc.json";

    private RestTemplate restTemplate;

    private SocrataAdapter adapter;

    @Before
    public void setUp() {
        restTemplate = mock(RestTemplate.class);
        adapter = new SocrataAdapter(restTemplate);
    }

    private final String expectedProjectId = "project id";
    private final String expectedProjectName = "project name";
    private final String expectedStreetNumber = "street number";
    private final String expectedStreetName = "street name";
    private final String expectedStreetType = "street type";

    @Test
    public void getAllProjects_shouldReturnOneProject() {
        Project expectedProjectResponse = new Project(expectedProjectId, expectedProjectName, expectedStreetNumber, expectedStreetName, expectedStreetType);
        Project[] projectArray = {expectedProjectResponse};

        when(restTemplate.getForObject(GET_PROJECTS_URL, Project[].class)).thenReturn(projectArray);

        List<Project> actual = adapter.getAllProjects();

        assertThat(actual.get(0).getProjectId(), is(expectedProjectId));
        assertThat(actual.get(0).getProjectName(), is(expectedProjectName));
        assertThat(actual.get(0).getStreetNumber(), is(expectedStreetNumber));
        assertThat(actual.get(0).getStreetName(), is(expectedStreetName));
        assertThat(actual.get(0).getStreetType(), is(expectedStreetType));
    }

    @Test
    public void getAllProjects_shouldReturnListOfTwoProjects() {
////        TODO: only tested 1 different value between expectedProjectResponse1 and
////        expectedProjectResponse2. Would want to make all values different (maybe by
////        adding a testing helper) to make sure we mapped all values correctly

        String expectedProjectId2 = "project id 2";
        Project expectedProjectResponse1 = new Project(expectedProjectId, expectedProjectName, expectedStreetNumber, expectedStreetName, expectedStreetType);
        Project expectedProjectResponse2 = new Project(expectedProjectId2,
                expectedProjectName, expectedStreetNumber, expectedStreetName, expectedStreetType);

        Project[] projectArray = {expectedProjectResponse1, expectedProjectResponse2};

        when(restTemplate.getForObject(GET_PROJECTS_URL, Project[].class)).thenReturn(projectArray);

        List<Project> actual = adapter.getAllProjects();

        assertThat(actual.get(0).getProjectId(), is(expectedProjectId));
        assertThat(actual.get(0).getProjectName(), is(expectedProjectName));
        assertThat(actual.get(0).getStreetNumber(), is(expectedStreetNumber));
        assertThat(actual.get(0).getStreetName(), is(expectedStreetName));
        assertThat(actual.get(0).getStreetType(), is(expectedStreetType));

        assertThat(actual.get(1).getProjectId(), is(expectedProjectId2));
        assertThat(actual.get(1).getProjectName(), is(expectedProjectName));
        assertThat(actual.get(1).getStreetNumber(), is(expectedStreetNumber));
        assertThat(actual.get(1).getStreetName(), is(expectedStreetName));
        assertThat(actual.get(1).getStreetType(), is(expectedStreetType));
    }

    //    TODO: Add tests to drive error handling
}