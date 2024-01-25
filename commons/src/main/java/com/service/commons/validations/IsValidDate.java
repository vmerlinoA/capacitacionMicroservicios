package com.service.pagos.validations;


import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsValidDate.IsValidDateValidator.class)
public @interface IsValidDate {
    String message() default "La fecha debe ser igual o mayor a la fecha actual en formato dd/MM/yyyy";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    class IsValidDateValidator implements ConstraintValidator<IsValidDate, Date> {
        private static final String DATE_FORMAT = "dd/MM/yyyy";

        @Override
        public void initialize(IsValidDate constraintAnnotation) {
        }

        @Override
        public boolean isValid(Date value, ConstraintValidatorContext context) {
            if (value == null) {
                return false;
            }

            // Validar el formato de la fecha
            SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            dateFormat.setLenient(false);

            try {
                dateFormat.parse(dateFormat.format(value));
            } catch (ParseException e) {
                return false;
            }

            // Validar que la fecha sea mayor o igual a la fecha actual
            Date currentDate = new Date();
            return !value.before(currentDate);
        }
    }
}
