package com.shamniestate.shamniestate.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeSliderModel {

    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("Data")
    @Expose
    private List<HomeSliderData> data = null;

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

    public List<HomeSliderData> getData() {
        return data;
    }

    public void setData(List<HomeSliderData> data) {
        this.data = data;
    }

    public static class HomeSliderData{

        public HomeSliderData(Integer totalMembers) {
            this.totalMembers = totalMembers;
        }

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

    public  class  SliderCount{
        String count ;

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }
    }

}
