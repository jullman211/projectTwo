
public class MesoInherit extends MesoAbstract{

	private int ascStringAverage[] = new int[3];
	
	private char ascLetterAverage[] = new char [3];
	
	private MesoStation station;
	
	char characterAverage;
	
	public MesoInherit(MesoStation station) {
		this.station = station;
		// TODO Auto-generated constructor stub
		characterAverage = letterAverage();
		
	}

	// finds all three ascii averages and returns those in in array
	public int[] calAverage() {
		
		double ascii = 0;
		
		double averageValue = 0;
		
		for(int i = 0; i < 4; i++) {
			ascii += station.getStID().charAt(i);
			}
		
		averageValue = ascii / 4;
	
		ascStringAverage[0] = (int) Math.ceil(averageValue);
		
		ascStringAverage[1] = (int) Math.floor(averageValue);
		
		ascStringAverage[2] = (int) Math.round(averageValue);
	
		return ascStringAverage;
	}
	
	// takes the normal rounded average and converts that to char
	public char letterAverage() {
		
		
		//char characterAverage;
		
		characterAverage = (char) ascStringAverage[2];
//		ascLetterAverage[0] = (char) ascStringAverage[0];
//		ascLetterAverage[1] = (char) ascStringAverage[1];
//		ascLetterAverage[2] = (char) ascStringAverage[2];
		
		
		return characterAverage;
	}
}
