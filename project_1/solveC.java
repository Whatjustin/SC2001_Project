import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class solveC {
    public static int[] generateRandomArray(int n, int x) {
        int[] list = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            list[i] = random.nextInt(x);
        }
        return list;
    }
    
    public static void writeToCsv(List<List<String>> rows, String filePath) throws IOException {
        FileWriter csvWriter = new FileWriter(filePath);
        for (List<String> rowData : rows) {
            csvWriter.append(String.join(",", rowData));
            csvWriter.append("\n");
        }
        csvWriter.flush();
        csvWriter.close();
    }
    
    public static void main(String[] args) throws IOException {
        ArrayList<List<String>> keyCompHybrid = new ArrayList<List<String>>();
        keyCompHybrid.add(Arrays.asList("arrayLength", "noOfComparisons"));
        int iterations = 10;

        int[] arraySize = { 1000, 2500, 5000, 7500, 10000, 25000, 50000, 75000, 100000, 250000, 500000, 750000, 1000000, 2500000, 5000000, 7500000, 10000000};
        for (int i : arraySize) {
            System.out.println(i);
            int t = 0;
            long totalComparisonsHybrid = 0;
            while (t < iterations) {
                int[] list1 = generateRandomArray(i, 1000000);
                // hybrid
                Comparisons.count = 0;
                hybridSort.sort(list1, 0, list1.length - 1, 100);
                totalComparisonsHybrid += Comparisons.count;
                t++;
            }
            keyCompHybrid.add(Arrays.asList(Integer.toString(i), Long.toString(totalComparisonsHybrid / iterations)));
        }

        String filePath = "./dataForC1.csv";
        writeToCsv(keyCompHybrid, filePath);
    }
}
