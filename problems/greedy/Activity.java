/*
 * A simple class which represents an activity or a task which has start time
 * and an end time. The time is represented as integers which can be
 * easily replaced with actual inbuilt data and time types
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random; // only test in main

// Immutable class for Activity or task
public class Activity {
    private final int start;
    private final int end;

    public static final Comparator<Activity> BY_START_TIME = new StartOrder();
    public static final Comparator<Activity> BY_END_TIME = new EndOrder();

    public Activity(int s, int e) {
        start = s;
        end = e;
    }

    // Compare activity according to start time
    private static class StartOrder implements Comparator<Activity> {
        public int compare(Activity a, Activity b) {
            if (a.start < b.start) {
                return -1;
            } else if (a.start > b.start) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    // Compare activity according to end time
    private static class EndOrder implements Comparator<Activity> {
        public int compare(Activity a, Activity b) {
            if (a.end < b.end) {
                return -1;
            } else if (a.end > b.end) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    // Is this activity overlapping with other
    // if start of one has same time as end of another,
    // then acitivites are considered as overlapping
    public boolean overlappingInclusive(Activity other) {
        if (other == null) {
            throw new IllegalArgumentException();
        }

        return (this.start <= other.end) && (other.start <= this.end);
    }

    // Is this activity overlapping with other
    // if start of one has same time as end of another,
    // then acitivites are considered as non overlapping
    public boolean overlappingExclusive(Activity other) {
        if (other == null) {
            throw new IllegalArgumentException();
        }

        return (this.start < other.end) && (other.start < this.end);
    }

    // Returns an integer hash code for this object
    @Override
    public int hashCode() {
        int hashStart = ((Integer)start).hashCode();
        int hashEnd = ((Integer)end).hashCode();
        return 31 * hashStart + hashEnd;
    }

    // Compare this acitivty to the other activity
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null || other.getClass() != this.getClass()) {
            return false;
        }
        Activity that = (Activity) other;
        return (this.start == that.start) && (this.end == that.end);
    }

    // Return string representation of this object
    @Override
    public String toString() {
        return new String("(" + start + "," + end + ")");
    }

    public static void main(String[] args) {
        // Generate n random start and end time within range
        int n = 10;
        int minStart = 10;
        int maxEnd = 200;
        Random rand = new Random();
        Activity[] activities = new Activity[n];

        for (int i = 0; i < n; ++i) {
            int start = minStart + rand.nextInt(maxEnd + 1);
            int end = minStart + rand.nextInt(maxEnd + 1);
            activities[i] = new Activity(start, end);
        }

        System.out.println("Activities: ");
        for (int i = 0; i < activities.length; ++i) {
            System.out.print(activities[i] + " ");
        }
        System.out.println("");

        System.out.println("Activities sorted by start time: ");
        Arrays.sort(activities, Activity.BY_START_TIME);
        for (int i = 0; i < activities.length; ++i) {
            System.out.print(activities[i] + " ");
        }
        System.out.println("");

        System.out.println("Activities sorted by end time: ");
        Arrays.sort(activities, Activity.BY_END_TIME);
        for (int i = 0; i < activities.length; ++i) {
            System.out.print(activities[i] + " ");
        }
        System.out.println("");
    }
}


