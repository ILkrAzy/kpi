package org.kpi.controller;

import org.kpi.model.ProjectType;
import org.kpi.model.dto.ProjectTypeDTO;
import org.kpi.service.ProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lnphi
 * @since 7/15/2017.
 */
@RestController
@RequestMapping("/api/projecttypes")
public class ProjectTypeController {

    private ProjectTypeService projectTypeService;

    @Autowired
    public ProjectTypeController(ProjectTypeService projectTypeService) {
        this.projectTypeService = projectTypeService;
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody ProjectTypeDTO typeDTO) {
        projectTypeService.add(typeDTO.toModel());
        return ResponseEntity.ok(null);
    }

    @GetMapping
    public List<ProjectTypeDTO> getAll() {
        List<ProjectTypeDTO> list = new ArrayList<>();
        for(ProjectType projectType : projectTypeService.getAll()){
            ProjectTypeDTO projectTypeDTO = new ProjectTypeDTO();
            list.add(projectTypeDTO.fromModel(projectType));
        }
        return list;
    }

    @GetMapping("/{name}")
    public ResponseEntity<ProjectTypeDTO> get(@PathVariable String name) {
        ProjectType type = projectTypeService.getByName(name);
        if (type == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ProjectTypeDTO projectTypeDTO = new ProjectTypeDTO();
        return ResponseEntity.ok(projectTypeDTO.fromModel(type));
    }
    
    @PutMapping("/assign/{name}")
    public void assign(@PathVariable String name, @RequestBody List<String> kpiUUIDs){
        projectTypeService.assign(name, kpiUUIDs);
    }
}
