import static org.junit.Assert.*;

import org.junit.Test;


public class QuestionTest {

	@Test
	public void questionGetters() {
		Question q = new Question("01", "a11", "Desde qué año residen en esta vivienda?");
		assertEquals(q.getId(), "01");
		assertEquals(q.getText(), "a11");
		assertEquals(q.getVar(), "Desde qué año residen en esta vivienda?");
	}
	
	@Test
	public void questionsSkipsReturnsCorrectValuesWithDefaultSkip() {
		Question q = new Question("01", "a11", "Desde qué año residen en esta vivienda?");
		q.setDefaultSkip("02");
		assertEquals(q.getSkip(9.0), "02");
	}
	
	@Test
	public void questionsSkipsReturnsCorrectValuesWithOneSkip() {
		Question q = new Question("06","a16","Pagan algún alquiler por la parte de la vivienda que no pertenece al hogar?");
		q.setSkip(1.0, "07"); // we can set skips but not get them without default skip set
		q.setDefaultSkip("08");
		assertEquals(q.getSkip(9.0), "08");
		assertEquals(q.getSkip(1.0), "07");
	}
	
	@Test(expected=RuntimeException.class)
	public void questionsSkipsThrowsExceptionWhenDefaultNotSet() {
		Question q = new Question("06","a16","Pagan algún alquiler por la parte de la vivienda que no pertenece al hogar?");
		q.setSkip(1.0, "07");
		q.getSkip(9.0);
	}
	



}
