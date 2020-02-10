package Temp;

import java.util.HashMap;
import java.util.Map;

public class FlipBinaryProgram {

	static Map<Integer,String[]> flipPointers = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String binaryString="0001010111";
		//String binaryString="001";

		 String flipPositions="p";
		int case1 = getFlipingCountStartWithChar(binaryString,'0',flipPositions);
		System.out.println("aftet caling funbction :" +flipPositions);
		
		int case2 = getFlipingCountStartWithChar(binaryString,'1',flipPositions);
		
		if (case1<case2) {
			System.out.println(flipPositions);
		}else {
			System.out.println(flipPositions);
		}
		System.out.println(Math.min(case1,case1));
		
	}

	public static int getFlipingCountStartWithChar(String str, char expected, String flipPositions) {
		
		int flipCounter = 0;
		String[] pointers = new String[str.length()];
		int index =0;
		for(int i=0;i< str.length();i++) {
			if(str.charAt(i)!= expected) {
				flipCounter++;
				flipPositions=flipPositions + ", "+i;
				System.out.println("flipPositions : " + flipPositions);
				//pointers[index]= String.valueOf(i+1);
				//flipPointers.put(1, String.valueOf(i+1));
			}
			expected=changeChar(expected);
			
		}
		
		return flipCounter;
		
	}
	private static char changeChar(char character) {
		
		//System.out.println("substring to change is : "+ character);
		if (character == '0'){
				return '1';
		}else {
			return '0';
		}
			
		//minFlipToMakeStringAlternate
		
	}
	
}
