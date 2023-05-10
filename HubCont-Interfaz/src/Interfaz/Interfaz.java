package Interfaz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;

public class Interfaz extends JFrame implements Serializable {
    private JPanel PanelPrincipal;
    private JTextField textNumIden;
    private JTextField textPeso;
    private JTextArea textAreaDescCont;
    private JTextField EmpRem;
    private JTextField EmpRecep;
    private JTabbedPane tabbedPane1;
    private JButton apilarButton;
    private JButton desabilitarButton;
    private JTextField textDesapilar;
    private JButton mostrarDatosContenedorButton;
    private JTextField textMostDatCont;
    private JButton cuántosButton;
    private JComboBox comboPais1;
    private JTextField textCuantos;
    private JComboBox comboPais;
    private JRadioButton Boton1;
    private JRadioButton Boton2;
    private JRadioButton Boton3;
    private JCheckBox insAdCheckBox;
    private JTextArea textAreaEstado;
    private JTextField salir;

    //private Hub hub;

    public Interfaz() throws IOException, ClassNotFoundException {
        // Las 4 sentencias de siempre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cierra la aplicacion y sale de memoria
        this.setTitle("Formulario Contenedor Hub");
        this.setSize(800, 400);
        this.setVisible(true);
        // Añadimos nuestro panel principal
        this.add(PanelPrincipal);

        // Añadimos opciones al combo País Procedencia
        this.comboPais.addItem("España");
        this.comboPais.addItem("Portugal");
        this.comboPais.addItem("Francia");
        this.comboPais.addItem("Italia");
        this.comboPais.setSelectedItem(null);
        // Añadimos opciones al combo Destino
        this.comboPais1.addItem("España");
        this.comboPais1.addItem("Portugal");
        this.comboPais1.addItem("Francia");
        this.comboPais1.addItem("Italia");
        this.comboPais1.setSelectedItem(null);

        mostrarDatosContenedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SecondWindow sw = new SecondWindow(c.mostrarContenedor(Integer.parseInt(textField6.getText())), aduanas);
            }
        });
        apilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Pulsaste el botón 'Apilar'.", "", JOptionPane.INFORMATION_MESSAGE);
                if(textField1.getText()!=null &&
                        textField2.getText()!=null &&
                        textField3.getText()!=null &&
                        textField4.getText()!=null &&
                        textArea1.getText()!=null &&
                        comboBox1.getSelectedItem()!=null &&
                        (a1RadioButton.isSelected() || a2RadioButton.isSelected() || a3RadioButton.isSelected())

                ){
                    int x=0;
                    if(a1RadioButton.isSelected())
                        x=1;
                    if(a2RadioButton.isSelected())
                        x=2;
                    if(a3RadioButton.isSelected())
                        x=3;
                    Contenedor cont = new Contenedor(Integer.parseInt(textField1.getText()),x,Double.parseDouble(textField2.getText()),
                            (String)comboBox1.getSelectedItem(), textArea1.getText(), textField3.getText(), textField4.getText());
                    c.apilarContenedor(cont);
                    textArea2.setText(c.toString());

                }
            }
        });

        desapilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Pulsaste el botón 'Desapìlar'.", "", JOptionPane.INFORMATION_MESSAGE);
                if (textField5.getText() != null && textfield.getText() != null) {
                    c.desapilarContenedor(Integer.parseInt(textField5.getText()), Integer.parseInt(textfield.getText()));
                    textArea2.setText(c.toString());
                }
            }
                });

        inspeccionadoEnAduanasCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inspeccionadoEnAduanasCheckBox.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Pulsaste el botón 'Inspeccionado en aduanas'.", "", JOptionPane.INFORMATION_MESSAGE);
                    aduanas = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Despulsaste el botón 'Inspeccionado en aduanas'.", "", JOptionPane.INFORMATION_MESSAGE);
                    aduanas = false;
                }
            }
        });




        Boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Boton1.isSelected()){
                    Boton2.setSelected(false);
                    Boton3.setSelected(false);
                }
            }
        });
        Boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Boton2.isSelected()){
                    Boton1.setSelected(false);
                    Boton3.setSelected(false);
                }
            }
        });
        Boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Boton3.isSelected()){
                    Boton1.setSelected(false);
                    Boton2.setSelected(false);
                }
            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox1.getSelectedItem() == "Sin desayuno")
                    JOptionPane.showMessageDialog(null, "Has seleccionado sin desayuno", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        });


    }

    public static void main(String[] args){

        Interfaz intzf = new Interfaz();

    }

}
