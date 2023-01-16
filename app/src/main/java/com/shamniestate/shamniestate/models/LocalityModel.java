package com.shamniestate.shamniestate.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LocalityModel {


    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("Data")
    @Expose
    private List<LocalityData> data = null;

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

    public List<LocalityData> getData() {
        return data;
    }

    public void setData(List<LocalityData> data) {
        this.data = data;
    }

    public  class  LocalityData{

        @SerializedName("locality_name")
        @Expose
        private String localityName;
        @SerializedName("locality_id")
        @Expose
        private String localityId;

        public String getLocalityName() {
            return localityName;
        }

        public void setLocalityName(String localityName) {
            this.localityName = localityName;
        }

        public String getLocalityId() {
            return localityId;
        }

        public void setLocalityId(String localityId) {
            this.localityId = localityId;
        }
    }
}
