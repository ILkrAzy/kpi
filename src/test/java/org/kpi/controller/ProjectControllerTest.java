package org.kpi.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpi.model.Project;
import org.kpi.model.ProjectType;
import org.kpi.model.dto.ProjectDTO;
import org.kpi.service.ProjectService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vquochuy on 7/18/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProjectControllerTest {
    @Mock
    private ProjectService projectService;
    @Mock
    private ProjectDTO projectDTO;
    private ProjectController projectController;

    @Before
    public void setUp() throws Exception {
        projectController = new ProjectController(projectService);
    }

    @Test
    public void create() throws Exception {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName("Vital QIP");
        projectController.create(projectDTO);
        verify(projectService, Mockito.times(1)).addProject(projectDTO.toModel());
    }

    @Test
    public void getAll() throws Exception {
        List<Project> projects = new ArrayList<>();
        projects.add(mock(Project.class));
        projects.add(mock(Project.class));
        when(projectService.getProjects()).thenReturn(projects);
        List<ProjectDTO> projectDTOs = new ArrayList<>();
        projectDTOs = ProjectDTO.toList(projects);
        assertThat(projectController.getAll(), equalTo(projectDTOs));
    }

}
