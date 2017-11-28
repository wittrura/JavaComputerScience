package main;

public class AdvancedSorting {

  public static int[] mergesort(int[] array) {
      mergesort(array, 0, array.length-1);
      return array;
  }

  private static void mergesort(int[] arr, int lowerIndex, int upperIndex) {
      // 1. Find the middle point to divide the array into two halves:
      if (lowerIndex < upperIndex) {
          int middle = lowerIndex + (upperIndex - lowerIndex) / 2;
          // 2. Call mergeSort for first half:
          mergesort(arr, lowerIndex, middle);
          // 3. Call mergeSort for second half:
          mergesort(arr, middle + 1, upperIndex);
          // 4. Merge the two halves sorted in step 2 and 3:
          mergeParts(arr, lowerIndex, middle, upperIndex);
      }
  }

  private static void mergeParts(int[] arr, int lowerIndex, int middle, int upperIndex) {
      int [] tempMergeArr = new int[arr.length];

      //
      for (int i = lowerIndex; i <= upperIndex; i++) {
          tempMergeArr[i] = arr[i];
      }
      int i = lowerIndex;
      int j = middle + 1;
      int k = lowerIndex;

      //
      while (i <= middle && j <= upperIndex) {
          //
          if (tempMergeArr[i] <= tempMergeArr[j]) {
              arr[k] = tempMergeArr[i];
              i++;
          } else {
              //
              arr[k] = tempMergeArr[j];
              j++;
          }
          k++;
      }

      //
      while (i <= middle) {
          arr[k] = tempMergeArr[i];
          k++;
          i++;
      }
  }

  public static int[] quicksort(int[] array) {
      quicksort(array, 0, array.length - 1);

      return array;
  }

  private static void quicksort(int[] arr, int lowerIndex, int upperIndex) {
      // get right-most element as pivot
      if (lowerIndex >= upperIndex) {
          return;
      }

      int pivot = upperIndex;
      int i = lowerIndex;

      while (i < pivot) {
          if (arr[i] >= arr[pivot]) {
              // rotate around the pivot to get the larger value to the right of the pivot
              int tempSwapValue = arr[pivot - 1];

              // if the pivot and compared item are the last two elements, it can be a direct two-way swap
              if ((pivot - 1) == lowerIndex) {
                  arr[pivot - 1] = arr[pivot];
                  arr[pivot] = tempSwapValue;
              } else {
                  // otherwise it is a three-way swap, with element before the pivot shifting
                  // to make space for compared element
                  arr[pivot - 1] = arr[pivot];
                  arr[pivot] = arr[i];
                  arr[i] = tempSwapValue;
              }

              pivot--;
          } else {
              // move on to the next element
              i++;
          }
      }

      // pivot right half
      quicksort(arr, lowerIndex, pivot - 1);
      // pivot left half
      quicksort(arr, pivot + 1, upperIndex);
      return;
  }

}
