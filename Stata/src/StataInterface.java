import java.util.ArrayList;
import java.util.HashMap;

public class StataInterface {

	
	
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
