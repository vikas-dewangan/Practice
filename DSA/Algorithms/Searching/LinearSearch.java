package DSA.Algorithms.Searching;

/**
 * LinearSearch
 */
public class LinearSearch implements SearchingStrategy{

    @Override
    public boolean search(int[] arr, int item) {

        for(int i : arr){
            if(item == i){
                return true;
            }
        }

        return false;
    }



}