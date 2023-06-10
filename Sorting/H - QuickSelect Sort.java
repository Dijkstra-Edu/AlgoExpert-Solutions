package Sorting;

class Program {
  public static int quickselect(int[] array, int k) {
    // Write your code here.
    int ans = Kth(array, 0, array.length-1, k, 1);
    return ans;
  }

  public static int Kth(int[] arr, int low, int high, int k, int type) {
		// find the partition
		int partition = 0;

		if(type==1) partition = partitionSmall(arr, low, high); //To find smallest
		//if(type==2) partition = partitionLarge(arr, low, high); //To find largest

		// if partition value is equal to the kth position,
		// return value at k.
		if (partition == k - 1)
			return arr[partition];

		// if partition value is less than kth position,
		// search right side of the array.
		else if (partition < k - 1)
			return Kth(arr, partition + 1, high, k, type);

		// if partition value is more than kth position,
		// search left side of the array.
		else
			return Kth(arr, low, partition - 1, k, type);
	}

  public static int partitionSmall(int[] arr, int low,
			int high) {
		int pivot = arr[high], pivotloc = low;
		for (int i = low; i <= high; i++) {
			// inserting elements of less value
			// to the left of the pivot location
			if (arr[i] < pivot) {
				int temp = arr[i];
				arr[i] = arr[pivotloc];
				arr[pivotloc] = temp;
				pivotloc++;
			}
		}

		// swapping pivot to the final pivot location
		int temp = arr[high];
		arr[high] = arr[pivotloc];
		arr[pivotloc] = temp;

		return pivotloc;
	}
}

