import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VoiceList")

public class VoiceList extends HttpServlet {

	/* Games Page Displays all the Games and their Information in Game Speed */

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		/* Checks the Games type whether it is electronicArts or activision or takeTwoInteractive */
				
		String name = null;
		String CategoryName = request.getParameter("maker");
		HashMap<String,Voice> hm = new HashMap<String, Voice>();
		
		if(CategoryName==null)
		{
			hm.putAll(SaxParserDataStore.voices);
			name = "";
		}
		else
		{
		  if(CategoryName.equals("Samsung1"))
		  {
			for(Map.Entry<String,Voice> entry : SaxParserDataStore.voices.entrySet())
				{
				if(entry.getValue().getRetailer().equals("Samsung Bixby"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
			name = "Samsung Bixby";
		  }
		  else if(CategoryName.equals("Bose1"))
		  {
			for(Map.Entry<String,Voice> entry : SaxParserDataStore.voices.entrySet())
				{
				if(entry.getValue().getRetailer().equals("Bose Home"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}	
			name = "Bose Home";
		  }
		  else if(CategoryName.equals("senstone"))
		  {
			for(Map.Entry<String,Voice> entry : SaxParserDataStore.voices.entrySet())
				{
				if(entry.getValue().getRetailer().equals("Senstone"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
			name = "Senstone";
		  }

		  
		  else if(CategoryName.equals("google"))
		  {
			for(Map.Entry<String,Voice> entry : SaxParserDataStore.voices.entrySet())
				{
				if(entry.getValue().getRetailer().equals("iHome Google"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
			name = "iHome Google";
		  }
		  else if(CategoryName.equals("echo"))
		  {
			for(Map.Entry<String,Voice> entry : SaxParserDataStore.voices.entrySet())
				{
				if(entry.getValue().getRetailer().equals("Echo Dot"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
			name = "Echo Dot";
		  }
		}

		/* Header, Left Navigation Bar are Printed.

		All the Games and Games information are dispalyed in the Content Section

		and then Footer is Printed*/
		
		Utilities utility = new Utilities(request,pw);
		utility.printHtml("Header.html");
		utility.printHtml("LeftNavigationBar.html");
		pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("<a style='font-size: 24px;'>"+name+" Voice Assistant</a>");
		pw.print("</h2><div class='entry'><table id='bestseller'>");
		int i = 1; int size= hm.size();
		for(Map.Entry<String, Voice> entry : hm.entrySet()){
			Voice voice = entry.getValue();
			if(i%3==1) pw.print("<tr>");
			pw.print("<td><div id='shop_item'>");
			pw.print("<h3>"+voice.getName()+"</h3>");
			pw.print("<strong>"+ "$" + voice.getPrice() + "</strong><ul>");
			pw.print("<li id='item'><img src='images/voice/"+voice.getImage()+"' alt='' /></li>");
			pw.print("<li><form method='post' action='Cart'>" +
					"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='voices'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='submit' class='btnbuy' value='Buy Now'></form></li>");
			pw.print("<li><form method='post' action='WriteReview'>"+"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='voices'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
				    "<input type='submit' value='WriteReview' class='btnreview'></form></li>");
			pw.print("<li><form method='post' action='ViewReview'>"+"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='voices'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
				    "<input type='submit' value='ViewReview' class='btnreview'></form></li>");
			pw.print("</ul></div></td>");
			if(i%3==0 || i == size) pw.print("</tr>");
			i++;
		}		
		pw.print("</table></div></div></div>");		
		utility.printHtml("Footer.html");
		
	}

}
