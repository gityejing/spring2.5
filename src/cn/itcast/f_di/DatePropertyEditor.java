package cn.itcast.f_di;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePropertyEditor extends PropertyEditorSupport {

	private String format;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date date = sdf.parse(text);
			setValue(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

}
