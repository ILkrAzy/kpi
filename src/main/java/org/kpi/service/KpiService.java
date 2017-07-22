package org.kpi.service;

import java.util.List;

import org.kpi.model.Kpi;

/**
 * Created by vquochuy on 7/21/2017.
 */
public interface KpiService {
    void save(Kpi kpi);

    Kpi getKpiByUUID(String uuid);

    List<Kpi> getAll();
}
