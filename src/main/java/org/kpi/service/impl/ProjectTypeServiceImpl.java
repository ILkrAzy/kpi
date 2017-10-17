package org.kpi.service.impl;

import org.kpi.model.ProjectType;
import org.kpi.repository.ProjectTypeRepository;
import org.kpi.service.ProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lnphi
 * @since 7/18/2017.
 */
@Service
public class ProjectTypeServiceImpl implements ProjectTypeService {

    private ProjectTypeRepository typeRepository;

    @Autowired
    public ProjectTypeServiceImpl(ProjectTypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public void add(ProjectType projectType) {
        typeRepository.save(projectType);
    }

    @Override
    public List<ProjectType> getAll() {
        return (List) typeRepository.findAll();
    }

    @Override
    public ProjectType getByName(String name) {
        return typeRepository.findByName(name);
    }

    @Override
    public ProjectType getUUID(String uuid) {
        return typeRepository.findByUuid(uuid);
    }

}
