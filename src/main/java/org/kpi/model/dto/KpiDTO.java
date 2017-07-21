package org.kpi.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by vquochuy on 7/21/2017.
 */
public class KpiDTO {
    
    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9\\s]{3,254}$", message = "name must contains letters or digit only")
    @Size(min = 3, max = 254)
    @Getter
    @Setter
    private String name;
    
    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9]{3,50}$", message = "measure must contains letters or digit only. Not contains space or empty")  
    @Size(min = 3, max = 50)
    @Getter
    @Setter
    private String measure;
}
