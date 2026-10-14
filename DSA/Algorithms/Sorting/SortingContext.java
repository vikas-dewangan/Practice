package DSA.Algorithms.Sorting;

import DSA.Algorithms.Utils.SortUtils;

//Strategy pattern
public class SortingContext {
    private final SortingStrategy strategy;

    // Dependency Injection via Constructor
    public SortingContext(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeSort(int[] arr) {
        System.out.println(strategy.getClass().getSimpleName());
        System.out.print("Before sorting: ");
        SortUtils.printArray(arr);

        strategy.sort(arr); // Executes whichever strategy was injected

        System.out.print("After sorting:  ");
        SortUtils.printArray(arr);
        System.out.println("-------------------------");
    }
}
