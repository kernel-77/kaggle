package and1knapsack;

import java.util.*;

class kn {
    // Function to solve the 0/1 Knapsack problem with arrays
    private int func(int[] wt, int[] val, int ind, int W, int[][] dp) {
        /* Base case: If there are no items left
        or the knapsack has no capacity, return 0 */
        if (ind < 0 || W == 0) {
            return 0;
        }

        /* If the result for this state is
        already calculated, return it */
        if (dp[ind][W] != -1) {
            return dp[ind][W];
        }

        /* Calculate the maximum value by either
        excluding the current item or including it */
        int notTaken = func(wt, val, ind - 1, W, dp);
        int taken = 0;

        /* Check if the current item can be included
        without exceeding the knapsack's capacity */
        if (wt[ind] <= W) {
            taken = val[ind] + func(wt, val, ind - 1, W - wt[ind], dp);
        }

        // Store the result in the DP table and return
        dp[ind][W] = Math.max(notTaken, taken);
        return dp[ind][W];
    }

    public int knapsack01(int[] wt, int[] val, int n, int W) { 
        // Initialize DP table with -1
        int[][] dp = new int[n][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return func(wt, val, n - 1, W, dp);
    }

    public static void main(String[] args) {
        int[] wt = {2, 3, 4, 5};
        int[] val = {3, 4, 5, 6};
        int W = 5;
        int n = wt.length;
        
        // Create an instance of Solution class
        kn sol = new kn();

        System.out.println("The Maximum value of items is " + sol.knapsack01(wt, val, n, W));
    }
}

// Title: Implement the 0/1 Knapsack Problem Using Dynamic Programming or Branch and Bound.
 
// Objective:
//   * To solve the 0/1 Knapsack problem.
//   * To maximize profit without exceeding the capacity.
//   * To understand Dynamic Programming or Branch and Bound techniques.
 
// Theory:
 
// The 0/1 Knapsack problem is an optimization problem in which we select items to maximize
// total value without exceeding the given capacity. Unlike Fractional Knapsack, an item
// cannot be divided. Every item has only two possibilities: 1 = select the complete item,
// 0 = do not select the item.
 
// Dynamic Programming approach: Construct a two-dimensional DP table where rows represent
// items, columns represent knapsack capacities, and each cell stores the maximum profit
// possible.
 
// Recurrence relation:
//       DP[i][w] = DP[i-1][w],   if wt(i) > w
//       DP[i][w] = max( DP[i-1][w],  val(i) + DP[i-1][w - wt(i)] ),   if wt(i) <= w
// Base conditions:
//       DP[0][w] = 0   and   DP[i][0] = 0
 
// Algorithm (Dynamic Programming):
//   1. Start.
//   2. Read the number of items and capacity.
//   3. Enter weights and values.
//   4. Create a DP table of size (n+1) x (W+1).
//   5. Initialize the first row and column with zero.
//   6. For every item and capacity:
//       - If item weight exceeds capacity, copy the previous value.
//       - Otherwise, calculate the maximum of including and excluding the item.
//   7. Store the result in the DP table.
//   8. Display DP[n][W].
//   9. Stop.
 
// Branch and Bound approach: Explores possible solutions using a state-space tree.
//   * Branch: Divide the problem into include and exclude decisions.
//   * Bound: Calculate an upper bound on the possible profit.
//   * Prune: Discard branches that cannot improve the current best solution.
 
// Important points:
//   +-----------------+--------------------------+---------------------+
//   | Feature         | 0/1 Knapsack             | Fractional Knapsack |
//   +-----------------+--------------------------+---------------------+
//   | Item division   | Not allowed              | Allowed             |
//   | Main technique  | DP / Branch and Bound    | Greedy              |
//   | Selection       | Complete item or nothing | Any fraction        |
//   | Greedy optimal? | Not always               | Yes                 |
//   +-----------------+--------------------------+---------------------+
 
//   * DP time complexity: O(nW). DP space complexity: O(nW).
//   * It is called pseudo-polynomial time because complexity depends on the numerical
//       capacity W.
 
// Conclusion: Thus, we implemented the 0/1 Knapsack problem using Dynamic Programming or
// Branch and Bound to obtain the maximum possible profit without exceeding the capacity.