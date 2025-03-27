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
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Formulario");

    // Components creation
    JLabel etiquetaNombre = new JLabel("Introduce tu nombre");
    JTextField textoNombre = new JTextField(15);
    JLabel etiquetaApellidos = new JLabel("Introduce tus apellidos");
    JTextField textoApellidos = new JTextField(15);
    JLabel etiquetaDNI = new JLabel("Introduce tu DNI");
    JTextField textoDNI = new JTextField(15);
    JLabel etiquetaTelefono = new JLabel("Introduce tu telefono");
    JTextField textoTelefono = new JTextField(15);
    JLabel etiquetaCorreo = new JLabel("Introduce tu correo electronico");
    JTextField textoCorreo = new JTextField(15);
    JLabel etiquetaPassword = new JLabel("Introduce tu contraseña");
    JPasswordField textoPassword = new JPasswordField(15);

    JButton botonEnviar = new JButton("Enviar");
    JButton botonLimpiar = new JButton("Limpiar");
    JButton botonCancelar = new JButton("Cancelar");
    JButton botonCondiciones = new JButton("Condiciones");
    JButton botonPrevisualizar = new JButton("Previsualizar");

    // Set button colors
    botonEnviar.setBackground(new Color(102, 255, 102));
    botonLimpiar.setBackground(new Color(255, 255, 153));
    botonCancelar.setBackground(new Color(255, 51, 51));
    botonCondiciones.setBackground(new Color(204, 153, 255));
    botonPrevisualizar.setBackground(new Color(204, 204, 204));

    // Layout
    Container contentPane = getContentPane();
    GroupLayout layout = new GroupLayout(contentPane);
    contentPane.setLayout(layout);
    
    // Horizontal group
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaNombre)
                    .addComponent(etiquetaApellidos)
                    .addComponent(etiquetaCorreo)
                    .addComponent(etiquetaPassword)
                    .addComponent(etiquetaDNI)
                    .addComponent(etiquetaTelefono)
                    .addComponent(botonEnviar)
                    .addComponent(botonPrevisualizar))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(textoNombre)
                    .addComponent(textoApellidos)
                    .addComponent(textoCorreo)
                    .addComponent(textoPassword)
                    .addComponent(textoDNI)
                    .addComponent(textoTelefono)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonLimpiar)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonCancelar)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonCondiciones)))
                .addGap(27, 27, 27))
    );

    // Vertical group
    layout.setVerticalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombre)
                    .addComponent(textoNombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaApellidos)
                    .addComponent(textoApellidos))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaCorreo)
                    .addComponent(textoCorreo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaPassword)
                    .addComponent(textoPassword))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaDNI)
                    .addComponent(textoDNI))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaTelefono)
                    .addComponent(textoTelefono))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEnviar)
                    .addComponent(botonLimpiar)
                    .addComponent(botonCancelar)
                    .addComponent(botonCondiciones))
                .addGap(11, 11, 11)
                .addComponent(botonPrevisualizar)
                .addGap(8, 8, 8))
    );

    pack();
    setVisible(true);
    
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
            escribir.write(new String(textoPassword.getPassword()));
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
          if (textoPassword.getPassword().length < 9) {
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

    //Evento para mostrar condiciones
    botonCondiciones.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        mostrarMensaje("Las condiciones son:" +
            "\nLa contraseña debe tener al menos 9 caracteres" +
            "\nEl numero de telefono debe ser de 9 digitos" +
            "\nEl correo debe contener una @", "Condiciones del formulario");
      }
    });

    //Evento para previsualizar datos
    botonPrevisualizar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        StringBuilder errores = new StringBuilder();
        
        // Validar todos los campos independientemente
        if (textoTelefono.getText().length() != 9) {
          errores.append("El teléfono debe tener 9 dígitos\n");
        }
        if (textoPassword.getPassword().length < 9) {
          errores.append("La contraseña debe tener al menos 9 caracteres\n");
        }
        if (!textoCorreo.getText().contains("@")) {
          errores.append("El correo electrónico debe contener '@'\n");
        }

        // Mostrar mensaje según si hay errores o no
        if (errores.length() > 0) {
          mostrarMensaje("Los errores son:\n" + errores.toString(), "Validación");
        } else {
         
          mostrarMensaje("No hay errores", "Previsualización");
        }
      }
    });
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