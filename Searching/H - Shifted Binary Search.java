package Searching;

class Program {
  public static int shiftedBinarySearch(int[] array, int target) {
    int min = Integer.MAX_VALUE;
    int minIdx = -1;
    for(int i=0; i<array.length; i++) {
      if(array[i]<min) {
        min = array[i];
        minIdx = i;
      }
    }

    int leftHalf = binarySearch(array, target, 0, minIdx);
    int rightHalf = binarySearch(array, target, minIdx, array.length-1);

    if(leftHalf!=-1) return leftHalf;
    else return rightHalf;
  }

  public static int binarySearch(int[] array, int target, int low, int high) {
    while(low<=high) {
      int mid = low+(high-low)/2;
      if(array[mid]==target) return mid;
      else if(array[mid]>target) high = mid-1;
      else low = mid+1;
    }
    return -1;
  }
}

