package org.kpi.service.impl;

import org.kpi.model.Project;
import org.kpi.model.ProjectType;
import org.kpi.repository.ProjectRepository;
import org.kpi.repository.ProjectTypeRepository;
import org.kpi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lnphi
 * @since 7/15/2017.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectTypeRepository typeRepository;
    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectTypeRepository typeRepository, ProjectRepository projectRepository) {
        this.typeRepository = typeRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public void addProjectType(ProjectType projectType) {
        typeRepository.save(projectType);
    }

    @Override
    public List<ProjectType> getProjectTypes() {
        return (List)typeRepository.findAll();
    }

    @Override
    public ProjectType getProjectType(String name) {
        return typeRepository.findByName(name);
    }

    @Override
    public void addProject(Project project) {
        projectRepository.save(project);
        
    }

    @Override
    public List<Project> getProjects() {
        return (List<Project>) projectRepository.findAll();
    }

    @Override
    public Project getProject(String name) {
        return projectRepository.findByName(name);
    }
}
