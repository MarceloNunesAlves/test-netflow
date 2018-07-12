package br.com.flexvision.processor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

	private static final String[] REPLACES = {"a", "A", "e", "E", "i", "I", "o", "O", "u", "U", "c", "C"};
	private static Pattern[] PATTERNS = new Pattern[12];
	
	static {
		
		PATTERNS[0] = Pattern.compile("[�����]");
		PATTERNS[1] = Pattern.compile("[�����]");
		PATTERNS[2] = Pattern.compile("[����]");
		PATTERNS[3] = Pattern.compile("[����]");
		PATTERNS[4] = Pattern.compile("[����]");
		PATTERNS[5] = Pattern.compile("[����]");
		PATTERNS[6] = Pattern.compile("[�����]");
		PATTERNS[7] = Pattern.compile("[�����]");
		PATTERNS[8] = Pattern.compile("[����]");
		PATTERNS[9] = Pattern.compile("[����]");
		PATTERNS[10] = Pattern.compile("[�]");
		PATTERNS[11] = Pattern.compile("[�]");
		
	}

	public static String replaceSpecial(String text) {
		
		String result = text;
		
		for (int i = 0; i < PATTERNS.length; i++) {
			Matcher matcher = PATTERNS[i].matcher(result);
			result = matcher.replaceAll(REPLACES[i]);
		}
		
		return result;
	}
	
    public static String lpad(String valueToPad, String filler, int size) {  
        while (valueToPad.length() < size) {  
            valueToPad = filler + valueToPad;  
        }  
        return valueToPad;  
    }  
      
    public static String rpad(String valueToPad, String filler, int size) {  
        while (valueToPad.length() < size) {  
            valueToPad = valueToPad+filler;  
        }  
        return valueToPad;  
    }
    
    public static String ultDig(int nod_id) {
    	String ult_dig = String.valueOf(nod_id);
		ult_dig = ult_dig.substring(ult_dig.length()-1, ult_dig.length());
		return ult_dig;
    }
}
