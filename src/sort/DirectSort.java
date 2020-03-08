package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DirectSort implements Sort{
    public static int[] insertion(int[] list){
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
    public static int[] selection(int[] list){
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
    public static int[] bubble(int[] list){
        boolean flagExchange = false;
        for(int i = 0; i < list.length - 1; i++){
            for(int j = list.length -1; j > i; j--){
                if(list[j] < list[j-1]){
                    int temp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = temp;
                    flagExchange = true;    //обмен совершен
                }
            }
            if(flagExchange == false){      //был ли обмен?
                return list;
            }
        }
        return list;
    }
    public static int[] shaker(int[] list){
        int left = 1;
        int right = list.length -1;
        int k = list.length -1 ;
        do {
            for(int j = right; j >= left; j--){
                if(list[j-1] > list[j]){
                    int temp = list[j-1];
                    list[j-1] = list[j];
                    list[j] = temp;
                    k = j;
                }
            }
            left = k + 1;
            for(int j = left; j <= right; j++){
                if(list[j-1] > list[j]){
                    int temp = list[j-1];
                    list[j-1] = list[j];
                    list[j] = temp;
                    k = j;
                }
            }
            right = k - 1;
        } while(left < right);
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
        array = DirectSort.shaker(array);
        for (int x: array) {
            System.out.print(x + " ");
        }
    }
}
