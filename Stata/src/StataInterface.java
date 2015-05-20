import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.stata.sfi.Data;
import com.stata.sfi.SFIToolkit;

public class StataInterface {

	public static int fillFlags(String[] args) {
		String initial;
		StataInterface si = new StataInterface(); 
		HashMap<String, Question> questions = new HashMap<String, Question>();
		try {
			questions = si.initializeQuestions(args[0], args[1]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			SFIToolkit.error(e.getMessage());
		}
		// initialize Flags
		
		for (String qId:questions.keySet()) {
			Question q = questions.get(qId);
			q.createFlag();
		}
		
		// Fill in Flags
		int N = Data.getObsCount(); 
		for (int i = 1; i <= N; i++) {
		     initial = "01";
		     Question q = questions.get(initial);
		     
		     q.setFlagToMissing(i);
		     while (!q.next(i).equals("-1")) {
		   	   q = questions.get(q.next(i));
		   	   q.setFlagToMissing(i); 
		   }
		}
		return 0;
	}

	public HashMap<String, Question> initializeQuestions(String questionsFile, String skipsFile) throws IOException {
		ArrayList<String[]> questionArray = new ArrayList<>() ;
		ArrayList<String[]> skipsArray = new ArrayList<>();
		questionArray = parseFile(questionsFile);
		skipsArray = parseFile(skipsFile);
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
					if (Math.abs(1+val) < 0.00001) question.setDefaultSkip(siguiente);
					else                           question.setSkip(val, siguiente);
				}
			}
			questions.put(question.getId(), question);
		}
		return questions;
	}
	
	
	public ArrayList<String[]> parseFile(String file) throws IOException {
		ArrayList<String[]> lines = new ArrayList<String[]>();
		In in = new In(file);
		// remove headers and determine number of columns+		
		int cols = in.readLine().split(",").length;
		
		String[] line;
		while (in.hasNextLine()) {
			line = in.readLine().split(",");
			validateLine(cols, line);
			String[] a = new String[cols];
			for (int i = 0; i < cols; i++) {
			a[i] = line[i].trim();
			}
			lines.add(a);
		}
		return lines;
	}

	private void validateLine(int cols, String[] line) throws IOException {
		if (line.length < cols) throw new IOException("La linea " + Arrays.toString(line) + 
														" tiene columnas de menos.\n");
		else if (line.length > cols) throw new IOException("La linea " + Arrays.toString(line) + 
				" tiene columnas de más.\n");
	}

}
