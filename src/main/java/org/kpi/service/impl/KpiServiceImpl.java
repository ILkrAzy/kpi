package org.kpi.service.impl;

import java.util.Collections;
import java.util.List;

import org.kpi.model.Kpi;
import org.kpi.repository.KpiRepository;
import org.kpi.service.KpiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vquochuy on 7/21/2017.
 */
@Service
public class KpiServiceImpl implements KpiService {
    
    private KpiRepository kpiRepository;

    @Autowired
    public KpiServiceImpl(KpiRepository kpiRepository) {
        this.kpiRepository = kpiRepository;
    }

    @Override
    public void save(Kpi kpi) {
        kpiRepository.save(kpi);
    }

    @Override
    public Kpi getKpiByUUID(String uuid) {
        Kpi kpi = kpiRepository.findByUuid(uuid);
        if(kpi == null){
            throw new IllegalArgumentException("Kpi with name " + uuid + " does not exist");
        }
        return kpi;
    }

    @Override
    public List<Kpi> getAll() {
        List<Kpi> kpis = (List<Kpi>) kpiRepository.findAll();
        return kpis == null ? Collections.emptyList() : kpis;
    }
}