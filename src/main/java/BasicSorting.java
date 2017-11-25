package main;

public class BasicSorting {

  public static int[] bubble(int[] array) {
    int temp;

    for (int j=0; j < array.length; j++) {
        for (int i = 1; i < array.length - j; i ++) {
            if (array[i-1] > array[i]) {
                temp = array[i];
                array[i] = array[i-1];
                array[i-1] = temp;
            }
        }
    }
    return array;
  }

  public static int[] selection(int[] array) {
    return array;
  }

  public static int[] insertion(int[] array) {
    return array;
  }
  
}
