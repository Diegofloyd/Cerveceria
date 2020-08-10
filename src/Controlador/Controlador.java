/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.CervezasDAO;
import Modelo.ListaSimple;
import Modelo.Nodo;
import Vista.VistaConsultarC;
import Vista.VistaRegistrarC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Johan López
 */
public class Controlador implements ActionListener, KeyListener {

    private CervezasDAO Model = new CervezasDAO();
    private VistaConsultarC VistaC = new VistaConsultarC();
    private VistaRegistrarC View = new VistaRegistrarC();
    int numR;

    public Controlador(CervezasDAO Model, VistaRegistrarC View) {
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
        this.numR = Model.UltimoRegistro();
    }

    public void LlenarTabla(JTable table) {
        DefaultTableModel modeloT = new DefaultTableModel();
        table.setModel(modeloT);
        modeloT.addColumn("Id");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Marca");
        modeloT.addColumn("% Alcohol");
        modeloT.addColumn("Precio");
        modeloT.addColumn("Tamaño");
        modeloT.addColumn("Tipo de Cerveza");
        modeloT.addColumn("Presentación");

        Object[] columna = new Object[8];
        int numRegistros = Model.ListaCervezas().size();

        for (int i = 0; i < numRegistros; i++) {
            columna[0] = Model.ListaCervezas().get(i).getIdCerveza();
            columna[1] = Model.ListaCervezas().get(i).getNombre();
            columna[2] = Model.ListaCervezas().get(i).getMarca();
            columna[3] = Model.ListaCervezas().get(i).getPorcientoAlcohol();
            columna[4] = Model.ListaCervezas().get(i).getPrecio();
            columna[5] = Model.ListaCervezas().get(i).getTamano();
            columna[6] = Model.ListaCervezas().get(i).getTipoCerveza();
            columna[7] = Model.ListaCervezas().get(i).getPresentacion();
            modeloT.addRow(columna);
        }
    }
    //Despues de aqui, hay que cambiar todo
    //Puede que algunos metodos ya no sirvan

