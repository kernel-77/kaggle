package fractionalknapsackgreedy;

import java.util.*;
import java.util.stream.Gatherer.Integrator.Greedy;

class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, long cap) {
        int n = val.length;

        // Create array of (ratio, index)
        double[][] ratio = new double[n][2];
        for (int i = 0; i < n; i++)
            ratio[i] = new double[]{(double) val[i] / wt[i], i};

        // Sort in descending order of ratio
        Arrays.sort(ratio, (a, b) -> Double.compare(b[0], a[0]));

        double totalValue = 0.0;
        for (double[] r : ratio) {
            int i = (int) r[1];
            if (wt[i] <= cap) {
                totalValue += val[i];
                cap -= wt[i];
            } else {
                totalValue += val[i] * ((double) cap / wt[i]);
                break;
            }
        }

        return Math.round(totalValue * 1e6) / 1e6;
    }
}

public class fractionalKnapsack {
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        long capacity = 50;

        Solution s = new Solution();
        System.out.printf("%.6f", s.fractionalKnapsack(val, wt, capacity));
    }
}

// Title: Design and Implement a Greedy Algorithm for the Fractional Knapsack Problem.
 
// Objective:
//   * To implement the Fractional Knapsack problem using the Greedy method.
//   * To maximize the total value within the given capacity.
//   * To understand the importance of the value-to-weight ratio.
 
// Theory:
 
// The Knapsack problem involves selecting items to maximize total profit without exceeding
// the capacity of a bag. Each item has a Weight (W) and a Value (V). In Fractional
// Knapsack, we are allowed to take a fraction of an item. The greedy strategy selects
// items according to their value-to-weight ratio.
 
//       Ratio = Value / Weight
 
// The item having the highest ratio is selected first.
 
// Example: Knapsack capacity = 50 kg.
//   +------+-------+--------+-------+
//   | Item | Value | Weight | Ratio |
//   +------+-------+--------+-------+
//   | I1   | 60    | 10     | 6     |
//   | I2   | 100   | 20     | 5     |
//   | I3   | 120   | 30     | 4     |
//   +------+-------+--------+-------+
 
// Selection:
//   * Take I1 completely = 60.
//   * Take I2 completely = 100.
//   * Remaining capacity = 20 kg.
//   * Take 20/30 fraction of I3 = 80.
 
//       Total profit = 60 + 100 + 80 = 240
 
// Algorithm:
//   1. Start.
//   2. Read the number of items and knapsack capacity.
//   3. Enter weight and value of each item.
//   4. Calculate value/weight ratio.
//   5. Sort items in descending order of ratio.
//   6. Select the item with the highest ratio.
//   7. If the complete item fits, take it.
//   8. Otherwise, take the required fraction.
//   9. Update remaining capacity.
//   10. Repeat until capacity becomes zero.
//   11. Display maximum profit.
//   12. Stop.
 
// Important points:
//   * Technique: Greedy Algorithm.
//   * Items can be divided into fractions.
//   * Selection is based on maximum value/weight ratio.
//   * Sorting complexity: O(n log n). Overall time complexity: O(n log n).
//   * Fractional Knapsack gives an optimal solution using the greedy method.
 
// Conclusion: Thus, we successfully implemented the Fractional Knapsack problem using the
// Greedy approach and maximized the total profit within the given capacity.
 