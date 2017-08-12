package org.kpi.model.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

import org.kpi.model.ProjectType;
import org.kpi.model.ProjectTypeKpi;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author lnphi
 * @since 7/14/2017.
 */
public class ProjectTypeDTO {

    @Getter
    @Setter
    @Pattern(regexp = "^[A-Za-z0-9]{2,50}$", message = "Name must contains letters or digit only")
    private String name;
    
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<KpiDTO> kpis = new ArrayList<KpiDTO>();
    
    @Getter
    @Setter
    private String uuid;
    
    
    public ProjectTypeDTO() {
    }

    public ProjectTypeDTO(ProjectType type) {
        this.name = type.getName();
        this.uuid = type.getUuid();
    }

    public ProjectType toModel() {
        ProjectType type = new ProjectType();
        type.setName(this.name);
        return type;
    }
    
    public ProjectTypeDTO fromModel(ProjectType projectType){
        this.name = projectType.getName();
        this.uuid = projectType.getUuid();
        for(ProjectTypeKpi projectTypeKpi : projectType.getKpis()){
            KpiDTO kpiDTO = new KpiDTO();
            this.kpis.add(kpiDTO.fromSimpleModel2(projectTypeKpi.getKpi()));
        }
        return this;
    }
    
    public ProjectTypeDTO fromSimpleModel(ProjectType projectType){
        this.name = projectType.getName();
        this.uuid = projectType.getUuid();
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProjectTypeDTO other = (ProjectTypeDTO) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        return true;
    }
    
    
}
