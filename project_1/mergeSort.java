import java.util.ArrayList;
import java.util.Arrays;

public class mergeSort {
    public static void sort(int[] subArr, int low, int high) {
        int mid = (low + high) / 2;
        if (high <= low) return;
        else if (high - low > 1) {
            sort(subArr, low, mid);
            sort(subArr, mid + 1, high);
        }
        merge(subArr, low, high);

    }
    public static void merge(int[] subArr, int low, int high) {
        if (high <= low)
            return;
        int mid = (low + high) / 2;
        int i = low;
        int j = mid + 1;
        ArrayList<Integer> aux = new ArrayList<>();
        while (i <= mid && j <= high) {
            Comparisons.count += 1;
            int compare = subArr[i] - subArr[j];
            if (compare < 0) {
                aux.add(subArr[i]);
                i++;
            } else {
                aux.add(subArr[j]);
                j++;
            }
        }
        while (i <= mid) {
            aux.add(subArr[i]);
            i++;
        }
        while (j <= high) {
            aux.add(subArr[j]);
            j++;
        }
        for (int k = 0; k < aux.size(); k++) {
            subArr[low+k] = aux.get(k);
        }
    }
    
    public static void main(String[] args) {
        int[] list = solveC.generateRandomArray(100, 100);
        long startTime = System.currentTimeMillis();
        sort(list, 0, list.length - 1);
        System.out.println(list);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println(estimatedTime);
        System.out.println(Comparisons.count);
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }
}
