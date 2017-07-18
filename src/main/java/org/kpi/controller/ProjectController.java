package org.kpi.controller;

import java.util.List;

import javax.validation.Valid;

import org.kpi.model.Project;
import org.kpi.model.ProjectType;
import org.kpi.model.dto.ProjectDTO;
import org.kpi.service.ProjectService;
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
        List<Project> projects = projectService.getProjects();
        List<ProjectDTO> projectDTOs = ProjectDTO.toList(projects);
        return projectDTOs;
    }
    
    @GetMapping("/{name}")
    public ProjectDTO get(@PathVariable String name){
        return ProjectDTO.fromProject(projectService.getProject(name));
    }
}
