/** Palindrome Detector
 ** Shahzore Qureshi
 ** October 8th, 2016
 **/
public class Palindrome {
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Please add one String as an argument.");
			return;
		}

		//Assuming that input string is case-insensitive.
		String inputString = args[0].toLowerCase();

		/**
			To determine if the input string is capable of being
			a palindrome, let's determine if it meets the following
			requirements for being a palindrome:

			1) If the string has an even length, all of the letters
			of the string need to appear at least twice (or rather,
			the count of each letter must be an even number (like
			2, 4, 6, 8, etc)

			2) If the string has an odd length, all of the letters
			of the string, except for the middle one, need to have
			a letter count that is an even number
		**/

		//Assume that alphabet is ASCII-based.
		//ASCII has 128 codes that represent
		//alphabet letters.
		//ex. 85 --> U, 89 --> Y, 105 --> i
		//
		//In the array below, we will keep
		//count of each letter code. The
		//letter U, for example, will be
		//at index 85, and the count of
		//U can be an integer (like 4).
		int[] alphabetCounter = new int[128];
		int inputStringLengthWithoutSpaces = 0;	
		for(int i = 0; i < inputString.length(); i++) {
			int charCode = inputString.charAt(i);
			//Ignore spaces.
			if(charCode != 32) {
				alphabetCounter[charCode]++;
				inputStringLengthWithoutSpaces++;
			}
		}

		//Determines if input string has an
		//even character length.
		boolean isEven = false;
		if(inputStringLengthWithoutSpaces % 2 == 0) {
			isEven = true;
		}

		//Determine if there is one character
		//in the input string with an odd
		//character count.
		boolean hasOneOddChar = false;
		
		//Check the occurrence of each letter.
		for(int j = 0; j < alphabetCounter.length; j++) {
			int count = alphabetCounter[j];
			
			//If the input string has an even length,
			//all letters must have an even letter count.
			if(isEven) {
				if(count % 2 != 0) {
					System.out.println("String cannot be formed into a palindrome.");
					return;
				}
			}
			//If the input string has an odd length,
			//all letters except one must have an even
			//letter count.
			else {
				if(count % 2 != 0) {
					if(hasOneOddChar) {
						System.out.println("String cannot be formed into a palindrome.");
						return;
					}
					hasOneOddChar = true;
				}
			}
		}

		System.out.println("String is a permutation of a palindrome.");
	}
}
