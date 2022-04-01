package com.evertonreis.dto;

import com.evertonreis.enums.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
public class UsuarioUpdateRoledto {

    @NotNull
    private Role role;

}
