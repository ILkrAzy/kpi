package org.kpi.controller;

import org.kpi.model.Project;
import org.kpi.model.ProjectType;
import org.kpi.model.dto.ProjectDTO;
import org.kpi.service.ProjectService;
import org.kpi.service.ProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author vquochuy
 * @since 7/17/2017
 */
@RestController
@RequestMapping(value="/api/projects")
public class ProjectController {
    private ProjectService projectService;

    private ProjectTypeService projectTypeService;

    @Autowired
    public ProjectController(ProjectService projectService, ProjectTypeService projectTypeService) {
        this.projectTypeService = projectTypeService;
        this.projectService = projectService;
    }
    
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody ProjectDTO projectDTO) {
        Project project = projectDTO.toModel();
        ProjectType projectType = projectTypeService.getByName(projectDTO.getProjectType());
        project.setType(projectType);
        projectService.addProject(project);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<ProjectDTO> getAll() {
        List<ProjectDTO> projectDTOs = new ArrayList<>();
        List<Project> projects = projectService.getProjects();
        for(Project p : projects){
            projectDTOs.add(ProjectDTO.fromProject(p));
        }
        return projectDTOs;
    }
}
