// Importamos las utilidades

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario extends JFrame {

  //Creamos un main, que llame al metodo de iniciar componentes
  public Formulario() {
    initComponents();
  }

  //Esta es la ventana que se va a mostrar
  public void initComponents() {

    //Añadimos las caracteristicas bases de la ventana
    setSize(500, 700);
    setTitle("Formulario");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Añadimos los componentes

    //Componentes de nombre
    JLabel etiquetaNombre = new JLabel("Introduce tu nombre");
    JTextField textoNombre = new JTextField(25);

    //Componentes de apellidos
    JLabel etiquetaApellidos = new JLabel("Introduce tus apellidos");
    JTextField textoApellidos = new JTextField(25);

    //Componentes de DNI
    JLabel etiquetaDNI = new JLabel("Introduce tu DNI");
    JTextField textoDNI = new JTextField(25);

    //Componentes de telefono
    JLabel etiquetaTelefono = new JLabel("Introduce tu telefono");
    JTextField textoTelefono = new JTextField(25);

    //Componentes de correo electronico
    JLabel etiquetaCorreo = new JLabel("Introduce tu correo electronico");
    JTextField textoCorreo = new JTextField(25);

    //Componentes de contraseña
    JLabel etiquetaPassword = new JLabel("Introduce tu contraseña");
    JTextField textoPassword = new JTextField(25);

    //Botones
    JButton botonEnviar = new JButton("Enviar"); //Boton enviar
    JButton botonLimpiar = new JButton("Limpiar"); //Boton limpiar
    JButton botonCancelar = new JButton("Cancelar"); //Boton cancelar
    JButton botonEasterEgg = new JButton("?"); //Boton easter egg

    // Eventos
    botonLimpiar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        textoNombre.setText("");
        textoApellidos.setText("");
        textoDNI.setText("");
        textoTelefono.setText("");
        textoCorreo.setText("");
        textoPassword.setText("");
      }
    });

    //Creamos el panel
    JPanel panel = new JPanel();

    //Añadimos los componentes a la ventana
    panel.add(etiquetaNombre);
    panel.add(textoNombre);
    panel.add(etiquetaApellidos);
    panel.add(textoApellidos);
    panel.add(etiquetaDNI);
    panel.add(textoDNI);
    panel.add(etiquetaTelefono);
    panel.add(textoTelefono);
    panel.add(etiquetaCorreo);
    panel.add(textoCorreo);
    panel.add(etiquetaPassword);
    panel.add(textoPassword);
    panel.add(botonEnviar);
    panel.add(botonLimpiar);
    panel.add(botonCancelar);
    panel.add(botonEasterEgg);
    setContentPane(panel);
    setVisible(true);
  }

  //Metodo main para que se pueda mostrar la ventana
  public static void main(String[] args) {
    new Formulario();
  }

}
