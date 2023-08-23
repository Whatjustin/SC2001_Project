import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class solveD {
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
        ArrayList<List<String>> rows = new ArrayList<List<String>>();
        rows.add(Arrays.asList("algo", "noOfComparisons", "cpuTimeInMs"));
        int iterations = 5;

        int i = 10000000;
        int t = 0;
        long totalComparisonsMerge = 0;
        double totalTimeMerge = 0;
        long totalComparisonsHybrid = 0;
        double totalTimeHybrid = 0;
        while (t < iterations) {
            System.out.println("interation: " + (t+1));
            int[] list1 = generateRandomArray(i, 1000000);
            int[] list2 = list1.clone();
            // merge
            Comparisons.count = 0;
            double startTime = System.currentTimeMillis();
            hybridSort.sort(list1, 0, list1.length - 1, 1);
            double estimatedTime = System.currentTimeMillis() - startTime;
            totalComparisonsMerge += Comparisons.count;
            totalTimeMerge += estimatedTime;
            
            // hybrid
            Comparisons.count = 0;
            startTime = System.currentTimeMillis();
            hybridSort.sort(list2, 0, list2.length - 1, 25);
            estimatedTime = System.currentTimeMillis() - startTime;
            totalComparisonsHybrid += Comparisons.count;
            totalTimeHybrid += estimatedTime;
            t++;
        }
        rows.add(Arrays.asList("mergesort", Long.toString(totalComparisonsMerge / iterations), Double.toString(totalTimeMerge / iterations)));
        rows.add(Arrays.asList("hybridsort", Long.toString(totalComparisonsHybrid / iterations), Double.toString(totalTimeHybrid / iterations)));
        String filePath = "./dataForD.csv";
        writeToCsv(rows, filePath);
    }
}
