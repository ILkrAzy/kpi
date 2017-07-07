package org.kpi.model.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.kpi.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by lnphi on 7/6/2017.
 */
public class NewUser {

    @NotNull
    @Size(min = 5, max = 30)
    private String username;

    @NotNull
    @Size(min = 6)
    private String password;

    @NotNull
    @Email
    private String email;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User toModel(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), email, firstName, lastName, null);
    }
}
