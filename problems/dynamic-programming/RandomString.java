import java.util.Random;

// generate pesudorandom strings
class RandomString {
    public static final int GENOME = 1;
    public static final int LOWER = 2;
    public static final int UPPER = 3;

    private static char[] getAlphabets(int c) {
        String s = "";
        switch(c) {
            case GENOME:
                s = "ACTG";
                break;
            case UPPER:
                s = "ABCDEFGHIJKLMNOPQRSUVWXYZ";
                break;
            case LOWER:
                s = "abcdefghijklmnopqrstuvwxyz";
                break;
            default:
                s = "Aa1";
                break;
        }

        return s.toCharArray();
    }

    public static String nextString(int length, char[] alphabets) {
        int upper = alphabets.length;
        Random random = new Random();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; ++i) {
            int index = random.nextInt(upper);
            sb.append(alphabets[index]);
        }

        return sb.toString();
    }

    public static String nextString(int length, int choice) {
        char[] array = getAlphabets(choice);
        return nextString(length, array);
    }

    public static void main(String[] args) {
        int length = 10;
        System.out.println(RandomString.nextString(length, RandomString.GENOME));
        System.out.println(RandomString.nextString(length, RandomString.UPPER));
        System.out.println(RandomString.nextString(length, RandomString.LOWER));
    }
}
