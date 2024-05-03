
package com.utils;


import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.entity.EIException;

/**
 * hibernate-validator
 */
public class ValidatorUtils {
    private static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * Check object
     * @param object        Check object
     * @param groups        The group to be verified
     * @throws EIException  If the verification fails, an EIException Exception is reported
     */
    public static void validateEntity(Object object, Class<?>... groups)
            throws EIException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
        	ConstraintViolation<Object> constraint = (ConstraintViolation<Object>)constraintViolations.iterator().next();
            throw new EIException(constraint.getMessage());
        }
    }
    
    
}
