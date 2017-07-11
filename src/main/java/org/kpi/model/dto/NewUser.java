package org.kpi.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.kpi.model.User;
import org.kpi.validation.annotation.EmailExist;
import org.kpi.validation.annotation.Username;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by lnphi on 7/6/2017.
 */
public class NewUser {

    @NotNull
    @Username
    @Pattern(regexp = "^[A-Za-z0-9]{5,30}$", message = "Username must contains letters or digit only")
    @Size(min = 5, max = 30)
    @Getter
    @Setter
    private String username;

    @NotNull
    @Size(min = 6)
    @Getter
    @Setter
    private String password;

    @NotNull
    @Email
    @EmailExist
    @Getter
    @Setter
    private String email;

    @NotEmpty
    @Getter
    @Setter
    private String firstName;

    @NotEmpty
    @Getter
    @Setter
    private String lastName;

    public User toModel(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), email, firstName, lastName, null);
    }
}
