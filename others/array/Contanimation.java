/*
 * https://www.careercup.com/question?id=5078647835197440
 */

class Contanimation {
    public static void findInfected(int[] person, int d) {
        if (person == null || d < 0) {
            throw new IllegalArgumentException();
        }

        int maxInfected = Integer.MIN_VALUE;
        int minInfected = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;
        int n = person.length;

        for (int i = 0; i < n; ++i) {
            while (right < n && (person[right] - person[i] < d)) {
                right++;
            }
            if (right >= n || (person[right] - person[i] > d)) {
                right--;
            }

            while (left < i && (person[i] - person[left] > d)) {
                left++;
            }
            if (left > i) {
                left--;
            }

            // Exclude the spreader person
            int currentInfections = (right - left - 1) + 1;

            if (maxInfected < currentInfections || minInfected > currentInfections) {
                System.out.println(left + " : " + right + ", infected = " + (currentInfections) + ", spreader : " + i);
            }

            maxInfected = Math.max(maxInfected, currentInfections);
            minInfected = Math.min(minInfected, currentInfections);
        }

        if (maxInfected == Integer.MIN_VALUE) {
            maxInfected = 0;
        }
        if (minInfected == Integer.MAX_VALUE) {
            minInfected = 0;
        }

        System.out.println("Max infected person : " + maxInfected);
        System.out.println("Min infected person : " + minInfected);
    }
}

class Test {
    public static void main(String[] args) {
        int d = 5;
        int[] person = {1, 3, 5, 9, 14, 15, 16, 17, 18, 19, 20};
        Contanimation.findInfected(person, d);
    }
}
