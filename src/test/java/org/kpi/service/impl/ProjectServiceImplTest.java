package org.kpi.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpi.model.Project;
import org.kpi.repository.ProjectRepository;
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
public class ProjectServiceImplTest {
    @Mock
    private ProjectRepository projectRepository;
    private ProjectService projectService;

    @Before
    public void setUp() throws Exception {
        projectService = new ProjectServiceImpl(projectRepository);
    }

    @Test
    public void create() throws Exception{
        Project project = new Project();
        project.setName("Vital QIP");
        projectService.addProject(project);
        verify(projectRepository, Mockito.times(1)).save(project);
    }

    @Test
    public  void getAll() throws Exception{
        List<Project> projectList = new ArrayList<>();
        projectList.add(mock(Project.class));
        projectList.add(mock(Project.class));
        when(projectRepository.findAll()).thenReturn(projectList);
        assertThat(projectService.getProjects(), equalTo(projectList));
    }
}
