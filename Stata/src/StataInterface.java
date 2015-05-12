import java.util.ArrayList;
import java.util.Arrays;

import com.stata.sfi.Data;
import com.stata.sfi.SFIToolkit;


public class StataInterface {

	static Question q;
	
	
	public static int createQuestionTest(String[] args) {
		q = new Question(args[0], args[1], args[2]);
		return 0;
	}
	
	public static int createFlagTest(String[] args)  {
    	
    	int status = q.createFlag();
    	return status;
	}
	
	public static int setFlagTest(String[] args)  {
		int obs = Integer.parseInt(args[0]);
		int flag = Integer.parseInt(args[1]);
    	int status = q.setFlag(obs, flag);
    	return status;
	}
	
	public static int setFlagToMissingTest(String[] args)  {
		int obs = Integer.parseInt(args[0]);
    	int status = q.setFlagToMissing(obs);
    	return status;
	}
	
	public static int getResponseTest(String[] args)  {
		int obs = Integer.parseInt(args[0]);
		double expectedResponse = Double.parseDouble(args[1]);
    	double response = q.getResponse(obs);
    	if (Math.abs(expectedResponse-response) > 0.0000001) {
    		SFIToolkit.error("Failed getResponseTest");
    		return 198;
    	} 
    	return 0;
	}
	
	public static int getMissingResponseTest(String[] args)  {
		int obs = Integer.parseInt(args[0]);
		double expectedResponse = Data.getMissingValue();
    	double response = q.getResponse(obs);
    	if (Math.abs(expectedResponse-response) > 0.0000001) {
    		SFIToolkit.error("Failed getMissingResponseTest");
    		return 198;
    	} 
    	return 0;
	}
	

	
	
	public ArrayList<String[]> parseFile(String file) {
		ArrayList<String[]> lines = new ArrayList<String[]>();
		In in = new In(file);
		// remove headers and determine number of columns+		
		int cols = in.readLine().split(",").length;
		
		String line;
		while (in.hasNextLine()) {
			line = in.readLine(); 
			String[] a = new String[cols];
			for (int i = 0; i < cols; i++) {
			a[i] = line.split(",")[i].trim();
			}
			lines.add(a);
		}
		return lines;
	}

}
