package DSA.Algorithms.Sorting;

public class SelectionSort implements SortingStrategy{

    @Override 
    public void sort(int[] arr){
        int len = arr.length;
        for(int i = 0; i<len; i++){
            int minIndx = i;
            for(int j = i+1;j<len;j++){
                if(arr[minIndx] > arr[j]){
                    minIndx = j;
                }
            }
            int temp = arr[minIndx];
            arr[minIndx] = arr[i];
            arr[i] = temp;
        }
    }
}
