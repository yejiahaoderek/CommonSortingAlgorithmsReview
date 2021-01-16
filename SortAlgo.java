import java.util.Arrays;

public class SortAlgo{
    private int[] arr;

    // constructor
    public SortAlgo(int[] arr){
        this.arr = arr;
    }

    public void insertionSort(){
	    for (int j = 1; j < arr.length; j++){
	        int key = arr[j];
	        int i = j - 1;
	        while (i >= 0 && arr[i] >= key){
	            arr[i + 1] = arr[i];
	            i--;
	        }
	        arr[i + 1] = key;
        }
    }

    public void quickSort(){
        // to be finished
    }

    
    public void mergeSort(){
        // to be finished
    }

    public String toString(){     
        return Arrays.toString(arr);
    }

    public static void main(String args[]){
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int) (Math.random() * 10 + 1);
        }
        System.out.printf("Original randomly generated array: %s \n", Arrays.toString(arr));

        SortAlgo sort1 = new SortAlgo(arr);
        sort1.insertionSort();
        System.out.printf("Sorted using Insertion Sort: %s \n", sort1.toString());
    }
}