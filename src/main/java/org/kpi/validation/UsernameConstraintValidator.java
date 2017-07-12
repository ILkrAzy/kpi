package org.kpi.validation;

import org.kpi.service.UserService;
import org.kpi.validation.annotation.Username;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by lnphi on 7/11/2017.
 */
public class UsernameConstraintValidator implements ConstraintValidator<Username, String> {

    private UserService userService;

    @Override
    public void initialize(Username constraintAnnotation) {
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (userService.exist(username)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("User " + username + " already exists!").addConstraintViolation();
            return false;
        }
        return true;
    }
}
