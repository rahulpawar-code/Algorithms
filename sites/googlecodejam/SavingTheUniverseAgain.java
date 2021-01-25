import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

/**
 *  https://codejam.withgoogle.com/2018/challenges/00000000000000cb/dashboard
 */

public class SavingTheUniverse {
    private static int TotalImpact(String str) {
        if (str.length() <= 0 || str.equals("")) {
            return 0;
        }
        
        int currentChargeStrength = 1;
        int impact = 0;
        
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == 'C') {
                currentChargeStrength *= 2;
            } else if (str.charAt(i) == 'S'){
                impact += currentChargeStrength;
            }
        }
        return impact;
    }
    
    private static int CountCharOccurance(String str, char c) {
        if (str.length() <= 0 || str.equals("")) {
            return 0;
        }
        int count = str.length() - str.replace(String.valueOf(c), "").length();
        return count;
    }
    
    private static String MinimumHacks(String str, int shieldStrength) {
        String result = "";
        int impact = TotalImpact(str);
        
        int c_count = CountCharOccurance(str, 'C');
        int s_count = CountCharOccurance(str, 'S');
        
        if (s_count > shieldStrength) {
            result = "IMPOSSIBLE";
        } else if (c_count == str.length()) {
            result = String.valueOf(0);
        } else if (s_count == str.length()) {
            result = String.valueOf(0);
        } else if (impact <= shieldStrength) {
            result = String.valueOf(0);
        } else {
            Map<Integer, Integer> chargeHashMap = new HashMap<>();
            int countCharge = 0;
            for(int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'C') {
                    countCharge++;
                    chargeHashMap.put(countCharge, i);
                }
            }
            
            int damageDifference = impact - shieldStrength;
            int numSwaps = 0;
            
            for(int i = countCharge; i > 0; i--) {
                int swapsNeeded = (int) Math.ceil(damageDifference / Math.pow(2, i - 1));
                int possibleSwaps = (str.length() - 1) - (countCharge - i) - chargeHashMap.get(i);

                if (swapsNeeded > possibleSwaps) {
                    numSwaps += possibleSwaps;
                    damageDifference -= Math.pow(2, i - 1) * possibleSwaps;
                } else {
                    numSwaps += swapsNeeded;
                    break;
                }
            }
            result = String.valueOf(numSwaps);
        }
        
        return result;
    }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; ++i) {
            int D = in.nextInt();
            String P = in.next();
            String result = MinimumHacks(P, D);
            System.out.println("Case #" + (i + 1) + ": " + result);            
        }
    }
}