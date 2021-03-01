import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Code {
    String secretCode;
    String abbreviatedAlphabet;
    String[] asterisks;
    int[] randomNumbers;
    char[] secretCodeOfNumbersAndLetters;
    char[] secretCodeArray;
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    char[] abbreviatedAlphabetArray;

    public StringBuilder generateAsterisks(Game game) {
        StringBuilder sbAsterisks = new StringBuilder();
        asterisks = new String[game.lengthRandomNumber];

        for (int i = 0; i < asterisks.length; i++) {
            asterisks[i] = "*";
            sbAsterisks.append(asterisks[i]);
        }

        return sbAsterisks;
    }

    public void generateSecretCodeOfNumbers(Game game) {
        StringBuilder sbSecretCodeOfNumbers = new StringBuilder();

        if (game.rangeOfPossibleCharacters <= 10) {
            randomNumbers = ThreadLocalRandom.current().ints(0, game.rangeOfPossibleCharacters).distinct().limit(game.lengthRandomNumber).toArray();

            for (int i = 0; i < randomNumbers.length; i++) {
                sbSecretCodeOfNumbers.append(randomNumbers[i]);
            }
        } else {
            randomNumbers = ThreadLocalRandom.current().ints(0, 10).distinct().limit(game.lengthRandomNumber).toArray();

            for (int i = 0; i < randomNumbers.length; i++) {
                sbSecretCodeOfNumbers.append(randomNumbers[i]);
            }
        }

        secretCode = String.valueOf(sbSecretCodeOfNumbers);
    }

    public void generateAbbreviatedAlphabet(Game game) {
        StringBuilder sbAbbreviatedAlphabet = new StringBuilder();
        abbreviatedAlphabetArray = new char[game.rangeOfPossibleCharacters - 10];

        System.arraycopy(alphabet, 0, abbreviatedAlphabetArray, 0, game.rangeOfPossibleCharacters - 10);

        for (int i = 0; i < abbreviatedAlphabetArray.length; i++) {
            sbAbbreviatedAlphabet.append(abbreviatedAlphabetArray[i]);
        }

        abbreviatedAlphabet = String.valueOf(sbAbbreviatedAlphabet);
    }

    public void generateSecretCodeOfNumbersAndLetters(Game game) {
        generateSecretCodeOfNumbers(game);
        generateAbbreviatedAlphabet(game);

        secretCode = secretCode + abbreviatedAlphabet;
        secretCodeArray = secretCode.toCharArray();
        secretCodeOfNumbersAndLetters = new char[game.lengthRandomNumber];

        Random rnd = new Random();

        for (int i = 0; i < secretCodeArray.length; i++) {
            int index = rnd.nextInt(i + 1);
            int a = secretCodeArray[index];
            secretCodeArray[index] = secretCodeArray[i];
            secretCodeArray[i] = (char) a;
        }

        System.arraycopy(secretCodeArray, 0, secretCodeOfNumbersAndLetters, 0, game.lengthRandomNumber);

        secretCode = String.valueOf(secretCodeOfNumbersAndLetters);
    }
}
