package com.shamniestate.shamniestate.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.bumptech.glide.load.model.ModelLoader;
import com.shamniestate.shamniestate.ui.auth.LoginActivity;

public class Session extends Object {

    private static final String PREF_NAME = "Rapidine_pref2";
    private static final String IS_LOGGEDIN = "isLoggedIn";
    private static final String ACCESS_TOKEN = "ACCESS_TOKEN";
    private static final String FAV = "fav";
    private static final String Mobile = "mobile";
    private static final String Email = "email";
    private static final String UserId = "user_id";
    private static final String User_name = "user_name";
    private static final String profileImage = "profile_img";
    private static final String role_ = "user_role";
    private static final String SearchMode = "SearchMode";
    private static final String LOGEDIN = "logedIn";
    private static final String LOGEDOUT = "logedout";
    private static final String aadhar_front_image = "aadhar_front_image";
    private static final String aadhar_back_image = "aadhar_front_image";
    private static final String pan_image = "pan_image";
    private static final String cancel_cheque_image = "cancel_cheque_image";
    private static final Object user_profile = "user_profile";
    private static final String user_invite_code = "user_invite_code";
    private static final String user_type = "user_type";

    private Context _context;
    private SharedPreferences Rapidine_pref;
    private SharedPreferences.Editor editor;

    public Session(Context context) {
        this._context = context;
        Rapidine_pref = _context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = Rapidine_pref.edit();
        editor.apply();
    }


    public void setMobile(String mobile) {
        editor.putString(Mobile, mobile);
        editor.apply();
        editor.commit();
    }

    public void setProfileImage(String mobile) {
        editor.putString(profileImage, mobile);
        editor.apply();
        editor.commit();
    }

    public String getSearch() {
        return Rapidine_pref.getString(SearchMode, "");
    }

    public String getProfileImage() {
        return Rapidine_pref.getString(profileImage, "");
    }

    public void setSearch(String search) {
        editor.putString(SearchMode, search);
        editor.apply();
        editor.commit();
    }

    public void setEmail(String em) {
        editor.putString(Email, em);
        editor.apply();
        editor.commit();
    }


    public void setUserInviteCode(String search) {
        editor.putString(user_invite_code, search);
        editor.apply();
        editor.commit();
    }

    public void setUserType(String search) {
        editor.putString(user_type, search);
        editor.apply();
        editor.commit();
    }


    public String getUserInviteCode() {
        return Rapidine_pref.getString(user_invite_code, "");
    }

    public String getUserIType() {
        return Rapidine_pref.getString(user_type, "");
    }

    public String getMobile() {
        return Rapidine_pref.getString(Mobile, "");

    }

    public String getUserName() {
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

    public String getRole() {
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

    public void setAccessToken(String accessToken) {
        editor.putString(ACCESS_TOKEN, accessToken);
        editor.commit();
    }


    public String getAadhar_front_image() {
        return Rapidine_pref.getString(aadhar_front_image, "");
    }

    public String getCancel_cheque_image() {
        return Rapidine_pref.getString(cancel_cheque_image, "");
    }

    public String getAadhar_back_image() {
        return Rapidine_pref.getString(aadhar_back_image, "");
    }

    public String getPan_image() {
        return Rapidine_pref.getString(pan_image, "");
    }


    public String getAccessToken() {
        return Rapidine_pref.getString(ACCESS_TOKEN, "");
    }

    public boolean isLoggedIn() {
        return Rapidine_pref.getBoolean(IS_LOGGEDIN, false);
    }

    public void setValue(String key, String value) {
        editor.putString(key, value);
        editor.apply();
    }

    public String getValue(String key) {
        return Rapidine_pref.getString(key, "");
    }

    public void logout() {
        editor.clear();
        editor.apply();
        Intent showLogin = new Intent(_context, LoginActivity.class);
        showLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        showLogin.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(showLogin);
    }

}
