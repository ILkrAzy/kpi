package org.kpi.repository;

import org.kpi.model.Kpi;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vquochuy on 7/21/2017.
 */
public interface KpiRepository extends CrudRepository<Kpi, Integer> {
    Kpi findByUuid(String uuid);
}
