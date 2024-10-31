package com.armirene.employees.dto.request;

import com.armirene.employees.domain.enums.Country;
import com.armirene.employees.domain.enums.IdentificationType;
import com.armirene.employees.domain.enums.WorkArea;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.lang.annotation.*;
import java.time.LocalDate;

@Data
public class RegisterEmployeeRequest {

    @NotNull(message = "El apellido es requerido")
    @Size(max = 20, message = "El apellido no puede tener más de 20 caracteres")
    @Pattern(regexp = "^[A-Z]*(\\s[A-Z]*)*$", message = "El apellido solo puede contener letras de la A a la Z (mayúsculas) sin acentos ni Ñ")
    private String lastName;

    @NotNull(message = "El segundo apellido es requerido")
    @Size(max = 20, message = "El segundo apellido no puede tener más de 20 caracteres")
    @Pattern(regexp = "^[A-Z]*(\\s[A-Z]*)*$", message = "El segundo apellido solo puede contener letras de la A a la Z (mayúsculas) sin acentos ni Ñ")
    private String secondLastName;

    @NotNull(message = "El nombre es requerido")
    @Size(max = 20, message = "El nombre no puede tener más de 20 caracteres")
    @Pattern(regexp = "^[A-Z]*(\\s[A-Z]*)*$", message = "El nombre solo puede contener letras de la A a la Z (mayúsculas) sin acentos ni Ñ")
    private String firstName;

    @Size(max = 50, message = "Los otros nombres no pueden tener más de 50 caracteres")
    @Pattern(regexp = "^[A-Z]*(\\s[A-Z]*)*$", message = "Los otros nombres solo pueden contener letras de la A a la Z (mayúsculas) sin acentos ni Ñ")
    private String secondName;

    @NotNull(message = "El campo country no puede ser nulo o no es un pais válido")
    private Country country;

    @NotNull(message = "El campo tipo de identificación no puede ser nulo")
    private IdentificationType identificationType;

    @NotNull(message = "El número de identificación es requerido")
    @Size(max = 20, message = "El número de identificación no puede tener más de 20 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9-]+$", message = "El número de identificación debe ser alfanumérico y puede incluir guiones (-)")
    private String identificationNumber;

    @NotNull(message = "La fecha de ingreso es requerida")
    @PastOrPresent(message = "La fecha de ingreso no puede ser futura")
    @DateWithinLastMonth
    private LocalDate startDate;

    @NotNull(message = "El área de trabajo es requerida")
    private WorkArea area;

    @NotNull(message = "La foto del empleado es requerida")
    @Pattern(regexp = "^data:image/([a-zA-Z]*);base64,([^\"]*)$", message = "El formato de la imagen debe ser Base64")
    private String photo;
}

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateWithinLastMonthValidator.class)
@Documented
@interface DateWithinLastMonth {
    String message() default "La fecha de ingreso debe ser dentro del último mes";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

class DateWithinLastMonthValidator implements ConstraintValidator<DateWithinLastMonth, LocalDate> {

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext context) {
        if (date == null) {
            return true; // Permite que @NotNull maneje la validación
        }
        LocalDate now = LocalDate.now();
        return !date.isAfter(now) && !date.isBefore(now.minusMonths(1));
    }
}
