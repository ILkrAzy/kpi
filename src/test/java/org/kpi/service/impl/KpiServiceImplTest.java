/**
 * 
 */
package org.kpi.service.impl;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpi.model.Kpi;
import org.kpi.repository.KpiRepository;
import org.kpi.service.KpiService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by vquochuy on 7/22/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class KpiServiceImplTest {
    
    @Mock
    private KpiRepository kpiRepository;
    
    private KpiService kpiService;
    
    private Kpi defect = new Kpi();
    private Kpi people = new Kpi();
    private List<Kpi> kpis = new ArrayList<>();
    @Before
    public void setUp(){
        kpiService = new KpiServiceImpl(kpiRepository);
        defect.setId(1);
        defect.setMeasure("Defect");
        defect.setName("Number of Defect");
        defect.setUuid("171a1372-9718-495b-ad39-73b55d3993a2");
        
        people.setId(2);
        people.setName("Number of People");
        people.setMeasure("People");
        people.setUuid("171a1372-9718-495b-ad39-73b55d3993a3");
        
        kpis.add(defect);
        kpis.add(people);
    }
    
    @Test
    public void create(){
        kpiService.save(defect);
        verify(kpiRepository, Mockito.times(1)).save(defect);
    }
    
    @Test
    public void getAll(){
        when(kpiRepository.findAll()).thenReturn(kpis);
        assertThat(kpiService.getAll(), equalTo(kpis));
    }
    
    @Test
    public void getAllShouldReturnEmptyList(){
        when(kpiRepository.findAll()).thenReturn(null);
        assertThat(kpiService.getAll(), equalTo(Collections.emptyList()));
    }
    
    @Test
    public void getKpiByUUID() {
        when(kpiRepository.findByUuid("171a1372-9718-495b-ad39-73b55d3993a2")).thenReturn(defect);
        assertThat(kpiService.getKpiByUUID("171a1372-9718-495b-ad39-73b55d3993a2"), equalTo(defect));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void findByUUIDShouldThrowExceptionWhenUUIDDoesNotExist() throws Exception {
        String uuid = "171a1372-9718-495b-ad39-73b55d3993a4";
        when(kpiRepository.findByUuid(uuid)).thenReturn(null);
        kpiService.getKpiByUUID(uuid);
    }
}
