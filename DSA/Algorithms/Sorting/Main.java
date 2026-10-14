package DSA.Algorithms.Sorting;

public class Main {
    public static void main(String[] args) {
        int[] data1 = {7, 5, 4, 3, 3, 9};

        // Test Bubble Sort
        SortingContext bubbleContext = new SortingContext(new BubbleSort());
        bubbleContext.executeSort(data1);

        // Test Selection Sort
        SortingContext selectionContext = new SortingContext(new SelectionSort());
        selectionContext.executeSort(data1);

        // Test Selection Sort
        SortingContext insertionContext = new SortingContext(new InsertionSort());
        insertionContext.executeSort(data1);

        // Test Selection Sort
        SortingContext mergeSortContext = new SortingContext(new MergeSort());
        mergeSortContext.executeSort(data1);
    }
}
