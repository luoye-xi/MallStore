package com.linkstar.app.store.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;

import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hx
 * Time 2018/12/14/014.
 */

public class StringUtil {
    /**
     * 账号格式验证
     *
     * @param account
     * @return
     */
    public static boolean checkAccount(String account) {
        String regex = "[a-zA-Z0-9]{6,15}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(account);
        boolean b = matcher.matches();
        return b;
    }

    /**
     * 检查电话号码，如果为11位数字返回true，否则false
     */
    public static boolean checkPhoneNumber(String phoneNumber) {
        String regex = "[0-9]{11}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        boolean b = matcher.matches();
        return b;
    }

    /**
     * 检查密码
     */
    public static boolean checkPassword(String password) {
        String regex = "[a-zA-Z0-9]{3,15}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        boolean b = matcher.matches();
        return b;
    }

    /**
     * 检查两个String是否内容相同
     */
    public static boolean checkEqual(String a, String b) {
        if (a.equals(b)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 检查手机号与验证码的map，如果不为空且为4位数数字返回true，否则返回false
     */
    public static boolean checkIdentifyingCode(Map<String, String> code, String phoneNumber) {
        if (code == null || code.isEmpty()) {
            return false;
        }
        String regex = "[0-9]{6}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        boolean b = matcher.matches();
        Log.d("Check", "return" + b);
        return b;
    }

    /**
     * 得到一个String类型1000-10000之间的验证码
     */
    public static String getIdentifyingCode() {
        Random random = new Random();
        int randomInt = random.nextInt(9000) + 1000;
        return randomInt + "";
    }

    /**
     * 获取6位数字的随机数字符串
     *
     * @return
     */
    public static String getRandomData() {
        Random random = new Random();
        String strData = "";
        for (int i = 0; i < 6; i++) {
            int data = random.nextInt(10);
            strData = strData + data;
        }
        return strData;
    }

    /**
     * 获取APP下载URL的名字，flag为1，从最后一个“/”开始截取，flag为2，从最后一个"/"开始截取，加上.emp后缀
     */
    public static String getDownLoadURLAppName(String URL, int flag) {
        switch (flag) {
            case 1:
                return URL.substring(URL.lastIndexOf("/") + 1);
            case 2:
                // if (URL.contains("."))
                // {
                // return URL.substring(0, URL.lastIndexOf("."));
                return URL + ".tmp";
            // }
            // else
            // {
            // return URL;
            // }
        }

        return null;
    }

    public static int toPercentage(long current, long total) {
        double d = (double) current / total;
        return (int) (d * 100);
    }

    /**
     * 将秒数转换成X天X时X分X秒
     */
    public static String secondToTime(int second) {
        if (second <= 0) {
            return "剩余时间：0天0时0分0秒";
        } else {
            int d = second / 86400;
            int h = (second - d * 86400) / 3600;
            int m = (second - d * 86400 - h * 3600) / 60;
            int s = second - d * 86400 - h * 3600 - m * 60;
            return "剩余时间：" + d + "天" + h + "时" + m + "分" + s + "秒";
        }

    }

    /**
     * 检查文件长度，输入的mb大于fileLength返回true，否则false
     */
    public static boolean checkFileLength(long fileLength, int mb) {
        if (mb * 1024 * 1024 > fileLength) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * 获取版本号
     */
    public static String getVersionCode(Context context) {
        // 获取packagemanager的实例
        PackageManager packageManager = context.getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = null;
        try {
            packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String version = packInfo.versionCode + "";
        return version;
    }

    /**
     * 将已下载的和总字节转换成"已下载的兆数/总兆数"
     */
    public static String toCurrentMBAndTotalMB(Context context, long current, long total) {
        StringBuffer mBuffer = new StringBuffer();
        mBuffer.append(Formatter.formatFileSize(context, current)).append("/")
                .append(Formatter.formatFileSize(context, total));
        return mBuffer.toString();
    }

    /**
     * 获取版本名
     */
    public static String getVersionName(Context context) {
        // 获取packagemanager的实例
        PackageManager packageManager = context.getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = null;
        try {
            packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String version = packInfo.versionName + "";
        return version;
    }

    /**
     * dp转px
     */
    public static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal,
                context.getResources().getDisplayMetrics());
    }

    /**
     * px转dp
     */
    public static float px2dp(Context context, float pxVal) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (pxVal / scale);
    }

    /**
     * 替换掉String类型最后一位字符
     */
    public static String replaceLastChar(String str, String replaceStr) {
        String mString = "";
        if (str.length() > 0) {
            mString = str.substring(0, str.length() - 1);
        }
        return mString + replaceStr;
    }

    /**
     * 判断内容后是否是空的
     */
    public static boolean checkTextIsEmpty(String str) {
        if (null != str && str.length() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断WIFI是否是开启状态
     *
     * @param context
     * @return wifi开启为true, 反之false
     */
    public static boolean getWifiIsOpen(Context context) {
        WifiManager mWifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        boolean b;
        switch (mWifiManager.getWifiState()) {
            case WifiManager.WIFI_STATE_DISABLED:// 关闭
                b = false;
                break;
            case WifiManager.WIFI_STATE_DISABLING:// 正在关闭
                b = false;
                break;
            case WifiManager.WIFI_STATE_ENABLED:// 开启
                b = true;
                break;
            case WifiManager.WIFI_STATE_ENABLING:// 正在开启
                b = false;
                break;
            case WifiManager.WIFI_STATE_UNKNOWN:// 未知
                b = true;
                break;
            default:
                b = true;
                break;
        }
        return b;
    }

    /**
     * 在TextView的原text替换掉@content0、content1...实参已传入数组
     *
     * @param tv
     * @param strings
     */
    public static void insertTextInTextView(TextView tv, String... strings) {
        if (null == tv) {
            return;
        }
        String str = tv.getText().toString();
        StringBuffer mBuffer = new StringBuffer(str);
        for (int i = 0; i < strings.length; i++) {
            String contentStr = "@content" + i;
            int startIndex = mBuffer.indexOf(contentStr);
            mBuffer.replace(startIndex, startIndex + contentStr.length(), strings[i]);
        }
        tv.setText(mBuffer.toString());
    }

    /**
     * 实参传入String，Sring中的@content0、content1,被传入的实参String数据替换，并设到置TextView的text
     *
     * @param mTextView
     * @param content
     * @param strings
     */
    public static void insertTextInRes(TextView mTextView, String content, String... strings) {
        if (null == mTextView || null == content || null == strings) {
            return;
        }
        StringBuffer mBuffer = new StringBuffer(content);
        Log.d("Check", "content:" + content + "   strings length：" + strings.length);
        for (int i = 0; i < strings.length; i++) {
            String contentStr = "@content" + i;
            int startIndex = mBuffer.indexOf(contentStr);
            mBuffer.replace(startIndex, startIndex + contentStr.length(), strings[i]);
        }
        mTextView.setText(mBuffer.toString());
    }

    /**
     * 实参传入String，Sring中的@content0、content1,被传入的实参String数据替换，并设到置TextView的text
     *
     * @param mTextView
     * @param content
     * @param strings
     */
    public static void insertTextInRes2(TextView mTextView, String content, String... strings) {
        if (null == mTextView || null == content || null == strings) {
            return;
        }
        StringBuffer mBuffer = new StringBuffer(content);
        for (int i = 0; i < strings.length; i++) {
            String contentStr = "content" + i;
            int startIndex = mBuffer.indexOf(contentStr);
            mBuffer.replace(startIndex, startIndex + contentStr.length(), strings[i]);
        }
        mTextView.setText(mBuffer.toString());
    }

    /**
     * 流量包信息字段拼接
     *
     * @param context
     * @param packageCycle
     * @param packageFlow
     * @param packageTime
     * @param packagePrice
     * @return
     */
    public static String appendFlowInfo(Context context, String packageCycle, int packageFlow, int packageTime, int packagePrice) {
        StringBuffer mBuffer = new StringBuffer();
        String dateUnit = null;
        switch (packageCycle) {

            case "DAY":
                dateUnit = "天";
                break;

            case "WEEK":
                dateUnit = "星期";
                break;

            case "MONTH":
                dateUnit = "月";
                break;

            case "YEAR":
                dateUnit = "年";
                break;
        }
        int flow = packageFlow / 1024;
        String units = null;
        if (flow / 1024 > 1) {
            flow = flow / 1024;
            units = "G";
        } else {
            units = "M";
        }
        mBuffer.append(packageTime).append("个").append(dateUnit).append("  ").append(Formatter.formatFileSize(context, packageFlow * 1024l))
                .append("  ").append(packagePrice).append("元");
        return mBuffer.toString();
    }
}
