package arboles;
 
import Analizadores.Scanner;
import Analizadores.sintactico;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
 
public class interfaz extends JFrame
{
   private JButton jButton1;
   private JButton jButton2;
   private JButton jButton3;
   private JButton jButton4;
   private JMenu jMenu1;
   private JMenu jMenu2;
   private JMenuBar jMenuBar1;
   private JMenuItem jMenuItem1;
   private JMenuItem jMenuItem2;
   private JMenuItem jMenuItem3;
   private JTextField mensaje;
 
   public interfaz(){
     initComponents();
   }
 
   private void initComponents(){
     this.jMenuItem2 = new JMenuItem();
     this.mensaje = new JTextField();
     this.jButton1 = new JButton();
     this.jButton2 = new JButton();
     this.jButton3 = new JButton();
     this.jButton4 = new JButton();
     this.jMenuBar1 = new JMenuBar();
     this.jMenu1 = new JMenu();
     this.jMenuItem3 = new JMenuItem();
     this.jMenuItem1 = new JMenuItem();
     this.jMenu2 = new JMenu();
 
     this.jMenuItem2.setText("jMenuItem2");
 
     setDefaultCloseOperation(3);
 
     this.jButton1.setText("Analizar Entrada");
     this.jButton1.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent evt) {
         interfaz.this.jButton1ActionPerformed(evt);
       }
     });
     this.jButton2.setText("Generar Imagenes");
     this.jButton2.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent evt) {
         interfaz.this.jButton2ActionPerformed(evt);
       }
     });
     this.jButton3.setText("Arbol Sintactico");
     this.jButton3.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent evt) {
         interfaz.this.jButton3ActionPerformed(evt);
       }
     });
     this.jButton4.setText("Arbol de Expresiones");
     this.jButton4.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent evt) {
         interfaz.this.jButton4ActionPerformed(evt);
       }
     });
     this.jMenu1.setText("File");
 
     this.jMenuItem3.setText("Generar Imagenes");
     this.jMenuItem3.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent evt) {
         interfaz.this.jMenuItem3ActionPerformed(evt);
       }
     });
     this.jMenu1.add(this.jMenuItem3);
 
     this.jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(65, 2));
     this.jMenuItem1.setText("Analizar Entrada");
     this.jMenuItem1.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent evt) {
         interfaz.this.jMenuItem1ActionPerformed(evt);
       }
     });
     this.jMenu1.add(this.jMenuItem1);
 
     this.jMenuBar1.add(this.jMenu1);
 
     this.jMenu2.setText("Edit");
     this.jMenuBar1.add(this.jMenu2);
 
     setJMenuBar(this.jMenuBar1);
 
     GroupLayout layout = new GroupLayout(getContentPane());
     getContentPane().setLayout(layout);
     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jButton3, -2, 163, -2).addGap(18, 18, 18).addComponent(this.jButton4, -2, 155, -2)).addGroup(layout.createSequentialGroup().addComponent(this.mensaje, -2, 202, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jButton1, -1, -1, 32767).addComponent(this.jButton2, -1, 178, 32767)))).addContainerGap(-1, 32767)));
 
     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(36, 36, 36).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButton1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.mensaje, -2, 84, -2).addComponent(this.jButton2))).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton3).addComponent(this.jButton4)).addContainerGap(28, 32767)));
 
     pack();
   }
 
   private void jButton1ActionPerformed(ActionEvent evt){
     System.out.println("***************Inicio***************");
     try {
       Scanner scanner2 = new Scanner(new BufferedReader(new StringReader(this.mensaje.getText())));
       sintactico miparser = new sintactico(scanner2);
       miparser.parse();
     }
     catch (Exception ex)
     {
     }
 
     System.out.println("***************Fin***************");
   }
 
   private void jMenuItem1ActionPerformed(ActionEvent evt){
   }
 
   private void jMenuItem3ActionPerformed(ActionEvent evt)
   {
     generar("Sintactico");
     generar("expresion");
   }
 
   private void jButton4ActionPerformed(ActionEvent evt) {
     mostrar("expresion");
   }
 
   private void jButton2ActionPerformed(ActionEvent evt) {
     generar("Sintactico");
     generar("expresion");
   }
 
   private void jButton3ActionPerformed(ActionEvent evt) {
     mostrar("Sintactico");
   }
 
   public void generar(String archivo){
     try {
	//Path donde se encuentra instalado Graphviz '\\Graphviz2.30\\bin\\dot.exe'
       String dotPath = "";
 	
	//Path donde se almacenara el archivo que graficara Graphviz.
       String fileInputPath = "" + archivo + ".txt";
 
	//Path donde se almacenara el archivo graficado Graphviz.
       String fileOutputPath = "" + archivo + ".jpg";
 
       String tParam = "-Tjpg";
 
       String tOParam = "-o";
 
       String[] cmd = new String[5];
       cmd[0] = dotPath;
       cmd[1] = tParam;
       cmd[2] = fileInputPath;
       cmd[3] = tOParam;
       cmd[4] = fileOutputPath;
 
       Runtime rt = Runtime.getRuntime();
 
       rt.exec(cmd);
     }
     catch (Exception ex) {
       ex.printStackTrace();
     } finally {
     }
   }
 
   public void mostrar(String nombre) {
     File f = new File("E:\\Jefferson\\Universidad\\Ciclo 8\\Analizador_Sintactico\\" + nombre + ".jpg");
     try {
       Desktop.getDesktop().open(f);
     } catch (IOException ex) {
       JOptionPane.showMessageDialog(this, "ERROR EN LA GENERACION DEL ARCHIVO");
     }
   }
 
   public static void main(String[] args){
     try
     {
       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
         if ("Nimbus".equals(info.getName())) {
           UIManager.setLookAndFeel(info.getClassName());
           break;
         }
     }
     catch (ClassNotFoundException ex){
       Logger.getLogger(interfaz.class.getName()).log(Level.SEVERE, null, ex);
     } catch (InstantiationException ex) {
       Logger.getLogger(interfaz.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IllegalAccessException ex) {
       Logger.getLogger(interfaz.class.getName()).log(Level.SEVERE, null, ex);
     } catch (UnsupportedLookAndFeelException ex) {
       Logger.getLogger(interfaz.class.getName()).log(Level.SEVERE, null, ex);
     }
 
     EventQueue.invokeLater(new Runnable(){
       public void run() {
         new interfaz().setVisible(true);
       }
     });
   }
 }