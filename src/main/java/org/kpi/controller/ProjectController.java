package org.kpi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.kpi.model.Kpi;
import org.kpi.model.Project;
import org.kpi.model.ProjectKpiValue;
import org.kpi.model.ProjectType;
import org.kpi.model.User;
import org.kpi.model.dto.ProjectDTO;
import org.kpi.model.dto.ProjectKpiValueDTO;
import org.kpi.service.KpiService;
import org.kpi.service.ProjectKpiValueService;
import org.kpi.service.ProjectService;
import org.kpi.service.ProjectTypeService;
import org.kpi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    private UserService userService;
    
    private ProjectKpiValueService projectKpiValueService;
    
    private KpiService kpiService;

    @Autowired
    public ProjectController(ProjectService projectService, ProjectTypeService projectTypeService, UserService userService, ProjectKpiValueService projectKpiValueService, KpiService kpiService) {
        this.projectTypeService = projectTypeService;
        this.projectService = projectService;
        this.userService = userService;
        this.projectKpiValueService = projectKpiValueService;
        this.kpiService = kpiService;
    }
    
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody ProjectDTO projectDTO) {
        Project project = projectDTO.toModel();
        for(String userName : projectDTO.getUserManagers()){
            User user = userService.getByUsername(userName);
            project.addManager(user);
        }
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
    public ResponseEntity<ProjectDTO> get(@PathVariable String name){
        Project project = projectService.getProject(name);
        if(project == null) {
            return new ResponseEntity<ProjectDTO>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(ProjectDTO.fromProject(project));
    }
    
    @PostMapping("/kpis")
    public ResponseEntity<Void> saveKpiValuesForProject(@Valid @RequestBody ProjectKpiValueDTO projectKpiValueDTO) {
        Kpi kpi = kpiService.getKpiByUUID(projectKpiValueDTO.getKpiUUID());
        Project project = projectService.getKpiByUUID(projectKpiValueDTO.getProjectUUID());
        ProjectKpiValue projectKpiValue = projectKpiValueDTO.toModel();
        projectKpiValue.setKpi(kpi);
        projectKpiValue.setProject(project);
        projectKpiValueService.save(projectKpiValue);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @GetMapping("/{name}/kpis")
    public ResponseEntity< List<ProjectKpiValueDTO>> getKpiValueForProject(@PathVariable String name, @RequestParam int month){
        Project project = projectService.getProject(name);
        List<ProjectKpiValue> projectKpiValues = projectKpiValueService.getListKpiValueByMonth(project.getId(), month);
        List<ProjectKpiValueDTO> list = new ArrayList<ProjectKpiValueDTO>();
        for(ProjectKpiValue projectKpiValue : projectKpiValues){
            list.add(new ProjectKpiValueDTO(projectKpiValue));
        }
        return ResponseEntity.ok(list);
    }
}
