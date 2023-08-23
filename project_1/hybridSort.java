public class hybridSort {
    public static void sort(int[] subArr, int low, int high, int threshold) {
        if (high - low +1 <= threshold) {
            insertionSort.sort(subArr, low, high);
            return;
        } else {
            int mid = (low + high) / 2;
            sort(subArr, low, mid, threshold);
            sort(subArr, mid + 1, high, threshold);
        }
        mergeSort.merge(subArr, low, high);
    }
    
    public static void main(String[] args) {
        int[] list = solveC.generateRandomArray(100, 100);
        long startTime = System.currentTimeMillis();
        Comparisons.count = 0;
        sort(list, 0, list.length -1 ,22);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println(estimatedTime);
        System.out.println(Comparisons.count);
        System.out.println("huh");
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

}