package com.shamniestate.shamniestate.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PropertyPlanModel {
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("Data")
    @Expose
    private List<PropertyPlanData> data = null;

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

    public List<PropertyPlanData> getData() {
        return data;
    }

    public void setData(List<PropertyPlanData> data) {
        this.data = data;
    }

    public  class  PropertyPlanData{

        boolean isSelected =false ;

        @SerializedName("property_plan")
        @Expose
        private Integer propertyPlan;
        @SerializedName("property_plan_name")
        @Expose
        private String propertyPlanName;

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }

        public Integer getPropertyPlan() {
            return propertyPlan;
        }

        public void setPropertyPlan(Integer propertyPlan) {
            this.propertyPlan = propertyPlan;
        }

        public String getPropertyPlanName() {
            return propertyPlanName;
        }

        public void setPropertyPlanName(String propertyPlanName) {
            this.propertyPlanName = propertyPlanName;
        }
    }
}
