package DSA.Algorithms.Searching;

import DSA.Algorithms.Utils.SearchUtils;

//Strategy pattern
public class SearchingContext {
    private final SearchingStrategy strategy;

    // Dependency Injection via Constructor
    public SearchingContext(SearchingStrategy strategy) {
        this.strategy = strategy;
    }

    public void performSearch(int[] arr, int item) {
        System.out.println(strategy.getClass().getSimpleName());

        boolean result = strategy.search(arr, item); // Executes whichever strategy was injected
        SearchUtils.printSearchResult(result);
        
        System.out.println("-------------------------");
    }
}
