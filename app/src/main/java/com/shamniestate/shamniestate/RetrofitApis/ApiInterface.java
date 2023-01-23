package com.shamniestate.shamniestate.RetrofitApis;

import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.admin_bank_list;
import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.amenities_list;
import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.city_list;
import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.forgot_password;
import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.get_profile;
import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.login_check;
import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.my_associates;
import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.new_visitor;
import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.property_details;
import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.property_list;
import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.property_plan;
import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.property_type;
import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.register_form;

import com.shamniestate.shamniestate.models.AmenitiesListModel;
import com.shamniestate.shamniestate.models.AppDetailsModel;
import com.shamniestate.shamniestate.models.BankListModel;
import com.shamniestate.shamniestate.models.CityListModel;
import com.shamniestate.shamniestate.models.LoginModel;
import com.shamniestate.shamniestate.models.MyAssociateModel;
import com.shamniestate.shamniestate.models.PropertyDetailsModel;
import com.shamniestate.shamniestate.models.PropertyModel;
import com.shamniestate.shamniestate.models.PropertyPlanModel;
import com.shamniestate.shamniestate.models.PropertyTypeModel;
import com.shamniestate.shamniestate.models.SignupModel;
import com.shamniestate.shamniestate.models.UserProfileModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("app_block.php")
    Call<AppDetailsModel> getAppDetails(
            @Field("id") String id
    );


    @FormUrlEncoded
    @POST(login_check)
    Call<LoginModel> login(
            @Field("email") String email,
            @Field("password") String password,
            @Header("Authorization") String Authorization
    );

    @GET(admin_bank_list)
    Call<BankListModel> getBankList();

    @FormUrlEncoded
    @POST(property_list)
    Call<PropertyModel> getAllProperty(
            @Header("Authorization") String Authorization,
            @Field("city") String city
    );

    @FormUrlEncoded
    @POST(register_form)
    Call<SignupModel> signup(
            @Header("Authorization") String Authorization,
            @Field("account_type")String account_type ,
            @Field("working_type")String working_type ,
            @Field("associate_name")String associate_name,
            @Field("associate_dob")String associate_dob,
            @Field("associate_gender")String associate_gender,
            @Field("associate_mobile")String associate_mobile,
            @Field("associate_address")String associate_address,
            @Field("associate_city")String associate_city,
            @Field("associate_state")String associate_state,
            @Field("associate_city_zip")String associate_city_zip,
            @Field("associate_aadhar_card_no")String associate_aadhar_card_no,
            @Field("associate_pan_no")String associate_pan_no,
            @Field("associate_bank_name")String associate_bank_name,
            @Field("associate_acc_no")String associate_acc_no,
            @Field("associate_bnk_ifsc_no")String associate_bnk_ifsc_no,
            @Field("associate_bnk_acc_name")String associate_bnk_acc_name,
            @Field("associate_email")String associate_email,
            @Field("associate_pass")String associate_pass,
            @Field("associate_con_pass")String associate_con_pass,
            @Field("sponsor_id")String sponsor_id,
            @Field("terms_and_conditions")String terms_and_conditions,
            @Field("associate_rera_reg_no")String associate_rera_reg_no,
            @Field("associate_aadhar_card_front")String associate_aadhar_card_front,
            @Field("associate_aadhar_card_back")String associate_aadhar_card_back,
            @Field("associate_blank_cheque")String associate_blank_cheque,
            @Field("associate_pan_card_front")String associate_pan_card_front
    );


    @FormUrlEncoded
    @POST(forgot_password)
    Call<SignupModel> forgotPassword(
            @Field("associate_email") String associate_email
    );


    @FormUrlEncoded
    @POST(new_visitor)
    Call<SignupModel> newVisitor(
            @Field("associate_id") String associate_id,
            @Field("visitor_name") String visitor_name,
            @Field("visitor_mob") String visitor_mob,
            @Field("visitor_dob") String visitor_dob,
            @Field("visitor_dov") String visitor_dov,
            @Field("visitor_proffession") String visitor_proffession,
            @Field("visitor_email") String visitor_email,
            @Field("visitor_address") String visitor_address,
            @Field("visitor_city") String visitor_city,
            @Field("visitor_state") String visitor_state,
            @Field("visitor_city_code") String visitor_city_code,
            @Field("visitor_aadhar_card_no") String visitor_aadhar_card_no,
            @Field("visitor_budget") String visitor_budget,
            @Field("visitor_project_name") String visitor_project_name,
            @Field("visitor_project_code") String visitor_project_code,
            @Field("visitor_unit_no") String visitor_unit_no,
            @Field("visitor_aadhar_card_front") String visitor_aadhar_card_front,
            @Field("visitor_aadhar_card_back") String visitor_aadhar_card_back,
            @Field("visitor_selfie") String visitor_selfie
    );


    @GET(property_type)
    Call<PropertyTypeModel> getPropertyType(
            @Header("Access_Token") String Access_Token
    );

    @FormUrlEncoded
    @POST(property_details)
    Call<PropertyDetailsModel> getPropertyDetails(
            @Header("Authorization") String Authorization,
            @Header("Access_Token") String Access_Token,
//            @Header("Content-Type") String Content,
            @Field("property_id") String property_id
    );

    @GET(property_plan)
    Call<PropertyPlanModel> getPropertyPlan(
            @Header("Access_Token") String Access_Token
    );

    @GET(amenities_list)
    Call<AmenitiesListModel> getPropertyAmenities(
            @Header("Access_Token") String Access_Token
    );

   @GET(city_list)
    Call<CityListModel> getCityList(
            @Header("Access_Token") String Access_Token
    );

    @FormUrlEncoded
    @POST(get_profile)
    Call<UserProfileModel> getProfile(
            @Header("Authorization") String Access_Token,
            @Field("associate_id") String associate_id
    );

    @FormUrlEncoded
    @POST(my_associates)
    Call<MyAssociateModel> getMyAssociates(
            @Header("Access_Token") String Access_Token,
            @Field("associate_id") String associate_id
    );

}
