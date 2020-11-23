
public class TennisGame1 implements TennisGame {

    private String player1Name;
    private int player1Score = 0;

    private String player2Name;
    private int player2Score = 0;

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
        } else if (isAdvantage()) {
            return advantage();
        } else if (isWin()) {
            return win();
        } else {
            return fromLoveToForty();
        }
    }

    private boolean isAdvantage() {
        return atLeastThreePointsScoredByEachPlayer() && aPlayerHasOneMorePointThanTheOther();
    }

    private boolean atLeastThreePointsScoredByEachPlayer() {
        return player1Score >= 3 && player2Score >= 3;
    }

    private boolean aPlayerHasOneMorePointThanTheOther() {
        return Math.abs(player1Score - player2Score) == 1;
    }

    private String advantage() {
        return "Advantage " + playerWithHigherScore();
    }

    private boolean isWin() {
        return aPlayerScoredAtLeastFourPoints() && aPlayerHasScoredAtLeastTwoPointsMoreThanTheOther();
    }

    private boolean aPlayerScoredAtLeastFourPoints() {
        return player1Score >= 4 || player2Score >= 4;
    }

    private boolean aPlayerHasScoredAtLeastTwoPointsMoreThanTheOther() {
        return Math.abs(player1Score - player2Score) >= 2;
    }

    private String win() {
        return "Win for " + playerWithHigherScore();
    }

    private String playerWithHigherScore() {
        if (player1Score > player2Score) {
            return player1Name;
        } else {
            return player2Name;
        }
    }

    private boolean isTie() {
        return player1Score == player2Score;
    }

    private String deuce() {
        if (player1Score < 3) {
            return tennisTermFor(player1Score) + "-All";
        } else {
            return "Deuce";
        }
    }

    private String fromLoveToForty() {
        return tennisTermFor(player1Score) + "-" + tennisTermFor(player2Score);
    }

    private String tennisTermFor(int score) {
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
