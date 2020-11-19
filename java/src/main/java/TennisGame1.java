
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
        if (player1Name.equals(playerName))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        if (isTie()) {
            return deuce();
        } else if (isAdvantageOrWin()) {
            return advantageOrWin();
        } else {
            return zeroToThreePoints();
        }
    }

    private boolean isAdvantageOrWin() {
        return player1Score >= 4 || player2Score >= 4;
    }

    private String advantageOrWin() {
        String score;
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) {
            score = "Advantage " + player1Name;
        } else if (minusResult == -1) {
            score = "Advantage " + player2Name;
        } else if (minusResult >= 2) {
            score = "Win for " + player1Name;
        } else {
            score = "Win for " + player2Name;
        }
        return score;
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

    private String zeroToThreePoints() {
        return integerToTennisTerm(player1Score) + "-" + integerToTennisTerm(player2Score);
    }

    private String integerToTennisTerm(int tempScore) {
        String score = "";
        switch (tempScore) {
            case 0:
                score = "Love";
                break;
            case 1:
                score = "Fifteen";
                break;
            case 2:
                score = "Thirty";
                break;
            case 3:
                score = "Forty";
                break;
        }
        return score;
    }
}
