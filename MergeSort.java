public class MergeSort{
    private final static int SWITCH = 15;
    public static void sort(int[] arr, Metrics metrics){
        if(arr == null || arr.length <= 1){
            return;
        }
        int[] arr1 = new int[arr.length];
        mergeSort(arr, arr1, 0, arr.length - 1, 1, metrics);
    }
    private static void mergeSort(int[] arr, int[] arr1, int low, int high, int depth, Metrics metrics){
        metrics.checkMaxDepth(depth);
        if(high - low + 1 <= SWITCH){
            insertionSort(arr, low, high, metrics);
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(arr, arr1, low, mid, depth+1, metrics);
        mergeSort(arr, arr1, mid+1, high, depth+1, metrics);
        merge(arr, arr1, low, mid, high, metrics);
    }
    private static void merge(int[] arr, int[] arr1, int low, int mid, int high, Metrics metrics){
        for(int k = low; k <= high; k++){
            arr1[k] = arr[k];
        }
        int i = low;
        int j = mid+1;
        for(int k = low; k <= high; k++){
            if(i > mid){
                arr[k] = arr1[j++];
            }else if(j > high){
                arr[k] = arr1[i++];
            }else{
                metrics.incrementComparisons();
                if(arr1[j] < arr1[i]){
                    arr[k] = arr1[j++];
                }else{
                    arr[k] = arr1[i++];
                }
            }
        }

    }
    private static void insertionSort(int[] arr, int low, int high, Metrics metrics){
        for(int i = low + 1; i <= high; i++){
            int key = arr[i];
            int j = i - 1;
            while(j >= low){
                metrics.incrementComparisons();
                if(arr[j] > key){
                    arr[j + 1] = arr[j];
                    j--;
                }else{
                    break;
                }
            }
            arr[j + 1] = key;
        }
    }
}