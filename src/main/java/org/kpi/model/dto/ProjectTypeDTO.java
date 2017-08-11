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
}
