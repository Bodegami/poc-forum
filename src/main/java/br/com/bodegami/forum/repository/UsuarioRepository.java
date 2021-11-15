package br.com.bodegami.forum.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bodegami.forum.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findByEmail(String email);

}
