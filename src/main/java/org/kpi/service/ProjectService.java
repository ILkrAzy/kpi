package org.kpi.service;

import java.util.List;

import org.kpi.model.Project;
import org.kpi.model.ProjectType;

/**
 * @author lnphi
 * @since 7/14/2017.
 */
public interface ProjectService {
    void addProjectType(ProjectType projectType);

    List<ProjectType> getProjectTypes();

    ProjectType getProjectType(String name);
    
    void addProject(Project project);
    
    List<Project> getProjects();
    
    Project getProject(String name);
}
