import java.util.Random;
public class QuickSort {
    public static final Random random = new Random();
    public static void sort(int[] arr, Metrics metrics){
        if(arr == null || arr.length <= 1){
            return;
        }
        quickSort(arr, 0, arr.length - 1, 1, metrics);
    }

    private static void quickSort(int[] arr, int low, int high, int depth, Metrics metrics){
        while(low < high){
            metrics.checkMaxDepth(depth);
            int pivotIndex = low + random.nextInt(high - low + 1);
            swap(arr, pivotIndex, low);
            int pivot = arr[low];
            int lt = low;
            int gt = high;
            int i = low + 1;
            while(i <= gt){
                if(arr[i] < pivot){
                    metrics.incrementComparisons();
                    swap(arr, lt, i);
                    lt++;
                    i++;
                }else if(arr[i] > pivot){
                    metrics.incrementComparisons();
                    swap(arr, gt, i);
                    gt--;
                }else{
                    metrics.incrementComparisons();
                    i++;
                }
            }

            int leftSize = lt - low;
            int rightSize = high - gt;
            if(leftSize < rightSize){
                quickSort(arr, low, lt-1, depth+1, metrics);
                low = gt + 1;
            }else{
                quickSort(arr, gt+1, high, depth+1, metrics);
                high = lt - 1;
            }
        }
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
