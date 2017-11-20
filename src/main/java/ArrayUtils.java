package main;

public class ArrayUtils {
    public static int[] reverse(int[] array) {
        int [] reversedArray = new int [array.length];
        int end = array.length - 1;
        for (int i = 0; i <= end; i++) {
            reversedArray[end - i] = array[i];
        }
        return reversedArray;
    }

    public static int[] push(int[] array, int num) {
        int [] pushedArray = new int[array.length + 1];
        int end = array.length - 1;
        for (int i = 0; i <= end; i++) {
            pushedArray[i] = array[i];
        }
        pushedArray[array.length] = num;

        array = pushedArray; // could return pushedArray instead for copy

        return array;
    }

    public static void print(int[] array) {
        System.out.print('[');
        for(int i=0; i<array.length; i++){
            if (i == array.length -1) {
                System.out.print(array[i] + "]");
            } else {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.print('\n');
    }

}
