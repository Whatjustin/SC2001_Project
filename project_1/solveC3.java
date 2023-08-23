import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class solveC3 {
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
        ArrayList<List<String>> timeComp = new ArrayList<List<String>>();
        timeComp.add(Arrays.asList("threshold", "timeTakenInMs"));
        int iterations = 5;
        // int[] thresholds = { 5, 10, 15, 20, 25, 30, 35, 40, 50, 75, 100, 150, 200, 250, 300, 350, 400, 500, 750, 1000 };
        int[] thresholds = new int[20];
        for (int i = 0; i < 20; i++) {
            thresholds[i] = 2*(i+1);
        }
        int arraySize = 10000000;
        int[] totalTime = new int[thresholds.length];
        for (int i = 0; i < totalTime.length; i++) {
            totalTime[i] = 0;
        }
        for (int k = 0; k < iterations; k++) {
            int[] list1 = generateRandomArray(arraySize, 10000000);
            int i = 0;
            for (int threshold : thresholds) {
                int[] temp = list1.clone();
                System.out.println(threshold);
                Comparisons.count = 0;
                long startTime = System.currentTimeMillis();
                hybridSort.sort(temp, 0, temp.length - 1, threshold);
                long estimatedTime = System.currentTimeMillis() - startTime;
                totalTime[i] += estimatedTime;
                i++;
            }
        }
        for (int j = 0; j < thresholds.length; j++) {
            timeComp.add(Arrays.asList(Integer.toString(thresholds[j]), Long.toString(totalTime[j] / iterations)));
        }

        String filePath = "./dataForC3_10mil.csv";
        writeToCsv(timeComp, filePath);
    }
}
