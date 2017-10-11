package org.kpi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.kpi.model.ProjectType;
import org.kpi.model.dto.ProjectTypeDTO;
import org.kpi.service.ProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
}
