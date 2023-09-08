/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolpractica;

import java.util.ArrayList;

/**
 *
 * @author Yiro
 */
public class Arbol {
    
    public Nodo raiz;
    
    public Arbol(){
        raiz = null;
    }
    
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
    
    public ArrayList<Double> obtenerInorden() {
        ArrayList<Double> datosEnOrden = new ArrayList<>();
        inordenRec(raiz, datosEnOrden);
        return datosEnOrden;
    }

    private void inordenRec(Nodo nodo, ArrayList<Double> datosEnOrden) {
        if (nodo == null) {
            return;
        }
        inordenRec(nodo.izq, datosEnOrden);
        datosEnOrden.add(nodo.dato);
        inordenRec(nodo.der, datosEnOrden);
    }
    
    public ArrayList<Double> obtenerPreorden() {
        ArrayList<Double> datosEnOrden = new ArrayList<>();
        preordenRec(raiz, datosEnOrden);
        return datosEnOrden;
    }

    private void preordenRec(Nodo nodo, ArrayList<Double> datosEnOrden) {
        if (nodo == null) {
            return;
        }
        datosEnOrden.add(nodo.dato);
        preordenRec(nodo.izq, datosEnOrden);
        preordenRec(nodo.der, datosEnOrden);
    }
    
    public ArrayList<Double> obtenerPostorden() {
        ArrayList<Double> datosEnOrden = new ArrayList<>();
        postordenRec(raiz, datosEnOrden);
        return datosEnOrden;
    }

    private void postordenRec(Nodo nodo, ArrayList<Double> datosEnOrden) {
        if (nodo == null) {
            return;
        }
        postordenRec(nodo.izq, datosEnOrden);
        postordenRec(nodo.der, datosEnOrden);
        datosEnOrden.add(nodo.dato);
    }
    
    public boolean eliminar(double dato) {
    if (raiz == null) {
        return false; // El árbol está vacío, no se puede eliminar nada
    } else {
        Nodo nodoPadre = null;
        Nodo nodoActual = raiz;

        // Buscar el nodo a eliminar y su padre
        while (nodoActual != null) {
            if (dato == nodoActual.dato) {
                break; // Encontramos el nodo a eliminar
            }
            nodoPadre = nodoActual;
            if (dato < nodoActual.dato) {
                nodoActual = nodoActual.izq;
            } else {
                nodoActual = nodoActual.der;
            }
        }

        // Si no se encontró el nodo a eliminar
        if (nodoActual == null) {
            return false;
        }

        // Caso 1: Nodo hoja (sin hijos)
        if (nodoActual.izq == null && nodoActual.der == null) {
            if (nodoPadre == null) {
                raiz = null; // El árbol tenía solo un nodo
            } else if (nodoActual == nodoPadre.izq) {
                nodoPadre.izq = null;
            } else {
                nodoPadre.der = null;
            }
        }
        // Caso 2: Nodo con un hijo
        else if (nodoActual.izq == null) {
            if (nodoPadre == null) {
                raiz = nodoActual.der;
            } else if (nodoActual == nodoPadre.izq) {
                nodoPadre.izq = nodoActual.der;
            } else {
                nodoPadre.der = nodoActual.der;
            }
        } else if (nodoActual.der == null) {
            if (nodoPadre == null) {
                raiz = nodoActual.izq;
            } else if (nodoActual == nodoPadre.izq) {
                nodoPadre.izq = nodoActual.izq;
            } else {
                nodoPadre.der = nodoActual.izq;
            }
        }
        // Caso 3: Nodo con dos hijos
        else {
            Nodo sucesor = obtenerNodoSucesor(nodoActual);
            nodoActual.dato = sucesor.dato;
            eliminar(sucesor.dato);
        }

        return true;
    }
}

    private Nodo obtenerNodoSucesor(Nodo nodo) {
        Nodo sucesorPadre = nodo;
        Nodo sucesor = nodo.der;
        while (sucesor.izq != null) {
            sucesorPadre = sucesor;
            sucesor = sucesor.izq;
        }
        if (sucesorPadre != nodo) {
            sucesorPadre.izq = sucesor.der;
            sucesor.der = nodo.der;
        }
        return sucesor;
    }

}
