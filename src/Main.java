import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TournamentManager tm = new TournamentManager();
        Scanner in = new Scanner(System.in);

        System.out.println("=== Tournament Manager ===");

        while (true) {
            System.out.println(
                    "\n1) Add Player\n" +
                            "2) Schedule Match\n" +
                            "3) View Upcoming Matches\n" +
                            "4) Process Next Match\n" +
                            "5) View Leaderboard\n" +
                            "6) View Match History\n" +
                            "7) Undo Last Match\n" +
                            "8) View Event Log\n" +
                            "9) Find Win-Rank by Count\n" +
                            "0) Exit"
            );
            System.out.print("Choice: ");
            switch (in.nextLine()) {
                case "1" -> {
                    System.out.print("Player ID: ");
                    String id = in.nextLine();
                    System.out.print("Name: ");
                    String name = in.nextLine();
                    System.out.println(tm.addPlayer(id, name) ? "Player added." : "ID already exists.");
                }
                case "2" -> {
                    System.out.print("Match ID: ");
                    String mid = in.nextLine();
                    System.out.print("Player 1 ID: ");
                    String p1 = in.nextLine();
                    System.out.print("Player 2 ID: ");
                    String p2 = in.nextLine();
                    System.out.println(tm.scheduleMatch(mid, p1, p2) ? "Match scheduled." : "Invalid player ID(s).");
                }
                case "3" -> {
                    List<MatchRequest> upcoming = tm.getUpcomingMatches();
                    if (upcoming.isEmpty()) {
                        System.out.println("No upcoming matches.");
                    }
                    else {
                        System.out.println("--- Upcoming Matches ---");
                        upcoming.forEach(System.out::println);
                    }
                }
                case "4" -> {
                    MatchRequest next = tm.peekNextMatch();
                    if (next == null) {
                        System.out.println("No matches to process.");
                        break;
                    }
                    System.out.println("Processing: " + next);
                    System.out.print("Score for " + next.getPlayer1Id() + ": ");
                    int s1 = Integer.parseInt(in.nextLine());
                    System.out.print("Score for " + next.getPlayer2Id() + ": ");
                    int s2 = Integer.parseInt(in.nextLine());
                    MatchRecord rec = tm.processNextMatch(s1, s2);
                    System.out.println("Recorded: " + rec);
                }
                case "5" -> {
                    System.out.println("--- Leaderboard ---");
                    tm.getLeaderboard().forEach(System.out::println);
                }
                case "6" -> {
                    List<MatchRecord> history = tm.getMatchHistory();
                    if (history.isEmpty()) System.out.println("No matches played.");
                    else {
                        System.out.println("--- Match History ---");
                        history.forEach(System.out::println);
                    }
                }
                case "7" -> {
                    tm.undoLastMatch();
                    System.out.println("Last match undone (if any).");
                }
                case "8" -> {
                    List<String> log = tm.getEventLog();
                    if (log.isEmpty()) System.out.println("Event log is empty.");
                    else {
                        System.out.println("--- Event Log ---");
                        log.forEach(System.out::println);
                    }
                }
                case "9" -> {
                    System.out.print("Enter win count: ");
                    int w = Integer.parseInt(in.nextLine());
                    int idx = tm.findWinCountIndex(w);
                    System.out.println(idx >= 0 ? "Win count found at sorted index " + idx : "Win count not found");
                }
                case "0" -> {
                    System.out.println("Exiting. Goodbye!");
                    in.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
