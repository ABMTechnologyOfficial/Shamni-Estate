package com.shamniestate.shamniestate.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookedPropertyModel {

    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("Data")
    @Expose
    private List<BookedPropertyData> data;

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

    public List<BookedPropertyData> getData() {
        return data;
    }

    public void setData(List<BookedPropertyData> data) {
        this.data = data;
    }

    public  class  BookedPropertyData{
        boolean isOpened = false ;

        @SerializedName("slot_id")
        @Expose
        private String slotId;
        @SerializedName("property_id")
        @Expose
        private String propertyId;
        @SerializedName("unit_id")
        @Expose
        private String unitId;
        @SerializedName("associate_id")
        @Expose
        private String associateId;
        @SerializedName("slot_no")
        @Expose
        private String slotNo;
        @SerializedName("slot_facing")
        @Expose
        private String slotFacing;
        @SerializedName("facing_charges")
        @Expose
        private String facingCharges;
        @SerializedName("slot_maintenance_charges")
        @Expose
        private String slotMaintenanceCharges;
        @SerializedName("slot_sell_type")
        @Expose
        private String slotSellType;
        @SerializedName("slot_hold_time")
        @Expose
        private String slotHoldTime;
        @SerializedName("applicant_name")
        @Expose
        private String applicantName;
        @SerializedName("applicant_dob")
        @Expose
        private String applicantDob;
        @SerializedName("applicant_family_name")
        @Expose
        private String applicantFamilyName;
        @SerializedName("applicant_contact_no")
        @Expose
        private String applicantContactNo;
        @SerializedName("applicant_contact_second_no")
        @Expose
        private String applicantContactSecondNo;
        @SerializedName("applicant_city")
        @Expose
        private String applicantCity;
        @SerializedName("applicant_state")
        @Expose
        private String applicantState;
        @SerializedName("applicant_city_pin")
        @Expose
        private String applicantCityPin;
        @SerializedName("applicant_permanent_add")
        @Expose
        private String applicantPermanentAdd;
        @SerializedName("applicant_current_add")
        @Expose
        private String applicantCurrentAdd;
        @SerializedName("applicant_pan_no")
        @Expose
        private String applicantPanNo;
        @SerializedName("applicant_email")
        @Expose
        private String applicantEmail;
        @SerializedName("property_code")
        @Expose
        private String propertyCode;
        @SerializedName("property_title")
        @Expose
        private String propertyTitle;
        @SerializedName("area_unit_type")
        @Expose
        private String areaUnitType;
        @SerializedName("property_type_id")
        @Expose
        private String propertyTypeId;
        @SerializedName("unit_img")
        @Expose
        private String unitImg;
        @SerializedName("unit_name")
        @Expose
        private String unitName;
        @SerializedName("unit_price")
        @Expose
        private String unitPrice;
        @SerializedName("unit_size")
        @Expose
        private String unitSize;
        @SerializedName("unit_size_price")
        @Expose
        private String unitSizePrice;
        @SerializedName("unit_size_type")
        @Expose
        private String unitSizeType;
        @SerializedName("property_type_name")
        @Expose
        private String propertyTypeName;

        public boolean isOpened() {
            return isOpened;
        }

        public void setOpened(boolean opened) {
            isOpened = opened;
        }

        public String getSlotId() {
            return slotId;
        }

        public void setSlotId(String slotId) {
            this.slotId = slotId;
        }

        public String getPropertyId() {
            return propertyId;
        }

        public void setPropertyId(String propertyId) {
            this.propertyId = propertyId;
        }

        public String getUnitId() {
            return unitId;
        }

        public void setUnitId(String unitId) {
            this.unitId = unitId;
        }

        public String getAssociateId() {
            return associateId;
        }

        public void setAssociateId(String associateId) {
            this.associateId = associateId;
        }

        public String getSlotNo() {
            return slotNo;
        }

        public void setSlotNo(String slotNo) {
            this.slotNo = slotNo;
        }

        public String getSlotFacing() {
            return slotFacing;
        }

        public void setSlotFacing(String slotFacing) {
            this.slotFacing = slotFacing;
        }

        public String getFacingCharges() {
            return facingCharges;
        }

        public void setFacingCharges(String facingCharges) {
            this.facingCharges = facingCharges;
        }

        public String getSlotMaintenanceCharges() {
            return slotMaintenanceCharges;
        }

        public void setSlotMaintenanceCharges(String slotMaintenanceCharges) {
            this.slotMaintenanceCharges = slotMaintenanceCharges;
        }

        public String getSlotSellType() {
            return slotSellType;
        }

        public void setSlotSellType(String slotSellType) {
            this.slotSellType = slotSellType;
        }

        public String getSlotHoldTime() {
            return slotHoldTime;
        }

        public void setSlotHoldTime(String slotHoldTime) {
            this.slotHoldTime = slotHoldTime;
        }

        public String getApplicantName() {
            return applicantName;
        }

        public void setApplicantName(String applicantName) {
            this.applicantName = applicantName;
        }

        public String getApplicantDob() {
            return applicantDob;
        }

        public void setApplicantDob(String applicantDob) {
            this.applicantDob = applicantDob;
        }

        public String getApplicantFamilyName() {
            return applicantFamilyName;
        }

        public void setApplicantFamilyName(String applicantFamilyName) {
            this.applicantFamilyName = applicantFamilyName;
        }

        public String getApplicantContactNo() {
            return applicantContactNo;
        }

        public void setApplicantContactNo(String applicantContactNo) {
            this.applicantContactNo = applicantContactNo;
        }

        public String getApplicantContactSecondNo() {
            return applicantContactSecondNo;
        }

        public void setApplicantContactSecondNo(String applicantContactSecondNo) {
            this.applicantContactSecondNo = applicantContactSecondNo;
        }

        public String getApplicantCity() {
            return applicantCity;
        }

        public void setApplicantCity(String applicantCity) {
            this.applicantCity = applicantCity;
        }

        public String getApplicantState() {
            return applicantState;
        }

        public void setApplicantState(String applicantState) {
            this.applicantState = applicantState;
        }

        public String getApplicantCityPin() {
            return applicantCityPin;
        }

        public void setApplicantCityPin(String applicantCityPin) {
            this.applicantCityPin = applicantCityPin;
        }

        public String getApplicantPermanentAdd() {
            return applicantPermanentAdd;
        }

        public void setApplicantPermanentAdd(String applicantPermanentAdd) {
            this.applicantPermanentAdd = applicantPermanentAdd;
        }

        public String getApplicantCurrentAdd() {
            return applicantCurrentAdd;
        }

        public void setApplicantCurrentAdd(String applicantCurrentAdd) {
            this.applicantCurrentAdd = applicantCurrentAdd;
        }

        public String getApplicantPanNo() {
            return applicantPanNo;
        }

        public void setApplicantPanNo(String applicantPanNo) {
            this.applicantPanNo = applicantPanNo;
        }

        public String getApplicantEmail() {
            return applicantEmail;
        }

        public void setApplicantEmail(String applicantEmail) {
            this.applicantEmail = applicantEmail;
        }

        public String getPropertyCode() {
            return propertyCode;
        }

        public void setPropertyCode(String propertyCode) {
            this.propertyCode = propertyCode;
        }

        public String getPropertyTitle() {
            return propertyTitle;
        }

        public void setPropertyTitle(String propertyTitle) {
            this.propertyTitle = propertyTitle;
        }

        public String getAreaUnitType() {
            return areaUnitType;
        }

        public void setAreaUnitType(String areaUnitType) {
            this.areaUnitType = areaUnitType;
        }

        public String getPropertyTypeId() {
            return propertyTypeId;
        }

        public void setPropertyTypeId(String propertyTypeId) {
            this.propertyTypeId = propertyTypeId;
        }

        public String getUnitImg() {
            return unitImg;
        }

        public void setUnitImg(String unitImg) {
            this.unitImg = unitImg;
        }

        public String getUnitName() {
            return unitName;
        }

        public void setUnitName(String unitName) {
            this.unitName = unitName;
        }

        public String getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(String unitPrice) {
            this.unitPrice = unitPrice;
        }

        public String getUnitSize() {
            return unitSize;
        }

        public void setUnitSize(String unitSize) {
            this.unitSize = unitSize;
        }

        public String getUnitSizePrice() {
            return unitSizePrice;
        }

        public void setUnitSizePrice(String unitSizePrice) {
            this.unitSizePrice = unitSizePrice;
        }

        public String getUnitSizeType() {
            return unitSizeType;
        }

        public void setUnitSizeType(String unitSizeType) {
            this.unitSizeType = unitSizeType;
        }

        public String getPropertyTypeName() {
            return propertyTypeName;
        }

        public void setPropertyTypeName(String propertyTypeName) {
            this.propertyTypeName = propertyTypeName;
        }
    }


}
