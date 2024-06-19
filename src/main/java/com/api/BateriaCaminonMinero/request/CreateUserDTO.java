package com.api.BateriaCaminonMinero.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {
    @NotBlank
    private String nom_tra;
    private String ape_tra;
    private String dni_tra;
    private Boolean estado;
    @NotBlank
    private String username;
    @NotBlank
    private String pass_tra;
    //private Set<String> roles;
    private Long roles;
    private Long empresaId;
}