#include <iostream>
using namespace std;

int board[8][8] = {0};

bool isSafe(int row, int col) {

    for (int i = 0; i < row; i++) {
        if (board[i][col] == 1)
            return false;
    }

    for (int i = row - 1, j = col - 1;
         i >= 0 && j >= 0; i--, j--) {
        if (board[i][j] == 1)
            return false;
    }

    for (int i = row - 1, j = col + 1;
         i >= 0 && j < 8; i--, j++) {
        if (board[i][j] == 1)
            return false;
    }

    return true;
}

bool solve(int row) {

    if (row == 8)
        return true;

    for (int col = 0; col < 8; col++) {

        if (isSafe(row, col)) {

            board[row][col] = 1;

            if (solve(row + 1))
                return true;

            board[row][col] = 0;
        }
    }

    return false;
}

int main() {

    board[0][0] = 1;

    if (solve(1)) {

        cout << "Solution:\n";

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cout << board[i][j] << " ";
            }
            cout << endl;
        }
    }
    else {
        cout << "No solution exists";
    }

    return 0;
}


// Title: Solve the 8-Queens Problem Using Backtracking.
 
// Objective:
//   * To place eight queens on an 8x8 chessboard.
//   * To ensure that no two queens attack each other.
//   * To understand the Backtracking technique.
 
// Theory:
 
// The 8-Queens problem is a classical problem in which eight queens must be placed on an
// 8x8 chessboard. A queen can attack another queen if they are in the same (1) Row, (2)
// Column or (3) Diagonal. Therefore, no two queens should share any of these positions.
 
// Backtracking: An algorithmic technique that builds a solution step by step. If a
// selected position violates the constraints, the algorithm removes that choice and tries
// another position.
 
// Algorithm:
//   1. Start.
//   2. Initialize an empty 8x8 chessboard.
//   3. Place the first queen at the given position.
//   4. Move to the next row.
//   5. Check every column for a safe position.
//   6. If a safe position is found, place a queen.
//   7. Move to the next row.
//   8. If no safe position exists, remove the previously placed queen.
//   9. Try the next available position.
//   10. Continue until all eight queens are placed.
//   11. Display the solution.
//   12. Stop.
 
// Safety conditions: A position is safe if:
//   * No queen exists in the same column.
//   * No queen exists in the upper-left diagonal.
//   * No queen exists in the upper-right diagonal.
// Because we place one queen per row, checking the same row is unnecessary.
 
// Important points:
//   * Technique: Backtracking. Board size: 8x8. Total queens: 8.
//   * One queen per row and column.
//   * There are 92 distinct solutions if rotations and reflections are counted separately.
//   * Common upper-bound time complexity for the row-wise backtracking approach: O(N!).
//   * Space complexity: O(N^2) for the board.
 
// Conclusion: Thus, we successfully solved the 8-Queens problem using Backtracking by
// placing eight queens without violating the attacking conditions.