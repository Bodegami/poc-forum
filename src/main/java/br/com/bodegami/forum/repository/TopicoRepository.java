package br.com.bodegami.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bodegami.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

}
