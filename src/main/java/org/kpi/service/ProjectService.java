package org.kpi.service;

import org.kpi.model.ProjectType;

import java.util.List;

/**
 * @author lnphi
 * @since 7/14/2017.
 */
public interface ProjectService {
    void addProjectType(ProjectType projectType);

    List<ProjectType> getProjectTypes();

    ProjectType getProjectType(String name);
}
