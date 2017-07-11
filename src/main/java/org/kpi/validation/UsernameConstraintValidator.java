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

    @Autowired
    UserService service;

    @Override
    public void initialize(Username constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (service.exist(value)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("User " + value + " already exists!").addConstraintViolation();
            return false;
        }
        return true;
    }
}
