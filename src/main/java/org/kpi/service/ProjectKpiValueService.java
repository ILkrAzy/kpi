package org.kpi.service;

import java.util.List;

import org.kpi.model.ProjectKpiValue;
/**
 * 
 * @author vquochuy
 * @since 9/20/2017
 */
public interface ProjectKpiValueService {
    void save(ProjectKpiValue projectKpiValue);
    List<ProjectKpiValue> getListKpiValueByMonth(int projectId, int month);
}
