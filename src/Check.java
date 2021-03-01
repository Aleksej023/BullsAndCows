import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Check {
    public int checkUserInput() {
        int userInput = 0;
        boolean isInt = false;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (!isInt) {
            try {
                userInput = Integer.parseInt(reader.readLine());

                if (userInput > 0) {
                    isInt = true;
                } else {
                    System.out.println("\nError! Enter a positive number.");
                }
            } catch (Exception e){
                System.out.println("\nError! Enter a positive number.");
            }
        }
        return userInput;
    }
}
