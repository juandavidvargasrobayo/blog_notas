package com.juan.blog_notas.blog_notas.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class RequiredValidation implements ConstraintValidator<IsRequired,String> {
    @Override
    public  boolean isValid(String value, ConstraintValidatorContext context){
        return StringUtils.hasText(value);
    }
}
