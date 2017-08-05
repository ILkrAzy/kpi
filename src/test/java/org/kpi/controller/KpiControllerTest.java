package org.kpi.controller;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpi.model.Kpi;
import org.kpi.model.dto.KpiDTO;
import org.kpi.service.KpiService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

/**
 * Created by vquochuy on 7/22/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class KpiControllerTest {
    @Mock
    private KpiService kpiService;
    private KpiController kpiController;
    
    @Before
    public void setUp(){
        kpiController = new KpiController(kpiService);
    }
    
    @Test
    public void create(){
        KpiDTO defectDTO = new KpiDTO();
        defectDTO.setMeasure("Defect");
        defectDTO.setName("Number of Defect");
        kpiController.createKpi(defectDTO);
        verify(kpiService, Mockito.times(1)).save(defectDTO.toModel());
    }
    
    @Test
    public void getAll(){
        List<Kpi> kpis = new ArrayList<>();
        Kpi defect = new Kpi();
        defect.setMeasure("Defect");
        defect.setName("Number of Defects");
        Kpi people = new Kpi();
        people.setMeasure("People");
        people.setName("Number of People");
        
        when(kpiService.getAll()).thenReturn(kpis);
        List<KpiDTO> kpiDTOs = new ArrayList<>();
        for(Kpi kpi : kpis){
            KpiDTO kpiDTO = new KpiDTO();
            kpiDTOs.add(kpiDTO.fromModel(kpi));
        }
        assertThat(kpiController.getAll(), equalTo(kpiDTOs));
    }
    
    @Test
    public void getKpiByUUID(){
        Kpi defect = new Kpi();
        defect.setMeasure("Defect");
        defect.setName("Number of Defects");
        defect.setUuid("171a1372-9718-495b-ad39-73b55d3993a2");
        when(kpiService.getKpiByUUID("171a1372-9718-495b-ad39-73b55d3993a2")).thenReturn(defect);
        KpiDTO defectDTO = new KpiDTO();
        defectDTO.fromModel(defect);
        assertThat(kpiController.getKpiByUUID("171a1372-9718-495b-ad39-73b55d3993a2"), equalTo(ResponseEntity.ok(defectDTO)));
    }
    
    @Test
    public void update(){
        List<KpiDTO> kpiDTOs = new ArrayList<>();
        List<Kpi> kpis = new ArrayList<>();
        Kpi defect = new Kpi();
        defect.setUuid("171a1372-9718-495b-ad39-73b55d3993a2");
        defect.setMeasure("Defect");
        defect.setName("Number of Defects");
        Kpi people = new Kpi();
        people.setUuid("171a1372-9718-495b-ad39-73b55d3993a1");
        people.setMeasure("People");
        people.setName("Number of People");
        kpis.add(people);
        kpis.add(defect);
        
        when(kpiService.getAll()).thenReturn(kpis);
        for(Kpi kpi : kpis){
            KpiDTO kpiDTO = new KpiDTO();
            kpiDTOs.add(kpiDTO.fromModel(kpi));
        }
        
        int i = 1;
        for(KpiDTO kpiDTO : kpiDTOs){
            kpiDTO.setMeasure("Defect" + i);
            kpiDTO.setName("Number of Defect" + i);
            i++;
        }
        
        kpiController.update(kpiDTOs);
        verify(kpiService, Mockito.times(1)).update(kpiDTOs);
    }
}
