import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class CountSketch extends Counter{
int msb;
    @Override
    public int hashFunction(String f, int s) throws NoSuchAlgorithmException {
        byte[] bytearray = f.concat(String.valueOf(s)).getBytes();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] messageDigest = md.digest(bytearray);
        msb = getBit(messageDigest, 0);
        return  ByteBuffer.wrap(messageDigest).getInt();
    }
    private static int getBit(byte[] data, int pos) {
        int posByte = pos/8;
        int posBit = pos%8;
        byte valByte = data[posByte];
        return valByte>>(8-(posBit+1)) & 0x0001;
    }
    public void buildCountSketch() throws NoSuchAlgorithmException {
        C = new int[k][w];
        for (int i = 0; i < numberOfFlows; i++) {
            for (int j = 0; j < k; j++) {
                int hashIndex = Math.floorMod(hashFunction(flowsArray[i].getFlowID(), seedArray[j]), w);
                if (msb == 1)
                    C[j][hashIndex] += Integer.parseInt(flowsArray[i].getFlowSize());
                else
                    C[j][Math.abs(hashIndex)] -= Integer.parseInt(flowsArray[i].getFlowSize());
            }
        }
    }
    public void computeError() throws NoSuchAlgorithmException {
        int[] estimatedSize = new int[k];
        float averageError = 0;
        for (int i = 0; i < numberOfFlows; i++) {
            int countValue;
            for (int j = 0; j < k; j++) {
                int hashIndex = Math.floorMod(hashFunction(flowsArray[i].getFlowID(), seedArray[j]), w);
                if (msb == 1)
                    countValue = C[j][hashIndex];
                else
                    countValue = (-1)*C[j][hashIndex];
                estimatedSize[j] = countValue;
            }
            Arrays.sort(estimatedSize);
            averageError += estimatedSize[k/2];
            flowsArray[i].setEstimatedSize(String.valueOf(estimatedSize[k/2]));
        }
        averageError /= numberOfFlows;
        System.out.println(averageError);
        Arrays.sort(flowsArray, (o1, o2) -> Integer.compare(Integer.parseInt(o2.getEstimatedSize()), Integer.parseInt(o1.getEstimatedSize())));
        for (int i = 0; i < 100; i++) {
            System.out.println(flowsArray[i].toString());
        }
    }
}
