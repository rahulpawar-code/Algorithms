import java.util.Comparator;
import java.util.Arrays;
import java.util.Random;

public class Job {
    final int deadline;
    final int profit;
    final String ID;

    public static final Comparator<Job> BY_ASCENDING_PROFIT = new ascendingProfit();
    public static final Comparator<Job> BY_DESCENDING_PROFIT = new descendingProfit();

    private static class ascendingProfit implements Comparator<Job> {
        public int compare(Job j1, Job j2) {
            if (j1.profit < j2.profit) {
                return -1;
            } else if (j1.profit > j2.profit) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    private static class descendingProfit implements Comparator<Job> {
        public int compare(Job j1, Job j2) {
            if (j1.profit < j2.profit) {
                return 1;
            } else if (j1.profit > j2.profit) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public Job(String id, int deadline, int profit) {
        ID = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "(" + ID + "," + deadline + "," + profit + ")";
    }

    public static void main(String[] args) {
        int n = 10;
        int maxDeadline = 10;
        int minDeadline = 1;
        int maxProfit = 100;
        int minProfit = 5;
        Random rand = new Random();

        Job[] jobs = new Job[n];
        for (int i = 0; i < n; ++i) {
            int deadline = minDeadline + rand.nextInt(maxDeadline + 1);
            int profit = minProfit + rand.nextInt(maxProfit + 1);
            jobs[i] = new Job("JobID" + Integer.toString(i), deadline, profit);
        }

        System.out.println("Before sort:");
        for (int i = 0; i < n; ++i) {
            System.out.print(jobs[i] + " ");
        }
        System.out.println("");

        Arrays.sort(jobs, Job.BY_ASCENDING_PROFIT);
        System.out.println("After sort by ascending profit:");
        for (int i = 0; i < n; ++i) {
            System.out.print(jobs[i] + " ");
        }
        System.out.println("");

        Arrays.sort(jobs, Job.BY_DESCENDING_PROFIT);
        System.out.println("After sort by descending profit:");
        for (int i = 0; i < n; ++i) {
            System.out.print(jobs[i] + " ");
        }
        System.out.println("");
    }
}
