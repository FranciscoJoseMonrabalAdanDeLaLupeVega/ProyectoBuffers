package view;

import java.awt.Dimension;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Component;

public class LaunchView extends JFrame {

	private JButton comparar,buscar;
	private JTextArea textArea;
	private JTextField fichero1,fichero2,palabra;
	private JLabel label_f1,label_f2,label_pal;
	private JCheckBox primera;
	
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblCopiaDeFicheros;
	private Component horizontalStrut;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private JTextField ficheroByte;
	private JLabel lblLocalicacionDelFichero;
	private JLabel lblRutaParaCopiar;
	private JTextField ficheroCByte;
	private JButton copiar;
	private Component verticalStrut_2;
	private Component verticalStrut_3;
	private JPanel panel_2;
	private JButton guardarLibro;
	private JButton verLibro;
	private JButton verTodos;
	private JTextField numPaginasTxt;
	private JTextField editorTxt;
	private JTextField fechaPublTxt;
	private JTextField autorTxt;
	private JTextField tituloTxt;
	private JLabel numPaginas;
	private JLabel editor;
	private JLabel fechaPubli;
	private JLabel autor;
	private JLabel titulo;
	private JTextField verLibroTitulo;
	private JLabel lblTitulo;
	private Component verticalStrut_4;
	private Component verticalStrut_5;
	
	public LaunchView() {
		
		setBounds(200,200,1000,450);
		setTitle("Proyecto Buffers");	
		
		panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		verticalStrut_1 = Box.createVerticalStrut(30);
		panel_1.add(verticalStrut_1);
		
		lblCopiaDeFicheros = new JLabel("Copia de ficheros");
		panel_1.add(lblCopiaDeFicheros);
		
		verticalStrut = Box.createVerticalStrut(30);
		panel_1.add(verticalStrut);
		
		lblLocalicacionDelFichero = new JLabel("Localicacion del fichero");
		panel_1.add(lblLocalicacionDelFichero);
		
		ficheroByte = new JTextField();
		panel_1.add(ficheroByte);
		ficheroByte.setColumns(10);
		
		lblRutaParaCopiar = new JLabel("Ruta para copiar");
		panel_1.add(lblRutaParaCopiar);
		
		ficheroCByte = new JTextField();
		panel_1.add(ficheroCByte);
		ficheroCByte.setColumns(10);
		
		verticalStrut_3 = Box.createVerticalStrut(80);
		panel_1.add(verticalStrut_3);
		
		copiar = new JButton("Copiar");
		panel_1.add(copiar);
		
		verticalStrut_2 = Box.createVerticalStrut(120);
		panel_1.add(verticalStrut_2);
		
		horizontalStrut = Box.createHorizontalStrut(50);
		panel_1.add(horizontalStrut);
		panel = new JPanel();
		
		comparar = new JButton("Comparar contenido");
		comparar.setPreferredSize(new Dimension(150, 26));
		buscar = new JButton("Buscar palabra");
		buscar.setPreferredSize(new Dimension(150, 26));
					
		fichero1 = new JTextField("",10);
		fichero2 = new JTextField("",10);
		palabra = new JTextField("",10);
		
		label_f1 = new JLabel("Fichero 1:");
		label_f2 = new JLabel("Fichero 2:");
		label_pal = new JLabel("Palabra:");
		
		primera = new JCheckBox("Primera aparición");

		textArea = new JTextArea(20, 80);
		textArea.setBounds(50,50,50,50);
		textArea.setEditable(false);		
		
		panel.add(comparar);
		panel.add(buscar);
		panel.add(label_f1);
		panel.add(fichero1);
		panel.add(label_f2);
		panel.add(fichero2);
		panel.add(label_pal);
		panel.add(palabra);
		panel.add(primera);
		panel.add(textArea);
		
        // Añadimos el JPanel al JFrame
        this.getContentPane().add(panel);
        
        panel_2 = new JPanel();
        getContentPane().add(panel_2, BorderLayout.EAST);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
        
        titulo = new JLabel("Titulo");
        panel_2.add(titulo);
        
        tituloTxt = new JTextField();
        panel_2.add(tituloTxt);
        tituloTxt.setColumns(10);
        
        autor = new JLabel("Autor");
        panel_2.add(autor);
        
        autorTxt = new JTextField();
        panel_2.add(autorTxt);
        autorTxt.setColumns(10);
        
        fechaPubli = new JLabel("Fecha publi");
        panel_2.add(fechaPubli);
        
        fechaPublTxt = new JTextField();
        panel_2.add(fechaPublTxt);
        fechaPublTxt.setColumns(10);
        
        editor = new JLabel("Editor");
        panel_2.add(editor);
        
        editorTxt = new JTextField();
        panel_2.add(editorTxt);
        editorTxt.setColumns(10);
        
        numPaginas = new JLabel("NumPaginas");
        panel_2.add(numPaginas);
        
        numPaginasTxt = new JTextField();
        panel_2.add(numPaginasTxt);
        numPaginasTxt.setColumns(10);
        
        guardarLibro = new JButton("Guardar libro");
        panel_2.add(guardarLibro);
        
        verticalStrut_5 = Box.createVerticalStrut(20);
        panel_2.add(verticalStrut_5);
        
        lblTitulo = new JLabel("Titulo");
        panel_2.add(lblTitulo);
        
        verLibroTitulo = new JTextField();
        panel_2.add(verLibroTitulo);
        verLibroTitulo.setColumns(10);
        
        verLibro = new JButton("Ver libro");
        panel_2.add(verLibro);
        
        verticalStrut_4 = Box.createVerticalStrut(20);
        panel_2.add(verticalStrut_4);
        
        verTodos = new JButton("Todos los libros");
        panel_2.add(verTodos);
		
	}	
	
