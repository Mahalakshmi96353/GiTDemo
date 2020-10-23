import java.io.IOException;
import java.util.ArrayList;

public class ExData2 {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ExData Ed = new ExData();
		ArrayList data = Ed.getData("APITest");
		
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		
		
		}

}
