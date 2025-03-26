// Importamos las utilidades

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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

    // Eventos

    //Evento para guardar datos
    botonEnviar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (textoTelefono.getText().length() == 9 && textoPassword.getText().length() >= 9 && textoCorreo.getText().contains("@")) {
          try {
            BufferedWriter escribir = new BufferedWriter(new FileWriter("datos.txt", true));
            escribir.write(textoNombre.getText());
            escribir.newLine();
            escribir.write(textoApellidos.getText());
            escribir.newLine();
            escribir.write(textoDNI.getText());
            escribir.newLine();
            escribir.write(textoTelefono.getText());
            escribir.newLine();
            escribir.write(textoCorreo.getText());
            escribir.newLine();
            escribir.write(textoPassword.getText());
            escribir.newLine();
            escribir.close();
            textoNombre.setText("");
            textoApellidos.setText("");
            textoDNI.setText("");
            textoTelefono.setText("");
            textoCorreo.setText("");
            textoPassword.setText("");
            mostrarMensaje("Datos enviados correctamente", "Éxito");
          } catch (IOException ex) {
            mostrarMensaje("Error al escribir los datos", "Error");
          }
        } else {
          if (textoTelefono.getText().length() != 9) {
            mostrarMensaje("El teléfono debe tener 9 dígitos", "Error");
          }
          if (textoPassword.getText().length() < 9) {
            mostrarMensaje("La contraseña debe tener al menos 9 caracteres", "Error");
          }
          if (!textoCorreo.getText().contains("@")) {
            mostrarMensaje("El correo electrónico debe contener '@'", "Error");
          }
        }
      }
    });

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

    //Evento para salir del formulario
    botonCancelar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        mostrarVentanaConfirmacionCancelar();
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
    formPanel.add(botonEnviar);

    // Panel para los botones
    JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
    botonesPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

    // Añadimos los botones al panel de botones
    botonesPanel.add(botonEnviar);
    botonesPanel.add(botonLimpiar);
    botonesPanel.add(botonCancelar);

    // Añadimos los paneles al panel principal
    panel.add(formPanel, BorderLayout.CENTER);
    panel.add(botonesPanel, BorderLayout.SOUTH);

    setContentPane(panel);
    setVisible(true);
  }

  //Ventanas de confirmacion

  //Ventana de confirmacion al salir del formulario
  private void mostrarVentanaConfirmacionCancelar() {
    // Crear una nueva ventana para confirmar si el usuario quiere salir
    JDialog confirmacionDialog = new JDialog(this, "¿Seguro que desea salir?", true);
    confirmacionDialog.setSize(300, 150);
    confirmacionDialog.setLayout(new FlowLayout());

    // Crear los botones "Aceptar" y "Cancelar"
    JButton aceptarButton = new JButton("Aceptar");
    JButton cancelarButton = new JButton("Cancelar");

    // Acción al hacer clic en "Aceptar"
    aceptarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0); // Cerrar la aplicación
      }
    });

    // Acción al hacer clic en "Cancelar"
    cancelarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        confirmacionDialog.dispose(); // Cerrar la ventana de confirmación
      }
    });

    // Añadir los botones al diálogo
    confirmacionDialog.add(aceptarButton);
    confirmacionDialog.add(cancelarButton);

    // Hacer visible la ventana de confirmación
    confirmacionDialog.setLocationRelativeTo(this); // Centrar la ventana en la principal
    confirmacionDialog.setVisible(true);
  }

  // Metodo para mostrar mensajes de confirmación y error
  private void mostrarMensaje(String mensaje, String titulo) {
    JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
  }

  //Metodo main para que se pueda mostrar la ventana
  public static void main(String[] args) {
    new Formulario();
  }

}