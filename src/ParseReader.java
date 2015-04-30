
public class ParseReader {

	private String input=null;
	private byte commandType=0x00;
	private SubField subFields=null;
	public enum CommandType{
		PPR_RESET_REQ,
		PPR_RESET_RESP,
		PPR_SIGNON_REQ,
		PPR_SIGNON_RESP,
		PPR_SIGNON_QUERY_REQ,
		PPR_SIGNON_QUERY_RESP
	}
	private class SubField
	{
		int len;
		String fieldName;
		boolean isBits = false;
		public SubField(int l, String fn)
		{
			len = l;
			fieldName = fn;
		}
		
		public SubField(int l, String fn, boolean isBits)
		{
			len = l;
			fieldName = fn;
			isBits = isBits;
		}
	}
	//********************************************

	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public Byte getCommandType() {
		return commandType;
	}
	public void setCommandType(Byte commandType) {
		this.commandType = commandType;
	}
	public ParseReader(){}
	public ParseReader(Byte ct)
	{
		commandType = ct;
	}
	
	
	public boolean parse()
	{
		CommandType type = CommandType.values()[commandType];	
		
		boolean result = true;
		SubField []fields = null;
		switch(type)
		{
			case PPR_RESET_REQ:
				fields = new SubField[]{					
				new SubField(3,"Total Length"),
				new SubField(5,"Header"),	
				new SubField(10,"TM Location ID"),
				new SubField(2,"TM ID"),
				new SubField(14,"TM TXN Date Time"),
				new SubField(6,"TM Serial No."),
				new SubField(4,"TM Agent No."),
				new SubField(4,"Txn Date Time"),
				new SubField(1,"Location ID"),
				new SubField(2,"New Location ID"),
				new SubField(1,"Service Provider ID"),
				new SubField(3,"New Service Provider ID"),
				new SubField(1,"SignOn Parameter 1"),
				new SubField(2,"One Day Quota For MicroPayment"),
				new SubField(2,"Once Quota For MicroPayment"),
				new SubField(1,"SAM Slot Control Flag"),
				new SubField(11,"RFU"),
				new SubField(1,"Le"),
				new SubField(1,"EDC"),					
			};
			break;
		
			case PPR_RESET_RESP:
				fields = new SubField[]{					
					new SubField(3,"Total Length"),
					//new SubField(5,"Header"),	
					new SubField(1,"Spec.Version Number(T4820)"),
					new SubField(4,"Reader ID (4104)"),
					new SubField(6,"Reader FW Verion (6000)"),
					new SubField(8,"old SAM ID (5361)"),
					new SubField(4,"old SAM SN (5362)"),
					new SubField(8,"old SAM CRN (5363)"),
					new SubField(4,"old Device ID (4101)"),
					new SubField(1,"old SAM Key Version (5301)"),
					new SubField(8,"old S-TAC (6400)"),
					new SubField(1,"new SAM Version Number (5364_1)"),
					new SubField(8,"new SAM ID (5371)"),
					new SubField(3,"new SAM Usage Control (5364_2)"),
					new SubField(1,"new SAM Admin KVN (5364_3)"),
					new SubField(1,"new SAM Issuer KVN (5364_2)"),
					new SubField(3,"Auth. Credit Limit (5365_1)"),
					new SubField(3,"Single Credit Txn Amt Limit (5366)"),
					new SubField(3,"Auth. Credit Balance (5365_2)"),
					new SubField(3,"Auth. Credit Cumulative (5365_3)"),
					new SubField(3,"Auth. Cancel Credit Cumulative (5365_4)"),
					new SubField(6,"New Device ID (4100)"),
					new SubField(40,"Tag List Table (5364_5)"),
					new SubField(32,"SAM Issuer Spec. Data (5364_6)"),
					new SubField(4,"STC (5368)"),
					new SubField(8,"RSAM (5307)"),
					new SubField(8,"RHOST (5308)"),
					new SubField(16,"SATOKEN (6408)"),
					new SubField(1,"CPD Read Flag...", true),
					new SubField(1,"One Data Quota Flag...", true),
					new SubField(2,"One Day Quota (6002_2)"),
					new SubField(2,"Once Quota (6002_4)"),
					new SubField(2,"Check Debit Value (6002_9)"),
					new SubField(1,"Add Quota Flag (6002_6)"),
					new SubField(3,"Add Quota (6002_7)"),
					new SubField(3,"The Remainder of Add Quota (6003_1)"),
					new SubField(3,"Cancel Credit Quota (6003_3)"),
					new SubField(8,"deMAC Parameter (6003_2)"),
					new SubField(4,"Last Txn Date Time"),
					new SubField(6,"Pre.New Device ID (5370_1)"),
					new SubField(4,"Pre.STC (5370_2)"),
					new SubField(4,"Pre.Txn Date Time (5370_3)"),
					new SubField(1,"Pre.Credit Balance Change Flag (5370_4)"),
					new SubField(2,"Pre. Confirm Code (5370_5)"),
					new SubField(16,"Pre.CACrypto"),
					new SubField(2,"StatusCode"),
					new SubField(1,"Le"),				
				};
			break;
			
			case PPR_SIGNON_REQ:
				
				fields = new SubField[]{
						new SubField(3,"Total Length"),
						new SubField(5,"Header"),						
						new SubField(8,"H-TAC (6401)"),
						new SubField(16,"HAToken (6409)"),
						new SubField(1,"SAM Update Option (5367)"),
						new SubField(40,"New SAM Value (5367)"),
						new SubField(16,"Update SAM Value MAC (5367)"),
						new SubField(1,"CPD Read Flag... (4824,4823,5369,6002_5,6002_10)"),
						new SubField(1,"One Day Quota Flag... (6002_1,6002_3,6002_8)"),
						new SubField(2,"One Day Quota (6002_2)"),
						new SubField(2,"Once Quota (6002_4)"),
						new SubField(2,"Check Debit Value (6002_9)"),
						new SubField(1,"Add Quota Flag (6002_6)"),
						new SubField(3,"Add Quota (6002_7)"),
						new SubField(31,"RFU"),
						new SubField(4,"EDC (5303, 5306)"),
						new SubField(1,"Le"),
					};
				
				break;
			
			case PPR_SIGNON_RESP:
			
				fields = new SubField[]{
						new SubField(3,"Total Length"),
												
						new SubField(1,"Credit Balance Change Flag (4825)"),
						new SubField(3,"Original Auth. Credit Limit"),
						new SubField(3,"Original Auth. Credit Balance"),
						new SubField(3,"Original Auth. Credit Cumulative"),
						new SubField(3,"Original Auth. Cancel Credit Cumulative"),
						new SubField(16,"CACrypto"),
						new SubField(2,"StatusCode"),
						new SubField(1,"Le"),
					};
			
			
			break;
			
			
			case PPR_SIGNON_QUERY_REQ:
				
				fields = new SubField[]{
						new SubField(3,"Total Length"),
						new SubField(5,"Header"),						
						new SubField(1,"Le"),
					};
				
				break;
			
			case PPR_SIGNON_QUERY_RESP:
			
				fields = new SubField[]{
						new SubField(3,"Total Length"),						
						new SubField(3,"Auth. Credit Limit"),
						new SubField(3,"Auth. Credit Balance"),
						new SubField(3,"Auth. Credit Cumulative"),
						new SubField(3,"Auth. Cancel Credit Cumulative"),
						new SubField(1,"Mixed parameter1"),
						new SubField(1,"Mixed parameter2"),
						new SubField(2,"One Day Quota For Micro Payment"),
						new SubField(2,"Once Day Quota For Micro Payment"),
						new SubField(2,"Check Debit Value"),
						new SubField(1,"Add Quota Flag"),
						new SubField(3,"Add Quota"),
						new SubField(4,"Last TXN Date Time"),
						new SubField(1,"Service Provider ID"),
						new SubField(3,"New Service Provider ID"),
						new SubField(2,"RFU"),
						new SubField(3,"The Remainder of Add Quota"),
						new SubField(3,"Cancel Credit Quota"),
						new SubField(2,"StatusCode"),
						new SubField(1,"Le"),
					};
			
			
			break;
			
				
				
			default:
				result = false;
				System.out.println("oh!!! UnKnoewn Command Type:"+commandType);
				break;
			
		}
		
		result = parseStart(fields);
		
		return result;
	}
	
	private boolean parseStart(SubField[] fields)
	{
		
		byte[] a = input.getBytes();
		byte[] t=null;
		int i=0;
		boolean result = true;
		for(SubField field:fields)
		{
			try{
				t=new byte[field.len*4];
				System.arraycopy(a, i, t, 0, t.length);
				i+=field.len*4;
				System.out.println(new String(t) + " --- " + field.fieldName);
			}
			catch(IndexOutOfBoundsException ie)
			{
				System.out.println("Index Error:"+ie.getMessage());
				result = false;
			}
			catch(Exception e)
			{
				System.out.println("Error:"+e.getMessage());
				result = false;				
			}
			
		}
		return result;
	}
}


