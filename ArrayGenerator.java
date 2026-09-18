import java.util.Arrays;
import java.util.Random;
public class ArrayGenerator{
    private static final Random random = new Random();
    public static int[] generateRandom(int size){
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = random.nextInt();
        }
        return arr;
    }
    public static int[] generateSorted(int size){
        int[] arr = generateRandom(size);
        Arrays.sort(arr);
        return arr;
    }
    public static int[] generateDuplicates(int size){
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = random.nextInt(10);
        }
        return arr;
    }
}
