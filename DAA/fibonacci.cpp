#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "Enter number of terms: ";
    cin >> n;

    int a = 0, b = 1, next;
    int steps = 0;

    for (int i = 0; i < n; i++) {

        if (i == 0) {
            cout << a << " ";
        }
        else if (i == 1) {
            cout << b << " ";
        }
        else {
            next = a + b;
            steps++;

            a = b;
            steps++;

            b = next;
            steps++;

            cout << b << " ";
        }
    }

    cout << "\nComputational steps: " << steps;

    return 0;
}


// Title: Generate Fibonacci Numbers and Determine the Number of Computational Steps
// Required.
 
// Objective:
//   * To generate Fibonacci numbers using an algorithm.
//   * To understand recursive and iterative approaches.
//   * To calculate the number of computational steps and analyze time complexity.
 
// Theory:
 
// The Fibonacci series is a sequence in which every number is the sum of the previous two
// numbers. The series starts with: 0, 1, 1, 2, 3, 5, 8, 13, 21, ...
 
// Recurrence:
//       F(n) = F(n-1) + F(n-2)
// Base conditions:
//       F(0) = 0,  F(1) = 1
 
// There are two common approaches:
 
// 1. Recursive approach
//   * A function calls itself to calculate the previous two Fibonacci numbers.
//   * It repeats calculations for the same values.
//   * It has exponential time complexity.
 
// 2. Iterative approach
//   * Uses a loop to calculate the next Fibonacci number.
//   * Stores only the previous two values.
//   * It is more efficient than recursion.
 
// Algorithm (Iterative):
//   1. Start.
//   2. Read the number of terms n.
//   3. Initialize a = 0, b = 1.
//   4. Print a and b when applicable.
//   5. Calculate c = a + b.
//   6. Update a = b and b = c.
//   7. Repeat until n terms are generated.
//   8. Count the computational steps.
//   9. Stop.
 
// Important points:
//   +------------------+-----------------+------------------+
//   | Approach         | Time complexity | Space complexity |
//   +------------------+-----------------+------------------+
//   | Recursive        | O(2^n)          | O(n)             |
//   | Iterative        | O(n)            | O(1)             |
//   | DP / Memoization | O(n)            | O(n)             |
//   +------------------+-----------------+------------------+
 
//   * Recursion uses a function call stack.
//   * Iteration avoids repeated calculations.
//   * Dynamic programming stores previously calculated results.
//   * Computational steps are the basic operations performed by an algorithm.
 
// Conclusion: Thus, we successfully generated the Fibonacci series and analyzed its
// computational steps. We observed that the iterative approach is more efficient than the
// simple recursive approach.
 