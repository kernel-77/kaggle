
package nqueen;
import java.util.*;

public class nqueen {

    private boolean isSafe(List<String> board, int row, int col) {
        int r = row, c = col;

        // Check upper-left diagonal
        while (r >= 0 && c >= 0) {
            if (board.get(r).charAt(c) == 'Q') return false;
            r--;
            c--;
        }

        r = row;
        c = col;

        // Check top
        while (r >= 0) {
            if (board.get(r).charAt(c) == 'Q') return false;
            r--;
        }

        r = row;
        c = col;

        // Check upper-right diagonal
        while (r >= 0 && c < board.get(0).length()) {
            if (board.get(r).charAt(c) == 'Q') return false;
            r--;
            c++;
        }

        return true;
    }

    private void func(int row, List<List<String>> ans,
                      List<String> board) {

        // Base condition
        if (row == board.size()) {
            ans.add(new ArrayList<>(board));
            return;
        }

        // Try every column
        for (int col = 0; col < board.get(0).length(); col++) {

            if (isSafe(board, row, col)) {

                // Place queen
                char[] rowArr = board.get(row).toCharArray();
                rowArr[col] = 'Q';
                board.set(row, new String(rowArr));

                // Recursive call
                func(row + 1, ans, board);

                // Backtrack
                rowArr[col] = '.';
                board.set(row, new String(rowArr));
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();

        // Initialize 8x8 board
        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }

        func(0, ans, board);

        return ans;
    }
}

class Main {
    public static void main(String[] args) {

        nqueen solution = new nqueen();

        int n = 8;  // 8 Queens

        List<List<String>> solutions = solution.solveNQueens(n);

        System.out.println("Total Solutions: " + solutions.size());

        // Print all solutions
        for (List<String> sol : solutions) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
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