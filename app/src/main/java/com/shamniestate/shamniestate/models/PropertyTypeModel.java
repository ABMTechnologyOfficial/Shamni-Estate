package com.shamniestate.shamniestate.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PropertyTypeModel {

    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("Data")
    @Expose
    private List<PropertyTypeData> data = null;

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

    public List<PropertyTypeData> getData() {
        return data;
    }

    public void setData(List<PropertyTypeData> data) {
        this.data = data;
    }

    public  class  PropertyTypeData{

        boolean isSelected = false ;

        @SerializedName("property_type_name")
        @Expose
        private String propertyTypeName;
        @SerializedName("property_type_ids")
        @Expose
        private String propertyTypeIds;
        @SerializedName("property_type_master_id")
        @Expose
        private String propertyTypeMasterId;
        @SerializedName("property_type_master_name")
        @Expose
        private String propertyTypeMasterName;

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }

        public String getPropertyTypeName() {
            return propertyTypeName;
        }

        public void setPropertyTypeName(String propertyTypeName) {
            this.propertyTypeName = propertyTypeName;
        }

        public String getPropertyTypeIds() {
            return propertyTypeIds;
        }

        public void setPropertyTypeIds(String propertyTypeIds) {
            this.propertyTypeIds = propertyTypeIds;
        }

        public String getPropertyTypeMasterId() {
            return propertyTypeMasterId;
        }

        public void setPropertyTypeMasterId(String propertyTypeMasterId) {
            this.propertyTypeMasterId = propertyTypeMasterId;
        }

        public String getPropertyTypeMasterName() {
            return propertyTypeMasterName;
        }

        public void setPropertyTypeMasterName(String propertyTypeMasterName) {
            this.propertyTypeMasterName = propertyTypeMasterName;
        }
    }

}
