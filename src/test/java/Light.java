import java.util.Date;
import java.util.List;
import java.util.Random;


public class Light {

    public static void main(String[] args) {
        Random rand = new Random();
        int n1 = 0;
        int n2 = 0;


        for (int j = 0; j < 10; j++) {
            int i = rand.nextInt(2);

            switch (i) {
                case 0:
                    System.out.println(i + " eagle");
                    n1 = n1 + 1 + i;
                    break;
                case 1:
                    System.out.println(i + " tail");
                    n2 = n2 + i;
                    break;
            }
        }

        System.out.println("total eagle: " + n1);
        System.out.println("total tails: " + n2);

    }
}

