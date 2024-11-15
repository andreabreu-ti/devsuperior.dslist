package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	/*
	 *	Boa Prática: Colocar a anotação [@Transactional] em todos os métodos dos seu service para que fique transacional
	 *	para garantir que a operação com o DB vá acontecer obdecendo os principois das transações o ACID.
	 *	Transações ACID são operações de banco de dados que possuem as quatro propriedades ACID:
	 *	Atomicidade, Consistência, Isolamento e Durabilidade;
	 *
	 *	O Argumento pode ser utilizado: @Transactional(readOnly = true), assegura que não irá realizar operações de escrita, ou seja, não vou bloquear o DB para escrita
	 * 
	 */
	
	
	/*
	 * Metodo para buscar todos
	 */
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
	/*
	 * Metodo para buscar por ID
	 */
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		
		Game result = gameRepository.findById(id).get();
		
		/**
		 * Converter objeto game para objeto gameDTo, utilizar o construtor do GameDTO
		 */
		return new GameDTO(result);
		
	}
	
}
