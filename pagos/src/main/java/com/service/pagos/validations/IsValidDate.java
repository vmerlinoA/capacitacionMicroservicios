package com.service.pagos.validations;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsValidDate.IsValidDateValidator.class)
public @interface IsValidDate {
    String message() default "La fecha debe ser igual o mayor a la fecha actual en formato DDMMAAAA";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    class IsValidDateValidator implements ConstraintValidator<IsValidDate, String> {
        @Override
        public void initialize(IsValidDate constraintAnnotation) {
        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            if (value == null || value.isEmpty()) {
                return false;
            }

            if (!value.matches("\\d{8}")) {
                return false; // No tiene 8 dígitos
            }
            // validación de fecha igual o mayor a la actual:
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
            dateFormat.setLenient(false);
            try {
                Date currentDate = new Date();
                Date inputDate = dateFormat.parse(value);
                return inputDate.after(currentDate) || inputDate.equals(currentDate);
            } catch (ParseException e) {
                return false; // Error al parsear la fecha
            }
        }
    }
}
