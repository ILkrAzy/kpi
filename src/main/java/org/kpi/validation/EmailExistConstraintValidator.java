package org.kpi.validation;

import org.kpi.service.UserService;
import org.kpi.validation.annotation.EmailExist;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by lnphi on 7/11/2017.
 */
public class EmailExistConstraintValidator implements ConstraintValidator<EmailExist, String> {

    @Autowired
    UserService userService;

    @Override
    public void initialize(EmailExist constraintAnnotation) {

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
