package cn.peter.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Peter Yu
 * @date 2018/6/19 19:29
 */
public class DateUtils {

    private DateUtils(){}

    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){

        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static Date parseWithNoPunctuation(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date parse = null;
        try {
            parse = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }

    public static Date postpone(Date date, Integer days){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR,1);
        return calendar.getTime();
    }

    public static Integer minus(Date day1, Date day2){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(day1);

        return null;
    }

    public static void main(String[] args) {

        System.out.println(new Date());
        Date postpone = postpone(new Date(), 1);
        System.out.println(postpone);
    }
}
