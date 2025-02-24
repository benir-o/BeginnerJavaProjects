package edu.bloomu.hw3;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Write a Monte Carlo simulation to calculate the expected payout
 * for the game of Capybara. The player repeatedly rolls a pair of dice and wins a
 * dol-lar amount equal to the sum. This continues until the player rolls 7, 8, or 9,
 * at which point the game ends. Note that if the first roll is 7, 8, or 9, the player
 * wins nothing. Display the result in $X.YZ format
 */
public class CapybaraPayout {
    public static void main(String[] args) {
        int simulations = 100_000_000;
        int totalWinnings = 0;
        int maxPayout = 0;
        for (int i = 0; i < simulations; i++) {
            int payout = (int) playCapybara();
            maxPayout = Math.max(payout, maxPayout);
            totalWinnings += payout;
        }
        float avgWinnings = (float) totalWinnings / simulations;
        System.out.printf("Average payout for %,d games of Capybara: $%1.2f %n",
                simulations, avgWinnings);
        System.out.printf("Maximum payout: $%d %n", maxPayout);
    }
    private static float playCapybara() {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        int winnings = 0;
        while (true) {
            int die1 = rand.nextInt(1, 7);
            int die2 = rand.nextInt(1, 7);
            int dieSum = die1 + die2;
            if (dieSum == 7 || dieSum == 8 || dieSum == 9) {
                return winnings;
            } else {
                winnings += dieSum;
            }
        }
    }
}
