package org.kpi.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpi.model.ProjectType;
import org.kpi.repository.KpiRepository;
import org.kpi.repository.ProjectTypeKpiRepository;
import org.kpi.repository.ProjectTypeRepository;
import org.kpi.service.ProjectTypeService;
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
public class ProjectTypeServiceImplTest {

    @Mock
    private ProjectTypeRepository projectTypeRepository;
    @Mock
    private ProjectTypeKpiRepository projectTypeKpiRepository;
    @Mock
    private KpiRepository kpiRepository;

    private ProjectTypeService service;

    @Before
    public void setUp() throws Exception {
        service = new ProjectTypeServiceImpl(projectTypeRepository, kpiRepository, projectTypeKpiRepository);
    }

    @Test
    public void addProjectType() throws Exception {
        ProjectType type = new ProjectType();
        type.setName("helloworld");
        service.add(type);
        verify(projectTypeRepository, Mockito.times(1)).save(type);
    }

    @Test
    public void getProjectTypes() throws Exception {
        List<ProjectType> types = new ArrayList<>();
        types.add(new ProjectType());
        types.add(new ProjectType());
        when(projectTypeRepository.findAll()).thenReturn(types);
        assertThat(service.getAll(), equalTo(types));
    }

    @Test
    public void getProjectType() throws Exception {
        ProjectType type = new ProjectType();
        type.setName("helloworld");
        when(projectTypeRepository.findByName(type.getName())).thenReturn(type);
        assertThat(service.getByName(type.getName()), equalTo(type));
    }
}
