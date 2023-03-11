package interfaces;

import javax.swing.*;

import programa.ConversorMonedas;
import programa.ListaMonedas;
import programa.Moneda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazMoneda implements ActionListener {
    private JComboBox<Moneda> comboBoxOrigen;
    private JComboBox<Moneda> comboBoxDestino;
    private JTextField cantidadTextField;
    private JLabel resultadoLabel;
    private ConversorMonedas conversorMonedas;

    public InterfazMoneda() {
        JFrame ventana = new JFrame("Conversor de monedas");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setPreferredSize(new Dimension(500, 500));
        ventana.setLayout(new BoxLayout(ventana.getContentPane(), BoxLayout.Y_AXIS));
        ventana.getContentPane().setBackground(new Color(226, 240, 255));

        JPanel panelOrigen = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelDestino = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelCantidad = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelResultado = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelOrigen = new JLabel("Moneda origen:");
        JLabel labelDestino = new JLabel("Moneda destino:");
        JLabel labelCantidad = new JLabel("Cantidad:");
        comboBoxOrigen = new JComboBox<>(ListaMonedas.getListaMonedas().toArray(new Moneda[0]));
        comboBoxDestino = new JComboBox<>(ListaMonedas.getListaMonedas().toArray(new Moneda[0]));
        cantidadTextField = new JTextField();
        JButton botonConvertir = new JButton("Convertir");
        resultadoLabel = new JLabel();
        JButton botonVolver = new JButton("Volver");

        comboBoxOrigen.setSelectedIndex(0);
        comboBoxDestino.setSelectedIndex(1);
        cantidadTextField.setColumns(10);
        resultadoLabel.setPreferredSize(new Dimension(400, 30));
        resultadoLabel.setHorizontalAlignment(JLabel.CENTER);
        resultadoLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        resultadoLabel.setForeground(new Color(17, 54, 99));
        botonConvertir.addActionListener(this);
        botonConvertir.setBackground(new Color(17, 54, 99));
        botonConvertir.setForeground(Color.WHITE);
        botonConvertir.setFont(new Font("Verdana", Font.BOLD, 20));
        labelOrigen.setFont(new Font("Verdana", Font.PLAIN, 20));
        labelOrigen.setForeground(new Color(17, 54, 99));
        labelDestino.setFont(new Font("Verdana", Font.PLAIN, 20));
        labelDestino.setForeground(new Color(17, 54, 99));
        labelCantidad.setFont(new Font("Verdana", Font.PLAIN, 20));
        labelCantidad.setForeground(new Color(17, 54, 99));
        comboBoxOrigen.setFont(new Font("Verdana", Font.PLAIN, 20));
        comboBoxOrigen.setBackground(Color.WHITE);
        comboBoxOrigen.setForeground(new Color(17, 54, 99));
        comboBoxDestino.setFont(new Font("Verdana", Font.PLAIN, 20));
        comboBoxDestino.setBackground(Color.WHITE);
        comboBoxDestino.setForeground(new Color(17, 54, 99));
        cantidadTextField.setFont(new Font("Verdana", Font.PLAIN, 20));
        cantidadTextField.setForeground(new Color(17, 54, 99));
        cantidadTextField.setBorder(BorderFactory.createLineBorder(new Color(17, 54, 99), 2));
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

        panelOrigen.add(labelOrigen);
        panelOrigen.add(comboBoxOrigen);
        panelDestino.add(labelDestino);
        panelDestino.add(comboBoxDestino);
        panelCantidad.add(labelCantidad);
        panelCantidad.add(cantidadTextField);
        panelResultado.add(resultadoLabel);
        panelBoton.add(botonConvertir);
        panelBoton.add(botonVolver);
        

        ventana.add(panelOrigen);
        ventana.add(panelDestino);
        ventana.add(panelCantidad);
        ventana.add(panelResultado);
        ventana.add(panelBoton);

        conversorMonedas = new ConversorMonedas();

        ventana.pack();
        ventana.setVisible(true);
  }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double cantidad = Double.parseDouble(cantidadTextField.getText());
            Moneda monedaOrigen = (Moneda) comboBoxOrigen.getSelectedItem();
            Moneda monedaDestino = (Moneda) comboBoxDestino.getSelectedItem();
            double resultado = conversorMonedas.convertir(cantidad, monedaOrigen.getCodigo(), monedaDestino.getCodigo());
            resultadoLabel.setText(String.format("%.2f %s", resultado, monedaDestino.getSimbolo()));
        } catch (NumberFormatException ex) {
            resultadoLabel.setText("Error: la cantidad no es un número válido");
        }
    }

    public static void main(String[] args) {
        new InterfazMoneda();
    }
}

