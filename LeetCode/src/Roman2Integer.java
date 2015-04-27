import java.util.HashMap;

// Jan 18, 2015

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 */

public class Roman2Integer {
	public int romanToInt(String s) {
		
		// Time Complexity: O(N) --> 
		// Space Complexity: O(1) --> Size of Hash Map is fixed
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int val = 0;
		for(int i=0; i<s.length() - 1; i++){
			if(map.get(s.charAt(i)) < map.get(s.charAt(i + 1))){
				val -= map.get(s.charAt(i));
			}else{
				val += map.get(s.charAt(i));
			}
		}
		return val + map.get(s.charAt(s.length() - 1));
	}
	
	public static void main(String[] args){
		String input = "MMMCMLXXXIX";
		Roman2Integer test = new Roman2Integer();
		System.out.println(test.romanToInt(input));
	}
}
