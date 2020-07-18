/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.JOptionPane;

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

    public void Insertar(String Nombre, String Marca, String porcientoAlcohol, int Precio, String Tamano, String tipoCerveza, String Presentacion) {
        Nodo nuevo_N = new Nodo();
        this.cont++;
        nuevo_N.setNum(cont);
        nuevo_N.setNombre(Nombre);
        nuevo_N.setMarca(Marca);
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
                aux.getPresentacion();

            }
        }

        this.EstadoActual = aux.getSiguiente();
        return aux;
    }

    public void Indexar() {
        Nodo aux = this.inicio;
        cont = cont - 1;
        if (!Vacia()) {
            do {
                aux.num = ++cont;
                aux = aux.getSiguiente();
            } while (aux != null);

        }

    }

    public void Modificar(String Nombre, String Marca, String PorcientoAlcohol, int Precio, String Tamano, String tipoCerveza, String Presentacion, int num) {
        Nodo aux = this.inicio;

        if (Vacia()) {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        } else {
            do {
                if (aux.getNum() == num) {
                    aux.setNombre(Nombre);
                    aux.setMarca(Marca);
                    aux.setPorcientoAlcohol(PorcientoAlcohol);
                    aux.setPrecio(Precio);
                    aux.setTamano(Tamano);
                    aux.setTipoCerveza(tipoCerveza);
                    aux.setPresentacion(Presentacion);

                }
                aux = aux.getSiguiente();
            } while (aux != null);
        }

    }

    public void eliminar(int n) {
        if (!Vacia()) {
            Nodo actual = this.inicio;
            Nodo actual_borrar = actual.getSiguiente();

            if (actual.getNum() == n && this.fin == this.inicio) {
                this.inicio = null;
                this.fin = null;
                EstadoActual = null;
                cont = -1;

            } else {
                if (actual.getNum() == n && actual == inicio && actual.getSiguiente() == this.fin) {
                    this.inicio = this.inicio.getSiguiente();
                    cont = 0;
                } else {
                    if (actual_borrar.getNum() == n && actual == inicio && actual.getSiguiente() == this.fin && actual_borrar.getSiguiente() == null) {
                        actual.setSiguiente(null);
                        this.fin = this.inicio;
                        cont--;
                    } else {
                        while (actual.getSiguiente() != null) {

                            if (actual_borrar.getNum() == n) {
                                Nodo borrar_siguiente = actual_borrar.getSiguiente();
                                actual.setSiguiente(borrar_siguiente);
                                cont--;
                                break;
                            }
                            actual = actual.getSiguiente();
                            if (actual.getSiguiente() != null) {
                                actual_borrar = actual.getSiguiente();
                            }
                        }
                    }
                }
            }
        }

    }

    public Nodo mostrarRegistros() {
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
                aux.getPresentacion();
            }
        }

        this.EstadoActual = aux.getSiguiente();
        return aux;
    }
    

}
