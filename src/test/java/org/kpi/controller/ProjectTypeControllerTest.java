package org.kpi.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpi.model.ProjectType;
import org.kpi.model.dto.ProjectTypeDTO;
import org.kpi.service.ProjectService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author lnphi
 * @since 7/14/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProjectTypeControllerTest {

    @Mock
    private ProjectService projectService;

    private ProjectTypeController controller;

    @Before
    public void setUp() throws Exception {
        controller = new ProjectTypeController(projectService);
    }

    @Test
    public void create() throws Exception {
        ProjectTypeDTO typeDTO = new ProjectTypeDTO();
        typeDTO.setName("hellos");
        controller.create(typeDTO);
        verify(projectService, Mockito.times(1)).addProjectType(typeDTO.toModel());
    }

    @Test
    public void getAll() throws Exception {
        List<ProjectType> types = new ArrayList<>();
        types.add(new ProjectType());
        types.add(new ProjectType());
        when(projectService.getProjectTypes()).thenReturn(types);
        assertThat(controller.getAll(), equalTo(types));
    }

    @Test
    public void get() throws Exception {
        ProjectType type = new ProjectType();
        type.setName("hello");
        when(projectService.getProjectType(type.getName())).thenReturn(type);
        assertThat(controller.get(type.getName()), equalTo(type));
    }
}