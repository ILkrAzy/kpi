package org.kpi.controller;

import org.kpi.model.ProjectType;
import org.kpi.model.dto.ProjectTypeDTO;
import org.kpi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author lnphi
 * @since 7/15/2017.
 */
@RestController
@RequestMapping("/api/projecttypes")
public class ProjectTypeController {

    private ProjectService projectService;

    @Autowired
    public ProjectTypeController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody ProjectTypeDTO typeDTO) {
        projectService.addProjectType(typeDTO.toModel());
        return ResponseEntity.ok(null);
    }

    @GetMapping
    public List<ProjectType> getAll() {
        return projectService.getProjectTypes();
    }

    @GetMapping("/{name}")
    public ProjectType get(@PathVariable String name) {
        return projectService.getProjectType(name);
    }
}
