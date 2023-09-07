/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolpractica;

/**
 *
 * @author Yiro
 */
public class Nodo {
    double dato;
    String nombre;
    Nodo izq, der;

    public double getDato() {
        return dato;
    }

    public void setDato(double dato) {
        this.dato = dato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }
    
    public Nodo(){
        dato = 0.0;
        nombre = "";
        izq = null;
        der = null;
    }
    
    public Nodo(double dato, String nombre){
        this.dato = dato;
        this.nombre = nombre;
    }
}
