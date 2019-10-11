import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PosAvg {
	
	private static final int START_LINE = 4;
	
	private int countIndex;
	
	protected int mainStringIndex;
	
	protected int indexPlusTwo;
	
	protected int indexPlusOne;
	
	protected int indexMinusTwo;
	
	protected int indexMinusOne;
	
	private String[] averageWords = new String[4];
	
	private String input;
	
	private int center;
	
	
	//constructor
	public PosAvg(String inputString) throws IOException {
		input = inputString;
		String[] newArray = new String[4];
		newArray = wordAverage();
	}
	
	// finds the start index
	public int findMatch() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		
		String foundString;
		int skipLineCounter = 0;
		int startIndex = 0;
		int baseIndex = 1;
		
		String strg;
		
		while(((strg = br.readLine()) != null) ){
			
		skipLineCounter++;

			
			
			if(skipLineCounter > START_LINE) {
				
				String[] splitCount = strg.split(" ");
				
				foundString = splitCount[1];
				
				++baseIndex;
				if(foundString.equals(input)) {
					return baseIndex;
				}
				 	
				
			}
			
		}
		br.close();
		return baseIndex;
	}
	
	
	// returns the index of the station
	public int indexOfStation() throws IOException {
		
		mainStringIndex = findMatch();
		return mainStringIndex;
	}
	
	// does the math to find the index of the station
//	public int compareStrings(String runThroughString, String inputFindString) {
//		int baseIndex = 0;
//		
//			if(runThroughString.equals(inputFindString)) {
//				return baseIndex;
//			}
//			else {
//				++baseIndex;
//			}
//			 	
//		
//		return baseIndex;
//	}
	
	
	// stores the four different averages from the cetner average and stores in string array
	public String[] wordAverage() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		
		String foundString;
		int skipLineCounter = 0;
		int startIndex = 0;
		int counterIndex = 1;
		center = findMatch();
		
		int centerPlusOne = center + 1;
		int centerPlusTwo = center + 2;
		int centerMinusOne = center - 1;
		int centerMinusTwo = center - 2;
		
		String strg;
		
		while((strg = br.readLine()) != null) {
			
			skipLineCounter++;
			
			if(skipLineCounter > START_LINE) {
				
				String[] splitCount = strg.split(" ");
				
				foundString = splitCount[1];
				
				++counterIndex;
				
				if(counterIndex == centerMinusTwo) {
					averageWords[0] = foundString;
				}
				else if(counterIndex == centerMinusOne) {
					averageWords[1] = foundString;
				}
				else if(counterIndex == centerPlusOne) {
					averageWords[2] = foundString;
				}
				else if(counterIndex == centerPlusTwo) {
					averageWords[3] = foundString;
				}
			}
			
		}
		br.close();
		return averageWords;
	}
	
	@Override
	public String toString() {
		return String.format("This index is average of %s and %s, %s and %s, and so on.", averageWords[1], averageWords[2], averageWords[0], averageWords[3]);
	}
	
}
