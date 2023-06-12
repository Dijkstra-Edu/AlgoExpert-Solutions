package Searching;

class Program {
  public static int binarySearch(int[] array, int target) {
    int i=0;
    int j=array.length-1;
    while(i<=j) {
      int mid = i+(j-i)/2;
      System.out.println(mid);
      if(array[mid]==target) return mid;
      else if(array[mid]>target) j=mid-1;
      else i=mid+1;
    }
    return -1;
  }
}