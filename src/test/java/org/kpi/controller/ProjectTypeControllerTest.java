package org.kpi.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpi.model.ProjectType;
import org.kpi.model.dto.ProjectTypeDTO;
import org.kpi.service.ProjectTypeService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

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
    private ProjectTypeService projectTypeService;

    private ProjectTypeController controller;

    @Before
    public void setUp() throws Exception {
        controller = new ProjectTypeController(projectTypeService);
    }

    @Test
    public void create() throws Exception {
        ProjectTypeDTO typeDTO = new ProjectTypeDTO();
        typeDTO.setName("hellos");
        controller.create(typeDTO);
        verify(projectTypeService, Mockito.times(1)).add(typeDTO.toModel());
    }

    @Test
    public void getAll() throws Exception {
        List<ProjectType> types = new ArrayList<>();
        types.add(new ProjectType());
        types.add(new ProjectType());
        when(projectTypeService.getAll()).thenReturn(types);
        List<ProjectTypeDTO> proTypeDTOs = new ArrayList<>();
        for(ProjectType type : types){
            proTypeDTOs.add(new ProjectTypeDTO(type));
        }
        assertThat(controller.getAll(), equalTo(proTypeDTOs));
    }

    @Test
    public void get() throws Exception {
        ProjectType type = new ProjectType();
        type.setName("hello");
        when(projectTypeService.getByName(type.getName())).thenReturn(type);
        ProjectTypeDTO typeDTO = new ProjectTypeDTO(type);
        assertThat(controller.get(type.getName()), equalTo(ResponseEntity.ok(typeDTO)));
    }

    @Test
    public void getShouldReturn404WhenProjectTypeDoesNotExist() throws Exception {
        ProjectType type = new ProjectType();
        type.setName("hello");
        when(projectTypeService.getByName(type.getName())).thenReturn(null);
        assertThat(controller.get(type.getName()), equalTo(ResponseEntity.notFound().build()));
    }
}
