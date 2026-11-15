
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int weights[] = {2, 3, 4, 5};
    int profits[] = {3, 4, 5, 6};

    int n = 4;
    int capacity = 5;

    int dp[5][6] = {0};

    for (int i = 1; i <= n; i++) {
        for (int w = 0; w <= capacity; w++) {

            if (weights[i - 1] <= w) {
                dp[i][w] = max(
                    dp[i - 1][w],
                    profits[i - 1] +
                    dp[i - 1][w - weights[i - 1]]
                );
            }
            else {
                dp[i][w] = dp[i - 1][w];
            }
        }
    }

    cout << "Maximum Profit: " << dp[n][capacity];

    return 0;
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