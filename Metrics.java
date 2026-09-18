public class Metrics {
    private int comparisons;
    private int maxDepth;
    public Metrics(){
        this.comparisons = 0;
        this.maxDepth = 0;
    }
    public Metrics(int comparisons, int maxDepth){
        this.comparisons = comparisons;
        this.maxDepth = maxDepth;
    }
    public void incrementComparisons(){
        this.comparisons++;
    }
    public void checkMaxDepth(int currentDepth){
        if(this.maxDepth < currentDepth){
            this.maxDepth = currentDepth;
        }
    }
    public int getComparisons(){
        return comparisons;
    }
    public int getMaxDepth(){
        return maxDepth;
    }
}
