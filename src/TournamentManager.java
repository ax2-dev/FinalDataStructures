import util.Searching;
import util.Sorting;
import java.util.*;

public class TournamentManager {
    private final Map<String, Player> players = new HashMap<>();
    private final TreeSet<String> playerNames = new TreeSet<>();
    private final List<MatchRecord> matchHistory = new ArrayList<>();
    private final LinkedList<String> eventLog = new LinkedList<>();
    private final Stack<MatchRecord> undoMatchStack = new Stack<>();
    private final Queue<MatchRequest> upcomingMatches = new LinkedList<>();

    public boolean addPlayer(String id, String name) {
        if (players.containsKey(id)){
            return false;
        }
        Player p = new Player(id, name);
        players.put(id, p);
        playerNames.add(name);
        return true;
    }

    public boolean scheduleMatch(String matchId, String p1, String p2) {
        if (!players.containsKey(p1) || !players.containsKey(p2)){
            return false;
        }
        upcomingMatches.offer(new MatchRequest(matchId, p1, p2));
        return true;
    }

    public MatchRequest peekNextMatch() {
        return upcomingMatches.peek();
    }

    public MatchRecord processNextMatch(int score1, int score2) {
        MatchRequest req = upcomingMatches.poll();
        if (req == null) {
            return null;
        }
        MatchRecord rec = new MatchRecord(req.getId(), req.getPlayer1Id(), req.getPlayer2Id(), score1, score2);
        matchHistory.add(rec);
        undoMatchStack.push(rec);
        players.get(rec.getPlayer1Id()).recordResult(score1, score2);
        players.get(rec.getPlayer2Id()).recordResult(score2, score1);
        eventLog.add("Match completed: " + rec);
        return rec;
    }

    public void undoLastMatch() {
        if (undoMatchStack.isEmpty()){
            return;
        }
        MatchRecord rec = undoMatchStack.pop();
        matchHistory.remove(rec);
        players.get(rec.getPlayer1Id()).recordResult(-rec.getScore1(), -rec.getScore2());
        players.get(rec.getPlayer2Id()).recordResult(-rec.getScore2(), -rec.getScore1());
        eventLog.add("Undid match: " + rec.getId());
    }

    public int[] getSortedWinCounts() {
        int[] wins = players.values().stream()
                .mapToInt(Player::getWins)
                .toArray();
        Sorting.mergeSort(wins, 0, wins.length - 1);
        return wins;
    }

    public int findWinCountIndex(int wins) {
        return Searching.binarySearch(getSortedWinCounts(), wins);
    }

    public List<Player> getLeaderboard() {
        List<Player> list = new ArrayList<>(players.values());
        list.sort((a, b) -> {
            if (b.getWins() != a.getWins()){
                return b.getWins() - a.getWins();
            }
            if (b.getDraws()!= a.getDraws()){
                return b.getDraws() - a.getDraws();
            }
            return a.getName().compareTo(b.getName());
        });
        return list;
    }

    public List<MatchRequest> getUpcomingMatches() {
        return new ArrayList<>(upcomingMatches);
    }

    public List<MatchRecord> getMatchHistory() {
        return new ArrayList<>(matchHistory);
    }

    public List<String> getEventLog() {
        return new ArrayList<>(eventLog);
    }
}
