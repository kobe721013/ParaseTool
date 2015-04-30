import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class UserMenu {

	Scanner scanner=null;
	//HashMap<String, String> menu;
	
	public UserMenu(){
		if(scanner==null) 
			scanner = new Scanner(System.in);
	}
	
	
	//private String keyIn;
	
	@SuppressWarnings("rawtypes")
	public int getChoice(HashMap<Integer, String> menu)
	{
		int result=0;
		String userInput=null;
		boolean gotData=false;
		
		
		java.util.Iterator it = menu.entrySet().iterator();
        while (it.hasNext()) {
            java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
            System.out.println(entry.getValue());
        }

		while(true){
			if((userInput = scanner.nextLine()).length() > 0)
			{
				try{
					result = Integer.parseInt(userInput);
					it = menu.entrySet().iterator();
					java.util.Map.Entry entry;
					while (it.hasNext()) {
			            entry = (java.util.Map.Entry) it.next();
			            
			            if(result==(int)entry.getKey())
			            {
			            	System.out.println("got it!!!");
			            	gotData = true;
			            	break;
			            }
			            
			        }
					if(gotData) break;
					else System.out.println("No this ChoiceItem!!!, try again");
				}
				catch (NumberFormatException e)
				{
					System.out.println("Please KeyIn Integer , OK?");
				}
			}
		}
		
		scanner.reset();
		if (0 == userInput.compareToIgnoreCase("q")) 
			return -1;
		
		
		return result;
	}
	
	public String gotParseData()
	{
		String userInput = null;
		System.out.println("Please keyIn data wanted to be parsed:");
		
		while(true)
		{
			if((userInput = scanner.nextLine()).length() > 0)
				break;				
		}
		
		scanner.reset();
		return userInput;
		
	}
	
}