    public void Iniciar() {
        this.View.setTitle("Formulario de registros de Cervezas");
        this.View.setLocationRelativeTo(null);
        this.View.btnConsultar.setEnabled(false);
        this.View.btnGuardar.setEnabled(true);
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
//Este metodo se queda, solo hay que modificar
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
        if (this.View.txtPrecio.getText().length() != 0) {
            nodo.setPrecio(Integer.parseInt(this.View.txtPrecio.getText().toString()));
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
            nodo.setTipoCerveza("Clara");
        } else {
            if (this.View.cbOscura.isSelected()) {
                Oscura = "Oscura";
                nodo.setTipoCerveza("Oscura");
            } else {
                if (this.View.cbAmbar.isSelected()) {
                    Ambar = "Ambar";
                    nodo.setTipoCerveza("Ambar");
                } else {
                    JOptionPane.showMessageDialog(null, "Es necesario elegir el Tipo de Cerveza");
                }
            }
        }

        if (this.View.rbtLata.isSelected()) {
            Lata = "Lata";
            nodo.setPresentacion("Lata");

        } else {
            if (this.View.rbtVidrio.isSelected()) {
                Vidrio = "Botella de Vidrio";
                nodo.setPresentacion("Botella de Vidrio");
            } else {
                JOptionPane.showMessageDialog(null, "Es necesario seleccionar la presentación");
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Boton = e.getActionCommand();
        try {
            switch (Boton) {
                case "Guardar":
                    validarCampo();
                    Model.AgregarRegistro(nodo.getNombre(), nodo.getMarca(), nodo.getPorcientoAlcohol(), nodo.getPrecio(), nodo.getTamano(), nodo.getTipoCerveza(), nodo.getPresentacion());
                    limpiar();
                    this.View.btnGuardar.setEnabled(true);
                    this.View.btnConsultar.setEnabled(true);
                    break;
                case "Consultar":

                    this.Model.EstadoActual = this.Model.getInicio();
                    VistaC.setVisible(true);
                    this.VistaC.TablaConsultar.removeAll();
                    this.Tabla.setNumRows(0);

                    if (Model.getBand() == 0) {
                        this.Tabla.addColumn("Nombre");
                        this.Tabla.addColumn("Marca");
                        this.Tabla.addColumn("Porciento de Alcohol");
                        this.Tabla.addColumn("Precio");
                        this.Tabla.addColumn("Tamaño");
                        this.Tabla.addColumn("Tipo de Cerveza");
                        this.Tabla.addColumn("Presentación");

                        while (this.Model.EstadoActual != null) {
                            this.nodo = this.Model.mostrarRegistros();
                            informacion[0] = nodo.getNombre();
                            informacion[1] = nodo.getMarca();
                            informacion[2] = nodo.getPorcientoAlcohol();
                            informacion[3] = String.valueOf(nodo.getPrecio());
                            informacion[4] = nodo.getTamano();
                            informacion[5] = nodo.getTipoCerveza();
                            informacion[6] = nodo.getPresentacion();

                            Tabla.addRow(informacion);

                            Model.setBand(1);
                        }

                        VistaC.TablaConsultar.setModel(Tabla);
                    } else {
                        while (this.Model.EstadoActual != null) {
                            this.nodo = this.Model.mostrarRegistros();
                            informacion[0] = nodo.getNombre();
                            informacion[1] = nodo.getMarca();
                            informacion[2] = String.valueOf(nodo.getPorcientoAlcohol());
                            informacion[3] = String.valueOf(nodo.getPrecio());
                            informacion[4] = nodo.getTamano();
                            informacion[5] = nodo.getTipoCerveza();
                            informacion[6] = nodo.getPresentacion();

                            Tabla.addRow(informacion);

                            Model.setBand(1);
                        }

                        VistaC.TablaConsultar.setModel(Tabla);

                    }

                    break;
                case "Eliminar":
                    try {

                        if (this.VistaC.TablaConsultar.getRowCount() == 0) {
                            this.VistaC.dispose();
                            JOptionPane.showMessageDialog(null, "No hay registros");
                            this.View.btnConsultar.setEnabled(false);
                            band = 1;
                        } else {
                            this.Model.Eliminar(this.VistaC.TablaConsultar.getSelectedRow());
                            this.Model.Indexar();
                            Tabla = (DefaultTableModel) this.VistaC.TablaConsultar.getModel();
                            Tabla.removeRow(this.VistaC.TablaConsultar.getSelectedRow());

                        }

                    } catch (Exception w) {
                        JOptionPane.showMessageDialog(null, "Error eliminar" + w);
                    }

                    break;
                case "Modificar":
                    if (this.VistaC.TablaConsultar.getRowCount() >= 0) {

                        try {
                            Nombre = this.VistaC.TablaConsultar.getValueAt(this.VistaC.TablaConsultar.getSelectedRow(), 0).toString();
                            Marca = this.VistaC.TablaConsultar.getValueAt(this.VistaC.TablaConsultar.getSelectedRow(), 1).toString();
                            Precio = Integer.parseInt(this.VistaC.TablaConsultar.getValueAt(this.VistaC.TablaConsultar.getSelectedRow(), 2).toString());
                            PorcientoAlcohol = this.VistaC.TablaConsultar.getValueAt(this.VistaC.TablaConsultar.getSelectedRow(), 3).toString();
                            Tamano = String.valueOf(this.VistaC.TablaConsultar.getValueAt(this.VistaC.TablaConsultar.getSelectedRow(), 4).toString());
                            TipoCerveza = this.VistaC.TablaConsultar.getValueAt(this.VistaC.TablaConsultar.getSelectedRow(), 5).toString();
                            Presentacion = this.VistaC.TablaConsultar.getValueAt(this.VistaC.TablaConsultar.getSelectedRow(), 6).toString();
                            this.Model.ModificarRegistro(Nombre, Marca, PorcientoAlcohol, Precio, Tamano, TipoCerveza, Presentacion, this.VistaC.TablaConsultar.getSelectedRow() + 1);
                            JOptionPane.showMessageDialog(null, "Los datos fueron modificados");
                        } catch (NumberFormatException er) {
                            JOptionPane.showMessageDialog(null, "Error: " + er);
                        }

                    }
                    break;

                case "Cargar Archivo":
                    try {
                        this.Model.CargarArchivos();
                        if (this.Model.getInicio() != null) {
                            this.View.btnConsultar.setEnabled(true);
                            this.View.btnCargarArchivo.setEnabled(false);
                        } else {
                            this.View.btnConsultar.setEnabled(false);
                        }
                    } catch (Exception x) {
                        JOptionPane.showMessageDialog(null, "Error en cargar archivo");
                    }
                    break;
                case "Guardar Archivo":
                    try {
                        this.Model.GuardarArchivo();
                        this.View.btnGuardarArchivo.setEnabled(false);
                        this.View.btnCargarArchivo.setEnabled(false);
                    } catch (Exception g) {
                        JOptionPane.showMessageDialog(null, "Error en guardar archivo");
                    }
                    break;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
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
