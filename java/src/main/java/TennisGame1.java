
public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private String player1Name;

    private int player2Score = 0;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName)) {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }

    public String getScore() {
        if (isTie()) {
            return deuce();
        } else if (isAdvantageOrWin()) {
            return advantageOrWin();
        } else {
            return fromLoveToForty();
        }
    }

    private boolean isAdvantageOrWin() {
        return player1Score >= 4 || player2Score >= 4;
    }

    private String advantageOrWin() {
        String score;
        if (isAdvantageForPlayer1()) {
            score = "Advantage " + player1Name;
        } else if (isAdvantageForPlayer2()) {
            score = "Advantage " + player2Name;
        } else {
            score = win();
        }
        return score;
    }

    private String win() {
        String score;
        if (isPlayer1Winner()) {
            score = "Win for " + player1Name;
        } else {
            score = "Win for " + player2Name;
        }
        return score;
    }

    private boolean isAdvantageForPlayer1() {
        return player1Score - player2Score == 1;
    }

    private boolean isAdvantageForPlayer2() {
        return player1Score - player2Score == -1;
    }

    private boolean isPlayer1Winner() {
        return player1Score - player2Score >= 2;
    }

    private boolean isTie() {
        return player1Score == player2Score;
    }

    private String deuce() {
        if (player1Score < 3) {
            return integerToTennisTerm(player1Score) + "-All";
        } else {
            return "Deuce";
        }
    }

    private String fromLoveToForty() {
        return integerToTennisTerm(player1Score) + "-" + integerToTennisTerm(player2Score);
    }

    private String integerToTennisTerm(int score) {
        String tennisTerm = "";
        switch (score) {
            case 0:
                tennisTerm = "Love";
                break;
            case 1:
                tennisTerm = "Fifteen";
                break;
            case 2:
                tennisTerm = "Thirty";
                break;
            case 3:
                tennisTerm = "Forty";
                break;
        }
        return tennisTerm;
    }
}
