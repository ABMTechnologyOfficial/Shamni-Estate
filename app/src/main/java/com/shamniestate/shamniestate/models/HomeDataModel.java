package com.shamniestate.shamniestate.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeDataModel {

    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("Data")
    @Expose
    private List<HomeData> data = null;

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

    public List<HomeData> getData() {
        return data;
    }

    public void setData(List<HomeData> data) {
        this.data = data;
    }

    public  class  HomeData{

        @SerializedName("Total Members")
        @Expose
        private Integer totalMembers;
        @SerializedName("Hold Property")
        @Expose
        private Integer holdProperty;
        @SerializedName("Booked Property")
        @Expose
        private Integer bookedProperty;

        public Integer getTotalMembers() {
            return totalMembers;
        }

        public void setTotalMembers(Integer totalMembers) {
            this.totalMembers = totalMembers;
        }

        public Integer getHoldProperty() {
            return holdProperty;
        }

        public void setHoldProperty(Integer holdProperty) {
            this.holdProperty = holdProperty;
        }

        public Integer getBookedProperty() {
            return bookedProperty;
        }

        public void setBookedProperty(Integer bookedProperty) {
            this.bookedProperty = bookedProperty;
        }
    }
}
