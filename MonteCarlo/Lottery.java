package BeginnerJavaProjects.MonteCarlo;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Simulates a lottery game where all players enter $1 and the money is then
 * redistributed randomly to all the players and calculates the average amount
 * of losers (players with $0)
 *
 * @author Riley Simmons
 */
public class Lottery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int players = scan.nextInt();
        int simulations = 100_000;
        int totalLosers = 0;
        for (int i = 0; i < simulations; i++) {
            int losers = simulate(players);
            totalLosers += losers;
        }
        System.out.printf("%2.3f = expected number of losers%n",
                (float) totalLosers / simulations);
        System.out.printf("%2.3f = %d/e", (players / Math.E), players);
    }

    /**
     * Simulates 1 turn of the lottery game
     */
    private static int simulate(int players) {
        int losers = 0;
        int[] playerArray = new int[players];
        ThreadLocalRandom rand = ThreadLocalRandom.current();

        for (int i = 0; i < players; i ++) {
            playerArray[rand.nextInt(0, players)] += 1;
        }
        for (int j : playerArray) {
            if (j==0) {
                losers++;
            }
        }
        return losers;
    }
}
