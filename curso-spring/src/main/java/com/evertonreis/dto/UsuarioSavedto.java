package com.evertonreis.dto;

import com.evertonreis.domain.Request;
import com.evertonreis.domain.Stage;
import com.evertonreis.domain.Usuario;
import com.evertonreis.enums.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class UsuarioSavedto {

    @NotBlank
    private String nome;

    @Email
    private String email;

    @Size(min = 4, max = 99, message = "senha tem que haver entre 1 e 99 digitos")
    private String senha;

    @NotNull
    private Role role;

    private List<Request> request = new ArrayList<>();
    private List<Stage> stages = new ArrayList<>();

    public Usuario transformToUsuario(){
        Usuario usuario = new Usuario(null, nome, email, senha, role, request, stages);

        return usuario;
    }

}
