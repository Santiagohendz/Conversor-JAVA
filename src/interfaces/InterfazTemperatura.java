package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazTemperatura implements ActionListener {
    private JComboBox<String> comboBoxOrigen;
    private JComboBox<String> comboBoxDestino;
    private JTextField cantidadTextField;
    private JLabel resultadoLabel;

    public InterfazTemperatura() {
        JFrame ventana = new JFrame("Conversor de temperaturas");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setPreferredSize(new Dimension(500, 500));
        ventana.setLayout(new BoxLayout(ventana.getContentPane(), BoxLayout.Y_AXIS));
        ventana.getContentPane().setBackground(new Color(226, 240, 255));

        JPanel panelOrigen = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelDestino = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelCantidad = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelResultado = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelOrigen = new JLabel("Escala origen:");
        JLabel labelDestino = new JLabel("Escala destino:");
        JLabel labelCantidad = new JLabel("Temperatura:");
        comboBoxOrigen = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});
        comboBoxDestino = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});
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

        ventana.pack();
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double temperatura = Double.parseDouble(cantidadTextField.getText());
            String escalaOrigen = comboBoxOrigen.getSelectedItem().toString();
            String escalaDestino = comboBoxDestino.getSelectedItem().toString();
            double resultado = convertirTemperatura(temperatura, escalaOrigen, escalaDestino);
            String simboloOrigen = obtenerSimboloTemperatura(escalaOrigen);
            String simboloDestino = obtenerSimboloTemperatura(escalaDestino);
            String resultadoTexto = String.format("%.2f %s = %.2f %s", temperatura, simboloOrigen, resultado, simboloDestino);
            resultadoLabel.setText(resultadoTexto);
        } catch (NumberFormatException ex) {
            resultadoLabel.setText("Error: la temperatura debe ser un número válido");
        }
    }

    private double convertirTemperatura(double temperatura, String escalaOrigen, String escalaDestino) {
        double resultado = 0;

        switch (escalaOrigen) {
            case "Celsius":
                resultado = temperatura + 273.15;
                break;
            case "Fahrenheit":
                resultado = (temperatura + 459.67) * 5 / 9;
                break;
            case "Kelvin":
                resultado = temperatura;
                break;
        }
        switch (escalaDestino) {
            case "Celsius":
                resultado -= 273.15;
                break;
            case "Fahrenheit":
                resultado = resultado * 9 / 5 - 459.67;
                break;
            case "Kelvin":
                break;
        }

        return resultado;
    }

    private String obtenerSimboloTemperatura(String escala) {
        switch (escala) {
            case "Celsius":
                return "°C";
            case "Fahrenheit":
                return "°F";
            case "Kelvin":
                return "K";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        new InterfazTemperatura();
    }
}    	