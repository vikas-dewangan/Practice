package DSA.Algorithms.Sorting;

public class MergeSort implements SortingStrategy{

    @Override 
    public void sort(int[] arr){
        int start = 0;
        int end = arr.length-1;
        mergeSort(arr, start, end);
    }

    public static void mergeSort(int[] arr, int start, int end){
        if(start<end){
            int mid = start + (end-start)/2;

            //left
            mergeSort(arr, start, mid);

            //right
            mergeSort(arr, mid+1, end);

            //merge all
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end){
        int[] left = new int[mid+1-start];
        int[] right = new int[end-mid];

        for(int i = 0; i<left.length;i++){
            left[i] = arr[start+i];
        }

        for(int i = 0; i<right.length;i++){
            right[i] = arr[mid+1+i];
        }
        int i = 0;
        int j = 0;
        int k = start;
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        //remaining items
        while(i<left.length){
            arr[k] = left[i];
            i++;
            k++;
        }

        while(j<right.length){
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
