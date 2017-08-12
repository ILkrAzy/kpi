package org.kpi.model.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

import org.kpi.model.Kpi;
import org.kpi.model.ProjectTypeKpi;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by vquochuy on 7/21/2017.
 */
public class KpiDTO {
    
    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9\\s]{3,254}$", message = "name must contains letters or digit only")
    @Size(min = 3, max = 254)
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String name;
    
    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9]{3,50}$", message = "measure must contains letters or digit only. Not contains space or empty")  
    @Size(min = 3, max = 50)
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String measure;
    
    @Getter
    @Setter
    private String uuid;
    
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ProjectTypeDTO> projectType = new ArrayList<ProjectTypeDTO>();
    
    public KpiDTO() {
    }
       
    public KpiDTO(Kpi kpi) {
        this.name = kpi.getName();
        this.measure = kpi.getMeasure();
        this.uuid = kpi.getUuid();
    }

    public KpiDTO fromModel(Kpi kpi){
        this.setName(kpi.getName());
        this.setMeasure(kpi.getMeasure());
        this.setUuid(kpi.getUuid());
        return this;
    }
   
   public Kpi toModel(){
       Kpi kpi = new Kpi();
       kpi.setMeasure(measure);
       kpi.setName(name);
       return kpi;
   }
   
   public KpiDTO fromSimpleModel(Kpi kpi){
       this.setName(kpi.getName());
       this.setMeasure(kpi.getMeasure());
       this.setUuid(kpi.getUuid());
       for(ProjectTypeKpi projectTypeKpi : kpi.getProjectTypes()){
           ProjectTypeDTO projectTypeDTO= new ProjectTypeDTO();
           projectTypeDTO.fromSimpleModel(projectTypeKpi.getProjectType());
           this.projectType.add(projectTypeDTO);
       }
       return this;
   }

   public KpiDTO fromSimpleModel2(Kpi kpi){
       this.setUuid(kpi.getUuid());
       return this;
   }
@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((measure == null) ? 0 : measure.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
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
    KpiDTO other = (KpiDTO) obj;
    if (measure == null) {
        if (other.measure != null)
            return false;
    } else if (!measure.equals(other.measure))
        return false;
    if (name == null) {
        if (other.name != null)
            return false;
    } else if (!name.equals(other.name))
        return false;
    return true;
}

}
