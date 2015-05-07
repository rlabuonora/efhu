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
		skips.put(d, string);
	}
	
	public void setDefaultSkip(String string) {
		skips.setDefault(string);
	}

	public String getSkip(double d) {
		return skips.get(d);
	}
}
