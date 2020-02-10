package Temp;

public class FlipBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String binaryString="0001010111";
		//String binaryString="001";

		System.out.println(Math.min(countFlips(binaryString,'0'),countFlips(binaryString,'1')));
		
	}

	private static int countFlips(String binaryString, char startChar) {
		String alteredString="";
		int countFlips=0;
		for (int countChar=0; countChar<binaryString.length(); countChar++) {
			//System.out.println("binary sting is : "+binaryString);
			char subString=binaryString.charAt(countChar) ;//substring(countChar, countChar+1);
			//System.out.println("substring is : " + subString);
			if (subString ==(startChar)) {
				alteredString=alteredString+subString;
				
			}else{
				
				countFlips=countFlips+1;
//				alteredString=alteredString+changeChar(subString);
				System.out.println("Flip[ position is "+ countChar);
			}
			
			startChar=changeChar(startChar);
			
		}
		System.out.println(alteredString);
		return countFlips;
		
	}
	private static char changeChar(char character) {
		
		//System.out.println("substring to change is : "+ character);
		if (character == '0'){
				return '1';
		}else {
			return '0';
		}
			
		
	}
	
}
