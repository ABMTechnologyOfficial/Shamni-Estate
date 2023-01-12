package com.shamniestate.shamniestate.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Session extends Object {

    private static final String PREF_NAME = "Rapidine_pref2";
    private static final String IS_LOGGEDIN = "isLoggedIn";
    private static final String FAV = "fav";
    private static final String Mobile = "mobile";
    private static final String Email = "email";
    private static final String UserId = "user_id";
    private static final String User_name = "user_name";
    private static final String Pro_Image = "pro_img";
    private static final String role_ = "user_role";
    private static final String LOGEDIN = "logedIn";
    private static final String LOGEDOUT = "logedout";

    private Context _context;
    private SharedPreferences Rapidine_pref;
    private SharedPreferences.Editor  editor;

    public Session(Context context) {
        this._context = context;
        Rapidine_pref = _context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = Rapidine_pref.edit();
        editor.apply();
    }

    public void setMobile(String mobile ) {
        editor.putString(Mobile, mobile);
       // editor.putString(Email, email);
        editor.apply();
        editor.commit();
    }

    public String getMobile() {
        return Rapidine_pref.getString(Mobile, "");

    }
    public  String getUserName() {
        return Rapidine_pref.getString(User_name, "");

    }
    public void setUserId(String userId) {
        editor.putString(UserId, userId);
        this.editor.apply();
    }

    public void setRole(String role) {
        editor.putString(role_, role);
        editor.apply();
        editor.commit();
    }

    public String getRole()
    {
        return Rapidine_pref.getString(role_, "");
    }

    public String getUserId() {
        return Rapidine_pref.getString(UserId, "");
    }

    public void setUserName(String user_name) {
        editor.putString(User_name, user_name);
        this.editor.apply();
    }

    public String getEmail() {
        return Rapidine_pref.getString(Email, "");
    }

    public void setLogin(boolean isLoggedIn) {
        editor.putBoolean(IS_LOGGEDIN, isLoggedIn);
        editor.commit();
    }

    public boolean isLoggedIn() {
        return Rapidine_pref.getBoolean(IS_LOGGEDIN, false);
    }


    public void setValue(String key, String value ){
        editor.putString(key,value);
        editor.apply();
    }


    public String getValue(String key) {
        return Rapidine_pref.getString(key, "");
    }

    public void setMyLogin (boolean tf) {
        editor.putBoolean(LOGEDIN,tf);
        editor.apply();

    }


    public boolean getMyLogin() {
        return Rapidine_pref.getBoolean(LOGEDIN, false);
    }

    public void setMyLogout (boolean tf) {
        editor.putBoolean(LOGEDOUT,tf);
        editor.clear();
        editor.apply();
    }
}
