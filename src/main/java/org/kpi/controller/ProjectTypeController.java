package org.kpi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.kpi.model.Kpi;
import org.kpi.model.ProjectType;
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


    @GetMapping("/{name}")
    public ResponseEntity<ProjectType> get(@PathVariable String name) {
        ProjectType type = projectTypeService.getByName(name);
        if (type == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(type);
    }
    @DeleteMapping("/{projectTypUUID}/kpis")
    public ResponseEntity<Void> remove(@PathVariable String projectTypeUUID, @RequestBody UUIDs uuid){
        ProjectType type = projectTypeService.getUUID(projectTypeUUID);
        for(String id : uuid.getUuids()){
            Kpi kpi = kpiService.getKpiByUUID(id);
            type.removeKpi(kpi);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/assign/{name}")
    public ResponseEntity<Void> assign(@PathVariable String name, @RequestBody List<String> kpiUUIDs){
        projectTypeService.assign(name, kpiUUIDs);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
