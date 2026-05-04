import java.util.concurrent.Callable;

import controllers.SortMethods;
import models.Results;

public class App {
    public static void main(String[] args) throws Exception {
        
        int size = 100000;
        int[] arreglo = generate(size);
        int[] arreglo2 = arreglo.clone();
        int[] arreglo3 = arreglo.clone();

        SortMethods metodos = new SortMethods();

        Callable<Void> funcionBubble = () -> {
            metodos.sortBubble(arreglo2);
            return null;
        };
        Results rBubble = BenchMarking.medirTiempo(funcionBubble, "Burbuja", size);
        
        System.out.println(rBubble.getName() + "=" + rBubble.getTime());

        
        Callable<Void> funcionBubbleAvz = () -> {
            metodos.sortBubbleAvz(arreglo3);
            return null;
        };
        Results rBubbleAvz = BenchMarking.medirTiempo(funcionBubbleAvz, "Burbuja Avanzado", size);
        
        System.out.println(rBubbleAvz.getName() + "=" + rBubbleAvz.getTime());
    }

    public static int[] generate(int size){
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            int numero = (int) (Math.random()*10000);
            array[i] = numero;
        }
        return array;
    }



}
