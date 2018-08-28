package cn.peter.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Peter Yu 2018/6/27 13:46
 */
public class DateMinusDemo {

    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){

        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }
    };

    public static void main(String[] args) {
        Date now = new Date();
        Date parse = null;
        DateFormat dateFormat = df.get();
        try {
            parse = dateFormat.parse("2018-06-27 00:00:00");
            long l = now.getTime() - parse.getTime();
            System.out.println(l);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
