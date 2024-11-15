package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.GameList;

public class GameListDTO {

	private Long id;
	private String name;

	public GameListDTO() {
		// ctrl+espaço sem ser dentro de um método. A primeira opção que aparece é a de
		// criar um construtor vazio.
	}

	public GameListDTO(GameList entity) {

		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
