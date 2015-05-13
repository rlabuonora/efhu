import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import com.stata.sfi.Data;


public class StataInterfaceTest {

	private static Question q;
	private static HashMap<String, Question> questionData;

	
	public static int initializeQuestion(String[] args) {
		q = new Question(args[0], args[1], args[2]);
		return 0;
	}
	
	public static int initializeInterface(String[] args ) {
		String qFile = args[0]; //"c:\\stata\\preguntas.csv";
		String sFile = args[1]; //"c:\\stata\\saltos.csv";
		StataInterface si = new StataInterface();
		questionData = si.initializeQuestions(qFile, sFile);
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
		String id = args[0];
		int obs = Integer.parseInt(args[1]);
		String expected = args[2];
		Question q = questionData.get(id);
		assertEquals(q.next(obs), expected);
		return 0;
	}

	public static int fillFlagsTest(String[] args)  {
		StataInterface.fillFlags(args);
		
    	return 0;
	}
	

}
