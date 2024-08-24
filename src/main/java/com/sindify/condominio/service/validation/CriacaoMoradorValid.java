package com.sindify.condominio.service.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CriacaoMoradorValidator.class)
public @interface CriacaoMoradorValid {

    String message() default "Validation error";

    Class<?>[] groups() default {};

    Class<? extends Payload> [] payload() default {};

}