import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;


public class StataInterfaceTest2 {

	
	@Test
	public void parseQuestionsFileReturnsFiftyTwoLines() throws IOException {
		StataInterface si = new StataInterface();
		String file = "c:\\stata\\testCSV\\preguntas.csv";
		ArrayList<String[]> questions = si.parseFile(file);
		assertEquals(52, questions.size());
	}
	
	@Test
	public void parseQuestionsFileForModA3ReturnsFortyOneLines() throws IOException {
		StataInterface si = new StataInterface();
		String file = "c:\\stata\\A3\\preguntasA3.csv";
		ArrayList<String[]> questions = si.parseFile(file);
		assertEquals(41, questions.size());
	}
	
	@Test
	public void parseQuestionsFileForModBReturnsFortyOneLines() throws IOException {
		StataInterface si = new StataInterface();
		String file = "c:\\stata\\B\\preguntasB.csv";
		ArrayList<String[]> questions = si.parseFile(file);
		assertEquals(84, questions.size());
		System.out.println(questions.get(1));
	}
	
	@Test
	public void parseQuestionsFileForModJReturnsLines() throws IOException {
		StataInterface si = new StataInterface();
		String file = "c:\\stata\\J\\preguntasJ.csv";
		ArrayList<String[]> questions = si.parseFile(file);
		assertEquals(345, questions.size());
		System.out.println(questions.get(1));
	}
	
	@Test(expected=IOException.class)
	public void parseQuestionsFileThrowsExceptionWithShortLine() throws IOException {
		StataInterface si = new StataInterface();
		String file = "c:\\stata\\testCSV\\preguntasError.csv";
		ArrayList<String[]> questions = si.parseFile(file);
	}
	
	@Test(expected=IOException.class)
	public void parseQuestionsFileThrowsExceptionWithLongLine() throws IOException {
		StataInterface si = new StataInterface();
		String file = "c:\\stata\\testCSV\\preguntasError2.csv";
		ArrayList<String[]> questions = si.parseFile(file);
	}
	

	
		
	@Test
	public void parseQuestionsFirstLineIsFirstLineOfFile() throws IOException {
		StataInterface si = new StataInterface();
		String file = "c:\\stata\\testCSV\\preguntas.csv";
		ArrayList<String[]> questions = si.parseFile(file);
		String firstId = "01";
		String firstVar = "a11";
		assertEquals(firstId, questions.get(0)[0]);
		assertEquals(firstVar, questions.get(0)[1]);
	}
	
	
	@Test
	public void parseQuestionsLastLineIsFirstLineOfFile() throws IOException {
		StataInterface si = new StataInterface();
		String file = "c:\\stata\\testCSV\\preguntas.csv";
		ArrayList<String[]> questions = si.parseFile(file);
		String firstId = "58";
		String firstVar = "a158";
		assertEquals(firstId, questions.get(51)[0]);
		assertEquals(firstVar, questions.get(51)[1]);
	}
	
	
	
	@Test
	public void parseSaltosReturnsSeventyTwoLines() throws IOException {
		StataInterface si = new StataInterface();
		String file = "c:\\stata\\testCSV\\saltos.csv";
		ArrayList<String[]> saltos = si.parseFile(file);
		assertEquals(75, saltos.size());
	}
	
	@Test
	public void parseSaltosModA3ReturnsFortySixLines() throws IOException {
		StataInterface si = new StataInterface();
		String file = "c:\\stata\\A3\\saltosA3.csv";
		ArrayList<String[]> saltos = si.parseFile(file);
		assertEquals(46, saltos.size());
	}
	
	@Test
	public void parseSaltosModBReturnsFortySixLines() throws IOException {
		StataInterface si = new StataInterface();
		String file = "c:\\stata\\B\\saltosB.csv";
		ArrayList<String[]> saltos = si.parseFile(file);
		assertEquals(117, saltos.size());
	}
	
	
	@Test
	public void parseSaltosLastLineIsFirstLineOfFile() throws IOException {
		StataInterface si = new StataInterface();
		String file = "c:\\stata\\testCSV\\saltos.csv";
		ArrayList<String[]> saltos = si.parseFile(file);
		String firstId = "01";
		String firstVar = "-7";
		assertEquals(firstId, saltos.get(0)[0]);
		assertEquals(firstVar, saltos.get(0)[1]);
	}
	
	@Test
	public void parseSaltosLastLineIsLastLineOfFile() throws IOException {
		StataInterface si = new StataInterface();
		String file = "c:\\stata\\testCSV\\saltos.csv";
		ArrayList<String[]> saltos = si.parseFile(file);
		String firstId = "58";
		String firstVar = "-7";
		assertEquals(firstId, saltos.get(74)[0]);
		assertEquals(firstVar, saltos.get(74)[1]);
	}
	
		
	@Test
	public void initializeQuestionsFromFiles() throws IOException {
		String sFile = "c:\\stata\\testCSV\\saltos.csv";
		
	}
	

	/*
	@Test
	public void nextReturnsCorrectValues() throws IOException {
		String sFile = "c:\\stata\\saltos.csv";
		String qFile = "c:\\stata\\preguntas.csv";
		StataInterface si = new StataInterface();
		HashMap<String, Question> questionData = si.initializeQuestions(qFile, sFile);
		Question q = questionData.get("01");
		assertEquals(q.getId(), "01");
		assertEquals(q.getText(), "\"Desde qué año residen en esta vivienda?\"");	
	}
	*/
	
}
