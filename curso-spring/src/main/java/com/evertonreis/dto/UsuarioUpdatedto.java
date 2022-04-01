package com.evertonreis.dto;

import com.evertonreis.domain.Request;
import com.evertonreis.domain.Stage;
import com.evertonreis.domain.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class UsuarioUpdatedto {

    @NotBlank
    private String nome;

    @Email
    private String email;

    @Size(min = 1, max = 99, message = "senha tem que haver entre 1 e 99 digitos")
    private String senha;

    private List<Request> request = new ArrayList<>();
    private List<Stage> stages = new ArrayList<>();

    public Usuario trasformToUsuario(){
        Usuario usuario = new Usuario(null, nome, email, senha, null, request, stages);

        return usuario;
    }

}
