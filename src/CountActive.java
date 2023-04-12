import java.util.Random;

public class CountActive {

    int numberPart;
    int exponentPart;
    int cap;
    int numberBitsValue = 0;
    int exponentBitsValue = 0;
    int exponent;


    public void stdInput(int numberPart, int exponentPart, int cap) {
        this.numberPart = numberPart;
        this.exponentPart = exponentPart;
        this.cap = cap;
        this.exponent = 1;
    }

    public void increaseCounter(int cap) {
        System.out.println(build(cap));
    }

    public int build(int cap){
        int i=1;
        while (i++ <= cap)
            counterIncrement();
        return (int) (numberBitsValue *Math.pow(2, exponentBitsValue));
    }

    public void counterIncrement(){
        Random rand = new Random();
        if(1 / (Math.pow(2, exponentBitsValue)) >= rand.nextDouble())
            numberBitsValue++;

        if(numberBitsValue >= Math.pow(2, numberPart)){
            numberBitsValue >>= 1;
            exponentBitsValue++;
        }
    }


}
