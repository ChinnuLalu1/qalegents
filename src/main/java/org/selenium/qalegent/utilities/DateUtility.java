package org.selenium.qalegent.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
    public static String getUserLoginDate(String format){
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date currentDate = new Date();
        return dateFormat.format(currentDate);
    }
}
