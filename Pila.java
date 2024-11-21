public class Pila {
    private int tamaño;
    private int[] pila;
    private int tope;

    // Constructor
    public Pila(int tamaño) {
        this.tamaño = tamaño;
        this.pila = new int[tamaño];
        this.tope = -1; // La pila está vacía al principio
    }

    // Verifica si la pila está vacía
    public boolean estaVacia() {
        return tope == -1;
    }

    // Verifica si la pila está llena
    public boolean estaLlena() {
        return tope == tamaño - 1;
    }

    // Agrega un elemento a la pila
    public void apilar(int elemento) {
        if (estaLlena()) {
            System.out.println("Error: La pila está llena.");
        } else {
            pila[++tope] = elemento;
        }
    }

    // Elimina y retorna el elemento superior de la pila
    public int desapilar() {
        if (estaVacia()) {
            System.out.println("Error: La pila está vacía.");
            return -1; // Indicamos un error con un valor no válido
        } else {
            return pila[tope--];
        }
    }

    // Retorna el elemento superior de la pila sin quitarlo
    public int cima() {
        if (estaVacia()) {
            System.out.println("Error: La pila está vacía.");
            return -1; // Indicamos un error con un valor no válido
        }
        return pila[tope];
    }

    public static void main(String[] args) {
        Pila pila = new Pila(5);

        // Apilar elementos
        pila.apilar(10);
        pila.apilar(20);
        pila.apilar(30);

        // Mostrar el elemento superior
        System.out.println("Cima de la pila: " + pila.cima()); // Salida: 30

        // Desapilar elementos
        System.out.println("Desapilado: " + pila.desapilar()); // Salida: 30
        System.out.println("Desapilado: " + pila.desapilar()); // Salida: 20

        // Ver el tamaño actual de la pila
        System.out.println("Tamaño actual de la pila: " + (pila.tope + 1)); // Salida: 1
    }
}
