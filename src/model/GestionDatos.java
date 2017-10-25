package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GestionDatos {

	public GestionDatos() {

		
	}

	//Metodos para abrir los ficheros de bytes
	public FileInputStream abrirFicheroLecturaBytes(String ruta) throws FileNotFoundException {
		
		FileInputStream fi = new FileInputStream(ruta);
		
		return fi;
	}
	
	public FileOutputStream abrirFicheroEscrituraBytes(String ruta) throws FileNotFoundException {
		
		FileOutputStream fo = new FileOutputStream(ruta);
		
		return fo;
	}
	
	//Metodos para cerrar los ficheros de bytes
	public void cerrarFicheroLecturaByte(FileInputStream fi) throws IOException {
		
		fi.close();
	}
	
	public void cerrarFicheroEscrituraByte(FileOutputStream fo) throws IOException {
		
		fo.close();
	}
	
	//TODO: Implementa una función para abrir ficheros
	public BufferedReader abrirFichero(String rutaFichero) throws FileNotFoundException {
		
		BufferedReader bf = new BufferedReader(new FileReader(rutaFichero));
		
		return bf;
	}
	
	//TODO: Implementa una función para cerrar ficheros
	public void cerrarFichero(BufferedReader bf) throws IOException {
		
		bf.close();
	}
	
	public boolean compararContenido (String fichero1, String fichero2) throws FileNotFoundException, IOException{
		//TODO: Implementa la función
		
		/*
		 * Este metodo compara solamente por texto si los dos archivos son iguales, no realiza una comparacion por peso.
		 */
		
		BufferedReader bfFichero1 = abrirFichero(fichero1);
		BufferedReader bfFichero2 = abrirFichero(fichero2);
		//esta variable no es descriptiva de hecho es todo lo contrario a lo que pone
		boolean distintos = true;
		String lnFichero1 = bfFichero1.readLine();
		String lnFichero2	= bfFichero2.readLine();
		
		//El while perdura mentras las tres condiciones se cumplan que es que los ficheros no esten vacios 
		while (distintos && lnFichero1 != null && lnFichero2 != null) {

			//Detecta si hay un fallo en la linea que esta leyendo
			if (!lnFichero1.equals(lnFichero2)) {
				distintos = false;
				break;
			}
			
			//Leemos la siguiente linea
			lnFichero1 = bfFichero1.readLine();
			lnFichero2	= bfFichero2.readLine();
			
			//esta comprobacion sirve para revisar si uno de los dos ficheros de texto ha fallado por lo que no son iguales y saldra
			if ((lnFichero1 == null && lnFichero2 != null) || (lnFichero1 != null && lnFichero2 == null)) {
				distintos = false;
				break;
			}
		}
		
		//Cerramos los ficheros
		cerrarFichero(bfFichero1);
		cerrarFichero(bfFichero2);
		return distintos;
	}
	
	public int buscarPalabra (String fichero1, String palabra, boolean primera_aparicion) throws FileNotFoundException, IOException{
		
		/*
		 * Este metodo busca la palabra introducida en el fichero proporcionado, ademas esta preparado para encontrarlo
		 * en textos los cuales tengan mas de una palabra por linea, puntos y comas, pero no esta preparado para otros caracteres 
		 * como parentesis y barras con los cual puede fallar en ese tipo de textos.		
		*/
		
		BufferedReader bfFichero1 = abrirFichero(fichero1);
		int ciclos = 1;
		int lineaPalabra = -1;
		String lnFichero = bfFichero1.readLine();
		String[] listaPalabras;
		
			while (lnFichero != null) {
				
				lnFichero = lnFichero.toLowerCase().replace(".", "").replace(",", "");
				listaPalabras = lnFichero.split(" ");
				
				for (int i = 0; i < listaPalabras.length; i++) {
					
					if (listaPalabras[i].equals(palabra.toLowerCase())){
						
						lineaPalabra = ciclos;
						break;
					}
				}
				
				if (lineaPalabra != -1 && primera_aparicion){
					break;
				}
				
				ciclos++;
				lnFichero = bfFichero1.readLine();
			}
		 
		cerrarFichero(bfFichero1);
		return lineaPalabra;
	}
	
	public void copiarFicheroBytes (String rutaFichero, String rutaFicheroCopia) throws FileNotFoundException, IOException {
		
		//abrirmos los ficheros de bytes
		FileInputStream fi = abrirFicheroLecturaBytes(rutaFichero);
		FileOutputStream fo = abrirFicheroEscrituraBytes(rutaFicheroCopia);
		
		//creamos un buffer para almacenar el fichero
		byte[] buffer = new byte[1000];
		
		//lo leemos y lo escribimos en la ruta proporcionada
		fi.read(buffer);
		fo.write(buffer);
		
		//cerramos los ficheros
		cerrarFicheroLecturaByte(fi);
		cerrarFicheroEscrituraByte(fo);
	}

	//Este metodo crea los objetos libros y los devuelve
	public Libro creaLibro(String autor, String titulo, String año_publi, String num_pag, String editor) {
		
		Libro lib = new Libro(autor, titulo, año_publi, num_pag, editor);
		
		return lib;
	}
	
	//Guarda el objeto libro que le llega
	public void guardarLibro(Libro libro) throws FileNotFoundException, IOException {
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(libro.getTitulo()));
		out.writeObject(libro);
	}
	
	//recupera el libro designado
	public Libro recuperarLibro(String identificador) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		Libro lib = new Libro(null, null, null, null, null);
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(identificador));
		lib = (Libro) in.readObject();
		
		return lib;
	}
}
