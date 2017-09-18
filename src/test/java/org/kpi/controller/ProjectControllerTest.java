package org.kpi.controller;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpi.model.Project;
import org.kpi.model.dto.ProjectDTO;
import org.kpi.service.ProjectService;
import org.kpi.service.ProjectTypeService;
import org.kpi.service.UserService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

/**
 * Created by vquochuy on 7/18/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProjectControllerTest {
    @Mock
    private ProjectService projectService;
    @Mock
    private ProjectTypeService projectTypeService;
    @Mock
    private UserService userService;
    private ProjectController projectController;

    private final static String NAME_PROJECT= "KPI PROJECT";

    @Before
    public void setUp() throws Exception {
        projectController = new ProjectController(projectService, projectTypeService, userService);
    }

    @Test
    public void create() throws Exception {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName(NAME_PROJECT);
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
    
    @Test
    public void get() throws Exception {
        Project project = mock(Project.class);
        when(projectService.getProject(NAME_PROJECT)).thenReturn(project);
        ProjectDTO projectDTO = ProjectDTO.fromProject(project);
        assertThat(projectController.get(NAME_PROJECT), equalTo(ResponseEntity.ok(projectDTO)));
    }

    @Test
    public void getReturn404WhenProjectNotFound() throws Exception {
        when(projectService.getProject(NAME_PROJECT)).thenReturn(null);
        assertThat(projectController.get(NAME_PROJECT), equalTo(ResponseEntity.notFound().build()));
    }
}
