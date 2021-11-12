package br.com.bodegami.forum.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bodegami.forum.controller.dto.TopicoDto;
import br.com.bodegami.forum.modelo.Topico;
import br.com.bodegami.forum.repository.TopicoRepository;

@RestController
public class TopicoController {
	
	private final TopicoRepository repository;
	
	public TopicoController(TopicoRepository repository) {
		this.repository = repository;
	}

	@ResponseBody
	@RequestMapping("/topicos")
	public List<TopicoDto> lista(String nomeCurso) {
		if (nomeCurso == null) {
			List<Topico> lista = repository.findAll();
			return TopicoDto.converter(lista);
		} else {
			List<Topico> lista = repository.carregarPorNomeDoCurso(nomeCurso);
			return TopicoDto.converter(lista);
		}
		
	}

}
