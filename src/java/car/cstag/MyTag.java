package car.cstag;
import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class MyTag extends SimpleTagSupport{
	String textColor;
	String text;

	public void doTag() throws JspException, IOException 
	{
		JspWriter out = getJspContext().getOut();
			out.write(String.format("<span style='color:%s'>%s</span>", textColor, text));
	}

	
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}

	public void setText(String text) {
		this.text = text;
	}

}
