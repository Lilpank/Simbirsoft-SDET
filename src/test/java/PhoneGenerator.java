import java.util.Random;

public class PhoneGenerator {
    public static String generatePhone() {
        Random rand = new Random();
        int num1, num2, num3;
        num1 = rand.nextInt(900) + 100;
        num2 = rand.nextInt(643) + 100;
        num3 = rand.nextInt(900) + 100;
        return "7" + (num1) + num2 + num3;
    }
}
