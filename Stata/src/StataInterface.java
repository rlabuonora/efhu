import java.util.ArrayList;
import java.util.Arrays;


public class StataInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//StdOut.println("Hello Stata!");
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
