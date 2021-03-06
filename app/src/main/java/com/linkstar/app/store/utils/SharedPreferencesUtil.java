package com.linkstar.app.store.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by hx
 * Time 2018/12/13/013.
 */

public class SharedPreferencesUtil {

    // 设置账号的登陆状态
    public static void setLoginState(Context context, String token, Boolean is_login) {
        SharedPreferences sp = context.getSharedPreferences("mall_store_app", Context.MODE_PRIVATE);
        sp.edit().putString("token", token).commit();
        sp.edit().putBoolean("is_login", is_login).commit();
    }

    // 设置当前账号登录状态，用于退出账号或者切换账号
    public static void setLoginState(Context context, Boolean is_login) {
        SharedPreferences sp = context.getSharedPreferences("mall_store_app", Context.MODE_PRIVATE);
        sp.edit().putBoolean("is_login", is_login).commit();
    }

    // 获取前台登录账号的账号
    public static boolean getLoginState(Context context) {
        SharedPreferences sp = context.getSharedPreferences("mall_store_app", Context.MODE_PRIVATE);
        boolean isLogin = sp.getBoolean("is_login", false);
        return isLogin;
    }

    // 获取前台登录账号的账号
    public static String getToken(Context context) {
        SharedPreferences sp = context.getSharedPreferences("mall_store_app", Context.MODE_PRIVATE);
        String token = sp.getString("token", "");
        return token;
    }

}
