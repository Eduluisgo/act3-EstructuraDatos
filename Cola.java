
class Nodo<T> {
    T dato;
    Nodo<T> siguiente;

    // Constructor del nodo
    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

public class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> finalDeCola;
    private int tamaño;
    private int capacidad;

    public Cola(int capacidad) {
        this.frente = null;
        this.finalDeCola = null;
        this.tamaño = 0;
        this.capacidad = capacidad > 0 ? capacidad : Integer.MAX_VALUE; // Si no se pasa, no hay límite
    }

    public Cola() {
        this(Integer.MAX_VALUE);
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public boolean estaLlena() {
        return tamaño >= capacidad;
    }

    public void encolar(T elemento) {
        if (estaLlena()) {
            throw new IllegalStateException("Error: La cola está llena.");
        }
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if (estaVacia()) {
            frente = nuevoNodo;
            finalDeCola = nuevoNodo;
        } else {
            finalDeCola.siguiente = nuevoNodo;
            finalDeCola = nuevoNodo;
        }
        tamaño++;
    }

    public T desencolar() {
        if (estaVacia()) {
            throw new IllegalStateException("Error: La cola está vacía.");
        }
        T valor = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            finalDeCola = null;
        }
        tamaño--;
        return valor;
    }

    public T frente() {
        if (estaVacia()) {
            throw new IllegalStateException("Error: La cola está vacía.");
        }
        return frente.dato;
    }

    @Override
    public String toString() {
        if (estaVacia()) {
            return "Cola vacía";
        }
        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = frente;
        while (actual != null) {
            sb.append(actual.dato).append(" ");
            actual = actual.siguiente;
        }
        return sb.toString().trim();
    }

    public int tamaño() {
        return tamaño;
    }

    public static void main(String[] args) {
        Cola<Integer> cola = new Cola<>(5);

        cola.encolar(20);
        cola.encolar(40);
        cola.encolar(60);

        System.out.println("Frente de la cola: " + cola.frente());
        System.out.println("Contenido de la cola: " + cola);
        System.out.println("Tamaño de la cola: " + cola.tamaño());

        System.out.println("Desencolado: " + cola.desencolar());
        System.out.println("Desencolado: " + cola.desencolar());

        System.out.println("¿Está vacía la cola?: " + cola.estaVacia());

        System.out.println("Tamaño de la cola: " + cola.tamaño());

        System.out.println("Desencolado: " + cola.desencolar());
        System.out.println("¿Está vacía la cola?: " + cola.estaVacia());
    }
}