	public JTextField getTituloTxt() {
		return tituloTxt;
	}

	public void setTituloTxt(JTextField tituloTxt) {
		this.tituloTxt = tituloTxt;
	}

	public JButton getGuardarLibro() {
		return guardarLibro;
	}

	public void setGuardarLibro(JButton guardarLibro) {
		this.guardarLibro = guardarLibro;
	}

	public JButton getVerLibro() {
		return verLibro;
	}

	public void setVerLibro(JButton verLibro) {
		this.verLibro = verLibro;
	}

	public JButton getVerTodos() {
		return verTodos;
	}

	public void setVerTodos(JButton verTodos) {
		this.verTodos = verTodos;
	}

	public JTextField getNumPaginasTxt() {
		return numPaginasTxt;
	}

	public void setNumPaginasTxt(JTextField numPaginasTxt) {
		this.numPaginasTxt = numPaginasTxt;
	}

	public JTextField getEditorTxt() {
		return editorTxt;
	}

	public void setEditorTxt(JTextField editorTxt) {
		this.editorTxt = editorTxt;
	}

	public JTextField getFechaPublTxt() {
		return fechaPublTxt;
	}

	public void setFechaPublTxt(JTextField fechaPublTxt) {
		this.fechaPublTxt = fechaPublTxt;
	}

	public JTextField getAutorTxt() {
		return autorTxt;
	}

	public void setAutorTxt(JTextField autorTxt) {
		this.autorTxt = autorTxt;
	}

	public JTextField getVerLibroTitulo() {
		return verLibroTitulo;
	}

	public void setVerLibroTitulo(JTextField verLibroTitulo) {
		this.verLibroTitulo = verLibroTitulo;
	}

	public JTextField getFicheroByte() {
		return ficheroByte;
	}

	public void setFicheroByte(JTextField ficheroByte) {
		this.ficheroByte = ficheroByte;
	}

	public JTextField getFicheroCByte() {
		return ficheroCByte;
	}

	public void setFicheroCByte(JTextField ficheroCByte) {
		this.ficheroCByte = ficheroCByte;
	}

	public JButton getCopiar() {
		return copiar;
	}

	public void setCopiar(JButton copiar) {
		this.copiar = copiar;
	}

	public JCheckBox getPrimera() {
		return primera;
	}

	public void setPrimera(JCheckBox primera) {
		this.primera = primera;
	}

	public JButton getComparar() {
		return comparar;
	}

	public void setComparar(JButton comparar) {
		this.comparar = comparar;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
			
	public JTextField getFichero1() {
		return fichero1;
	}

	public void setFichero1(JTextField fichero1) {
		this.fichero1 = fichero1;
	}

	public JTextField getPalabra() {
		return palabra;
	}

	public void setPalabra(JTextField palabra) {
		this.palabra = palabra;
	}

	public JTextField getFichero2() {
		return fichero2;
	}

	public void setFichero2(JTextField fichero2) {
		this.fichero2 = fichero2;
	}

	public void showError(String m){
		JOptionPane.showMessageDialog(this.panel,
			    m,
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
	}


}
