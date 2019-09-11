/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sfds.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import sfds.adapter.SocrataAdapter;
import sfds.domain.Project;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = AffordableProjectController.class)
public class ApplicationTest {

    @MockBean
    private SocrataAdapter adapter;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void homePage_shouldIncludeExpectedText() throws Exception {
        mockMvc.perform(get("/index.html"))
                .andExpect(content().string(containsString("Welcome to the Mayor's Office")));
    }

    @Test
    public void getAffordableProjects_shouldIncludeExpectedText() throws Exception {
        Project mockProject = mock(Project.class);
        when(adapter.getAllProjects()).thenReturn(Arrays.asList(mockProject));
        mockMvc.perform(get("/housing"))
                .andExpect(content().string(containsString("Affordable rental housing developed")));
    }

    @Test
    public void getAffordableProjects_shouldIncludeDataInTable() throws Exception {
        Project mockProject = mock(Project.class);
        String projectId = "i am a project id";
        when(mockProject.getProjectId()).thenReturn(projectId);
        when(adapter.getAllProjects()).thenReturn(Arrays.asList(mockProject));
        mockMvc.perform(get("/housing"))
                .andExpect(content().string(containsString(projectId)));
    }

}
