package com.devsuperior.dslist.projections;

public interface GameMinProjection {

	/*
	 * Colocar metodos get correspondentes a consulta sql
	 */
	Long getId();

	String getTitle();

	Integer getGameYear();

	String getImgUrl();

	String getShortDescription();

	Integer getPosition();

}
