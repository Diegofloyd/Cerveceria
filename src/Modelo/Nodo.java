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
public class Nodo {
    int num;
    private String Nombre;
    private String Marca;
    private String porcientoAlcohol;
    private float Precio;
    private String Tamano;
    private String tipoCerveza;
    private String Presentacion;
    private Nodo Siguiente;
    private Nodo Anterior;

    public Nodo() {
        this.Nombre = null;
        this.Marca = null;
        this.porcientoAlcohol = null;
        this.Precio = 0;
        this.Tamano = null;
        this.tipoCerveza = null;
        this.Presentacion = null;
        this.Siguiente = null;
        this.Anterior = null;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getPorcientoAlcohol() {
        return porcientoAlcohol;
    }

    public void setPorcientoAlcohol(String porcientoAlcohol) {
        this.porcientoAlcohol = porcientoAlcohol;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public String getTamano() {
        return Tamano;
    }

    public void setTamano(String Tamano) {
        this.Tamano = Tamano;
    }

    public String getTipoCerveza() {
        return tipoCerveza;
    }

    public void setTipoCerveza(String tipoCerveza) {
        this.tipoCerveza = tipoCerveza;
    }

    public String getPresentacion() {
        return Presentacion;
    }

    public void setPresentacion(String Presentacion) {
        this.Presentacion = Presentacion;
    }

    public Nodo getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(Nodo Siguiente) {
        this.Siguiente = Siguiente;
    }

    public Nodo getAnterior() {
        return Anterior;
    }

    public void setAnterior(Nodo Anterior) {
        this.Anterior = Anterior;
    }
    
}
