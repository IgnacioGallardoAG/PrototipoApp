package info;

import javax.swing.*;

public class InicioSesionInterfaz extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContraseña;

    public InicioSesionInterfaz() {
        setTitle("Inicio de Sesión");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(20, 20, 80, 30);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(100, 20, 160, 30);
        add(txtUsuario);

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setBounds(20, 60, 80, 30);
        add(lblContraseña);

        txtContraseña = new JPasswordField();
        txtContraseña.setBounds(100, 60, 160, 30);
        add(txtContraseña);

        JButton btnIniciarSesion = new JButton("Iniciar sesión");
        btnIniciarSesion.setBounds(100, 100, 120, 30);
        add(btnIniciarSesion);

        btnIniciarSesion.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String contraseña = String.valueOf(txtContraseña.getPassword());

            // Verificar el usuario y la contraseña
            if (usuario.equals("admin") && contraseña.equals("password") || usuario.equals("admin1") && contraseña.equals("password")) {
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                dispose(); // Cerrar la interfaz de inicio de sesión
                abrirMenuInterfaz(); // Abrir la interfaz de la tabla
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales inválidas");
            }
        });
    }

    private void abrirMenuInterfaz() {
        java.awt.EventQueue.invokeLater(() -> {
            MenuInterfaz menuInterfaz = new MenuInterfaz();
            menuInterfaz.setVisible(true);
        });
    }
}
