/*
 * Link : https://www.geeksforgeeks.org/job-sequencing-problem/
 */
import java.util.Arrays;
import java.util.Random;

public class JobSequencing {
    private static int getMaxDeadline(Job[] jobs) {
        int max = jobs[0].deadline;
        for (int i = 1; i < jobs.length; ++i) {
            max = Math.max(max, jobs[i].deadline);
        }
        return max;
    }

    private static void sequence(Job[] jobs) {
        if (jobs == null || jobs.length <= 1) {
            return;
        }

        int max = getMaxDeadline(jobs);
        String[] sequence = new String[max + 1];

        for (Job j : jobs) {
            for (int i = j.deadline; i >= 1; --i) {
                if (sequence[i] == null) {
                    sequence[i] = j.ID;
                    break;
                }
            }
        }

        for (int i = 1; i <= max; ++i) {
            if (sequence[i] != null) {
                System.out.println(sequence[i]);
            }
        }
    }

    // Generate test data
    private static Job[] generateRandomJobs(int n, int minProfit, int maxProfit,
            int minDeadline, int maxDeadline) {
        Job[] jobs = new Job[n];
        Random rand = new Random();
        for (int i = 0; i < n; ++i) {
            String id = "JobID" + Integer.toString(i + 1);
            int profit = minProfit + rand.nextInt(maxProfit);
            int deadline = minDeadline + rand.nextInt(maxDeadline);
            jobs[i] = new Job(id, deadline, profit);
        }
        return jobs;
    }

    public static void main(String[] args) {
        int n = 20;
        int maxProfit = 100;
        int minProfit = 5;
        int minDeadline = 1;
        int maxDeadline = 5;

        Job[] jobs = generateRandomJobs(n, minProfit, maxProfit, minDeadline, maxDeadline);

        // Sort by descending profits. Greedy step
        Arrays.sort(jobs, Job.BY_DESCENDING_PROFIT);

        JobSequencing.sequence(jobs);
    }
}
