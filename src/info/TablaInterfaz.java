package info;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.TableRowSorter;

public class TablaInterfaz extends JFrame {

    private JTable tabla;
    private DefaultTableModel modelo;
    private JComboBox<String> comboBoxComunidad;

    public TablaInterfaz() {
        setTitle("Tabla de Datos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("RUN");
        modelo.addColumn("Dirección");
        modelo.addColumn("Correo");
        modelo.addColumn("Número Celular");
        modelo.addColumn("N° Familiares");
        modelo.addColumn("Comunidad");

        tabla = new JTable(modelo);

        // Combobox para filtrar por comunidad
        comboBoxComunidad = new JComboBox<>();
        comboBoxComunidad.addItem("Divina Providencia");
        comboBoxComunidad.addItem("San Juan Evangelista");
        comboBoxComunidad.addItem("Aux1");
        comboBoxComunidad.addItem("Aux2");
        comboBoxComunidad.addItem("Aux3");
        comboBoxComunidad.addItem("Aux4");
        comboBoxComunidad.addItem("Aux5");
        comboBoxComunidad.addItem("Aux6");
        comboBoxComunidad.addItem("Aux7");
        comboBoxComunidad.addItem("Aux8");

        // Botón de filtrar
        JButton botonFiltrar = new JButton("Filtrar");
        botonFiltrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarPorComunidad();
            }
        });

        // Panel superior con el combobox y el botón de filtrar
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelSuperior.add(comboBoxComunidad);
        panelSuperior.add(botonFiltrar);

        // Botón de regresar
        JButton botonRegresar = new JButton("Regresar");
        botonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirMenuInterfaz();
            }
        });

        // Botón de agregar
        JButton botonAgregar = new JButton("Agregar");
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarDato();
            }
        });

        // Botón de modificar
        JButton botonModificar = new JButton("Modificar");
        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarDato();
            }
        });

        // Botón de eliminar
        JButton botonEliminar = new JButton("Eliminar");
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarDato();
            }
        });

        // Panel inferior izquierdo con los botones de regresar, agregar, modificar y eliminar
        JPanel panelInferiorIzquierdo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelInferiorIzquierdo.add(botonRegresar);
        panelInferiorIzquierdo.add(botonAgregar);
        panelInferiorIzquierdo.add(botonModificar);
        panelInferiorIzquierdo.add(botonEliminar);

        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(panelSuperior, BorderLayout.NORTH);
        add(panelInferiorIzquierdo, BorderLayout.SOUTH);

        setSize(800, 600);
        setLocationRelativeTo(null);
        
        cargarDatosDeEjemplo();
        abrirEnPantallaCompleta();
    }
    
    private void cargarDatosDeEjemplo() {
        Object[][] datosEjemplo = {
            {"Juan Pérez", "12345678-9", "Calle 123", "juan@example.com", "987654321", "4", "Divina Providencia"},
            {"María Gómez", "98765432-1", "Avenida 456", "maria@example.com", "123456789", "2", "San Juan Evangelista"},
            {"Pedro Rodríguez", "45678901-2", "Plaza 789", "pedro@example.com", "654321987", "3", "Reñaca"}
        };

        for (Object[] fila : datosEjemplo) {
            modelo.addRow(fila);
        }
    }
    
    private void abrirEnPantallaCompleta() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void abrirMenuInterfaz() {
        MenuInterfaz menuInterfaz = new MenuInterfaz();
        menuInterfaz.setVisible(true);
        dispose();
    }

    private void filtrarPorComunidad() {
        String comunidadSeleccionada = (String) comboBoxComunidad.getSelectedItem();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        tabla.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(comunidadSeleccionada, 6));
    }

    private void agregarDato() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre:");
        if (nombre != null && !nombre.isEmpty()) {
            String run = JOptionPane.showInputDialog(this, "Ingrese el RUN:");
            if (run != null && !run.isEmpty()) {
                String direccion = JOptionPane.showInputDialog(this, "Ingrese la dirección:");
                if (direccion != null && !direccion.isEmpty()) {
                    String correo = JOptionPane.showInputDialog(this, "Ingrese el correo:");
                    if (correo != null && !correo.isEmpty()) {
                        String numeroCelular = JOptionPane.showInputDialog(this, "Ingrese el número celular:");
                        if (numeroCelular != null && !numeroCelular.isEmpty()) {
                            String numFamiliares = JOptionPane.showInputDialog(this, "Ingrese el número de familiares:");
                            if (numFamiliares != null && !numFamiliares.isEmpty()) {
                                String comunidad = JOptionPane.showInputDialog(this, "Ingrese la comunidad:");
                                if (comunidad != null && !comunidad.isEmpty()) {
                                    modelo.addRow(new Object[]{nombre, run, direccion, correo, numeroCelular, numFamiliares, comunidad});
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void modificarDato() {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre:", modelo.getValueAt(filaSeleccionada, 0));
            if (nombre != null && !nombre.isEmpty()) {
                String run = JOptionPane.showInputDialog(this, "Ingrese el RUN:", modelo.getValueAt(filaSeleccionada, 1));
                if (run != null && !run.isEmpty()) {
                    String direccion = JOptionPane.showInputDialog(this, "Ingrese la dirección:", modelo.getValueAt(filaSeleccionada, 2));
                    if (direccion != null && !direccion.isEmpty()) {
                        String correo = JOptionPane.showInputDialog(this, "Ingrese el correo:", modelo.getValueAt(filaSeleccionada, 3));
                        if (correo != null && !correo.isEmpty()) {
                            String numeroCelular = JOptionPane.showInputDialog(this, "Ingrese el número celular:", modelo.getValueAt(filaSeleccionada, 4));
                            if (numeroCelular != null && !numeroCelular.isEmpty()) {
                                String numFamiliares = JOptionPane.showInputDialog(this, "Ingrese el número de familiares:", modelo.getValueAt(filaSeleccionada, 5));
                                if (numFamiliares != null && !numFamiliares.isEmpty()) {
                                    String comunidad = JOptionPane.showInputDialog(this, "Ingrese la comunidad:", modelo.getValueAt(filaSeleccionada, 6));
                                    if (comunidad != null && !comunidad.isEmpty()) {
                                        modelo.setValueAt(nombre, filaSeleccionada, 0);
                                        modelo.setValueAt(run, filaSeleccionada, 1);
                                        modelo.setValueAt(direccion, filaSeleccionada, 2);
                                        modelo.setValueAt(correo, filaSeleccionada, 3);
                                        modelo.setValueAt(numeroCelular, filaSeleccionada, 4);
                                        modelo.setValueAt(numFamiliares, filaSeleccionada, 5);
                                        modelo.setValueAt(comunidad, filaSeleccionada, 6);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarDato() {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este dato?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                modelo.removeRow(filaSeleccionada);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}