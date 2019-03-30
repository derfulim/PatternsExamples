package ua.training.strategy;

import java.util.Arrays;

public class StrategyApp {
    public static void main(String[] args) {
        int[] arr0 = {1, 3, 2, 1};
        StrategyClient strategyClient = new StrategyClient();
        strategyClient.setStratagy(new SelectionSort());
        strategyClient.executeStrategy(arr0);

        int[] arr1 = {11, 4, 2, 7, 8, 54};
        strategyClient.setStratagy(new InsertionSort());
        strategyClient.executeStrategy(arr1);


        int[] arr2 = {3, -8, 0, 33, 1, 3, 2};
        strategyClient.setStratagy(new BubbleSort());
        strategyClient.executeStrategy(arr2);
    }

}

//Context
class StrategyClient {
    Sorting strategy;

    public void setStratagy(Sorting strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] arr) {
        strategy.sort(arr);
    }
}
//Strategy
interface Sorting{
    void sort (int[] arr);
}

//Bubble sorting strategy
class BubbleSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        System.out.println("Bubble sorting");
        System.out.println("before: " + Arrays.toString(arr));
        for (int barrier = arr.length-1; barrier>=0 ; barrier--) {
            for (int i = 0; i <barrier ; i++) {
                if (arr[i]>arr[i+1]){
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
        }
        System.out.println("after: " + Arrays.toString(arr));
    }
}

class InsertionSort implements Sorting{

    @Override
    public void sort(int[] arr) {
        System.out.println("Insertion sorting");
        System.out.println("before: " + Arrays.toString(arr));
        int j;
        int element;
        for (int i = 1; i<arr.length; i++) {
            element = arr[i];
            j = i;

            while ((j>0)&&(arr[j-1]>element)){
                arr[j] = arr[j-1];
                j = j-1;
                arr[j] = element;
            }
        }
            System.out.println("after: " + Arrays.toString(arr));
    }
}

class SelectionSort implements Sorting {

    @Override
    public void sort(int[] arr) {
        System.out.println("Selection sorting");
        System.out.println("before: " + Arrays.toString(arr));
        int min;
        int j;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int n = arr[i];
                arr[i] = arr[min];
                arr[min] = n;
            }
        }
        System.out.println("after: " + Arrays.toString(arr));
    }

    
}


