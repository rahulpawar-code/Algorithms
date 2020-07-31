package Strings;

public class RotationBy2 {
	private static boolean isRotatedBy2(String str1, String str2) {
		if (str1 == null || str1.length() <= 0) {
			throw new IllegalArgumentException("Illeagl argument");
		}
		
		boolean isLeftRotated = true;
		boolean isRightRotated = true;
		int n = str1.length();
		int k = 0;
		int i = 0;
		int j = (i + 2) % n;
		
		while (k < n) {
			if (str1.charAt(i) != str2.charAt(j)) {
				isRightRotated = false;
			}
			i++;
			j = (j + 1) % n;
			k++;			
		}
		
		i = 0;
		j = (n - 2) % n;
		k = 0;
		while (k < n) {
			if (str1.charAt(i) != str2.charAt(j)) {
				isLeftRotated= false;
			}
			i++;
			j = (j + 1) % n;
			k++;
		}		
		
		return isLeftRotated || isRightRotated;
	}

	public static void main(String[] args) {
		String str1 = "amazon";
		String str2 = "azonam";
		boolean isRotated = false;
		isRotated =  isRotatedBy2(str1, str2);
		System.out.println(isRotated);
		
		str1 = "amazon";
		str2 = "onamaz";
		isRotated =  isRotatedBy2(str1, str2);
		System.out.println(isRotated);
		
	}

}
