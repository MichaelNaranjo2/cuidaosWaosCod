
package com.mycompany.cuidaoswaoscod;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CuidaosWaosCod extends JFrame {
    JTextField perrosGrandesField;
    JTextField perrosMedianosField;
    JTextField perrosPequenosField;
    JTextField horasField;
    JButton enviarButton;
    
    public static void main(String[] args) {
        new CuidaosWaosCod().setVisible(true);
    }

    public CuidaosWaosCod() {
        setTitle("Cuidaos Waos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 200);
        setLocationRelativeTo(null);

        perrosGrandesField = new JTextField(10);
        perrosMedianosField = new JTextField(10);
        perrosPequenosField = new JTextField(10);
        horasField = new JTextField(10);
        enviarButton = new JButton("Enviar");
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int perrosGrandes = Integer.parseInt(perrosGrandesField.getText());
                    int perrosMedianos = Integer.parseInt(perrosMedianosField.getText());
                    int perrosPequenos = Integer.parseInt(perrosPequenosField.getText());
                    int horas = Integer.parseInt(horasField.getText());

                    int precioTotal = (perrosGrandes * 10000 + perrosMedianos * 5000 + perrosPequenos * 3000) * horas;
                    
                    if ((perrosGrandes==0  && perrosMedianos==0 && perrosPequenos==0) || horas==0) {
                        JOptionPane.showMessageDialog(CuidaosWaosCod.this, "Error, no se permite que las horas sean 0, o que todos los perros sean 0");
                    } else {
                        if (perrosGrandes<0  || perrosMedianos<0 || perrosPequenos<0 || horas<0) {
                            JOptionPane.showMessageDialog(CuidaosWaosCod.this, "Error, no se permiten números negativos");
                        } else {
                            if (perrosGrandes>10  || perrosMedianos>10 || perrosPequenos>10 || horas>12) {
                                JOptionPane.showMessageDialog(CuidaosWaosCod.this, "Error, debe llenar maximo 10 perros por categoria y máximo 12 horas");
                            } else {
                                if (perrosGrandes + perrosMedianos + perrosPequenos > 1) {
                                    double descuento = 0.1;
                                    precioTotal -= precioTotal * descuento;
                                }
                                JOptionPane.showMessageDialog(CuidaosWaosCod.this, "El precio a pagar es: $" + precioTotal);
                            }
                        }
                    }
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(CuidaosWaosCod.this,
                            "Datos no validos");
                }
            }
        });
        
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.add(new JLabel("¿Cuántos perros grandes desea que cuidemos?"));
        panel.add(perrosGrandesField);
        panel.add(new JLabel("¿Cuántos perros medianos desea que cuidemos?"));
        panel.add(perrosMedianosField);
        panel.add(new JLabel("¿Cuántos perros pequeños desea que cuidemos?"));
        panel.add(perrosPequenosField);
        panel.add(new JLabel("¿Cuántas Horas?"));
        panel.add(horasField);
        panel.add(new JLabel());
        panel.add(enviarButton);
        
        getContentPane().add(panel, BorderLayout.CENTER);
    }
}