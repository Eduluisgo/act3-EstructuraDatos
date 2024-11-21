import java.util.LinkedList;
import java.util.Queue;

public class MinMax {

    public static int[] encontrarMinMax(Queue<Integer> cola) {
        if (cola.isEmpty()) {
            throw new IllegalArgumentException("La cola está vacía.");
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Integer elemento : cola) {
            if (elemento < min) {
                min = elemento;
            }
            if (elemento > max) {
                max = elemento;
            }
        }

        return new int[] { min, max };
    }

    public static void imprimirCola(Queue<Integer> cola) {
        System.out.println(cola);
    }

    public static void main(String[] args) {

        Queue<Integer> cola = new LinkedList<>();
        cola.add(120);
        cola.add(20);
        cola.add(50);
        cola.add(30);
        cola.add(15);

        System.out.println("Cola original:");
        imprimirCola(cola);

        int[] minMax = encontrarMinMax(cola);
        System.out.println("Mínimo: " + minMax[0]);
        System.out.println("Máximo: " + minMax[1]);
    }
}
