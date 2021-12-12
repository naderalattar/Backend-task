package commonSubString;

public class CommonSubString {

	public static void main(String[] args) {
		
		
		String s1="Hello";
		
		String s2="Word";
		
		
		System.out.println(two_string(s1, s2));
		
		
		

	}
	
	public static String two_string(String s1,String s2) {
		
		String message="NO";
		
		char [] s1Array=s1.toLowerCase().toCharArray();
		char [] s2Array=s2.toLowerCase().toCharArray();
		
		for(char c1: s1Array) {
			for(char c2: s2Array) {
				if (c1==c2)
					return "YES";
			}
			
		}
		
		
		
		return message;
	}

}
