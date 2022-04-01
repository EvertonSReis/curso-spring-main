package com.evertonreis.services;

import com.evertonreis.domain.Usuario;
import com.evertonreis.model.PageModel;
import com.evertonreis.model.PageRequestModel;
import com.evertonreis.repository.UsuarioRepository;
import com.evertonreis.util.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario save(Usuario usuario){
        String hash = HashUtil.getSecureHash(usuario.getSenha());
        usuario.setSenha(hash);

        Usuario createdUsuario = repository.save(usuario);
        return createdUsuario;
    }

    public Usuario update(Usuario usuario){
        String hash = HashUtil.getSecureHash(usuario.getSenha());
        usuario.setSenha(hash);

        Usuario updateUsuario = repository.save(usuario);
        return updateUsuario;
    }

    public Usuario getById(Long id){
        Optional<Usuario> obj = repository.findById(id);
        return obj.get();
    }

    public List<Usuario> listAll(){
        List<Usuario> usuarios = repository.findAll();
        return usuarios;
    }

    public PageModel<Usuario> listAllOnLazyModel(PageRequestModel pr){
        Pageable pageable = PageRequest.of(pr.getPage(), pr.getSize());
        Page<Usuario> page = repository.findAll(pageable);

        PageModel<Usuario> pm = new PageModel<>((int) page.getTotalElements(), page.getSize(), page.getTotalPages(), page.getContent());
        return pm;
    }

    public Usuario login(String email, String senha){
        senha = HashUtil.getSecureHash(senha);

        Optional<Usuario> obj = repository.login(email, senha);
        return obj.orElse(new Usuario());
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public int updateRole(Usuario usuario){
        return  repository.updateRole(usuario.getId(), usuario.getRole());
    }
}
