package br.com.bodegami.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bodegami.forum.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

Curso findByNome(String nomeCurso);

}
