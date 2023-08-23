import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class solveC2 {
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
        keyCompHybrid.add(Arrays.asList("threshold", "noOfComparisons"));
        int iterations = 5;
        int[] thresholds = { 5, 10, 15, 20, 25, 30, 35, 40, 50, 75, 100, 150, 200, 250, 300, 350, 400, 500, 750, 1000 };
        int[] totalComparisons = new int[thresholds.length];
        int arraySize = 1000000;
        for (int k = 0; k < iterations; k++) {
            int[] list1 = generateRandomArray(arraySize, 1000000);
            int i = 0;
            for (int threshold : thresholds) {
                int[] temp = list1.clone();
                System.out.println(threshold);
                Comparisons.count = 0;
                hybridSort.sort(temp, 0, temp.length - 1, threshold);
                totalComparisons[i] += Comparisons.count;
                i++;
            }
        }
        for (int j = 0; j < thresholds.length; j++) {
            keyCompHybrid.add(Arrays.asList(Integer.toString(thresholds[j]), Long.toString(totalComparisons[j] / iterations)));
        }
        
        String filePathHybrid = "./dataForC2.csv";
        writeToCsv(keyCompHybrid, filePathHybrid);
    }
}
