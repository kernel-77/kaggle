#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

struct Job {
    string id;
    int deadline;
    int profit;
};

bool compare(Job a, Job b) {
    return a.profit > b.profit;
}

int main() {
    Job jobs[] = {
        {"J1", 2, 100},
        {"J2", 1, 19},
        {"J3", 2, 27},
        {"J4", 1, 25},
        {"J5", 3, 15}
    };

    int n = 5;

    sort(jobs, jobs + n, compare);

    vector<string> slots(n + 1, "");

    int totalProfit = 0;

    for (int i = 0; i < n; i++) {
        for (int j = jobs[i].deadline; j >= 1; j--) {
            if (slots[j] == "") {
                slots[j] = jobs[i].id;
                totalProfit += jobs[i].profit;
                break;
            }
        }
    }

    cout << "Scheduled Jobs: ";

    for (int i = 1; i <= n; i++) {
        if (slots[i] != "") {
            cout << slots[i] << " ";
        }
    }

    cout << "\nMaximum Profit: " << totalProfit;

    return 0;
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