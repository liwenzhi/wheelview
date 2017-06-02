
package com.example.wheelview.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 这是一个时间转换的工具类
 * <p/>
 * 计算机能识别下面的字母："yyyy-MM-dd DD HH:mm:ss SSS"
 * y代表的是年份，M代表的是月份，d代表的当月的第几天，D代表的是当年的第几天，
 * H代表的是小时数，m代表的是分钟数，s代表的秒数，S代表的是毫秒数。这个常识是需要我们记住的。
 * <p/>
 * *方法1：long getTimeLong()
 * 获取当前时间的毫秒数
 * <p/>
 * *方法2：int getTimeInt(String filter)
 * 输入某种时间格式的字符串，显示当前时间它的数据，比如输入getTimeInt（“DD”）获取今日是当前月的天数
 * <p/>
 * * 方法3：String getTimeString()
 * 获取当前时间的完整的格式，比如2016-11-11 8：20：20
 * <p/>
 * * 方法4：String getTimeString(long time)
 * 输入一个long类型的数据，获取一个完整格式的时间字符串，获取到的格式和方法三一样
 * <p/>
 * * 方法5： String getTimeString(long time, String filter)
 * 输入一个long类型的数据和一个自定义时间的格式的字符串，获取一个自定义的时间字符串，
 * 比如getTimeString（1111111L，“MM-dd”）获取的是毫秒数11111111的月分数和天数
 * <p/>
 * * 方法6：String getTimeString( String filter)
 * 输入某种时间格式的字符串，显示当前时间它的数据，比如输入getTimeString（“DD”）获取今日是当前月的天数
 * 这个方法和方法2相似，不过这里获取到的是字符串，只能用来做显示，而方法二获取到的是数字，可以用来显示和做相关运算。
 * * 方法7：String getTimeLong( String filter,String date)
 * 输入某种时间格式的字符串和对应时间格式的时间，显示它的毫秒数，比如输入getTimeString（“MM-dd”，“8-12”）获取8月12日的毫秒数
 * 这个方法一般用于对两个时间进行比较，从而得出哪一个时间比较久
 */

public class TimeUtil {


    /**
     * 获取当前时间的毫秒数
     */
    public static long getTimeLong() {
        return System.currentTimeMillis();
    }

    /**
     * 获取当时时间的年，月，日，时分秒
     * 这里获得的时int类型的数据，要输入对应的格式
     * 比如要获得现在时间的天数值，
     * 使用getTime（“MM”）,如果现在是2016年5月20日，取得的数字是5；
     */
    public static int getTimeInt(String filter) {
        //
        SimpleDateFormat format = new SimpleDateFormat(filter);
        String time = format.format(new Date());
        return Integer.parseInt(time);
    }

    /**
     * 获取指定时间的年，月，日，时分秒
     * 这里获得的时int类型的数据，要输入完整时间的字符串和对应的格式
     * 比如要获得时间2016-12-12 14：12：10的小时的数值，
     * 使用getTime（“2016-12-12 14：12：10”，“HH”）；得到14
     */
    public static int getTimeInt(String StringTime, String filter) {
        //
        SimpleDateFormat format = new SimpleDateFormat(filter);
        String time = format.format(new Date(getTimeLong("yyyy-MM-dd HH:mm:ss", StringTime)));
        return Integer.parseInt(time);
    }


    /**
     * 获取当前时间的完整显示字符串
     */
    public static final String getTimeString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date(getTimeLong()));
    }

    /**
     * 获得某个时间的完整格式的字符串
     * 输入的是某个时间的毫秒数，
     * 有些时候文件保存的时间是毫秒数，这时就需要转换来查看时间了！
     */
    public static final String getTimeString(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date(time));
    }

    /**
     * 获得自定义格式的时间字符串
     * 输入的是某个时间的毫秒数，显示的可以是时间字符串的某一部分
     * 比如想要获得某一个时间的月和日，getTimeString(1111111111111,"MM-dd");
     */
    public static final String getTimeString(long time, String filter) {
        SimpleDateFormat format = new SimpleDateFormat(filter);
        return format.format(new Date(time));
    }

    /**
     * 获得自定义格式的当前的时间的字符串
     * 比如当前时间2016年8月8日12时8分21秒，getTimeString("yyyy-MM-dd"),可以得到 2016-8-12
     */
    public static final String getTimeString(String filter) {
        SimpleDateFormat format = new SimpleDateFormat(filter);
        return format.format(new Date(getTimeLong()));
    }

    /**
     * 获取某个时间的毫秒数，
     * 一般作用于时间先后的对比
     * 第一个参数是时间的格式，第二个参数是时间的具体值
     * 比如需要知道2016-6-20的毫秒数（小时和分钟默认为零），
     * getTimeLong("yyyy-MM-dd","2016-6-20")
     * 有时只有月日也是可以的，比如  getTimeLong("MM-dd","6-20") ，一般这个用来比较时间先后
     * 记住获得的毫秒数越大，时间就越近你
     */
    public static Long getTimeLong(String filter, String date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(filter);
            Date dateTime = format.parse(date);
            return dateTime.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0L;
    }


    /**
     * 获得某一个时间字符串中的局部字符串
     * 比如：String data= "2016-5-20 12：12：10"，要获得后面的时间：5-20或 12：10
     * 使用：getTimeLocalString("yyyy-MM-dd HH:mm:ss",data,"MM-dd")   ，可以获得5-20
     * 如果是data="2016-5-20"，要获得后面的5-20，
     * 也是一样的用法getTimeLocalString("yyyy-MM-dd ",data,"MM-dd")！
     */
    public static String getTimeLocalString(String filter, String data, String filterInside) {
        Long timeLong = getTimeLong(filter, data);
        return getTimeString(timeLong, filterInside);
    }

}