package DynamicProgramming;

import java.util.*;

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int cases = sc.nextInt();
	    while (cases > 0) {
	        int m = sc.nextInt();
	        int n = sc.nextInt();
	        
	        int pos = 1; 
	        // counting the position of first set bit 
	        for (int i = 0; i < 32; i++) { 
	            if (((m >> pos) & 1) != ((n >> pos) & 1)) 
	            	pos++;
	            else 
            		break;  
	        } 
            System.out.println(pos);
	        
	        cases--;
	    }
	    sc.close();
	}

}
