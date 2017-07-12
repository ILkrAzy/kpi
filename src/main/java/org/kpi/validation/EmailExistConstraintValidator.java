package org.kpi.validation;

import org.kpi.service.UserService;
import org.kpi.validation.annotation.EmailExist;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailExistConstraintValidator implements ConstraintValidator<EmailExist, String> {

    private UserService userService;

    @Override
    public void initialize(EmailExist constraintAnnotation) {
        // nothing to do
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (userService.existEmail(email)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Email " + email + " already exists!").addConstraintViolation();
            return false;
        }
        return true;
    }
}
