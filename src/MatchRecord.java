import java.time.LocalDateTime;
// ^^ I looked this up

public class MatchRecord extends MatchRequest {
    private final int score1;
    private final int score2;
    private final LocalDateTime timestamp;

    public MatchRecord(String id, String player1Id, String player2Id, int score1, int score2) {
        super(id, player1Id, player2Id);
        this.score1 = score1;
        this.score2 = score2;
        this.timestamp = LocalDateTime.now();
    }

    public int getScore1() {
        return score1;
    }
    public int getScore2() {
        return score2;
    }

    @Override
    public String toString() {
        return String.format("%s: %s %d–%d %s @ %s",
                getId(),
                getPlayer1Id(), score1,
                score2, getPlayer2Id(),
                timestamp.toLocalTime());
    }
}
