import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;


public class StataInterfaceTest {

	@Test
	public void parseQuestionsFileReturnsFiftyTwoLines() {
		StataInterface si = new StataInterface();
		String file = "c:\\stata\\preguntas.csv";
		ArrayList<String[]> questions = si.parseFile(file);
		assertEquals(52, questions.size());
	}
		
	@Test
	public void parseQuestionsFirstLineIsFirstLineOfFile() {
		StataInterface si = new StataInterface();
		String file = "c:\\stata\\preguntas.csv";
		ArrayList<String[]> questions = si.parseFile(file);
		String firstId = "01";
		String firstVar = "a11";
		assertEquals(firstId, questions.get(0)[0]);
		assertEquals(firstVar, questions.get(0)[1]);
	}
	
	
	@Test
	public void parseQuestionsLastLineIsFirstLineOfFile() {
		StataInterface si = new StataInterface();
		String file = "c:\\stata\\preguntas.csv";
		ArrayList<String[]> questions = si.parseFile(file);
		String firstId = "58";
		String firstVar = "a158";
		assertEquals(firstId, questions.get(51)[0]);
		assertEquals(firstVar, questions.get(51)[1]);
	}
	
	@Test
	public void parseSaltosReturnsSeventyTwoLines() {
		StataInterface si = new StataInterface();
		String file = "c:\\stata\\saltos.csv";
		ArrayList<String[]> saltos = si.parseFile(file);
		assertEquals(75, saltos.size());
	}
	
	
	@Test
	public void parseSaltosLastLineIsFirstLineOfFile() {
		StataInterface si = new StataInterface();
		String file = "c:\\stata\\saltos.csv";
		ArrayList<String[]> saltos = si.parseFile(file);
		String firstId = "01";
		String firstVar = "-1";
		assertEquals(firstId, saltos.get(0)[0]);
		assertEquals(firstVar, saltos.get(0)[1]);
	}
	
	@Test
	public void parseSaltosLastLineIsLastLineOfFile() {
		StataInterface si = new StataInterface();
		String file = "c:\\stata\\saltos.csv";
		ArrayList<String[]> saltos = si.parseFile(file);
		String firstId = "58";
		String firstVar = "-1";
		assertEquals(firstId, saltos.get(74)[0]);
		assertEquals(firstVar, saltos.get(74)[1]);
	}
	

	
	

}
