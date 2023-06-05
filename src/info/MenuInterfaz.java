package info;

import javax.swing.*;

public class MenuInterfaz extends JFrame {
    public MenuInterfaz() {
        setTitle("Menú");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JButton btnAbrirTabla = new JButton("Abrir Tabla");
        btnAbrirTabla.setBounds(50, 30, 200, 30);
        add(btnAbrirTabla);

        JButton btnCerrarPrograma = new JButton("Cerrar Programa");
        btnCerrarPrograma.setBounds(50, 70, 200, 30);
        add(btnCerrarPrograma);

        btnAbrirTabla.addActionListener(e -> {
            dispose(); // Cerrar la interfaz del menú
            abrirTablaInterfaz(); // Abrir la interfaz de la tabla
        });

        btnCerrarPrograma.addActionListener(e -> {
            System.exit(0); // Cerrar el programa
        });
    }

    private void abrirTablaInterfaz() {
        java.awt.EventQueue.invokeLater(() -> {
            TablaInterfaz tablaInterfaz = new TablaInterfaz();
            tablaInterfaz.setVisible(true);
        });
    }
}
