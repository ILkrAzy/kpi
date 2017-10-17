package org.kpi.model.dto;

import lombok.Getter;
import lombok.Setter;

import org.kpi.model.ProjectType;

import javax.validation.constraints.Pattern;

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
    private String label = "default";

    @Getter
    @Setter
    private String uuid;

    public ProjectType toModel() {
        ProjectType type = new ProjectType();
        type.setName(name);
        type.setLabel(label);
        return type;
    }

    public ProjectTypeDTO fromModel(ProjectType projectType) {
        this.setLabel(projectType.getLabel());
        this.setName(projectType.getName());
        this.setUuid(projectType.getUuid());
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((label == null) ? 0 : label.hashCode());
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
        if (label == null) {
            if (other.label != null)
                return false;
        } else if (!label.equals(other.label))
            return false;
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
