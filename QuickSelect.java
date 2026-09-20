import java.util.Random;

public class QuickSelect {
    private static final Random random = new Random();
    public static int select(int[] array, int k, Metrics metrics) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }
        if (k < 0 || k >= array.length) {
            throw new IllegalArgumentException("Index k is out of bounds: " + k);
        }
        int[] a = array.clone();
        return select(a, 0, a.length - 1, k, 1, metrics);
    }

    private static int select(int[] a, int low, int high, int k, int depth, Metrics metrics) {
        metrics.checkMaxDepth(depth);
        if (low == high) {
            return a[low];
        }
        int pivotIndex = low + random.nextInt(high - low + 1);
        swap(a, low, pivotIndex);
        int pivot = a[low];
        int lt = low;
        int gt = high;
        int i = low + 1;
        while (i <= gt) {
            metrics.incrementComparisons();
            if (a[i] < pivot) {
                swap(a, lt, i);
                lt++;
                i++;
            } else if (a[i] > pivot) {
                metrics.incrementComparisons();
                swap(a, i, gt);
                gt--;
            } else {
                i++;
            }
        }
        if (k >= lt && k <= gt) {
            return a[k];
        } else if (k < lt) {
            return select(a, low, lt - 1, k, depth + 1, metrics);
        } else {
            return select(a, gt + 1, high, k, depth + 1, metrics);
        }
    }
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}