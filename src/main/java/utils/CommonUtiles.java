package utils;

import java.util.Date;

public class CommonUtiles {
	
	public  String EmailTimestamp() {
		Date date=new Date();
		return "nandi"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";

}
}