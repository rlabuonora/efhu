
public class Question {
	
	String id;
	String text;
	String var;
	DefaultHashMap<Double, String> skips = new DefaultHashMap<Double, String>();
	
	public Question(String id, String text, String var) {
		super();
		this.id = id;
		this.text = text;
		this.var = var;
	}

	public String getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public String getVar() {
		return var;
	}

	public void setSkip(Double d, String string) {
		// TODO Auto-generated method stub
		skips.put(d, string);
	}
	
	public void setDefaultSkip(String string) {
		// TODO Auto-generated method stub
		skips.setDefault(string);
	}

	public String getSkip(double d) {
		// TODO Auto-generated method stub
		return skips.get(d);
	}
	

	
	
	
	

}
