package org.kpi.model.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import org.kpi.model.ProjectKpiValue;

public class ProjectKpiValueDTO {
    @NotNull
    @Getter
    @Setter
    private String projectUUID;
    @NotNull
    @Getter
    @Setter
    private String kpiUUID;
    @Getter
    @Setter
    private int month;
    @Getter
    @Setter
    private int year;
    @Getter
    @Setter
    private String value;
    @Getter
    @Setter
    private String comment;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((kpiUUID == null) ? 0 : kpiUUID.hashCode());
        result = prime * result
                + ((projectUUID == null) ? 0 : projectUUID.hashCode());
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
        ProjectKpiValueDTO other = (ProjectKpiValueDTO) obj;
        if (kpiUUID == null) {
            if (other.kpiUUID != null)
                return false;
        } else if (!kpiUUID.equals(other.kpiUUID))
            return false;
        if (projectUUID == null) {
            if (other.projectUUID != null)
                return false;
        } else if (!projectUUID.equals(other.projectUUID))
            return false;
        return true;
    }
    
    public ProjectKpiValue toModel() {
        ProjectKpiValue project = new ProjectKpiValue(this.month, this.year, this.value, this.comment);
        return project;
    }
}
