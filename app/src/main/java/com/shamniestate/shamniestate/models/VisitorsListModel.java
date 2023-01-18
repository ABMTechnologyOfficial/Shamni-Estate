package com.shamniestate.shamniestate.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VisitorsListModel {

    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("Data")
    @Expose
    private List<VisitorListData> data = null;

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

    public List<VisitorListData> getData() {
        return data;
    }

    public void setData(List<VisitorListData> data) {
        this.data = data;
    }
    public  class  VisitorListData{

        @SerializedName("visitor_id")
        @Expose
        private String visitorId;
        @SerializedName("visitor_name")
        @Expose
        private String visitorName;
        @SerializedName("visitor_dov")
        @Expose
        private String visitorDov;
        @SerializedName("visitor_mob")
        @Expose
        private String visitorMob;
        @SerializedName("visitor_email")
        @Expose
        private String visitorEmail;

        public String getVisitorId() {
            return visitorId;
        }

        public void setVisitorId(String visitorId) {
            this.visitorId = visitorId;
        }

        public String getVisitorName() {
            return visitorName;
        }

        public void setVisitorName(String visitorName) {
            this.visitorName = visitorName;
        }

        public String getVisitorDov() {
            return visitorDov;
        }

        public void setVisitorDov(String visitorDov) {
            this.visitorDov = visitorDov;
        }

        public String getVisitorMob() {
            return visitorMob;
        }

        public void setVisitorMob(String visitorMob) {
            this.visitorMob = visitorMob;
        }

        public String getVisitorEmail() {
            return visitorEmail;
        }

        public void setVisitorEmail(String visitorEmail) {
            this.visitorEmail = visitorEmail;
        }

    }
}
