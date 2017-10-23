package org.kpi.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.kpi.model.Kpi;
import org.kpi.model.ProjectTypeKpi;
import org.kpi.model.dto.KpiDTO;
import org.kpi.repository.KpiRepository;
import org.kpi.repository.ProjectTypeKpiRepository;
import org.kpi.service.KpiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vquochuy on 7/21/2017.
 */
@Service
public class KpiServiceImpl implements KpiService {
    
    private KpiRepository kpiRepository;
    private ProjectTypeKpiRepository typeKpiRepository;
    
    @Autowired
    public KpiServiceImpl(KpiRepository kpiRepository, ProjectTypeKpiRepository typeKpiRepository) {
        this.kpiRepository = kpiRepository;
        this.typeKpiRepository =  typeKpiRepository;
    }

    @Override
    public void save(Kpi kpi) {
        kpiRepository.save(kpi);
    }

    @Override
    public Kpi getKpiByUUID(String uuid) {
        Kpi kpi = kpiRepository.findByUuid(uuid);
        if(kpi == null){
            throw new IllegalArgumentException("Kpi with uuid " + uuid + " does not exist");
        }
        return kpi;
    }

    @Override
    public List<Kpi> getAll() {
        List<Kpi> kpis = (List<Kpi>) kpiRepository.findAll();
        return kpis == null ? Collections.emptyList() : kpis;
    }

    @Override
    public void update(List<KpiDTO> kpiDTOs) {
        List<Kpi> kpis = new ArrayList<>();
        for(KpiDTO kpiDTO : kpiDTOs){
           Kpi kpi =  kpiRepository.findByUuid(kpiDTO.getUuid());
           if(kpi != null){
               updateModel(kpi, kpiDTO);
               kpis.add(kpi);
           }
        }
        kpiRepository.save(kpis);
    }
    
    private void updateModel(Kpi kpi, KpiDTO kpiDTO){
        kpi.setMeasure(kpiDTO.getMeasure());
        kpi.setName(kpiDTO.getName());
    }

    @Override
    public List<Kpi> getKpisNotAsociationWithProjectType() {
        List<Kpi> kpis = (List<Kpi>) kpiRepository.findAll();
        List<ProjectTypeKpi> projectTypeKpis = (List<ProjectTypeKpi>) typeKpiRepository.findAll();
        List<Kpi> kpi2s = new ArrayList<>();
        for(ProjectTypeKpi type : projectTypeKpis){
            kpi2s.add(type.getKpi());
        }
        List<Kpi> kpi3s = new ArrayList<>(kpis);
        kpi3s.removeAll(kpi2s);
        return kpi3s;
    }
}
