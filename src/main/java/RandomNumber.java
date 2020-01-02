import java.util.Random;

public class RandomNumber {
    final int digit;
    StringBuilder sb;

    public RandomNumber(int digit) {
        this.digit = digit;
    }

    private String getRandomNumber(){
        Random random = new Random();
        int ranNum = random.nextInt(10);
        return Integer.toString(ranNum);
    }

    public String getNumber(){

    }

}
