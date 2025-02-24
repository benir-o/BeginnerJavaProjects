package edu.bloomu.hw3;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Runs a monte carlo simulation that randomly places balls in bins, and calculates
 * the average maximum amount of balls in a given bin.
 *
 * @author Riley Simmons
 */
public class MaximumLoad {
    public static void main(String[] args) {
        int simulations = 100_000_000;
        System.out.println("Enter number of balls and number of bins");
        Scanner scan = new Scanner(System.in);
        int balls = scan.nextInt();
        int bins = scan.nextInt();
        int totalMax = 0;
        for (int i = 0; i < simulations; i++) {
            int max = throwBalls(balls, bins);
            totalMax += max;
        }
        double maxAvg = (double) totalMax / simulations;
        System.out.printf("Maximum load: %.2f", maxAvg);
    }

    /**
     * Simulates one round of throwing k balls into n bins.
     *
     * @return Maximum amount of balls in a bin
     */
    private static int throwBalls(int balls, int bins) {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        int max = 0;
        int[] binArray = new int[bins];
        for (int i = 0; i < balls; i++) {
            int rndBin = rand.nextInt(0, bins);
            binArray[rndBin] += 1;
        }
        for (int i = 0; i < bins; i++) {
            max = Math.max(max, binArray[i]);
        }
        return max;
    }
}
