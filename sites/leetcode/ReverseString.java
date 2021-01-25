// // https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/

class ReverseString {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        System.out.println(s);
        ReverseString rs = new ReverseString();
        rs.reverseString(s);
        System.out.println(s);
    }
}
