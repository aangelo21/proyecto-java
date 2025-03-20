// Importamos las utilidades

import javax.swing.*;
import java.awt.*;
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
    setSize(500, 400);  // Reducimos la altura de 700 a 400
    setTitle("Formulario");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Añadimos los componentes

    //Componentes de nombre
    JLabel etiquetaNombre = new JLabel("Introduce tu nombre");
    JTextField textoNombre = new JTextField(15);

    //Componentes de apellidos
    JLabel etiquetaApellidos = new JLabel("Introduce tus apellidos");
    JTextField textoApellidos = new JTextField(15);

    //Componentes de DNI
    JLabel etiquetaDNI = new JLabel("Introduce tu DNI");
    JTextField textoDNI = new JTextField(15);

    //Componentes de telefono
    JLabel etiquetaTelefono = new JLabel("Introduce tu telefono");
    JTextField textoTelefono = new JTextField(15);

    //Componentes de correo electronico
    JLabel etiquetaCorreo = new JLabel("Introduce tu correo electronico");
    JTextField textoCorreo = new JTextField(15);

    //Componentes de contraseña
    JLabel etiquetaPassword = new JLabel("Introduce tu contraseña");
    JTextField textoPassword = new JTextField(15);

    //Botones
    JButton botonEnviar = new JButton("Enviar"); //Boton enviar
    JButton botonLimpiar = new JButton("Limpiar"); //Boton limpiar
    JButton botonCancelar = new JButton("Cancelar"); //Boton cancelar
    JButton botonEasterEgg = new JButton("?"); //Boton easter egg

    // Eventos

    //Evento para limpiar textos
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
    JPanel panel = new JPanel(new BorderLayout(10, 10));
    
    // Panel para los campos del formulario
    JPanel formPanel = new JPanel(new GridLayout(6, 2, 5, 5));
    formPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Reducimos el padding vertical
    
    // Añadimos los componentes al panel del formulario
    formPanel.add(etiquetaNombre);
    formPanel.add(textoNombre);
    formPanel.add(etiquetaApellidos);
    formPanel.add(textoApellidos);
    formPanel.add(etiquetaDNI);
    formPanel.add(textoDNI);
    formPanel.add(etiquetaTelefono);
    formPanel.add(textoTelefono);
    formPanel.add(etiquetaCorreo);
    formPanel.add(textoCorreo);
    formPanel.add(etiquetaPassword);
    formPanel.add(textoPassword);

    // Panel para los botones
    JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
    botonesPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Reducimos el padding vertical
    
    // Añadimos los botones al panel de botones
    botonesPanel.add(botonEnviar);
    botonesPanel.add(botonLimpiar);
    botonesPanel.add(botonCancelar);
    botonesPanel.add(botonEasterEgg);

    // Añadimos los paneles al panel principal
    panel.add(formPanel, BorderLayout.CENTER);
    panel.add(botonesPanel, BorderLayout.SOUTH);

    setContentPane(panel);
    setVisible(true);
  }

  //Metodo main para que se pueda mostrar la ventana
  public static void main(String[] args) {
    new Formulario();
  }

}
