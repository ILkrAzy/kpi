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
    
    ProjectType getUUID(String uuid);
    
    void assign(String projectTypeUUID, List<String> kpiUUIDs);
    
    void deAssign(String projectTypeUUID, List<String> kpiUUIDs);
}
