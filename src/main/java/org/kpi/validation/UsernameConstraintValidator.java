package org.kpi.validation;

import org.kpi.service.UserService;
import org.kpi.validation.annotation.Username;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameConstraintValidator implements ConstraintValidator<Username, String> {

    private UserService userService;

    @Override
    public void initialize(Username constraintAnnotation) {
        // nothing to do
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
