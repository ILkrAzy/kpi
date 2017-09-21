package org.kpi.service.impl;

import org.kpi.model.Project;
import org.kpi.repository.ProjectRepository;
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

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
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

    @Override
    public Project getKpiByUUID(String uuid) {
        Project project = projectRepository.findByUuid(uuid);
        if(project == null){
            throw new IllegalArgumentException("Project with uuid " + uuid + " does not exist");
        }
        return project;
    }
}
