package org.kpi.service;

import org.kpi.model.Project;

import java.util.List;

/**
 * @author lnphi
 * @since 7/14/2017.
 */
public interface ProjectService {
    void addProject(Project project);
    
    List<Project> getProjects();
    
    Project getProject(String name);
}
