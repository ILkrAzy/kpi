package org.kpi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.kpi.model.Kpi;
import org.kpi.model.ProjectType;
import org.kpi.model.ProjectTypeKpi;
import org.kpi.model.dto.KpiDTO;
import org.kpi.model.dto.ProjectTypeDTO;
import org.kpi.model.dto.UUIDs;
import org.kpi.service.KpiService;
import org.kpi.service.ProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lnphi
 * @since 7/15/2017.
 */
@RestController
@RequestMapping("/api/projecttypes")
public class ProjectTypeController {

    private ProjectTypeService projectTypeService;
    private KpiService kpiService;
    @Autowired
    public ProjectTypeController(ProjectTypeService projectTypeService, KpiService kpiService) {
        this.projectTypeService = projectTypeService;
        this.kpiService = kpiService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody ProjectTypeDTO typeDTO) {
        projectTypeService.add(typeDTO.toModel());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<ProjectTypeDTO> getAll() {
        List<ProjectType> projectTypes = projectTypeService.getAll();
        List<ProjectTypeDTO> projectTypeDTOs = new ArrayList<ProjectTypeDTO>();
        for(ProjectType projectType : projectTypes){
            projectTypeDTOs.add(new ProjectTypeDTO().fromModel(projectType));
        }
        return projectTypeDTOs;
    }

    @GetMapping("/{projectTypeUUID}")
    public ResponseEntity<ProjectTypeDTO> get(@PathVariable String projectTypeUUID) {
        ProjectType type = projectTypeService.getUUID(projectTypeUUID);
        if (type == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(new ProjectTypeDTO().fromModel(type));
    }
    
    @DeleteMapping("/{projectTypeUUID}/kpis")
    public ResponseEntity<Void> remove(@PathVariable String projectTypeUUID, @RequestBody List<String> kpiUUIDs){
        projectTypeService.deAssign(projectTypeUUID, kpiUUIDs);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/assign/{projectTypeUUID}")
    public ResponseEntity<Void> assign(@PathVariable String projectTypeUUID, @RequestBody List<String> kpiUUIDs){
        projectTypeService.assign(projectTypeUUID, kpiUUIDs);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/{projectTypeUUID}/kpis")
    public ResponseEntity<List<KpiDTO>> getKpisfromProjectType(@PathVariable String projectTypeUUID) {
        ProjectType type = projectTypeService.getUUID(projectTypeUUID);
        if (type == null || type.getKpis() == null || type.getKpis().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<KpiDTO> kpiDTOs = new ArrayList<>();
        for(ProjectTypeKpi kpi : type.getKpis()){
            kpiDTOs.add(new KpiDTO().fromModel(kpi.getKpi()));
        }
        return ResponseEntity.ok(kpiDTOs);
    }
}
