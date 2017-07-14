package org.kpi.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpi.model.ProjectType;
import org.kpi.repository.ProjectTypeRepository;
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
public class ProjectServiceImplTest {

    @Mock
    private ProjectTypeRepository projectTypeRepository;

    private ProjectService service;

    @Before
    public void setUp() throws Exception {
        service = new ProjectServiceImpl(projectTypeRepository);
    }

    @Test
    public void addProjectType() throws Exception {
        ProjectType type = new ProjectType();
        type.setName("helloworld");
        service.addProjectType(type);
        verify(projectTypeRepository, Mockito.times(1)).save(type);
    }

    @Test
    public void getProjectTypes() throws Exception {
        List<ProjectType> types = new ArrayList<>();
        types.add(new ProjectType());
        types.add(new ProjectType());
        when(projectTypeRepository.findAll()).thenReturn(types);
        assertThat(service.getProjectTypes(), equalTo(types));
    }

    @Test
    public void getProjectType() throws Exception {
        ProjectType type = new ProjectType();
        type.setName("helloworld");
        when(projectTypeRepository.findByName(type.getName())).thenReturn(type);
        assertThat(service.getProjectType(type.getName()), equalTo(type));
    }
}
