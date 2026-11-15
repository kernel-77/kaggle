#include <iostream>
using namespace std;

int main() {
    int n = 5;
    int r = 2;

    int dp[6][6] = {0};

    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= i; j++) {

            if (j == 0 || j == i) {
                dp[i][j] = 1;
            }
            else {
                dp[i][j] = dp[i - 1][j - 1]
                         + dp[i - 1][j];
            }
        }
    }

    cout << "Binomial Coefficient C("
         << n << "," << r << ") = "
         << dp[n][r];

    return 0;
}

// Title: Calculate Binomial Coefficients Using Dynamic Programming.
 
// Objective:
//   * To calculate binomial coefficients using Dynamic Programming.
//   * To understand Pascal's Triangle.
//   * To reduce repeated calculations using previously computed results.
 
// Theory:
 
// A binomial coefficient represents the number of ways to select r objects from n objects.
//       nCr = n! / ( r! (n-r)! )
// For example: 5C2 = 5! / (2! 3!) = 10
 
// Instead of calculating factorials repeatedly, we use Dynamic Programming.
 
// Recurrence relation:
//       C(n, r) = C(n-1, r-1) + C(n-1, r)
// Base conditions:
//       C(n, 0) = 1   and   C(n, n) = 1
 
// These values form Pascal's Triangle.
 
// Example - Pascal's Triangle:
//             1
//           1   1
//         1   2   1
//       1   3   3   1
//     1   4   6   4   1
// 5C2 = 10
 
// Algorithm:
//   1. Start.
//   2. Read n and r.
//   3. Create a DP table.
//   4. Set C[i][0] = 1.
//   5. Set C[i][i] = 1.
//   6. For each remaining position, calculate C[i][j] = C[i-1][j-1] + C[i-1][j].
//   7. Display C[n][r].
//   8. Stop.
 
// Important points:
//   * Technique: Dynamic Programming.
//   * Pascal's Triangle is used.
//   * Each value depends on two values in the previous row.
//   * Time complexity: O(nr) when computing only up to r.
//   * Space complexity: O(nr) for the full DP table. One-dimensional DP can reduce space
//       to O(r).
 
// Conclusion: Thus, we successfully calculated binomial coefficients using Dynamic
// Programming and reduced repeated computations using previously stored results.