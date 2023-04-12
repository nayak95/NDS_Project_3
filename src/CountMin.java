import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class CountMin extends Counter{

    public void buildCountMin() throws NoSuchAlgorithmException {
        C = new int[k][w];
        for (int i = 0; i < numberOfFlows; i++) {
            for (int j = 0; j < k; j++) {
                int hashIndex = Math.floorMod(hashFunction(flowsArray[i].getFlowID(), seedArray[j]), w);
                C[j][hashIndex]+= Integer.parseInt(flowsArray[i].getFlowSize());
            }
        }
    }
    public void computerError() throws NoSuchAlgorithmException {
        int[] estimatedSize = new int[numberOfFlows];
        for (int i = 0; i < numberOfFlows; i++) {
            int minimum = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                int hashIndex = Math.floorMod(hashFunction(flowsArray[i].getFlowID(), seedArray[j]), w);
                if (C[j][hashIndex] < minimum)
                    minimum = C[j][hashIndex];
            }
            estimatedSize[i] = minimum;
            flowsArray[i].setEstimatedSize(String.valueOf(minimum));
        }
        int sum = 0;
        for (int i = 0; i < numberOfFlows; i++) {
            sum += Math.abs(estimatedSize[i] - Integer.parseInt(flowsArray[i].getFlowSize()));
        }
        System.out.println((double)sum/numberOfFlows);
        Arrays.sort(flowsArray, (o1, o2) -> Integer.compare(Integer.parseInt(o2.getEstimatedSize()), Integer.parseInt(o1.getEstimatedSize())));
        for (int i = 0; i < 100; i++) {
            System.out.println(flowsArray[i].toString());
        }
    }
}
