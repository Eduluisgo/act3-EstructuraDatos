import java.util.ArrayDeque;
import java.util.Deque;

public class InvertirPila {

    public static <T> void invertirPila(Deque<T> pila) {
        if (pila.isEmpty()) {
            return;
        }

        T elemento = pila.removeLast();

        invertirPila(pila);

        agregarAlFinal(pila, elemento);
    }

    private static <T> void agregarAlFinal(Deque<T> pila, T elemento) {
        if (pila.isEmpty()) {
            pila.addLast(elemento);
        } else {
            T temp = pila.removeLast();
            agregarAlFinal(pila, elemento);
            pila.addLast(temp);
        }
    }

    public static <T> void imprimirPila(Deque<T> pila) {
        System.out.println(pila);
    }

    public static void main(String[] args) {

        Deque<Integer> pila = new ArrayDeque<>();
        pila.addLast(5);
        pila.addLast(10);
        pila.addLast(15);
        pila.addLast(20);
        pila.addLast(25);

        System.out.println("Pila original:");
        imprimirPila(pila);

        invertirPila(pila);

        System.out.println("Pila invertida:");
        imprimirPila(pila);
    }
}
