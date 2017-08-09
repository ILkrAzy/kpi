package org.kpi.service;

import org.kpi.model.ProjectType;

import java.util.List;

/**
 * @author lnphi
 * @since 7/18/2017.
 */
public interface ProjectTypeService {
    void add(ProjectType projectType);

    List<ProjectType> getAll();

    ProjectType getByName(String name);
    
    void assign(String projectTypeName, List<String> kpiUUIDs);
}
