/*
 * Link : https://www.geeksforgeeks.org/job-sequencing-problem/
 */
import java.util.Arrays;
import java.util.Random;

public class JobSequencing2 {
    private static class UnionFind {
        int parent[];
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            if (p == parent[p]) {
                return p;
            }
            return parent[p] = find(parent[p]);
        }

        public boolean connected(int p, int q) {
           return find(p) == find(q);
        }

        public void union(int p, int q) {
            parent[q] = p;
        }
    }

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
        UnionFind set = new UnionFind(max + 1);

        for (Job j : jobs) {
            int availableSlot = set.find(j.deadline);
            if (availableSlot > 1) {
                set.union(availableSlot - 1, availableSlot);
                System.out.println(j);
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

        JobSequencing2.sequence(jobs);
    }
}
