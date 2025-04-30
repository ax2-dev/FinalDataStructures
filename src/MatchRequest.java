public class MatchRequest {
    private final String id;
    private final String player1Id;
    private final String player2Id;

    public MatchRequest(String id, String player1Id, String player2Id) {
        this.id = id;
        this.player1Id = player1Id;
        this.player2Id = player2Id;
    }

    public String getId() {
        return id;
    }
    public String getPlayer1Id() {
        return player1Id;
    }
    public String getPlayer2Id() {
        return player2Id;
    }

    @Override
    public String toString() {
        return String.format("%s: %s vs %s", id, player1Id, player2Id);
    }
}
