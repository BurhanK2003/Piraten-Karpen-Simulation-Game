# A1 - Piraten Karpen

  * Author: Burhanuddin Kharodawala
  * Email: kharodab@mcmaster.ca

## Build and Execution

  * To clean your working directory:
    * `mvn clean`
  * To compile the project:
    * `mvn compile`
  * To run the project in development mode:
    * `mvn -q exec:java` (here, `-q` tells maven to be _quiet_)
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar` 

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * The ccompiles successfully without any errors.

### Backlog 

| MVP? | Id  | Feature  | Status  |  Started  | Delivered |
| :-:  |:-:  |---       | :-:     | :-:       | :-:       |
| x   | F01 | Roll a dice |  D | 01/01/23 | 01/01/23 |
| x   | F02 | Roll eight dices  |  D | 11-01-23  |12-01-23  |
| x   | F03 | Two players in the game  |  D  |12-01-23    |  12-01-23 |
| x   | F04 | Score 100 points per daimond and gold kept and add points for the combo of dice | D | 20-01-23 | 25-01-23 |
| x   | F05 | Player rolls random dice at their turn or tries to get a combo | D | 20-01-23 | 25-01-23 |
| x   | F06 | Player wins with 1000 points | D |13-01-23 | 13-01-23 |
| x   | F07 | Track points in the game to declare a winner | D | 13-01-23 | 13-01-23 |
| x   | F08 | 3 skulls mean that the round ends and no points gained | D | 13-01-23 | 13-01-23 |
| x   | F09 | Precentage of wins per player | D | 13-01-23 | 13-01-23 |
| x   | F10 | Implement the sea battle strat | D | 25-01-23 | 26-01-23 |
| x   | F11 | Implement the sea battle strat score | D | 26-01-23 | 27-01-23 |
| x   | F12 | Implement the monkey business stratergy and score | D | 27-01-23 | 27-01-23 |