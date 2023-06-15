package Sorting;

class Program { //Dutch Flag Algo
  public int[] threeNumberSort(int[] inputArray, int[] order) {
        int i = -1;
        int j = 0;
        int k = inputArray.length;

        while (j < k) {
            if(inputArray[j] == order[0] && i!=j) {
                i++;
                swap(i,j,inputArray);
            } else if (inputArray[j] == order[2] && k!= j) {
                k--;
                swap(k,j,inputArray);
            } else {
              j++;
            }
        }
        return inputArray;
    }

    public void swap(int x, int y, int[] array) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
