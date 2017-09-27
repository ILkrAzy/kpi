package org.kpi.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
import java.util.ArrayList;
import java.util.List;

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

    @Size(min = 6)
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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

    @NotEmpty
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String role;
    
    public User toModel(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), email, firstName, lastName, null);
    }

    public static NewUser fromModel(User user){
        NewUser newUser = new NewUser();
        newUser.setUsername(user.getUsername());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        if(user.getRole()!=null){
            newUser.setRole(user.getRoleName());
        }
        return newUser;
    }

    public static List<NewUser> toList(List<User> users){
        List<NewUser> userList = new ArrayList<>();
        for (User user : users){
            userList.add(NewUser.fromModel(user));
        }
        return userList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewUser newUser = (NewUser) o;

        if (username != null ? !username.equals(newUser.username) : newUser.username != null) return false;
        if (password != null ? !password.equals(newUser.password) : newUser.password != null) return false;
        if (email != null ? !email.equals(newUser.email) : newUser.email != null) return false;
        if (firstName != null ? !firstName.equals(newUser.firstName) : newUser.firstName != null) return false;
        return lastName != null ? lastName.equals(newUser.lastName) : newUser.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
