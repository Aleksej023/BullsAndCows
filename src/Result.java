import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Result {
    String userInput;
    int cows;
    int bulls;
    int count = 1;

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void showResult(Code code) {
        if (code.secretCode.equals(userInput)) {
            System.out.println("\nGrade: " + bulls + " bulls\n" +
                    "Congratulations! You guessed the secret code.");
        } else if (bulls > 0 && cows > 0) {
            System.out.println("\nGrade: " + bulls + " bulls and " + cows + " cows");
            count++;
        } else if (bulls == 0 && cows == 0) {
            System.out.println("\nGrade: None");
            count++;
        } else if (bulls > 0) {
            System.out.println("\nGrade: " + bulls + " bulls");
            count++;
        } else if (cows > 0) {
            System.out.println("\nGrade: " + cows + " cows");
            count++;
        }

        bulls = 0;
        cows = 0;
    }

    public void checkInputAndShowResult(Code code) throws IOException {
        do {
            System.out.println("\nTurn " + count + ":");

            userInput = reader.readLine();

            if (userInput.length() != code.secretCode.length()) {
                System.out.println("\nError: the length of your code does not match the length of the secret code, try again.");
                continue;
            }

            for (int i = 0; i < code.secretCode.length(); i++) {
                if (userInput.contains(String.valueOf(code.secretCode.charAt(i)))) {
                    if (String.valueOf(userInput.charAt(i)).equals(String.valueOf(code.secretCode.charAt(i)))) {
                        bulls++;
                    } else {
                        cows++;
                    }
                }
            }

            showResult(code);
        } while (!code.secretCode.equals(userInput));
    }
}
