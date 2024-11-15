package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;

	/*
	 * Boa Prática: Colocar a anotação [@Transactional] em todos os métodos dos seu
	 * service para que fique transacional para garantir que a operação com o DB vá
	 * acontecer obdecendo os principois das transações o ACID. Transações ACID são
	 * operações de banco de dados que possuem as quatro propriedades ACID:
	 * Atomicidade, Consistência, Isolamento e Durabilidade;
	 *
	 * O Argumento pode ser utilizado: @Transactional(readOnly = true), assegura que
	 * não irá realizar operações de escrita, ou seja, não vou bloquear o DB para
	 * escrita
	 * 
	 */

	/*
	 * Metodo para buscar todas as listas
	 */
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {

		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}

}
