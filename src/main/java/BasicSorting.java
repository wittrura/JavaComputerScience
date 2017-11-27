package main;

import java.util.Arrays;

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
      for (int j = 0; j < array.length - 1; j++) {

          int minIndex = j;
          for (int i = j + 1; i < array.length; i++) {
              // find min
              if (array[i] <= array[minIndex]) {
                  minIndex = i;
              }
          }

          // swap min with spot for selection
          int temp = array[j];
          array[j] = array[minIndex];
          array[minIndex] = temp;
      }

      return array;
  }

  public static int[] insertion(int[] array) {
      for (int i = 1; i < array.length; i++) {

          for (int j = i; j > 0; j--) {
              if (array[j] < array[j-1]) {
                  int temp = array[j-1];
                  array[j-1] = array[j];
                  array[j] = temp;
              }
          }

      }
      return array;
  }
  
}
