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
}
