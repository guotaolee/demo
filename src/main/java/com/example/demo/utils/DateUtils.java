package com.example.demo.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: gtli
 * Date: 2020-05-26
 * Time: 10:12
 * Description: jdk8的时间格式化工具类
 */
public class DateUtils {

    private static final SimpleDateFormat TimeStringFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter SHORT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    public static final DateTimeFormatter SHORT_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static final DateTimeFormatter MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyyMM");
    public static final DateTimeFormatter SHORT_TIME_FORMATTER = DateTimeFormatter.ofPattern("HHmmss");

    /***
     * 不允许实例化
     */
    private DateUtils() {
        super();
    }

    /**
     * 日期比较，如果s>=e 返回true 否则返回false
     *
     * @param s
     * @param e
     * @return
     */
    public static boolean compareDate(String s, String e) {
        if (fomatDate(s) == null || fomatDate(e) == null) {
            return false;
        }
        return s.compareTo(e) > 0;
    }

    /**
     * @return String 日期字符串
     * @throws
     * @Description: 获取当前系统日期 格式:yyyy-mm-dd
     */
    public static String getCurrentDate() {
        return LocalDate.now().toString();
    }

    /**
     * @return String
     * @throws
     * @Title: getDate
     * @Description: 获取当前系统日期 格式:yyyymmdd
     */
    public static String getDate() {
        return LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
    }

    /**
     * 功能描述：根据给定的格式将str转化为Date类型
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static LocalDate getDate(String dateStr, String format) {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern(format);
        LocalDate date = null;
        try {
            date = LocalDate.parse(dateStr, formater);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return date;
    }

    /**
     * @param format 日期格式
     * @return String 日期字符串
     * @throws
     * @Description: 获取当前系统日期
     */
    public static String getCurrentDate(String format) {
        return getCurrentDateTimeStr(format);
    }

    /**
     * @return String 时间字符串
     * @throws
     * @Description: 获取当前系统时间 格式:HH:mm:ss
     */
    public static String getCurrentTime() {
        return LocalTime.now().withNano(0).toString();
    }

    /**
     * @param format 时间格式
     * @return String 时间字符串
     * @throws
     * @Description: 获取当前系统时间
     */
    public static String getCurrentTime(String format) {
        return getCurrentDateTimeStr(format);
    }

    /**
     * @return String 时间字符串
     * @throws
     * @Description: 获取当前系统时间戳 格式:yyyy-mm-dd HH:mm:ss
     */
    public static String getCurrentTimeStamp() {
        return getCurrentDate("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @return String 时间字符串
     * @throws
     * @Description: 获取当前系统时间戳 精确到毫秒 格式:yyyy-mm-dd HH:mm:ss:sss
     */
    public static String getCurrentTimeToMs() {
        return getCurrentDate("yyyy-MM-dd HH:mm:ss:sss");
    }

    /**
     * @param format 时间格式
     * @return String 时间字符串
     * @throws
     * @Description: 获取当前系统时间戳
     */
    public static String getCurrentTimeStamp(String format) {
        return getCurrentDateTimeStr(format);
    }

    /**
     * @param format 日期时间格式
     * @return String 日期时间字符串
     * @throws
     * @Description: 获取当前日期时间字符串
     */
    public static String getCurrentDateTimeStr(String format) {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern(format);
        return formater.format(LocalDate.now());
    }

    /**
     * 获取某天的开始日期
     *
     * @param offset 0今天，1明天，-1昨天，依次类推
     * @return
     */
    public static LocalDateTime dayStart(int offset) {
        return LocalDate.now().plusDays(offset).atStartOfDay();
    }

    /**
     * 获取此刻与相对当天第day天的起始时间相隔的秒数。day为0表示今天的起始时间；1明天，2后天，-1昨天，-2前天等，依次例推。
     *
     * @param day
     * @return
     */
    public static int ttl(int day) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime time = LocalDate.now().plusDays(day).atStartOfDay();
        int ttl = (int) Duration.between(now, time).toMillis() / 1000;
        return ttl;
    }

    /**
     * 获取某周的开始日期
     *
     * @param offset 0本周，1下周，-1上周，依次类推
     * @return
     */
    public static LocalDate weekStart(int offset) {
        LocalDate localDate = LocalDate.now().plusWeeks(offset);
        return localDate.with(DayOfWeek.MONDAY);
    }

    /**
     * 获取某月的开始日期
     *
     * @param offset 0本月，1下个月，-1上个月，依次类推
     * @return
     */
    public static LocalDate monthStart(int offset) {
        return LocalDate.now().plusMonths(offset).with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 获取某季度的开始日期
     * 季度一年四季， 第一季度：2月-4月， 第二季度：5月-7月， 第三季度：8月-10月， 第四季度：11月-1月
     *
     * @param offset 0本季度，1下个季度，-1上个季度，依次类推
     * @return
     */
    public static LocalDate quarterStart(int offset) {
        final LocalDate date = LocalDate.now().plusMonths(offset * 3);
        int month = date.getMonth().getValue();//当月
        int start = 0;
        if (month >= 2 && month <= 4) {//第一季度
            start = 2;
        } else if (month >= 5 && month <= 7) {//第二季度
            start = 5;
        } else if (month >= 8 && month <= 10) {//第三季度
            start = 8;
        } else if ((month >= 11 && month <= 12)) {//第四季度
            start = 11;
        } else if (month == 1) {//第四季度
            start = 11;
            month = 13;
        }
        return date.plusMonths(start - month).with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 获取某年的开始日期
     *
     * @param offset 0今年，1明年，-1去年，依次类推
     * @return
     */
    public static LocalDate yearStart(int offset) {
        return LocalDate.now().plusYears(offset).with(TemporalAdjusters.firstDayOfYear());
    }

    /**
     * 格式化日期
     *
     * @param date
     * @return
     */
    public static Date fomatDate(String date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return fmt.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * yyyyMMddHHmmss
     */
    public static String getCurrentShortDateTimeStr() {
        return LocalDateTime.now(ZoneOffset.of("+8")).format(SHORT_DATETIME_FORMATTER);
    }

    /**
     * HHmmss
     */
    public static String getCurrentTimeStr() {
        return LocalTime.now(ZoneOffset.of("+8")).format(SHORT_TIME_FORMATTER);
    }

    /**
     * 获取日期，格式：yyyyMMdd
     * 0 当天
     * 1 明天
     * -1 昨天
     *
     * @param offset
     * @return
     */
    public static String getDate(int offset) {
        return LocalDateTime.now().plusDays(offset).format(SHORT_DATE_FORMATTER);
    }

    /**
     * 指定日期偏移
     *
     * @param strDate String  日期
     * @param offset  偏移
     * @return 计算后日期
     */
    public static String getDate(String strDate, int offset) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDateTime ldt = LocalDateTime.parse(strDate, df);
        return ldt.plusDays(offset).format(SHORT_DATE_FORMATTER);
    }


    /**
     * 计算日期
     *
     * @param time 计算的时间
     * @param day  减去的天数
     * @return
     * @throws Exception
     */
    public static String calculateTime(String time, String Symbol, int day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(stringToDate(time));
        if ("+".equalsIgnoreCase(Symbol)) {
            cal.add(Calendar.DATE, +day);
        } else if ("-".equalsIgnoreCase(Symbol)) {
            cal.add(Calendar.DATE, -day);
        } else {
            return time;
        }
        return sdf.format(cal.getTime());
    }

    public static Date stringToDate(String time) {
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取月份：yyyyMM
     */
    public static String getMonth() {
        return LocalDateTime.now(ZoneOffset.of("+8")).format(MONTH_FORMATTER);
    }
}
