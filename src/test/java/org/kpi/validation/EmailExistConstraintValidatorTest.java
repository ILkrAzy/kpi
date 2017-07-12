package org.kpi.validation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpi.service.UserService;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.validation.ConstraintValidatorContext;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by lnphi on 7/11/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmailExistConstraintValidatorTest {

    @Mock
    private UserService userService;

    @Mock
    private ConstraintValidatorContext validatorContext;

    @Mock
    private ConstraintValidatorContext.ConstraintViolationBuilder violationBuilder;

    private EmailExistConstraintValidator validator;

    @Before
    public void setUp() throws Exception {
        validator = new EmailExistConstraintValidator();
        validator.setUserService(userService);
    }

    @Test
    public void returnTrueWithValidEmail() throws Exception {
        String email = "hello@kpi.org";
        when(userService.existEmail(email)).thenReturn(false);
        assertTrue(validator.isValid(email, validatorContext));
    }

    @Test
    public void returnFalseWithExistEmail() throws Exception {
        String email = "hello@kpi.org";
        when(userService.existEmail(email)).thenReturn(true);
        when(validatorContext.buildConstraintViolationWithTemplate("Email " + email + " already exists!")).thenReturn(violationBuilder);
        assertFalse(validator.isValid(email, validatorContext));
    }
}
