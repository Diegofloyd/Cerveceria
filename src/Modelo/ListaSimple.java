/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Johan López
 */
public class ListaSimple {

    private Nodo inicio;
    private Nodo fin;
    public Nodo EstadoActual;
    int band, cont;

    public ListaSimple() {
        this.inicio = null;
        this.fin = null;
        this.EstadoActual = null;
        this.band = 0;
        this.cont = 0;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public Nodo getEstadoActual() {
        return EstadoActual;
    }

    public void setEstadoActual(Nodo EstadoActual) {
        this.EstadoActual = EstadoActual;
    }

    public int getBand() {
        return band;
    }

    public void setBand(int band) {
        this.band = band;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public boolean Vacia() {
        boolean resp;
        if (this.inicio == null && this.fin == null) {
            resp = true;
        } else {
            resp = false;
        }
        return resp;
    }


    public void Insertar(String Nombre, String Marca, String porcientoAlcohol, String Precio,  String Tamano, String tipoCerveza, String Presentacion) {
        Nodo nuevo_N = new Nodo();
         this.Contador++;
         nuevo_N.setNum(Contador);
        nuevo_N.setNombre(Nombre);
        nuevo_N.setMarca(Apellido);
        nuevo_N.setPorcientoAlcohol(porcientoAlcohol);
        nuevo_N.setPrecio(Precio);
        nuevo_N.setTamano(Tamano);
        nuevo_N.setTipoCerveza(tipoCerveza);
        nuevo_N.setPresentacion(Presentacion);
        

        if (Vacia()) {
            this.inicio = nuevo_N;
            this.fin = nuevo_N;
            this.EstadoActual = inicio;
        } else {
            this.fin.setSiguiente(nuevo_N);
            nuevo_N.setAnterior(this.fin);
            this.fin = nuevo_N;
        }
    }

    public Nodo mostrarLista() {
        Nodo aux = new Nodo();
        aux = EstadoActual;
        if (Vacia()) {
            JOptionPane.showMessageDialog(null, "No hay ningun registro por mostrar");

        } else {
            if (aux != null) {
                aux.getNombre();
                aux.getMarca();
                aux.getPorcientoAlcohol();
                aux.getPrecio();
                aux.getTamano();
                aux.getTipoCerveza();
                aux.getPresentacion()
                
            }
        }

        this.EstadoActual = aux.getSiguiente();
        return aux;
    }


}
