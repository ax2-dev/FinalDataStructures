
# Tournament Manager

A Java app to manage game tournaments.

## Features
- Add players with unique IDs  
- Schedule matches between registered players  
- View upcoming match queue  
- Process next match with score input  
- Automatic leaderboard sorted by wins, draws, and losses  
- Match history with timestamps  
- Undo last processed match  
- Event log of all actions  

## Project Structure  
  - Main.java – Main code (UI stuff)  
  - TournamentManager.java – core logic and data storage  
  - Player.java – model for player data (wins, losses, draws)  
  - MatchRequest.java – represents a scheduled match  
  - MatchRecord.java – represents a completed match with scores and timestamp  
  - Sorting.java – mergeSort and other sorting algorithms (Slightly modified from class to make the functions public)
  - Searching.java – binarySearch and linearSearch method (Same one from class)

## Options
1) Add Player  
   Enter a unique Player ID and a Name.

2) Schedule Match  
   Enter a Match ID, Player 1 ID and Player 2 ID. 

3) View Upcoming Matches  
   Displays all scheduled matches in queue order.  

4) Process Next Match  
   Shows the next match, prompts for each players score, then records the result, updates player records and logs the event.  

5) View Leaderboard  
   Lists all players sorted by wins then draws then name.  

6) View Match History  
   Displays all completed matches with IDs, scores, and timestamps.  

7) Undo Last Match  
   Reverts the most recent processed match, updates player records, and logs the undo.  

8) View Event Log  
   Shows a chronological log of all actions (everything listed above).  

9) Find Win-Rank by Count  
   The program sorts all players’ win counts via mergeSort and searches with binarySearch, then reports the index or not found if it doesn't find anything.  

0) Exit  
   Exit.  

## Data Structures Used
- HashMap for fast lookup of Player by ID  
- TreeSet to keep player names in alphabetical order  
- ArrayList to store match history in insertion order  
- LinkedList for the event log  
- Stack to support undoing the last match  
- Queue to manage upcoming match requests  
- Merge Sort for ordering numeric arrays  
- Binary Search for fast lookup in sorted arrays
![IMG1](https://i.imgur.com/AguH7Ih.png)
![IMG2](https://i.imgur.com/HaEgtmu.png)
![IMG3](https://i.imgur.com/qwhvaMd.png)
![IMG4](https://i.imgur.com/zoGZShQ.png)
![IMG5](https://i.imgur.com/084ME7F.png)
![IMG6](https://i.imgur.com/INhAfwD.png)
