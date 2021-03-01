public class Game {
    int lengthRandomNumber;
    int rangeOfPossibleCharacters;

    public void prepareForTheGame(Code code, Game game, Check check) {
        while (true) {
            System.out.println("Input the length of the secret code:");

            lengthRandomNumber = check.checkUserInput();

            System.out.println("\nInput the number of possible symbols in the code:");

            rangeOfPossibleCharacters = check.checkUserInput();

            if (rangeOfPossibleCharacters < lengthRandomNumber || lengthRandomNumber <= 0) {
                System.out.println("\nError: it's not possible to generate a code with a length of " + lengthRandomNumber + " with " + rangeOfPossibleCharacters + " unique symbols.\n");
                continue;
            } else if (rangeOfPossibleCharacters > 36) {
                System.out.println("\nError: maximum number of possible symbols in the code is 36 (0-9, a-z).\n");
                continue;
            }
            break;
        }

        if (rangeOfPossibleCharacters <= 10) {
            code.generateSecretCodeOfNumbers(game);

            System.out.println("\nThe secret is prepared: " + code.generateAsterisks(game) + " (0-" + (rangeOfPossibleCharacters - 1) + ").\n" +
                    "Okay, let's start a game!");
        } else {
            code.generateSecretCodeOfNumbersAndLetters(game);

            System.out.println("\nThe secret is prepared: " + code.generateAsterisks(game) + " (0-9, a-" + code.alphabet[rangeOfPossibleCharacters - 11] + ").\n" +
                    "Okay, let's start a game!");
        }
    }
}
