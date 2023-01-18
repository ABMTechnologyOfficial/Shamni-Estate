package com.shamniestate.shamniestate.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyAssociateModel {


    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("Data")
    @Expose
    private List<MyAssocData> data = null;

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

    public List<MyAssocData> getData() {
        return data;
    }

    public void setData(List<MyAssocData> data) {
        this.data = data;
    }

    public  class  MyAssocData{

        @SerializedName("associate_id")
        @Expose
        private String associateId;
        @SerializedName("associate_name")
        @Expose
        private String associateName;
        @SerializedName("associate_invite_code")
        @Expose
        private String associateInviteCode;
        @SerializedName("associate_email")
        @Expose
        private String associateEmail;
        @SerializedName("associate_mobile")
        @Expose
        private String associateMobile;
        @SerializedName("associate_city")
        @Expose
        private String associateCity;

        public String getAssociateId() {
            return associateId;
        }

        public void setAssociateId(String associateId) {
            this.associateId = associateId;
        }

        public String getAssociateName() {
            return associateName;
        }

        public void setAssociateName(String associateName) {
            this.associateName = associateName;
        }

        public String getAssociateInviteCode() {
            return associateInviteCode;
        }

        public void setAssociateInviteCode(String associateInviteCode) {
            this.associateInviteCode = associateInviteCode;
        }

        public String getAssociateEmail() {
            return associateEmail;
        }

        public void setAssociateEmail(String associateEmail) {
            this.associateEmail = associateEmail;
        }

        public String getAssociateMobile() {
            return associateMobile;
        }

        public void setAssociateMobile(String associateMobile) {
            this.associateMobile = associateMobile;
        }

        public String getAssociateCity() {
            return associateCity;
        }

        public void setAssociateCity(String associateCity) {
            this.associateCity = associateCity;
        }
    }
}
