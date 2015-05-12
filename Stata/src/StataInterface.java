import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

import org.junit.Test;

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
    	assertEquals(expectedResponse, response, 0.0000001);
    	return 0;	
	}
	
	public static int getMissingResponseTest(String[] args)  {
		int obs = Integer.parseInt(args[0]);
		double expectedResponse = Data.getMissingValue();
    	double response = q.getResponse(obs);
    	assertEquals(expectedResponse, response, 0.0000001);
    	return 0;
	}
	
	@SuppressWarnings("deprecation")
	public static int nextTest(String[] args) {
		String sFile = "c:\\stata\\saltos.csv";
		String qFile = "c:\\stata\\preguntas.csv";
		StataInterface si = new StataInterface();
		HashMap<String, Question> questionData = si.initializeQuestions(qFile, sFile);
		String id = args[0];
		int obs = Integer.parseInt(args[1]);
		String expected = args[2];
		Question q = questionData.get(id);
		assertEquals(q.next(obs), expected);
		return 0;
	}
	
	public HashMap<String, Question> initializeQuestions(String questionsFile, String skipsFile) {
		ArrayList<String[]> questionArray = parseFile(questionsFile);
		ArrayList<String[]> skipsArray = parseFile(skipsFile);
		HashMap<String, Question> questions = new HashMap<>();
		String idQ, var, txt, idS, siguiente;
		double val;
		
		
		// loop through questions
		for (String[] q:questionArray) {
			idQ = q[0];
			var = q[1];  // ojo con el orden !!! armonizar!!
			txt = q[2];
			Question question = new Question(idQ, var, txt);
			// loop through skips
			for (String[] s:skipsArray) {
				idS = s[0];
				if (idS.equals(idQ)) {
					// do the casting her
					val = Double.parseDouble(s[1]);
					siguiente = s[2];
					if (Math.abs(val+1) < 0.00001) question.setDefaultSkip(siguiente);
					else                           question.setSkip(val, siguiente);
				}
			}
			questions.put(question.getId(), question);
		}
		return questions;
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
