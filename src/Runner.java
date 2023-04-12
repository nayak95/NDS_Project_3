import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            System.out.print("Enter the counter do you want to implement: \n" +
                    "1. CountMin(Enter 1)\n" +
                    "2. Counter Sketch(Enter 2)\n" +
                    "3. Active Counter(Enter 3)\n" +
                    "Your Choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("------CountMin");
                    CountMin countMinObject = new CountMin();
                    countMinObject.stdInput(3, 3000);
                    countMinObject.buildCountMin();
                    Counter.writeNewFile("output_countmin");
                    countMinObject.computerError();
                    break;
                case 2:
                    System.out.println("------CountSketch");
                    CountSketch sketchObject = new CountSketch();
                    sketchObject.stdInput(3, 3000);
                    sketchObject.buildCountSketch();
                    Counter.writeNewFile("output_countSketch");
                    sketchObject.computeError();
                    break;
                case 3:
                    System.out.println("------ActiveCounter");
                    CountActive activeObject = new CountActive();
                    activeObject.stdInput(16, 16, 1000000);
                    Counter.writeNewFile("output_active");
                    activeObject.increaseCounter(1000000);
                    break;
                default:
                    System.out.println("Enter a valid choice (i.e. between 1 and 3)");
                    break;
            }

        } catch (InputMismatchException | NoSuchAlgorithmException e){
            System.out.println("Bad numbers!! Please re-run the program and input valid numbers");
        }
    }
}
