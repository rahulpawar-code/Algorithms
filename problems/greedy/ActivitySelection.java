/*
 * Problem : https://en.wikipedia.org/wiki/Activity_selection_problem
 */

import java.util.Arrays;
import java.util.LinkedList;

public class ActivitySelection {
    // Greedy way to find max number of non overlapping activities
    private static LinkedList<Activity> getMaximumNumberOfActivities(Activity[] activities) {
        if (activities == null) {
            throw new IllegalArgumentException();
        }

        // Sort activities array by end time
        Arrays.sort(activities, Activity.BY_END_TIME);

        // First activity is always chosen
        int number = 1;
        Activity previous = activities[0];
        LinkedList<Activity> list = new LinkedList<>();
        list.add(activities[0]);

        for (int i = 1; i < activities.length; ++i) {
            // check if current is overlapping with previous
            if (!activities[i].overlappingExclusive(previous)) {
                number++;
                previous = activities[i];
                list.add(activities[i]);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        // Create array of Activity objects
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        int n = start.length;
        Activity[] activities = new Activity[n];
        for (int i = 0; i < n; ++i) {
            activities[i] = new Activity(start[i], end[i]);
        }

        LinkedList<Activity> max = ActivitySelection.getMaximumNumberOfActivities(activities);
        System.out.println("Chosen activities : " + max);
    }
}
