package Comp;

import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Ventana extends JFrame {
	static TextArea t1;
	static JTextArea t2;
	static comp analizador;
	public Ventana(String title) {
		InputStream stream = new ByteArrayInputStream( "".getBytes(StandardCharsets.UTF_8));
		analizador = new comp(stream) ;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle(title);
		this.setLayout(null);
		this.setResizable(false);
		t1 = new TextArea();
		this.setVisible(true);
		this.setLocation(230, 80);
		this.setSize(800, 600);										
		t1.setLocation(0, 0);	
		t1.setSize(550, 350);	
		t1.setBackground(Color.WHITE);
		JButton btn1= new JButton("Correr");
		Correr run = new Correr();
		btn1.addActionListener(run);
		btn1.setSize(120, 60);
		btn1.setLocation(600, 20);
		JButton btn2= new JButton("Abrir  archivo");
		AdjuntarArchivo adj= new AdjuntarArchivo();
		btn2.addActionListener(adj);
		btn2.setSize(120, 60);
		btn2.setLocation(600, 100);
		JButton btn3= new JButton("Borrar");
		Borrar borrar = new Borrar();
		btn3.addActionListener(borrar);
		btn3.setSize(120, 60);
		btn3.setLocation(600, 180);
		this.add(t1);
		this.add(btn1);		
		this.add(btn2);
		this.add(btn3);
		t2 = new JTextArea();
		t2.setSize(780, 205);	
		t2.setLocation(5, 355);			
		t2.setEditable(false);
		t2.setBackground(Color.WHITE);		
		t2.setForeground(Color.RED);
		this.add(t2);
		this.repaint();
		
	}
	class Borrar implements ActionListener{	
		public void actionPerformed(ActionEvent arg0) {			
			t1.setText(null);
			
		}
		
	}
	class AdjuntarArchivo implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			System.out.println("Adjuntar archivo");							
			
		}

	}
	class Correr implements ActionListener {	
		public void actionPerformed(ActionEvent arg0) {			
			iniciar();			
			
		}		
	}
	static void iniciar(){
		try
		{		
			String g=t1.getText();
			InputStream stream = new ByteArrayInputStream( g.getBytes(StandardCharsets.UTF_8));
			analizador.ReInit(stream);     		
			analizador.Programa();
					
		}
		catch(ParseException e)
		{
			t2.setText(e.getMessage()+"\n"+"\tAnalizador ha terminado.");
			System.out.println(e.getMessage());
			System.out.println("\tAnalizador ha terminado.");
		}
	}
}
