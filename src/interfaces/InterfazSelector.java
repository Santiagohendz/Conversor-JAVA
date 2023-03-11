package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazSelector implements ActionListener {
    private JFrame ventana;
    private JComboBox<String> comboBox;

    public InterfazSelector() {
        ventana = new JFrame("Seleccionar conversor");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setPreferredSize(new Dimension(500, 500));
        ventana.setLayout(new BoxLayout(ventana.getContentPane(), BoxLayout.Y_AXIS));
        ventana.getContentPane().setBackground(new Color(226, 240, 255));

        JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelSeleccion = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelTitulo = new JLabel("Seleccione el tipo de conversor:");
        comboBox = new JComboBox<>(new String[]{"Conversor de monedas", "Conversor de temperaturas"});
        JButton botonSeleccionar = new JButton("Seleccionar");
        JButton botonVolver = new JButton("Volver");

        labelTitulo.setFont(new Font("Verdana", Font.BOLD, 25));
        labelTitulo.setForeground(new Color(17, 54, 99));
        comboBox.setFont(new Font("Verdana", Font.PLAIN, 20));
        comboBox.setBackground(Color.WHITE);
        comboBox.setForeground(new Color(17, 54, 99));
        botonSeleccionar.addActionListener(this);
        botonSeleccionar.setBackground(new Color(17, 54, 99));
        botonSeleccionar.setForeground(Color.WHITE);
        botonSeleccionar.setFont(new Font("Verdana", Font.BOLD, 20));
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.dispose();
                new InterfazSelector();
            }
        });
        botonVolver.setBackground(new Color(17, 54, 99));
        botonVolver.setForeground(Color.WHITE);
        botonVolver.setFont(new Font("Verdana", Font.BOLD, 20));

        panelTitulo.add(labelTitulo);
        panelSeleccion.add(comboBox);
        panelBoton.add(botonSeleccionar);
        panelBoton.add(botonVolver);

        ventana.add(panelTitulo);
        ventana.add(Box.createRigidArea(new Dimension(0, 50)));
        ventana.add(panelSeleccion);
        ventana.add(Box.createRigidArea(new Dimension(0, 50)));
        ventana.add(panelBoton);

        ventana.pack();
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String seleccion = (String) comboBox.getSelectedItem();

        if (seleccion.equals("Conversor de monedas")) {
            new InterfazMoneda();
        } else if (seleccion.equals("Conversor de temperaturas")) {
            new InterfazTemperatura();
        }

        ventana.dispose();
    }

    public static void main(String[] args) {
        new InterfazSelector();
    }
}