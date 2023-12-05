package com.etechoracio.opala.repositories;

import com.etechoracio.opala.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select u from Usuario u where u.email = :email")
    List<Usuario> findUsuarioByEmail(String email);

    @Query("select u from Usuario u where u.cpf = :cpf")
    List<Usuario> findUsuarioByCPF(Long cpf);

    @Query("select u from Usuario u where u.senha = :senha AND u.email = :email OR u.cpf = :cpf")
    List<Usuario> findSenha(String senha, String email, Long cpf);

}
