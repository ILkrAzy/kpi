package org.kpi.service.impl;

import org.kpi.model.ProjectType;
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

    @Autowired
    public ProjectServiceImpl(ProjectTypeRepository typeRepository) {
        this.typeRepository = typeRepository;
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
}
