import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LetterAvg {
	
	private static final int START_LINE = 4;
	
	private char letterAverage;
	
	private ArrayList<String> similarStart = new ArrayList<String>();
	
	private ArrayList<String> newArray = new ArrayList<String>();
	
	public LetterAvg(char letterAverage) throws IOException {
		this.letterAverage = letterAverage;
		
		newArray = totalMatches();
	}
	
	// calculates number of stations that start with same char
	public int numberOfStationWithLetterAvg() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
				
		String foundString;
		String start;
		int skipCounter = 0;
		
		int totalCounter = 0;
		
		//String sameStart[] = new String[77];
		
		while((start = br.readLine()) != null) {
			
			++skipCounter;
			
			if(skipCounter > START_LINE) {
				
				
			String[] splitCount = start.split(" ");
					
			foundString = splitCount[1];
					
			if(foundString.charAt(0) == letterAverage) {
					++totalCounter;
				}
			}
			
		}
		br.close();
		return totalCounter;
	}
	
	
	// goes through and adds string with similar char and adds to similarStart arraylist and returns that
	public ArrayList<String> totalMatches() throws IOException{
		//ArrayList<String> similarStart = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		
		String foundString;
		String start;
		int readCounter = 0;
		
			while ((start = br.readLine()) != null) {
				++readCounter;
				
				if(readCounter > START_LINE) {
					String[] splitCount = start.split(" ");
					
					foundString = splitCount[1];
					
					
					if(foundString.charAt(0) == letterAverage) {
						similarStart.add(foundString);
					}
				}
			}
			br.close();
	
		return similarStart;
	}
	
	@Override
	public String toString(){
		
		String myString = ("\nThey are:");
		
		for(int i = 0; i < similarStart.size(); i++) {
			myString += "\n" + similarStart.get(i);
		}
		return myString;
	}
	
}
