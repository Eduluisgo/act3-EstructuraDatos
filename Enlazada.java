class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

class ListaEnlazada {
    private Nodo cabeza;

    public ListaEnlazada() {
        cabeza = null;
    }

    public void agregar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public int contarElementos() {
        int contador = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}

public class Enlazada {
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();

        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);

        System.out.print("Elementos de la lista: ");
        lista.mostrar();

        int cantidad = lista.contarElementos();
        System.out.println("La cantidad de elementos en la lista es: " + cantidad);
    }
}
