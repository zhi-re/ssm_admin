package fun.chenqi.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String date(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = sdf.format(date);
        return s;
    }
}
