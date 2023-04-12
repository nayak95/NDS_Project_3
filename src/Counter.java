import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.Scanner;

public class Counter {
    int numberOfFlows;
    int k, w; // k is number of counters
    int[][] C;
    Flow[] flowsArray;
    int[] seedArray;

    public void stdInput(int k, int w) throws FileNotFoundException {
        this.k = k;
        this.w = w;
        seedArray = new int[k];
        randomizeSeedArray(seedArray);

        File file = new File("/Users/sanketnayak/Desktop/UF - MSCS/Fall 2020/NDS/Project 3/src/project3input.txt");
        Scanner sc = new Scanner(file);
        numberOfFlows = sc.nextInt();
        sc.nextLine();

        String[][] input = new String[numberOfFlows][2];
        flowsArray = new Flow[numberOfFlows];

        int i = 0;
        while (sc.hasNextLine() && i < numberOfFlows){
            input[i] = sc.nextLine().split("\\s+");
            flowsArray[i] = new Flow();
            flowsArray[i].setFlowID(input[i][0]);
            flowsArray[i].setFlowSize(input[i][1]);
            i++;
        }
    }
    public static void randomizeSeedArray(int[] s){
        Random rand = new Random();
        for (int i = 0; i < s.length; i++)
            s[i] = rand.nextInt();
    }
    public int hashFunction(String f, int s) throws NoSuchAlgorithmException {
        byte[] bytearray = f.concat(String.valueOf(s)).getBytes();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] messageDigest = md.digest(bytearray);
        return  ByteBuffer.wrap(messageDigest).getInt();
    }
    public static void writeNewFile(String fileName) throws FileNotFoundException {
        System.out.println("--- Please Check the Folder for the Output File(output_[typeOfSketch])");
        if (fileName.equals("output_countmin") || fileName.equals("output_countSketch"))
            System.out.println("--- For Count Min and Counter Sketch \n" +
                "--- First line represents the average error and subsequent 100 lines with largest estimated flow size are in following order\n" +
                "--- [FlowID] [Estimated Flow Size] [Actual Flow Size]");
        PrintStream outputFile = new PrintStream(new File(fileName));
        System.setOut(outputFile);
    }
}
