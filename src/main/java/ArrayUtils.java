package main;

public class ArrayUtils {

  public int[] reverse(int[] array) {
    return array;
  };

  public int[] push(int[] array, int num) {
    return array;
  };

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
  };

}
