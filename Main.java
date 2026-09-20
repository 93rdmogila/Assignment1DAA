public class Main {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000};

        for (int size : sizes) {
            System.out.println("РАЗМЕР МАССИВА: " + size);
            int[] data = ArrayGenerator.generateRandom(size);

            Metrics qm = new Metrics();
            long start = System.currentTimeMillis();
            QuickSort.sort(data.clone(), qm);
            long qTime = System.currentTimeMillis() - start;

            System.out.println("QuickSort время (мс): " + qTime);
            System.out.println("QuickSort сравнения: " + qm.getComparisons());
            System.out.println("QuickSort глубина рекурсии: " + qm.getMaxDepth());

            Metrics mm = new Metrics();
            start = System.currentTimeMillis();
            MergeSort.sort(data.clone(), mm);
            long mTime = System.currentTimeMillis() - start;
            System.out.println("MergeSort время (мс): " + mTime);
            System.out.println("MergeSort сравнения: " + mm.getComparisons());
            System.out.println("MergeSort глубина рекурсии: " + mm.getMaxDepth());

            Metrics sm = new Metrics();
            start = System.currentTimeMillis();
            QuickSelect.select(data, size / 2, sm);
            long sTime = System.currentTimeMillis() - start;
            System.out.println("QuickSelect время (мс): " + sTime);
            System.out.println("QuickSelect сравнения: " + sm.getComparisons());
            System.out.println("QuickSelect глубина рекурсии: " + sm.getMaxDepth());
            System.out.println();
        }
    }
}
