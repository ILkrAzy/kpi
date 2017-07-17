package org.kpi.model.dto;

import javax.validation.constraints.Pattern;

import org.kpi.model.Project;

import lombok.Getter;
import lombok.Setter;

public class ProjectDTO {
    @Getter
    @Setter
    @Pattern(regexp = "^[A-Za-z0-9\\s]{2,100}$", message = "Name must contains letters or digit only")
    private String name;
    
    @Getter
    @Setter
    private String projectType;
    
    public Project toModel() {
        Project project = new Project();
        project.setName(this.name);
        return project;
    }
    
    public static ProjectDTO fromProject(Project project){
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName(project.getName());
        projectDTO.setProjectType(project.getType().getName());
        return projectDTO;
    }
}
