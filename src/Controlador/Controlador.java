/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ListaSimple;
import Modelo.Nodo;
import Vista.VistaConsultarC;
import Vista.VistaRegistrarC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Johan López
 */
public class Controlador implements ActionListener, KeyListener {

    private VistaRegistrarC View;
    private ListaSimple Model;

    VistaConsultarC VistaC = new VistaConsultarC();
    private DefaultTableModel Tabla;

    private Nodo nodo = new Nodo();
    boolean validacion = false;
    String[] informacion = new String[6];

    String Clara = null;
    String Oscura = null;
    String Ambar = null;
    String Lata = null;
    String Vidrio = null;

    public Controlador(ListaSimple Model, VistaRegistrarC View) {
        this.Model = Model;
        this.View = View;
        this.View.txtNombre.addActionListener(this);
        this.View.txtMarca.addActionListener(this);
        this.View.txtPrecio.addActionListener(this);
        this.View.cbPorcientoAlcohol.addActionListener(this);
        this.View.btgTipoCerveza.add(this.View.cbClara);
        this.View.btgTipoCerveza.add(this.View.cbOscura);
        this.View.btgTipoCerveza.add(this.View.cbAmbar);
        this.View.btgPresentacion.add(this.View.rbtLata);
        this.View.btgPresentacion.add(this.View.rbtVidrio);
        this.View.cbTamano.addActionListener(this);
        //Vista Consultar registros
        this.VistaC.btnEliminar.addActionListener(this);
        this.VistaC.btnModificar.addActionListener(this);
        //botones
        this.View.btnCargarArchivo.addActionListener(this);
        this.View.btnGuardarArchivo.addActionListener(this);
        this.View.btnGuardar.addActionListener(this);
        this.View.btnConsultar.addActionListener(this);
        this.VistaC.btnEliminar.addActionListener(this);
        this.VistaC.btnModificar.addActionListener(this);
    }

    public void Iniciar() {
        this.View.setTitle("Formulario de registros de Cervezas");
        this.View.setLocationRelativeTo(null);
        this.View.btnConsultar.setEnabled(false);
        this.View.btnGuardar.setEnabled(false);
        Tabla = new DefaultTableModel();

    }

    public void limpiar() {
        this.View.txtNombre.setText("");//---------------------
        this.View.txtMarca.setText("");
        this.View.txtPrecio.setText("");
        this.View.cbPorcientoAlcohol.setSelectedIndex(0);
        this.View.cbTamano.setSelectedIndex(0);

        //------------------------------------
        this.View.rbtLata.setSelected(false);
        this.View.rbtVidrio.setSelected(false);
        //--------------Pendiente----------------------------
        this.View.btgPresentacion.setSelected(null, validacion);

    }

    public void validarCampo() {
        int ac1 = 0;
        int ac2 = 0;

        if (this.View.txtNombre.getText().length() != 0) {
            nodo.setNombre(this.View.txtNombre.getText().toString());
            validacion = true;
            ac1 += 1;

        } else {
            JOptionPane.showMessageDialog(null, "Debe llenar el campo de 'Nombre' ");
            validacion = false;
            ac2 += 1;
        }
        if (this.View.txtMarca.getText().length() != 0) {
            nodo.setMarca(this.View.txtMarca.getText().toString());
            validacion = true;
            ac1 += 1;
        } else {
            JOptionPane.showMessageDialog(null, "Debe llenar el campo 'Marca' ");
            validacion = false;
            ac2 += 1;

        }
        if (this.View.txtPrecio.getText().length() == 0) {
            nodo.setPrecio(Integer.parseInt(this.View.txtPrecio.getText()));
            validacion = true;
            ac1 += 1;
        } else {
            JOptionPane.showMessageDialog(null, "Debe llenar el campo 'Precio' ");
            validacion = false;
            ac2 += 1;
        }
        //----------------------Pendientes por revisar------------------------------------------
        if (this.View.cbPorcientoAlcohol.isValid()) {
            String PorcientoA = this.View.cbPorcientoAlcohol.getSelectedItem().toString();
            String edad2 = PorcientoA;
            nodo.setPorcientoAlcohol(edad2);

        } else {
            JOptionPane.showMessageDialog(null, "Es necesario llenar el campo 'Porciento de Alcohol'");
            validacion = false;
        }
        if (this.View.cbTamano.isValid()) {
            String Tamano = this.View.cbTamano.getSelectedItem().toString();
            String tamano2 = Tamano;
            nodo.setTamano(tamano2);
        } else {
            JOptionPane.showMessageDialog(null, "Es necesario llenar el campo de 'Tamaño'");
            validacion = false;
        }
        //-------------------------------------------------------------------------------

        if (this.View.cbClara.isSelected()) {
            Clara = "Clara";
        } else {
            if (this.View.cbOscura.isSelected()) {
                Oscura = "Oscura";
            } else {
                if (this.View.cbAmbar.isSelected()) {
                    Ambar = "Ambar";
                } else {
                    JOptionPane.showMessageDialog(null, "Es necesario elegir el Tipo de Cerveza");
                }
            }
        }

        if (this.View.rbtLata.isSelected()) {
            Lata = "Lata";

        } else {
            if (this.View.rbtVidrio.isSelected()) {
                Vidrio = "Botella de Vidrio";
            } else {
                JOptionPane.showMessageDialog(null, "Es necesario seleccionar la presentación");
            }
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Boton=e.getActionCommand();
        try{
            switch(Boton){
                case "Guardar":
                    
            }
        }catch(Exception ex){
            
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

}
