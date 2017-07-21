package org.kpi.service.impl;

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
    
    @Autowired
    private KpiRepository kpiRepository;

    @Override
    public void save(Kpi kpi) {
        kpiRepository.save(kpi);
    }

    @Override
    public Kpi getKpiByName(String name) {
        return kpiRepository.findByName(name);
    }

    @Override
    public Kpi getKpiByUUID(String uuid) {
        return kpiRepository.findByUuid(uuid);
    }
}
