package org.kpi.model.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

public class NewUserInput {
    @NotNull
    @Getter
    @Setter
    private String username;
    
    @NotNull
    @Getter
    @Setter
    private String password;
    
    @Getter
    @Setter
    private String firstName;
    
    @Getter
    @Setter
    private String lastName;
    
    @Getter
    @Setter
    private String  email;
}
