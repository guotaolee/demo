package com.example.demo.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: gtli
 * Date: 2020-05-26
 * Time: 10:10
 * Description: 时间格式工具类
 */
public class DateUtil {

    private static final SimpleDateFormat TimeStringFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * @return String 日期字符串
     * @throws
     * @Description: 获取当前系统日期 格式:yyyy-mm-dd
     */
    public static String getCurrentDate() {
        return getCurrentDate("yyyy-MM-dd");
    }

    /**
     * @return String
     * @throws
     * @Title: getDate
     * @Description: 获取当前系统日期 格式:yyyymmdd
     */
    public static String getDate() {
        return getCurrentDate("yyyyMMdd");
    }

    /**
     * 功能描述：根据给定的格式将str转化为Date类型
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static Date getDate(String dateStr, String format) {
        DateFormat formater = new SimpleDateFormat(format);
        Date result;
        try {
            result = formater.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return result;
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
        return getCurrentDate("HH:mm:ss");
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
        DateFormat formater = new SimpleDateFormat(format);
        return formater.format(new Date());
    }

    /**
     * @param source
     * @param interval
     * @return String
     * @throws Exception
     * @Title:sourcePlusInterval
     * @Description:日期增加
     */
    public static String sourcePlusInterval(String source, int interval) {
        DateFormat informater = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(informater.parse(source));
        } catch (ParseException e) {

        }
        int day = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.set(Calendar.DAY_OF_YEAR, day + interval);
        return informater.format(calendar.getTime());
    }

    /**
     * @param @param  source 日期原串
     * @param @param  infmt 日期输入格式
     * @param @param  outfmt 日期输出格式
     * @param @return 目标日期字符串
     * @throws ParseException
     * @Description: 将字符串从一种格式转化的
     */
    public static String getFmtDate(String source, String infmt, String outfmt)
            throws ParseException {
        // 输入格式
        DateFormat informater = new SimpleDateFormat(infmt);
        // 输出格式
        DateFormat outfomater = new SimpleDateFormat(outfmt);

        return outfomater.format(informater.parse(source));
    }

    /**
     * @param @param  source 日期原串
     * @param @param  infmt 日期输入格式
     * @param @param  outfmt 日期输出格式
     * @param @return 目标日期字符串
     * @throws ParseException
     * @Description: 将字符串从一种格式转化的
     */
    public static String getFmtDateStr(String source, String infmt, String outfmt) {
        String result = "";
        try {
            // 输入格式
            DateFormat informater = new SimpleDateFormat(infmt);
            // 输出格式
            DateFormat outfomater = new SimpleDateFormat(outfmt);

            result = outfomater.format(informater.parse(source));

        } catch (Exception e) {
            result = source;
        }

        return result;
    }

    /**
     * @param @param  num
     * @param @param  fmt
     * @param @return 设定文件
     * @param num
     * @param fmt
     * @return
     * @throws
     * @Title:getAppointDay
     * @Description:
     */
    public static String getAppointDay(String fmt, int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, num);
        Date tmp = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        String date = sdf.format(tmp);
        return date;
    }

    /**
     * @param source
     * @param interval
     * @return Date
     * @Title:dataPlusInterval
     * @Description:日期增加(Date格式操作)
     */
    public static Date dataPlusInterval(Date source, int interval) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(source);
        int day = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.set(Calendar.DAY_OF_YEAR, day + interval);
        return calendar.getTime();
    }

    /**
     * @param source
     * @param interval
     * @param format
     * @return Date
     * @Title:dataPlusInterval
     * @Description:日期增加(string格式操作)
     */
    public static String datePlusIntervaltoString(Date source, int interval, String format) {
        Date date = dataPlusInterval(source, interval);
        return getDateStr(date, format);
    }

    /**
     * @param dateString
     * @param interval
     * @param format
     * @return Date
     * @Title:dataPlusInterval
     * @Description:日期增加(string格式操作)
     */
    public static String datePlusIntervaltoString(String dateString, int interval, String format) {
        Date source = getDate(dateString, format);
        Date date = dataPlusInterval(source, interval);
        return getDateStr(date, format);
    }

    /**
     * @param date   日期
     * @param format 日期格式
     * @return 日期字符串
     * @Description:日期转化为字符串
     */
    public static String getDateStr(Date date, String format) {
        DateFormat dateformat = new SimpleDateFormat(format);
        return dateformat.format(date);
    }

    /**
     * @param date 传入日期
     * @param item 加减的日期天数
     * @return
     */
    @SuppressWarnings("static-access")
    public static String getFormatDate(String date, int item) {
        String resDate = "";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d = format.parse(date);
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            c.add(Calendar.DATE, item);
            Date temp_date = c.getTime();
            resDate = format.format(temp_date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resDate;
    }

    public static Date getNowDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = DateUtil.getCurrentTimeStamp();
        Date date = null;
        try {
            date = formatter.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取执行日期加或减mintues分钟的时间串
     *
     * @param date
     * @param minutes
     * @return
     */
    public static String getDateString(Date date, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int now = calendar.get(Calendar.MINUTE);
        calendar.set(Calendar.MINUTE, now + minutes);
        return TimeStringFormat.format(calendar.getTime());
    }

    /**
     * 获取执行日期加或减mintues分钟的时间串
     *
     * @param date
     * @param minutes
     * @return
     */
    public static Date getDate(Date date, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int now = calendar.get(Calendar.MINUTE);
        calendar.set(Calendar.MINUTE, now + minutes);
        return calendar.getTime();
    }

    /**
     * 获取给定日期：yyyy-MM月份的第一天
     *
     * @param dateString
     * @return
     */
    public static String getFirstDayOfMonth(String dateString) {
        Date date = DateUtil.getDate(dateString, "yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDayOfMonth = calendar.getTime();
        return getDateStr(firstDayOfMonth, "yyyyMMdd");
    }

    /**
     * 获取给定日期：yyyy-MM月份的最后一天
     *
     * @param dateString
     * @return
     */
    public static String getLastDayOfMonth(String dateString) {
        Date date = DateUtil.getDate(dateString, "yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date lastDayOfMonth = calendar.getTime();
        return getDateStr(lastDayOfMonth, "yyyyMMdd");
    }

    /**
     * 获取昨天的时间
     *
     * @return String
     */
    public static String getYesterDay() {
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
        return dft.format(date.getTime());
    }
}
