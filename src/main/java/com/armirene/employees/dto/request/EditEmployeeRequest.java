package com.armirene.employees.dto.request;

import com.armirene.employees.domain.enums.Country;
import com.armirene.employees.domain.enums.IdentificationType;
import com.armirene.employees.domain.enums.WorkArea;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EditEmployeeRequest {

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

    @NotNull(message = "El campo country no puede ser nulo o no es un país válido")
    private Country country;

    @NotNull(message = "El campo tipo de identificación no puede ser nulo")
    private IdentificationType identificationType;

    @NotNull(message = "El número de identificación es requerido")
    @Size(max = 20, message = "El número de identificación no puede tener más de 20 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9-]+$", message = "El número de identificación debe ser alfanumérico y puede incluir guiones (-)")
    private String identificationNumber;

    @NotNull(message = "El área de trabajo es requerida")
    private WorkArea area;

    @NotNull(message = "La foto del empleado es requerida")
    @Pattern(regexp = "^data:image/([a-zA-Z]*);base64,([^\"]*)$", message = "El formato de la imagen debe ser Base64")
    private String photo;
}

