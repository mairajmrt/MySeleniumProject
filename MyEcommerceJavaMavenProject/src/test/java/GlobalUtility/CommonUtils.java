package GlobalUtility;

import java.util.Date;

public class CommonUtils {

	public static CharSequence getNewEmailAddress() {
		return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "") + "@gmail.com";

	}

}
