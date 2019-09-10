package sfds.adapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;
import sfds.domain.Project;

import java.util.Arrays;
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
    public void getAllProjects_shouldReturnListOfProjects() {
        ProjectResponse expectedProjectResponse = new ProjectResponse(expectedProjectId, expectedProjectName, expectedStreetNumber, expectedStreetName, expectedStreetType);
        AllProjectsResponse expectedAllProjectsResponse = new AllProjectsResponse(Arrays.asList(expectedProjectResponse));

        when(restTemplate.getForObject(GET_PROJECTS_URL, AllProjectsResponse.class)).thenReturn(expectedAllProjectsResponse);

        List<Project> actual = adapter.getAllProjects();

        assertThat(actual.get(0).getProjectId(), is(expectedProjectId));
        assertThat(actual.get(0).getProjectName(), is(expectedProjectName));
        assertThat(actual.get(0).getStreetNumber(), is(expectedStreetNumber));
        assertThat(actual.get(0).getStreetName(), is(expectedStreetName));
        assertThat(actual.get(0).getStreetType(), is(expectedStreetType));
    }
}