package com.shamniestate.shamniestate.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AmenitiesListModel {



    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("Data")
    @Expose
    private List<AmenitiesData> data = null;

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

    public List<AmenitiesData> getData() {
        return data;
    }

    public void setData(List<AmenitiesData> data) {
        this.data = data;
    }

    public  class  AmenitiesData{

        boolean isSelected = false ;

        @SerializedName("amenities_id")
        @Expose
        private String amenitiesId;
        @SerializedName("amenities_name")
        @Expose
        private String amenitiesName;
        @SerializedName("amenities_icon")
        @Expose
        private String amenitiesIcon;

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }

        public String getAmenitiesId() {
            return amenitiesId;
        }

        public void setAmenitiesId(String amenitiesId) {
            this.amenitiesId = amenitiesId;
        }

        public String getAmenitiesName() {
            return amenitiesName;
        }

        public void setAmenitiesName(String amenitiesName) {
            this.amenitiesName = amenitiesName;
        }

        public String getAmenitiesIcon() {
            return amenitiesIcon;
        }

        public void setAmenitiesIcon(String amenitiesIcon) {
            this.amenitiesIcon = amenitiesIcon;
        }

    }

}
