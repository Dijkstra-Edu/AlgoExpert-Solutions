package Sorting;

class Program {
  public static int[] selectionSort(int[] array) {
    for(int i=0; i<array.length-1; i++) {
      int minIdx = i;
      for(int j=i+1; j<array.length; j++) {
        if(array[j] < array[minIdx]) {
          minIdx = j;
        }
      }
      int temp = array[i];
      array[i] = array[minIdx];
      array[minIdx] = temp;
    }
    return array;
  } 
}
