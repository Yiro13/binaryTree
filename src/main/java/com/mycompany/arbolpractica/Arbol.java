/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolpractica;

/**
 *
 * @author Yiro
 */
public class Arbol {
    
    public Nodo raiz;
    
    public Arbol(){
        raiz = null;
    }
    
    /*public void insertar(Nodo raiz, Nodo nodo){
        if(raiz == null){
            raiz = nodo;
            System.out.println("Insertado " + nodo.getDato());
        }else{
            if(nodo.dato < raiz.dato){
                insertar(raiz.izq, nodo);
            }else{
                insertar(raiz.der, nodo);
            }
        }
    }*/
    
    public void insertar(double dato, String nombre) {
        raiz = insertarRec(raiz, dato, nombre);
    }

    private Nodo insertarRec(Nodo nodo, double dato, String nombre) {
        if (nodo == null) {
            return new Nodo(dato, nombre);
        }

        if (dato < nodo.dato) {
            nodo.izq = insertarRec(nodo.izq, dato, nombre);
        } else if (dato > nodo.dato) {
            nodo.der = insertarRec(nodo.der, dato, nombre);
        }

        return nodo;
    }

    
    public Nodo buscar(Nodo raiz, double dato){
        if(raiz == null){
            return null;
        }else if(dato == raiz.dato){
            return raiz;
        }else if(dato < raiz.dato){
            return buscar(raiz.izq, dato);
        }else if(dato > raiz.dato){
            return buscar(raiz.der, dato);
        }else{
            return null;
        }
    }
 
}
