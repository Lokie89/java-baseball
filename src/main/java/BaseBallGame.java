public class BaseBallGame {
    final int chance;
    final String randomNum;

    public BaseBallGame(int chance, String randomNum) {
        this.chance = chance;
        this.randomNum = randomNum;
    }

    public void run() {
        int attempt = 1;
        while (attempt <= chance) {
            String response = new CustomScanner().getResponse(chance + "기회 중 " + attempt + "번째 시도입니다. 던지세요.");
            if (confirm(response)) {
                success();
                break;
            }
            if (attempt == chance) {
                fail();
            }
            attempt++;
        }
    }

    private boolean confirm(String response) {
        boolean allStrike = false;
        int digit = response.length();
        int strike = 0;
        int ball = 0;
        int out = 0;
        for (int i = 0; i < digit; i++) {
            int index = getIndex(response.substring(i, i + 1));
            if (index == -1) {
                out++;
                continue;
            }
            if (index != -1) {
                if (index == i) {
                    strike++;
                    continue;
                }
                ball++;
                continue;
            }
        }
        showResult(strike, ball, out);
        if (strike == digit)
            allStrike = true;
        return allStrike;
    }

    private int getIndex(String number) {
        return randomNum.indexOf(number);
    }

    private void showResult(int strike, int ball, int out) {
        StringBuilder sb = new StringBuilder();
        if (strike > 0) {
            sb.append(strike);
            sb.append(" Strike ");
        }
        if (ball > 0) {
            sb.append(ball);
            sb.append(" Ball ");
        }
        if (out > 0) {
            sb.append(out);
            sb.append(" Out");
        }
        System.out.println(sb.toString());
    }

    private void success() {
        System.out.println("성공하였습니다.");
    }

    private void fail() {
        System.out.println("실패하였습니다.");
    }
}
