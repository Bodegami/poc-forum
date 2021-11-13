package br.com.bodegami.forum.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.bodegami.forum.controller.dto.DetalhesDoTopicoDto;
import br.com.bodegami.forum.controller.dto.TopicoDto;
import br.com.bodegami.forum.controller.form.TopicoForm;
import br.com.bodegami.forum.modelo.Topico;
import br.com.bodegami.forum.repository.CursoRepository;
import br.com.bodegami.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

	private final TopicoRepository topicoRepository;
	private final CursoRepository cursoRepository;

	public TopicoController(TopicoRepository topicoRepository, CursoRepository cursoRepository) {
		this.topicoRepository = topicoRepository;
		this.cursoRepository = cursoRepository;

	}

	@ResponseBody
	@GetMapping
	public List<TopicoDto> lista(String nomeCurso) {
		if (nomeCurso == null) {
			List<Topico> lista = topicoRepository.findAll();
			return TopicoDto.converter(lista);
		} else {
			List<Topico> lista = topicoRepository.carregarPorNomeDoCurso(nomeCurso);
			return TopicoDto.converter(lista);
		}

	}

	@PostMapping
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter(cursoRepository);
		topicoRepository.save(topico);

		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}

	@GetMapping("/{id}")
	public DetalhesDoTopicoDto detalhar(@PathVariable Long id) {
		Topico topico = topicoRepository.getOne(id);
		return new DetalhesDoTopicoDto(topico);
	}

}
