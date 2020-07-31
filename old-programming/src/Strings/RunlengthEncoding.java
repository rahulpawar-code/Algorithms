package Strings;

public class RunlengthEncoding {
	public static String encodeString(String string) {
		if (string == null || string.length() <= 1) {
			return string;
		}
		
		StringBuilder sb = new StringBuilder();
		int n = string.length();
		for (int i = 0; i < n; ++i) {
			int count = 1;
			while (i < n - 1 && string.charAt(i) == string.charAt(i + 1)) {
				count++;
				i++;
			}
			sb.append(string.charAt(i));
			sb.append(count);
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		String string;
		String encoded;
		
		string = "abcde";
		encoded = encodeString(string);
		System.out.println(encoded);
		
		string = "s";
		encoded = encodeString(string);
		System.out.println(encoded);
	}

}
