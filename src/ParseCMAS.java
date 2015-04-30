import javax.xml.parsers.*;
import org.xml.sax.InputSource;
import org.w3c.dom.*;
import java.io.*;


public class ParseCMAS {

	private String input="";
	
	public ParseCMAS(){}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	
	public boolean parseStart()
	{
		System.out.println("P CMAS Start");
		System.out.println(input.replaceAll("><T", ">\n<T"));
		
		System.out.println("P CMAS OK");
		return true;
	}
	
	/**
	 * @return
	 */
	/**
	 * @return
	 */
	public boolean parseXMLDetail()
	{
		//String xmlRecords = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><TransXML><Trans><T0100>0810</T0100><T0300>881999</T0300><T0400>0</T0400><T0403>0</T0403><T0407>0</T0407><T0408>0</T0408><T0409>0</T0409><T0410>0</T0410><T1100>000084</T1100><T1101>000001</T1101><T1200>102920</T1200><T1201>102902</T1201><T1300>20150306</T1300><T1301>20150306</T1301><T3700>20150306000001</T3700><T3800>bP2p59</T3800><T3900>00</T3900><T4100>0A100D112700</T4100><T4101>4ED4FE00</T4101><T4102>8.8.8.8</T4102><T4103>KOBE-PC-24</T4103><T4104>B0808C59</T4104><T4200>00010001</T4200><T4210>00000</T4210><T4802>00</T4802><T4813>0</T4813><T4814>0</T4814><T4815>0</T4815><T4816>0</T4816><T4817>0</T4817><T4820>01</T4820><T4823>11</T4823><T4824>00</T4824><T5301>01</T5301><T5303>02</T5303><T5306>F11EA1</T5306><T5307>EBD927BCBEF46C4F</T5307><T5308>CFA31679E083000F</T5308><T5361>5430363931333432</T5361><T5362>00005E52</T5362><T5363>24D47C5E103098FC</T5363><T5364>014DD9822020DF01DF02DF03DF04DF05DF06DF07DF08DF09DF10DF11DF12000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000</T5364><T5365>007102F04909000000000000</T5365><T5366>102700</T5366><T5368>00001512</T5368><T5369>11</T5369><T5370>0A100D112700000015111880F8540190002FE59C7F31BAD617C718E820BE541519</T5370><T5371>5039303030373234</T5371><T5501>15030601</T5501><T5503>0000100011</T5503><T5504>00</T5504><T5510>1234</T5510><T5588><T558801>01</T558801><T558803>000001</T558803></T5588><T5588><T558801>03</T558801><T558802>ECCAPP-V13</T558802><T558803>000013</T558803></T5588><T5588><T558801>04</T558801><T558803>000131</T558803></T5588><T5591>0</T5591><T5595><T559502>TM01</T559502><T559503>5909</T559503><T559504>20131125</T559504><T559505>99991231</T559505></T5595><T5595><T559502>TM02</T559502><T559503>00010001</T559503><T559504>20131125</T559504><T559505>99991231</T559505></T5595><T5595><T559502>TM03</T559502><T559503>1    </T559503><T559504>20131125</T559504><T559505>99991231</T559505></T5595><T5595><T559502>TM04</T559502><T559503>0000100011</T559503><T559504>20131125</T559504><T559505>99991231</T559505></T5595><T5595><T559502>TM17</T559502><T559503>特店00010001</T559503><T559504>20131125</T559504><T559505>99991231</T559505></T5595><T5595><T559502>TM18</T559502><T559503>分店0000100011</T559503><T559504>20131125</T559504><T559505>99991231</T559505></T5595><T5595><T559501>000001</T559501><T559502>TM09</T559502><T559503>123456</T559503><T559504>20130101</T559504><T559505>20990101</T559505></T5595><T5595><T559501>000001</T559501><T559502>TM10</T559502><T559503>/OUT/ssl/ck1.cer</T559503><T559504>20130101</T559504><T559505>20990101</T559505></T5595><T5595><T559501>000013</T559501><T559502>TM12</T559502><T559503>/OUT/exe/ECCAPP/ECCAPP0013a.CAP</T559503><T559504>19700101</T559504><T559505>99991231</T559505></T5595><T5595><T559501>000131</T559501><T559502>ER01</T559502><T559503>OFF</T559503><T559504>20150201</T559504><T559505>20150801</T559505></T5595><T5595><T559501>000131</T559501><T559502>ER02</T559502><T559503>RS232</T559503><T559504>20150201</T559504><T559505>20150801</T559505></T5595><T5595><T559501>000131</T559501><T559502>ER03</T559502><T559503>0</T559503><T559504>20150201</T559504><T559505>20150801</T559505></T5595><T5595><T559501>000131</T559501><T559502>ER05</T559502><T559503>1_9600_8_N_1</T559503><T559504>20150201</T559504><T559505>20150801</T559505></T5595><T5595><T559501>000131</T559501><T559502>TM19</T559502><T559503>1</T559503><T559504>20150201</T559504><T559505>20150801</T559505></T5595><T5595><T559501>000131</T559501><T559502>TM20</T559502><T559503>收銀機測試</T559503><T559504>20150201</T559504><T559505>20150801</T559505></T5595><T5595><T559501>000131</T559501><T559502>TM25</T559502><T559503>1</T559503><T559504>20150201</T559504><T559505>20150801</T559505></T5595><T5595><T559501>000131</T559501><T559502>TM30</T559502><T559503>110101100</T559503><T559504>20150201</T559504><T559505>20150801</T559505></T5595><T5595><T559501>000131</T559501><T559502>TM31</T559502><T559503>10</T559503><T559504>20150201</T559504><T559505>20150801</T559505></T5595><T5596><T559601>00000000</T559601><T559602>00000001</T559602><T559603>00000000</T559603><T559604>00000001</T559604></T5596><T6000>261D0323D000</T6000><T6002>11B80B01E8030001A0860101F40100000000000000000000</T6002><T6003>A086010000000000000000000000000000000000000000000000000000000000</T6003><T6004>03341</T6004><T6400>EE8979D3333A5EAD</T6400><T6401>E643ABDC870A2DC8</T6401><T6408>AE81F028B2CF53B8CF9FD9637EEB3876</T6408><T6409>3AC39FDE1EA74C2B389CD90906BDBE00</T6409></Trans></TransXML>";
		//String xmlRecords = "<TransXML><Trans>"
		//		+"<T0100 num='1'>0800</T0100>"
		//		+"</Trans></TransXML>";
		
		 try {
		        DocumentBuilderFactory dbf =
		            DocumentBuilderFactory.newInstance();
		        DocumentBuilder db = dbf.newDocumentBuilder();
		        InputSource is = new InputSource();
		        is.setCharacterStream(new StringReader(input));

		        Document doc = db.parse(is);
		        //NodeList nodes = doc.getElementsByTagName("Trans");
		        
		        //System.out.println("<Trans> nodes Length:"+nodes.getLength());
		        
		        NodeList root = doc.getElementsByTagName("Trans");
		        NodeList nodes = root.item(0).getChildNodes();
		        //System.out.println("node5595Len:"+nodes.getLength());
		        for (int i = 0; i < nodes.getLength(); i++) {
		            Node node = nodes.item(i);
		            if (node.getNodeType() == Node.ELEMENT_NODE) {
		                // do something with the current element
		                System.out.println(node.getNodeName()+":"+node.getTextContent());
		            }
		        }
		        
		        /*
		        // iterate the employees
		        for (int i = 0; i < nodes.getLength(); i++) {
		           Element element = (Element) nodes.item(i);

		           NodeList childs = element.getChildNodes();
		           Node node = childs.item(0);
		           node.normalize();
		           System.out.println("Child Node has childs?:"+node.hasChildNodes());
		           
		           System.out.println("Childs nodes length:"+childs.getLength());
		           
		           System.out.println(childs.item(0).getNodeName());
		           System.out.println(childs.item(0).getNodeValue());
		           System.out.println(childs.item(0).getNodeType());
		           System.out.println(childs.item(0).getTextContent());
		           System.out.println(childs.item(0).hasChildNodes());
		           
		           
		           
		           NodeList childss = childs.item(0).getChildNodes();
		           System.out.println("chilss type:"+childss.item(0).getNodeType());
		           
		           if(childss != null)
		           {
		        	   System.out.println(childss.item(0).getNodeName());
		           }
		           else
		        	   System.out.println("Childss is NULL");
		           
		           System.out.println("Childss length:"+childss.getLength());
		          
		        }*/
		    }
		    catch (Exception e) {
		        e.printStackTrace();
		    }
		
		
		return true;
	}
	
	 public static String getCharacterDataFromElement(Element e) {
		    Node child = e.getFirstChild();
		    if (child instanceof CharacterData) {
		       CharacterData cd = (CharacterData) child;
		       return cd.getData();
		    }
		    return "?";
		  }
	
}
