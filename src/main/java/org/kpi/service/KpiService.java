package org.kpi.service;

import java.util.List;

import org.kpi.model.Kpi;
import org.kpi.model.dto.KpiDTO;

/**
 * Created by vquochuy on 7/21/2017.
 */
public interface KpiService {
    void save(Kpi kpi);

    Kpi getKpiByUUID(String uuid);

    List<Kpi> getAll();
    
    void update(List<KpiDTO> kpiDTOs);
    
    List<Kpi> getKpisNotAsociationWithProjectType();
}
