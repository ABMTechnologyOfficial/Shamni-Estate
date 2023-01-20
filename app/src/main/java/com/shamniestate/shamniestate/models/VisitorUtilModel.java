package com.shamniestate.shamniestate.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class VisitorUtilModel implements Serializable {



    @SerializedName("visitor_id")
    @Expose
    private String visitorId;
    @SerializedName("associate_id")
    @Expose
    private String associateId;
    @SerializedName("visitor_name")
    @Expose
    private String visitorName;
    @SerializedName("visitor_mob")
    @Expose
    private String visitorMob;
    @SerializedName("visitor_dob")
    @Expose
    private String visitorDob;
    @SerializedName("visitor_dov")
    @Expose
    private String visitorDov;
    @SerializedName("visitor_proffession")
    @Expose
    private String visitorProffession;
    @SerializedName("visitor_email")
    @Expose
    private String visitorEmail;
    @SerializedName("visitor_address")
    @Expose
    private String visitorAddress;
    @SerializedName("visitor_city")
    @Expose
    private String visitorCity;
    @SerializedName("visitor_state")
    @Expose
    private String visitorState;
    @SerializedName("visitor_city_code")
    @Expose
    private String visitorCityCode;
    @SerializedName("visitor_aadhar_card_no")
    @Expose
    private String visitorAadharCardNo;
    @SerializedName("visitor_aadhar_card_front")
    @Expose
    private String visitorAadharCardFront;
    @SerializedName("visitor_aadhar_card_back")
    @Expose
    private String visitorAadharCardBack;
    @SerializedName("visitor_budget")
    @Expose
    private String visitorBudget;
    @SerializedName("visitor_project_name")
    @Expose
    private String visitorProjectName;
    @SerializedName("visitor_project_code")
    @Expose
    private String visitorProjectCode;
    @SerializedName("visitor_unit_no")
    @Expose
    private String visitorUnitNo;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("visitor_selfie")
    @Expose
    private String visitorSelfie;
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
    @SerializedName("associate_gender")
    @Expose
    private String associateGender;
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
    @SerializedName("associate_pass")
    @Expose
    private String associatePass;
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

    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getAssociateId() {
        return associateId;
    }

    public void setAssociateId(String associateId) {
        this.associateId = associateId;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorMob() {
        return visitorMob;
    }

    public void setVisitorMob(String visitorMob) {
        this.visitorMob = visitorMob;
    }

    public String getVisitorDob() {
        return visitorDob;
    }

    public void setVisitorDob(String visitorDob) {
        this.visitorDob = visitorDob;
    }

    public String getVisitorDov() {
        return visitorDov;
    }

    public void setVisitorDov(String visitorDov) {
        this.visitorDov = visitorDov;
    }

    public String getVisitorProffession() {
        return visitorProffession;
    }

    public void setVisitorProffession(String visitorProffession) {
        this.visitorProffession = visitorProffession;
    }

    public String getVisitorEmail() {
        return visitorEmail;
    }

    public void setVisitorEmail(String visitorEmail) {
        this.visitorEmail = visitorEmail;
    }

    public String getVisitorAddress() {
        return visitorAddress;
    }

    public void setVisitorAddress(String visitorAddress) {
        this.visitorAddress = visitorAddress;
    }

    public String getVisitorCity() {
        return visitorCity;
    }

    public void setVisitorCity(String visitorCity) {
        this.visitorCity = visitorCity;
    }

    public String getVisitorState() {
        return visitorState;
    }

    public void setVisitorState(String visitorState) {
        this.visitorState = visitorState;
    }

    public String getVisitorCityCode() {
        return visitorCityCode;
    }

    public void setVisitorCityCode(String visitorCityCode) {
        this.visitorCityCode = visitorCityCode;
    }

    public String getVisitorAadharCardNo() {
        return visitorAadharCardNo;
    }

    public void setVisitorAadharCardNo(String visitorAadharCardNo) {
        this.visitorAadharCardNo = visitorAadharCardNo;
    }

    public String getVisitorAadharCardFront() {
        return visitorAadharCardFront;
    }

    public void setVisitorAadharCardFront(String visitorAadharCardFront) {
        this.visitorAadharCardFront = visitorAadharCardFront;
    }

    public String getVisitorAadharCardBack() {
        return visitorAadharCardBack;
    }

    public void setVisitorAadharCardBack(String visitorAadharCardBack) {
        this.visitorAadharCardBack = visitorAadharCardBack;
    }

    public String getVisitorBudget() {
        return visitorBudget;
    }

    public void setVisitorBudget(String visitorBudget) {
        this.visitorBudget = visitorBudget;
    }

    public String getVisitorProjectName() {
        return visitorProjectName;
    }

    public void setVisitorProjectName(String visitorProjectName) {
        this.visitorProjectName = visitorProjectName;
    }

    public String getVisitorProjectCode() {
        return visitorProjectCode;
    }

    public void setVisitorProjectCode(String visitorProjectCode) {
        this.visitorProjectCode = visitorProjectCode;
    }

    public String getVisitorUnitNo() {
        return visitorUnitNo;
    }

    public void setVisitorUnitNo(String visitorUnitNo) {
        this.visitorUnitNo = visitorUnitNo;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getVisitorSelfie() {
        return visitorSelfie;
    }

    public void setVisitorSelfie(String visitorSelfie) {
        this.visitorSelfie = visitorSelfie;
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


    public String getAssociateOtp() {
        return associateOtp;
    }

    public void setAssociateOtp(String associateOtp) {
        this.associateOtp = associateOtp;
    }

    public String getAssociatePass() {
        return associatePass;
    }

    public void setAssociatePass(String associatePass) {
        this.associatePass = associatePass;
    }




    public String getAssociateGstinNo() {
        return associateGstinNo;
    }

    public void setAssociateGstinNo(String associateGstinNo) {
        this.associateGstinNo = associateGstinNo;
    }



    public void setAssociateReraRegNo(String associateReraRegNo) {
        this.associateReraRegNo = associateReraRegNo;
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


    public String getTokenValidity() {
        return tokenValidity;
    }

    public void setTokenValidity(String tokenValidity) {
        this.tokenValidity = tokenValidity;
    }

    @Override
    public String toString() {
        return "VisitorUtilModel{" +
                "visitorId='" + visitorId + '\'' +
                ", associateId='" + associateId + '\'' +
                ", visitorName='" + visitorName + '\'' +
                ", visitorMob='" + visitorMob + '\'' +
                ", visitorDob='" + visitorDob + '\'' +
                ", visitorDov='" + visitorDov + '\'' +
                ", visitorProffession='" + visitorProffession + '\'' +
                ", visitorEmail='" + visitorEmail + '\'' +
                ", visitorAddress='" + visitorAddress + '\'' +
                ", visitorCity='" + visitorCity + '\'' +
                ", visitorState='" + visitorState + '\'' +
                ", visitorCityCode='" + visitorCityCode + '\'' +
                ", visitorAadharCardNo='" + visitorAadharCardNo + '\'' +
                ", visitorAadharCardFront='" + visitorAadharCardFront + '\'' +
                ", visitorAadharCardBack='" + visitorAadharCardBack + '\'' +
                ", visitorBudget='" + visitorBudget + '\'' +
                ", visitorProjectName='" + visitorProjectName + '\'' +
                ", visitorProjectCode='" + visitorProjectCode + '\'' +
                ", visitorUnitNo='" + visitorUnitNo + '\'' +
                ", created='" + created + '\'' +
                ", visitorSelfie='" + visitorSelfie + '\'' +
                ", accountType='" + accountType + '\'' +
                ", workingType='" + workingType + '\'' +
                ", associateProfile='" + associateProfile + '\'' +
                ", associateName='" + associateName + '\'' +
                ", associateGender='" + associateGender + '\'' +
                ", associateDob='" + associateDob + '\'' +
                ", associateMobile='" + associateMobile + '\'' +
                ", associateOtp='" + associateOtp + '\'' +
                ", associateAddress='" + associateAddress + '\'' +
                ", associateCity='" + associateCity + '\'' +
                ", associateState='" + associateState + '\'' +
                ", associateCityZip='" + associateCityZip + '\'' +
                ", associateEmail='" + associateEmail + '\'' +
                ", associatePass='" + associatePass + '\'' +
                ", associateAadharCardNo='" + associateAadharCardNo + '\'' +
                ", associateAadharCardFront='" + associateAadharCardFront + '\'' +
                ", associateAadharCardBack='" + associateAadharCardBack + '\'' +
                ", associatePanNo='" + associatePanNo + '\'' +
                ", associatePanCardFront='" + associatePanCardFront + '\'' +
                ", associateBankName='" + associateBankName + '\'' +
                ", associateAccNo='" + associateAccNo + '\'' +
                ", associateBnkIfscNo='" + associateBnkIfscNo + '\'' +
                ", associateBnkAccName='" + associateBnkAccName + '\'' +
                ", associateGstinNo='" + associateGstinNo + '\'' +
                ", associateReraRegNo='" + associateReraRegNo + '\'' +
                ", associateBlankCheque='" + associateBlankCheque + '\'' +
                ", associateInviteCode='" + associateInviteCode + '\'' +
                ", sponsorId='" + sponsorId + '\'' +
                ", resetLinkToken='" + resetLinkToken + '\'' +
                ", resetExpDate='" + resetExpDate + '\'' +
                ", resetOtpExpDate='" + resetOtpExpDate + '\'' +
                ", associateMobStatus='" + associateMobStatus + '\'' +
                ", associateDocStatus='" + associateDocStatus + '\'' +
                ", formClearingHeading='" + formClearingHeading + '\'' +
                ", formClearingMessage='" + formClearingMessage + '\'' +
                ", associateAccountStatus='" + associateAccountStatus + '\'' +
                ", termsAndConditions='" + termsAndConditions + '\'' +
                ", privacyPolicy='" + privacyPolicy + '\'' +
                ", joinType='" + joinType + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", tokenValidity='" + tokenValidity + '\'' +
                '}';
    }
}
