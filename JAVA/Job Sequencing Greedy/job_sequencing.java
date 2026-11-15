import java.util.*;

class job_secquencing {
    // Function to calculate maximum profit
    public int[] JobScheduling(int[][] Jobs) {
        // Sort jobs based on profit in descending order
        Arrays.sort(Jobs, (a, b) -> b[2] - a[2]);

        // Total number of jobs
        int n = Jobs.length;

        // Get the maximum deadline to complete the jobs
        int maxDeadline = -1;
        for (int[] it : Jobs) {
            maxDeadline = Math.max(maxDeadline, it[1]);
        }

        // Initialize a hash table to store selected jobs
        int[] hash = new int[maxDeadline];
        Arrays.fill(hash, -1);

        // Initialize count
        int cnt = 0;

        // Initialize the total profit earned
        int totalProfit = 0;

        // Iterate over each job
        for (int i = 0; i < n; i++) {

            /* Iterate over each deadline slot 
            starting from the job's deadline */
            for (int j = Jobs[i][1] - 1; j >= 0; j--) {

                // If the current deadline slot is available 
                if (hash[j] == -1) {
                    cnt++; // Count of selected jobs
                    hash[j] = Jobs[i][0]; // Mark the job as selected
                    totalProfit += Jobs[i][2]; // Update the total profit

                    // Move to the next job
                    break;
                }
            }
        }

        // Return the array
        return new int[]{cnt, totalProfit};
    }
}

class Main {
    public static void main(String[] args) {
        int[][] jobs = {{1, 4, 20}, {2, 1, 10}, {3, 1, 40}, {4, 1, 30}};

        job_secquencing solution = new job_secquencing();
        int[] result = solution.JobScheduling(jobs);

        // Output the result
        System.out.println("Number of Jobs: " + result[0]);
        System.out.println("Maximum Profit: " + result[1]);
    }
}

// Title: Implement a Greedy Algorithm for the Job Sequencing Problem with Deadlines.
 
// Objective:
//   * To implement the Job Sequencing problem using the Greedy method.
//   * To maximize total profit by scheduling jobs before their deadlines.
//   * To understand the working of greedy algorithms.
 
// Theory:
 
// Job Sequencing is a scheduling problem in which every job has: (1) Job ID, (2) Deadline,
// (3) Profit. Each job requires one unit of time, and profit is earned only when the job
// is completed before or on its deadline. The objective is to schedule jobs so that the
// maximum possible profit is obtained.
 
// Greedy approach: Select the job having the highest profit first and schedule it in the
// latest available time slot before its deadline.
 
// Example:
//   +-----+----------+--------+
//   | Job | Deadline | Profit |
//   +-----+----------+--------+
//   | J1  | 2        | 100    |
//   | J2  | 1        | 50     |
//   | J3  | 2        | 10     |
//   | J4  | 1        | 20     |
//   | J5  | 3        | 30     |
//   +-----+----------+--------+
 
// Sort jobs by decreasing profit: J1 -> J2 -> J5 -> J4 -> J3
 
// One optimal schedule:
//   * Slot 1: J2
//   * Slot 2: J1
//   * Slot 3: J5
 
// Total profit = 50 + 100 + 30 = 180.
 
// Algorithm:
//   1. Start.
//   2. Read the number of jobs.
//   3. Enter job ID, deadline and profit.
//   4. Sort all jobs in descending order of profit.
//   5. Find the maximum deadline.
//   6. Create empty time slots.
//   7. For each job, check for an available slot from its deadline backwards.
//   8. If an empty slot is found, schedule the job.
//   9. Calculate total profit.
//   10. Display the scheduled jobs and maximum profit.
//   11. Stop.
 
// Important points:
//   * Technique: Greedy Algorithm.
//   * Objective: Maximize profit.
//   * Jobs are sorted by decreasing profit.
//   * Each job takes one unit of time.
//   * A job must be completed before or on its deadline.
//   * Time complexity with simple slot searching: O(n log n + nD), where D is the maximum
//       deadline.
//   * Space complexity: O(D), excluding input storage.
 
// Conclusion: Thus, we implemented Job Sequencing using the Greedy method and obtained an
// optimal job schedule that maximizes the total profit under the given deadlines.
