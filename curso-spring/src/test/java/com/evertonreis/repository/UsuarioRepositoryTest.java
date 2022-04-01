package com.evertonreis.repository;

import com.evertonreis.domain.Usuario;
import com.evertonreis.enums.Role;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository repository;
    @Test
    public void AsaveTest(){
        Usuario usuario = new Usuario(null, "Everton Reis", "everton@gmail.com", "123", Role.ADMINISTRADOR, null, null);
        Usuario createdUsuario = repository.save(usuario);

        assertThat(createdUsuario.getId()).isEqualTo(1L);
    }

    @Test
    public void updateTest(){
        Usuario usuario = new Usuario(1L, "Everton Silva Reis", "everton@gmail.com", "123", Role.ADMINISTRADOR, null, null);
        Usuario updateUsuario = repository.save(usuario);

        assertThat(updateUsuario.getNome()).isEqualTo("Everton Silva Reis");
    }

    @Test
    public void getByIdTest(){
        Optional<Usuario> result = repository.findById(1L);
        Usuario usuario = result.get();

        assertThat(usuario.getSenha()).isEqualTo("123");
    }

    @Test
    public void listTest(){
        List<Usuario> usuarios = repository.findAll();

        assertThat(usuarios.size()).isEqualTo(1);
    }

    @Test
    public void loginTest(){
        Optional<Usuario> result = repository.login("lorenzo@gmail.com", "123456");
        Usuario logUsuario = result.get();

        assertThat(logUsuario.getId()).isEqualTo(7L);
    }

    @Test
    public void updateRoleTest(){
        int affectedRows = repository.updateRole(5L,Role.ADMINISTRADOR);

        assertThat(affectedRows).isEqualTo(1);
    }
}
