package main;

public class Arrays {

  public void print(int[] array) {
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

  public int[] reverse(int[] array) {
    int[] newArray = new int[array.length];
    for(int i=0; i<array.length; i++){
     newArray[i] = array[array.length - i - 1];
    }
    return newArray;
  };

  public int[] push(int[] array, int num) {
    int[] newArray = new int[array.length + 1];
    for(int i=0; i<array.length; i++){
     newArray[i] = array[i];
    }
    newArray[array.length] = num;
    return newArray;
  }
  
}
