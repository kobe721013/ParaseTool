import java.util.HashMap;
import java.util.Scanner;


public class EZParser {

	public  static void main(String args[]) {	
	     System.out.println("Welcome Kobe PPPP~arser~~");
	     
	     UserMenu userMenu = new UserMenu();
	     ParseReader pReader = new ParseReader();
	     ParseCMAS pCMAS = new ParseCMAS();
	     String userInput=null;
	     
	     HashMap<Integer, String> menuParseType = new HashMap<Integer, String>();
	     menuParseType.put(1, "1.Reader Type");
	     menuParseType.put(2, "2.CMAS Type");
	     
	     while(true){
		     switch(userMenu.getChoice(menuParseType))
		     {
		     	case 1://parse Reader
		     		boolean result=false;
		     		HashMap<Integer, String> menuReaderCommand = new HashMap<Integer, String>();
		     		menuReaderCommand.put(0, "0.PPR_Reset_Req");
		     		menuReaderCommand.put(1, "1.PPR_Reset_Resp");
		     		menuReaderCommand.put(2, "2.PPR_SignOn_Req");	   	     
		     		menuReaderCommand.put(3, "3.PPR_SignOn_Resp");
		     		menuReaderCommand.put(4, "4.PPR_SignOn_Query_Req");	   	     
		     		menuReaderCommand.put(5, "5.PPR_SignOn_Query_Resp");
		     						
					pReader.setCommandType((byte)userMenu.getChoice(menuReaderCommand));					
					
					//got Parse Data
					userInput = userMenu.gotParseData();				
					pReader.setInput(userInput);
				    result = pReader.parse();			     
				    System.out.println("Parse result:"+result);
		     		
		     		break;
		     		
		     	case 2: ////parse CMAS
		     		
		     		userInput = userMenu.gotParseData();
		     		pCMAS.setInput(userInput);
		     		//pCMAS.parseStart();
		     		pCMAS.parseXMLDetail();
		     		
		     		
		     		break;
		     		
		     	default:
		     		
		     		break;
		     } 
	     }
	}
}
