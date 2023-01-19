package com.shamniestate.shamniestate.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserProfileModel {


    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("Data")
    @Expose
    private ProfileData data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ProfileData getData() {
        return data;
    }

    public void setData(ProfileData data) {
        this.data = data;
    }

    public class ProfileData {
        @SerializedName("user_profile")
        @Expose
        private List<UserProfile> userProfile = null;

        public List<UserProfile> getUserProfile() {
            return userProfile;
        }

        public void setUserProfile(List<UserProfile> userProfile) {
            this.userProfile = userProfile;
        }


        public class UserProfile {

            @SerializedName("associate_id")
            @Expose
            private String associateId;
            @SerializedName("account_type")
            @Expose
            private String accountType;
            @SerializedName("working_type")
            @Expose
            private String workingType;
            @SerializedName("associate_profile")
            @Expose
            private String associateProfile;
            @SerializedName("associate_name")
            @Expose
            private String associateName;
            @SerializedName("associate_dob")
            @Expose
            private String associateDob;
            @SerializedName("associate_mobile")
            @Expose
            private String associateMobile;
            @SerializedName("associate_otp")
            @Expose
            private String associateOtp;
            @SerializedName("associate_address")
            @Expose
            private String associateAddress;
            @SerializedName("associate_city")
            @Expose
            private String associateCity;
            @SerializedName("associate_state")
            @Expose
            private String associateState;
            @SerializedName("associate_city_zip")
            @Expose
            private String associateCityZip;
            @SerializedName("associate_email")
            @Expose
            private String associateEmail;
            @SerializedName("associate_aadhar_card_no")
            @Expose
            private String associateAadharCardNo;
            @SerializedName("associate_aadhar_card_front")
            @Expose
            private String associateAadharCardFront;
            @SerializedName("associate_aadhar_card_back")
            @Expose
            private String associateAadharCardBack;
            @SerializedName("associate_pan_no")
            @Expose
            private String associatePanNo;
            @SerializedName("associate_pan_card_front")
            @Expose
            private String associatePanCardFront;
            @SerializedName("associate_bank_name")
            @Expose
            private String associateBankName;
            @SerializedName("associate_acc_no")
            @Expose
            private String associateAccNo;
            @SerializedName("associate_bnk_ifsc_no")
            @Expose
            private String associateBnkIfscNo;
            @SerializedName("associate_bnk_acc_name")
            @Expose
            private String associateBnkAccName;
            @SerializedName("associate_gstin_no")
            @Expose
            private String associateGstinNo;
            @SerializedName("associate_rera_reg_no")
            @Expose
            private String associateReraRegNo;
            @SerializedName("associate_blank_cheque")
            @Expose
            private String associateBlankCheque;
            @SerializedName("associate_invite_code")
            @Expose
            private String associateInviteCode;
            @SerializedName("sponsor_id")
            @Expose
            private String sponsorId;
            @SerializedName("reset_link_token")
            @Expose
            private String resetLinkToken;
            @SerializedName("reset_exp_date")
            @Expose
            private String resetExpDate;
            @SerializedName("reset_otp_exp_date")
            @Expose
            private String resetOtpExpDate;
            @SerializedName("associate_mob_status")
            @Expose
            private String associateMobStatus;
            @SerializedName("associate_doc_status")
            @Expose
            private String associateDocStatus;
            @SerializedName("form_clearing_heading")
            @Expose
            private String formClearingHeading;
            @SerializedName("form_clearing_message")
            @Expose
            private String formClearingMessage;
            @SerializedName("associate_account_status")
            @Expose
            private String associateAccountStatus;
            @SerializedName("terms_and_conditions")
            @Expose
            private String termsAndConditions;
            @SerializedName("privacy_policy")
            @Expose
            private String privacyPolicy;
            @SerializedName("join_type")
            @Expose
            private String joinType;
            @SerializedName("access_token")
            @Expose
            private String accessToken;
            @SerializedName("token_validity")
            @Expose
            private String tokenValidity;
            @SerializedName("created")
            @Expose
            private String created;
            @SerializedName("associate_gender")
            @Expose
            private String associateGender;

            public String getAssociateId() {
                return associateId;
            }

            public void setAssociateId(String associateId) {
                this.associateId = associateId;
            }

            public String getAccountType() {
                return accountType;
            }

            public void setAccountType(String accountType) {
                this.accountType = accountType;
            }

            public String getWorkingType() {
                return workingType;
            }

            public void setWorkingType(String workingType) {
                this.workingType = workingType;
            }

            public String getAssociateProfile() {
                return associateProfile;
            }

            public void setAssociateProfile(String associateProfile) {
                this.associateProfile = associateProfile;
            }

            public String getAssociateName() {
                return associateName;
            }

            public void setAssociateName(String associateName) {
                this.associateName = associateName;
            }

            public String getAssociateDob() {
                return associateDob;
            }

            public void setAssociateDob(String associateDob) {
                this.associateDob = associateDob;
            }

            public String getAssociateMobile() {
                return associateMobile;
            }

            public void setAssociateMobile(String associateMobile) {
                this.associateMobile = associateMobile;
            }

            public String getAssociateOtp() {
                return associateOtp;
            }

            public void setAssociateOtp(String associateOtp) {
                this.associateOtp = associateOtp;
            }

            public String getAssociateAddress() {
                return associateAddress;
            }

            public void setAssociateAddress(String associateAddress) {
                this.associateAddress = associateAddress;
            }

            public String getAssociateCity() {
                return associateCity;
            }

            public void setAssociateCity(String associateCity) {
                this.associateCity = associateCity;
            }

            public String getAssociateState() {
                return associateState;
            }

            public void setAssociateState(String associateState) {
                this.associateState = associateState;
            }

            public String getAssociateCityZip() {
                return associateCityZip;
            }

            public void setAssociateCityZip(String associateCityZip) {
                this.associateCityZip = associateCityZip;
            }

            public String getAssociateEmail() {
                return associateEmail;
            }

            public void setAssociateEmail(String associateEmail) {
                this.associateEmail = associateEmail;
            }

            public String getAssociateAadharCardNo() {
                return associateAadharCardNo;
            }

            public void setAssociateAadharCardNo(String associateAadharCardNo) {
                this.associateAadharCardNo = associateAadharCardNo;
            }

            public String getAssociateAadharCardFront() {
                return associateAadharCardFront;
            }

            public void setAssociateAadharCardFront(String associateAadharCardFront) {
                this.associateAadharCardFront = associateAadharCardFront;
            }

            public String getAssociateAadharCardBack() {
                return associateAadharCardBack;
            }

            public void setAssociateAadharCardBack(String associateAadharCardBack) {
                this.associateAadharCardBack = associateAadharCardBack;
            }

            public String getAssociatePanNo() {
                return associatePanNo;
            }

            public void setAssociatePanNo(String associatePanNo) {
                this.associatePanNo = associatePanNo;
            }

            public String getAssociatePanCardFront() {
                return associatePanCardFront;
            }

            public void setAssociatePanCardFront(String associatePanCardFront) {
                this.associatePanCardFront = associatePanCardFront;
            }

            public String getAssociateBankName() {
                return associateBankName;
            }

            public void setAssociateBankName(String associateBankName) {
                this.associateBankName = associateBankName;
            }

            public String getAssociateAccNo() {
                return associateAccNo;
            }

            public void setAssociateAccNo(String associateAccNo) {
                this.associateAccNo = associateAccNo;
            }

            public String getAssociateBnkIfscNo() {
                return associateBnkIfscNo;
            }

            public void setAssociateBnkIfscNo(String associateBnkIfscNo) {
                this.associateBnkIfscNo = associateBnkIfscNo;
            }

            public String getAssociateBnkAccName() {
                return associateBnkAccName;
            }

            public void setAssociateBnkAccName(String associateBnkAccName) {
                this.associateBnkAccName = associateBnkAccName;
            }

            public String getAssociateGstinNo() {
                return associateGstinNo;
            }

            public void setAssociateGstinNo(String associateGstinNo) {
                this.associateGstinNo = associateGstinNo;
            }

            public String getAssociateReraRegNo() {
                return associateReraRegNo;
            }

            public void setAssociateReraRegNo(String associateReraRegNo) {
                this.associateReraRegNo = associateReraRegNo;
            }

            public String getAssociateBlankCheque() {
                return associateBlankCheque;
            }

            public void setAssociateBlankCheque(String associateBlankCheque) {
                this.associateBlankCheque = associateBlankCheque;
            }

            public String getAssociateInviteCode() {
                return associateInviteCode;
            }

            public void setAssociateInviteCode(String associateInviteCode) {
                this.associateInviteCode = associateInviteCode;
            }

            public String getSponsorId() {
                return sponsorId;
            }

            public void setSponsorId(String sponsorId) {
                this.sponsorId = sponsorId;
            }

            public String getResetLinkToken() {
                return resetLinkToken;
            }

            public void setResetLinkToken(String resetLinkToken) {
                this.resetLinkToken = resetLinkToken;
            }

            public String getResetExpDate() {
                return resetExpDate;
            }

            public void setResetExpDate(String resetExpDate) {
                this.resetExpDate = resetExpDate;
            }

            public String getResetOtpExpDate() {
                return resetOtpExpDate;
            }

            public void setResetOtpExpDate(String resetOtpExpDate) {
                this.resetOtpExpDate = resetOtpExpDate;
            }

            public String getAssociateMobStatus() {
                return associateMobStatus;
            }

            public void setAssociateMobStatus(String associateMobStatus) {
                this.associateMobStatus = associateMobStatus;
            }

            public String getAssociateDocStatus() {
                return associateDocStatus;
            }

            public void setAssociateDocStatus(String associateDocStatus) {
                this.associateDocStatus = associateDocStatus;
            }

            public String getFormClearingHeading() {
                return formClearingHeading;
            }

            public void setFormClearingHeading(String formClearingHeading) {
                this.formClearingHeading = formClearingHeading;
            }

            public String getFormClearingMessage() {
                return formClearingMessage;
            }

            public void setFormClearingMessage(String formClearingMessage) {
                this.formClearingMessage = formClearingMessage;
            }

            public String getAssociateAccountStatus() {
                return associateAccountStatus;
            }

            public void setAssociateAccountStatus(String associateAccountStatus) {
                this.associateAccountStatus = associateAccountStatus;
            }

            public String getTermsAndConditions() {
                return termsAndConditions;
            }

            public void setTermsAndConditions(String termsAndConditions) {
                this.termsAndConditions = termsAndConditions;
            }

            public String getPrivacyPolicy() {
                return privacyPolicy;
            }

            public void setPrivacyPolicy(String privacyPolicy) {
                this.privacyPolicy = privacyPolicy;
            }

            public String getJoinType() {
                return joinType;
            }

            public void setJoinType(String joinType) {
                this.joinType = joinType;
            }

            public String getAccessToken() {
                return accessToken;
            }

            public void setAccessToken(String accessToken) {
                this.accessToken = accessToken;
            }

            public String getTokenValidity() {
                return tokenValidity;
            }

            public void setTokenValidity(String tokenValidity) {
                this.tokenValidity = tokenValidity;
            }

            public String getCreated() {
                return created;
            }

            public void setCreated(String created) {
                this.created = created;
            }

            public String getAssociateGender() {
                return associateGender;
            }

            public void setAssociateGender(String associateGender) {
                this.associateGender = associateGender;
            }


        }
    }

}


