package org.kpi.service;

import java.util.List;

import org.kpi.model.Kpi;
import org.kpi.model.ProjectType;

/**
 * @author lnphi
 * @since 7/18/2017.
 */
public interface ProjectTypeService {
    void add(ProjectType projectType);

    List<ProjectType> getAll();

    ProjectType getByName(String name);
    
    void assign(String projectTypeName, List<String> kpiUUIDs);
    
    List<Kpi> getKpisByProjectName(String name);
}
