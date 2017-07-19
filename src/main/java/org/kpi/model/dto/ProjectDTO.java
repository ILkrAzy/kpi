package org.kpi.model.dto;

import javax.validation.constraints.Pattern;

import org.kpi.model.Project;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
        if(project.getType()!=null){
            projectDTO.setProjectType(project.getType().getName());
        }
        return projectDTO;
    }

    public static List<ProjectDTO> toList(List<Project> projects){
        List<ProjectDTO> projectDTOs = new ArrayList<>();
        for(Project p : projects){
            projectDTOs.add(ProjectDTO.fromProject(p));
        }
        return projectDTOs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectDTO that = (ProjectDTO) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
