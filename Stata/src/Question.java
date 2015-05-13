import com.stata.sfi.Data;
import com.stata.sfi.SFIToolkit;

public class Question {
	
	String id;
	String text;
	String var;
	DefaultHashMap<Double, String> skips = new DefaultHashMap<Double, String>();
	String flagName;
	
	public Question(String id, String var, String text) {
		super();
		this.id = id;
		this.var = var;
		this.text = text;
		this.flagName = "FL_" + id;
		
	}
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", text=" + text + ", var=" + var
				+ ", skips=" + skips + "]";
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
	
	public int createFlag() {
	// creates the flag for this question and sets it to 0
		
		int status = Data.addVarInt(flagName);
		if (status != 0) {
			SFIToolkit.error("Could not create " + flagName );
			return(198);
		}
		int index = getFlagIndex();
		if (index == 0) {
			SFIToolkit.error("Could not create " + flagName );
			return(198);
		} else {
			int N = Data.getObsCount();
			for (int i = 1; i <= N; i++)  {
				Data.storeNum(index, i, 0);  
		        }
		}
		return 0;
	}	
	
	public int getIndex() {
		return Data.getVarIndex(var);
	}
	public int getFlagIndex() {
		// put it in a field initialized by constructor
		return Data.getVarIndex(flagName);
	}

	public int setFlag(int obs, double flag) {
		int status = Data.storeNum(getFlagIndex(), obs, flag); 
		return status;
	}

	public int setFlagToMissing(int obs) {
		// TODO Auto-generated method stub
		int status = setFlag(obs, Data.getMissingValue());
		if (status != 0) SFIToolkit.error("Cannot set flag " + flagName + "\n");
		return status;
	}

	public double getResponse(int obs) {
		// Add error checks!
		double respuesta =  Data.getNum(getIndex(), obs);
		return respuesta;
	}

	public String next(int obs) {
		double response = getResponse(obs);
		return getSkip(response);
	}
	
	
	
}
