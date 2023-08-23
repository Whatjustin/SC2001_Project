public class insertionSort {
    public static void swap(int[] subArr, int i, int j) {
        int tmp = subArr[i];
        subArr[i] = subArr[j];
        subArr[j] = tmp;
    }
    
    public static void sort(int[] subArr, int low, int high) {
        for (int i = low+1; i <= high; i++) {
            for (int j = i; j > low; j--) {
                Comparisons.count += 1;
                if (subArr[j] < subArr[j-1]) {
                    swap(subArr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // int[] list = solveC.generateRandomArray(10000, 999);
        int[] list = { 5,4,3,2,1 };
        long startTime = System.currentTimeMillis();
        Comparisons.count = 0;
        sort(list, 0, list.length - 1);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println(Comparisons.count);
    }
}
