package aed;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo cabeza;
    private Nodo cola;
    private int longitud;

    private class Nodo {
        T dato;
        Nodo siguiente;
        Nodo anterior;

        Nodo (T v){
            this.dato = v;
        }
    }

    public ListaEnlazada() {
        this.cabeza = new Nodo(null);
        this.cola = new Nodo(null);
        this.longitud = 0;
        this.cabeza.anterior = null;
        this.cabeza.siguiente = cola;
        this.cola.siguiente = null;
        this.cola.anterior = cabeza;
    }

    public int longitud() {
        return this.longitud;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevoadelante = new Nodo(elem);
        if (this.longitud == 0){
            this.cabeza.siguiente = nuevoadelante;
            this.cola.anterior = nuevoadelante;
            nuevoadelante.siguiente = this.cola;
            nuevoadelante.anterior = this.cabeza;
            this.longitud += 1;
        } 
        else{
            nuevoadelante.siguiente = this.cabeza.siguiente;
            nuevoadelante.anterior = this.cabeza;
            this.cabeza.siguiente.anterior = nuevoadelante;
            this.cabeza.siguiente = nuevoadelante;
            this.longitud += 1;
        }
    }
    public void agregarAtras(T elem) {
        Nodo nuevoatras = new Nodo(elem); 
        if (this.longitud == 0){
            this.cabeza.siguiente = nuevoatras;
            this.cola.anterior = nuevoatras;
            nuevoatras.siguiente = this.cola;
            nuevoatras.anterior = this.cabeza;
            this.longitud += 1;
        } 
        else{
            nuevoatras.siguiente = this.cola;
            nuevoatras.anterior = this.cola.anterior;
            this.cola.anterior.siguiente = nuevoatras;
            this.cola.anterior = nuevoatras;     
            this.longitud += 1;
    }
    }

    public T obtener(int i) {
        Nodo actual = this.cabeza;
        if (i==0 && this.longitud > 0){
            return actual.siguiente.dato;
        }
        else if (i > 0 && this.longitud > 0){
            while (i >= 0){
                actual = actual.siguiente;
                i -= 1;    
            }   
        return actual.dato;
        }
        else {
            return null;
        }    
    }
    
    private Nodo aux_iterador(int i, ListaEnlazada<T> l){
        Nodo cur = l.cabeza;
        if (i==0 && l.longitud > 0){
            return cur.siguiente;
        }
        else if (i > 0 && l.longitud > 0){
            while (i >= 0){
                cur = cur.siguiente;
                i -= 1;    
            }   
        return cur;
        }
        else {
            return null;
        } 
    }

    public void eliminar(int i) {
        Nodo a_eliminar = aux_iterador(i, this);
        a_eliminar.anterior.siguiente = a_eliminar.siguiente;
        a_eliminar.siguiente.anterior = a_eliminar.anterior;
        this.longitud -= 1;
    }

    public void modificarPosicion(int indice, T elem) {
        aux_iterador(indice, this).dato = elem;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        this.cabeza = new Nodo(null);
        this.cola = new Nodo(null);
        this.cabeza.anterior = null;
        this.cabeza.siguiente = cola;
        this.cola.siguiente = null;
        this.cola.anterior = cabeza;
        this.longitud = 0;
        Nodo actual = lista.cabeza;   
        for (int i = 0; i < lista.longitud; i++) {
            while(actual != null){
                if(i == 0){    
                    Nodo copia = new Nodo(actual.dato);
                    copia.anterior = this.cabeza;
                    copia.siguiente = this.cola;
                    this.cabeza.siguiente = copia;
                    this.cola.anterior = copia;
                    actual = actual.siguiente;
                    this.longitud += 1 ;
                }else{
                    Nodo copia = new Nodo(actual.dato);
                    copia.anterior = actual.anterior;
                    copia.siguiente = this.cola;
                    actual.anterior.siguiente = copia;
                    this.cola.anterior = copia;
                    actual = actual.siguiente;
                    this.longitud += 1 ;
                }
                            
            } 

        }   
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

}
