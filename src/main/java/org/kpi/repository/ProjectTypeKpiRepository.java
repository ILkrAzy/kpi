package org.kpi.repository;

import org.kpi.model.Kpi;
import org.kpi.model.ProjectType;
import org.kpi.model.ProjectTypeKpi;
import org.springframework.data.repository.CrudRepository;

public interface ProjectTypeKpiRepository extends CrudRepository<ProjectTypeKpi, Integer>{
    ProjectTypeKpi findByProjectTypeAndKpi(ProjectType projectType, Kpi kpi);
}
