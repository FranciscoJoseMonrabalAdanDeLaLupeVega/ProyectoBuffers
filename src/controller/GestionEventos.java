package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.*;

public class GestionEventos {

	private GestionDatos model;
	private LaunchView view;
	private ActionListener actionListener_comparar, actionListener_buscar, actionListener_Copiar, actionListener_Guardar, actionListener_Sacar;

	public GestionEventos(GestionDatos model, LaunchView view) {
		this.model = model;
		this.view = view;
	}

	public void contol() {
		actionListener_comparar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_compararContenido
				call_compararContenido();
			}
		};
		view.getComparar().addActionListener(actionListener_comparar);

		actionListener_buscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_buscarPalabra
				call_buscarPalabra();
			}
		};
		view.getBuscar().addActionListener(actionListener_buscar);
		
		actionListener_Copiar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_copiarFicheros
				call_copiarFicheros();
			}
		};
		view.getCopiar().addActionListener(actionListener_Copiar);
		
		actionListener_Guardar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_copiarFicheros
				call_guardarLibro();
			}
		};
		view.getGuardarLibro().addActionListener(actionListener_Guardar);
		
		actionListener_Sacar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_copiarFicheros
				call_sacarLibro();
			}
		};
		view.getVerLibro().addActionListener(actionListener_Sacar);
	}

	private void call_compararContenido() {

		// TODO: Llamar a la función compararContenido de GestionDatos
		// TODO: Gestionar excepciones
		boolean iguales;
		
		try {
			//LLamo a la funcion comparar contenido y le paso los parametros
			iguales = model.compararContenido(view.getFichero1().getText(), view.getFichero2().getText());
		
			//Comprobacion de l resultado
			if (iguales) {
				
				view.getTextArea().setText("Los ficheros son iguales");
			} else {
				
				view.getTextArea().setText("Los ficheros son distintos");
			}
		} catch (Exception e) {
			
			//Manejo del error
			view.showError("Error: " + e);
		}
		
	}

	private void call_buscarPalabra() {

		// TODO: Llamar a la función buscarPalabra de GestionDatos
		// TODO: Gestionar excepciones
		
		int linea;
		
		try {
			//Llamamos a la funcion buscar palabra
			linea = model.buscarPalabra(view.getFichero1().getText(), view.getPalabra().getText(), view.getPrimera().isSelected());
			
			//Analizamos los resulatados
			if (linea == -1) {
				
				view.getTextArea().setText("Esa palabra no existe en el fichero");
			} else {
				
				view.getTextArea().setText("La palabra aparece en la linea " + linea);
			}
			
		} catch (Exception e) {
			
			//Manejo del error
			view.showError("Error: " + e);
		}
		
	}
	
	private void call_copiarFicheros() {
		
		//llamada al metodo de copiar fichero bytes y manejo de error
		try {
			model.copiarFicheroBytes(view.getFicheroByte().getText(), view.getFicheroCByte().getText());
		}catch(Exception e){
			view.showError("Error: " + e);
		}
	}

	private void call_guardarLibro() {
		
		String titulo = view.getTituloTxt().getText();
		String autor = view.getAutorTxt().getText();
		String publi = view.getFechaPublTxt().getText();
		String editor = view.getEditorTxt().getText();
		String num_pag = view.getNumPaginasTxt().getText();
		
		Libro lib = model.creaLibro(autor, titulo, publi, num_pag, editor);
		try {
			model.guardarLibro(lib);
		}catch(Exception e){
			view.showError("Error: " + e);
		}
	}
	
	private void call_sacarLibro() {
		
		Libro lib = new Libro(null, null, null, null, null);
		String displayLibro;
		
		try {
			lib = model.recuperarLibro(view.getVerLibroTitulo().getText());
		}catch (Exception e) {
			view.showError("Error: " + e);
		}
		
		displayLibro = "=============Libro==============\n"
				+ "Autor: " + lib.getAutor() + "\n"
				+ "Titulo: " + lib.getTitulo() + "\n"
				+ "Año publicacion: " + lib.getAño_publi() + "\n"
				+ "Editor: " + lib.getEditor() + "\n"
				+ "Nº de paginas: " + lib.getNum_pag() + "\n";
		
		view.getTextArea().setText(displayLibro);
	}
}
