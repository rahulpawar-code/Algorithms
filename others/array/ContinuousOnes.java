/*
 * https://www.techiedelight.com/find-index-0-replaced-get-maximum-length-sequence-of-continuous-ones/
 */

class ContinuousOnes {
    public static int findIndexOfZero(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException();
        }

        int maxCount = 0;
        int maxIndex = -1;

        int currentCount = 0;
        int previousIndex = -1;

        for (int i = 0; i < array.length; ++i) {
            if (array[i] == 1) {
                currentCount++;
            } else {
                currentCount = i - previousIndex;
                previousIndex = i;
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                maxIndex = previousIndex;
            }
        }

        return maxIndex;
    }

    public static void main(String[] args) {
        int[] array = {0, 0, 1, 0, 1, 1, 1, 0, 1, 1};
        int index = ContinuousOnes.findIndexOfZero(array);
        System.out.println("Index to be replaces : " + index);
    }
}
