public class Player {
    private final String id;
    private final String name;
    private int wins;
    private int losses;
    private int draws;

    public Player(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getWins() {
        return wins;
    }
    public int getLosses() {
        return losses;
    }
    public int getDraws() {
        return draws;
    }

    public void recordResult(int scoreFor, int scoreAgainst) {
        if (scoreFor > scoreAgainst){
            wins++;
        }
        else if (scoreFor < scoreAgainst){
            losses++;
        }
        else{
            draws++;
        }
    }

    @Override
    public String toString() {
        return String.format("%s (W:%d L:%d D:%d)", name, wins, losses, draws);
    }
}
