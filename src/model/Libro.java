package model;

import java.io.Serializable;

public class Libro implements Serializable{

	
	String titulo, autor, año_publi, editor, num_pag, id;
	
	/*
	 * Clase libro usado para almacenar libros
	 * Esta clase guarda de ID el titulo del libro
	 */
	
	public Libro(String autor, String titulo, String año_publi, String num_pag, String editor) {
		this.autor = autor;
		this.titulo = titulo;
		this.año_publi = año_publi;
		this.id = titulo;
		this.num_pag = num_pag;
		this.editor = editor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAño_publi() {
		return año_publi;
	}

	public void setAño_publi(String año_publi) {
		this.año_publi = año_publi;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getNum_pag() {
		return num_pag;
	}

	public void setNum_pag(String num_pag) {
		this.num_pag = num_pag;
	}

}
