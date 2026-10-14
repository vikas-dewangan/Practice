package DSA.Algorithms.Searching;

public class Main {
    public static void main(String[] args){

        int[] data = {2,6,78,4,9,6,8};
        int value = 22;

        SearchingContext lSearchingContext = new SearchingContext(new LinearSearch());
        lSearchingContext.performSearch(data, value);

    }
}
