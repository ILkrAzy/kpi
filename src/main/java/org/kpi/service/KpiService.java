package org.kpi.service;

import org.kpi.model.Kpi;

/**
 * Created by vquochuy on 7/21/2017.
 */
public interface KpiService {
    void save(Kpi kpi);
    Kpi getKpiByName(String name);
    Kpi getKpiByUUID(String uuid);
}
