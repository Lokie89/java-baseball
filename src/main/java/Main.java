import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("main");
        try {
            // 여기서 숫자가 아니면 Exception 할것
            RandomNumber randomNumber = new RandomNumber(Integer.parseInt(new CustomScanner().getResponse("몇 자리 게임 할거야?")));
            BaseBallGame baseBallGame = new BaseBallGame(10, randomNumber.getBaseBallNumber());
            baseBallGame.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
