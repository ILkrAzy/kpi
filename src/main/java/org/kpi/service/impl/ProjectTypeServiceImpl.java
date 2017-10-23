package org.kpi.service.impl;

import java.util.List;

import org.kpi.model.Kpi;
import org.kpi.model.ProjectType;
import org.kpi.model.ProjectTypeKpi;
import org.kpi.repository.KpiRepository;
import org.kpi.repository.ProjectTypeKpiRepository;
import org.kpi.repository.ProjectTypeRepository;
import org.kpi.service.ProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lnphi
 * @since 7/18/2017.
 */
@Service
public class ProjectTypeServiceImpl implements ProjectTypeService {

    private ProjectTypeRepository typeRepository;
    private KpiRepository kpiRepository;
    private ProjectTypeKpiRepository typeKpiRepository;
    
    @Autowired
    public ProjectTypeServiceImpl(ProjectTypeRepository typeRepository, KpiRepository kpiRepository, ProjectTypeKpiRepository typeKpiRepository) {
        this.typeRepository = typeRepository;
        this.kpiRepository = kpiRepository;
        this.typeKpiRepository = typeKpiRepository;
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

    @Override
    public void assign(String projectTypeUUID, List<String> kpiUUIDs) {
        ProjectType projectType = typeRepository.findByUuid(projectTypeUUID);
        if(projectType == null){
            throw new IllegalArgumentException("Project Type with uuid " + projectTypeUUID + " does not exist");
        }
        for(String uuid : kpiUUIDs){
            Kpi kpi = kpiRepository.findByUuid(uuid);
            if(kpi == null){
                throw new IllegalArgumentException("Kpi with uuid " + uuid + " does not exist");
            }
            ProjectTypeKpi projectTypeKpi = new ProjectTypeKpi(projectType, kpi);
            typeKpiRepository.save(projectTypeKpi);
        }
    }

    @Override
    public void deAssign(String projectTypeUUID, List<String> kpiUUIDs) {
        ProjectType projectType = typeRepository.findByUuid(projectTypeUUID);
        if(projectType == null){
            throw new IllegalArgumentException("Project Type with uuid " + projectTypeUUID + " does not exist");
        }
        for(String uuid : kpiUUIDs){
            Kpi kpi = kpiRepository.findByUuid(uuid);
            if(kpi == null){
                throw new IllegalArgumentException("Kpi with uuid " + uuid + " does not exist");
            }
            ProjectTypeKpi typeKpi = typeKpiRepository.findByProjectTypeAndKpi(projectType, kpi);
            typeKpiRepository.delete(typeKpi);
        }
    }

}
