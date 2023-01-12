package com.shamniestate.shamniestate.RetrofitApis;

import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.admin_bank_list;
import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.login_check;

import com.shamniestate.shamniestate.models.BankListModel;
import com.shamniestate.shamniestate.models.LoginModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST(login_check)
    Call<LoginModel> login(
            @Field("email") String email,
            @Field("password") String password,
            @Header("Authorization") String Authorization
    );

    @GET(admin_bank_list)
    Call<BankListModel> getBankList();

}
