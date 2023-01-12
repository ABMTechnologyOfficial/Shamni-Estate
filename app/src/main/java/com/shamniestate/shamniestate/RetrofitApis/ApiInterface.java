package com.shamniestate.shamniestate.RetrofitApis;

import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.login_check;

import com.shamniestate.shamniestate.models.LoginModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST(login_check)
    Call<LoginModel> login (
            @Field("email") String email,
            @Field("password") String password
    );

}
