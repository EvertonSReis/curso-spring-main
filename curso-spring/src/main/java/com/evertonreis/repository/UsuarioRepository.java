package com.evertonreis.repository;

import com.evertonreis.domain.Usuario;
import com.evertonreis.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    @Query("SELECT u FROM Usuario u WHERE u.email = ?1 AND u.senha = ?2")
    public Optional<Usuario> login(String email, String senha);

    @Transactional(readOnly = false)
    @Modifying
    @Query("UPDATE Usuario SET role = ?2 WHERE id = ?1" )
    public int updateRole(Long id, Role role);
}
