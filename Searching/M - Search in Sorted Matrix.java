package Searching;

class Program {
  public static int[] searchInSortedMatrix(int[][] matrix, int target) {
    int i=0;
    int j=matrix[0].length-1;
    
    while(i<matrix.length && j>=0) {
      if(matrix[i][j]==target) return new int[] {i,j};
      else if (matrix[i][j]>target) j--;
      else i++;
    }
    return new int[] {-1, -1};
  }
}

