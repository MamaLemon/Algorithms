package sort.direct_methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DirectSort {
    public static int[] directInclusion(int[] list){
        int j = 0;
        int elementInclusion;
        for(int i = 1; i < list.length; i++){
            elementInclusion = list[i];
            j = i - 1;          //индекс предыдущего элемента
            //сравниваем эл-ты от данного до нулевого
            while(j >= 0 && elementInclusion < list[j]) {
                list[j + 1] = list[j];
                j--;
            }
            list[j+1] = elementInclusion;
        }
        return list;
    }
    public static int[] directSelection(int[] list){
        int elementSelection;
        int indexElementSelection;
        for(int i = 0; i < list.length-1; i++){
            elementSelection = list[i];
            indexElementSelection = i;
            for(int j = i + 1; j < list.length; j++){
                if(list[j] < elementSelection){
                    indexElementSelection = j;
                    elementSelection = list[indexElementSelection];
                }
            }
            //меняем местами элементы
            list[indexElementSelection] = list[i];
            list[i] = elementSelection;
        }
        return list;
    }
    public static int[] directExchange(int[] list){

        return list;
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[10];
        for (int i = 0; i < 10; i++){
            try {
                array[i] = Integer.parseInt(reader.readLine());
            }
            catch (IOException e){
                System.out.println("I have a problem!");
            }
        }
        for (int x: array) {
            System.out.print(x + " ");
        }
        System.out.println();
        array =  directSelection(array);
        for (int x: array) {
            System.out.print(x + " ");
        }
    }
}
