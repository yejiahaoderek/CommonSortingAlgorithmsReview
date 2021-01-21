import java.util.Arrays;

public class SortAlgo{
    private int[] arr;

    // constructor
    public SortAlgo(int[] arr){
        this.arr = Arrays.copyOfRange(arr, 0, arr.length);
    }

    public void insertionSort(){
	    for (int j = 1; j < arr.length; j++){
	        int key = arr[j];
	        int i = j - 1;
	        while (i >= 0 && arr[i] > key){
	            arr[i + 1] = arr[i];
	            i--;
	        }
	        arr[i + 1] = key;
        }
    }

    public void quickSort(int[] arr, int leftIdx, int rightIdx){
        if (leftIdx + 1 > rightIdx)
            return;

        int new_pivot = partition(arr, leftIdx, rightIdx);
        quickSort(arr, 0, new_pivot);
        quickSort(arr, new_pivot + 1, rightIdx);
    }

    public int partition(int[] arr, int leftIdx, int rightIdx){
        int key = arr[leftIdx];
        int i = leftIdx + 1;
        for (int j = leftIdx + 1; j < rightIdx; j++){
            if (arr[j] < key){
                int swapTmp = arr[j];
                arr[j] = arr[i];
                arr[i] = swapTmp;
                i++; // now, elements left to index i are guaranteed to < key
            }
        }
        
        arr[leftIdx] = arr[i - 1];
        arr[i - 1] = key;

        return i - 1;
    }

    // Time Complexity
    public void mergeSort(int[] arr, int size){
        if (size == 1)
            return;
        
        int mid = size / 2;

        int[] left = new int[mid];
        int[] right = new int[size - mid];

        for (int i = 0; i < mid; i++){
            left[i] = arr[i];
        }

        for (int i = mid; i < size; i++){
            right[i - mid] = arr[i];
        }

        mergeSort(left, mid);
        mergeSort(right, size - mid);

        merge(arr, left, right, mid, size - mid);
    }

    public void merge(int[] arr, int[] left, int[] right, int left_size, int right_size){
        int i = 0, j = 0, k = 0;

        while (i < left_size && j < right_size){
            if (left[i] < right[j]){
                arr[k++] = left[i++];
            }
            else{
                arr[k++] = right[j++];
            }
        }
        
        while (i < left_size){
            arr[k++] = left[i++];
        }
        while (j < right_size){
            arr[k++] = right[j++];
        }
    }

    public int[] getArray(){
        return this.arr;
    }


    public static void main(String args[]){
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int) (Math.random() * 10 + 1);
        }
        System.out.printf("Original randomly generated array: %s \n \n", Arrays.toString(arr));

        SortAlgo sort1 = new SortAlgo(arr);
        SortAlgo sort2 = new SortAlgo(arr);
        SortAlgo sort3 = new SortAlgo(arr);


        // O(n^2) 
        // best case: O(n)
        sort1.insertionSort();

        // always: O(nlgn) 
        sort2.mergeSort(sort2.getArray(), arr.length);

        // avg : O(nlgn) 
        // worst case: O(n^2)
        // pro: in-place
        sort3.quickSort(sort3.getArray(), 0, arr.length);

        System.out.printf("Sorted using Insertion Sort: \t %s \n", Arrays.toString(sort1.getArray()));
        System.out.printf("Sorted using Merge Sort: \t %s \n", Arrays.toString(sort2.getArray()));
        System.out.printf("Sorted using Quick Sort: \t %s \n", Arrays.toString(sort3.getArray()));

    }
}