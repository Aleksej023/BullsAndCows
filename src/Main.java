import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        Code code = new Code();
        Check check = new Check();
        Result result = new Result();

        game.prepareForTheGame(code, game, check);
        result.checkInputAndShowResult(code);
    }
}
