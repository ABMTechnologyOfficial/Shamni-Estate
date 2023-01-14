package com.shamniestate.shamniestate.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PropertyModel {

    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("Count")
    @Expose
    private Integer count;
    @SerializedName("Data")
    @Expose
    private List<PropertyData> data = null;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<PropertyData> getData() {
        return data;
    }

    public void setData(List<PropertyData> data) {
        this.data = data;
    }

    public  class  PropertyData{

        @SerializedName("property_id")
        @Expose
        private String propertyId;
        @SerializedName("property_code")
        @Expose
        private String propertyCode;
        @SerializedName("property_title")
        @Expose
        private String propertyTitle;
        @SerializedName("property_place")
        @Expose
        private String propertyPlace;
        @SerializedName("property_place_type")
        @Expose
        private String propertyPlaceType;
        @SerializedName("property_post_type")
        @Expose
        private String propertyPostType;
        @SerializedName("property_city_id")
        @Expose
        private String propertyCityId;
        @SerializedName("property_locality_id")
        @Expose
        private String propertyLocalityId;
        @SerializedName("property_zip_code")
        @Expose
        private String propertyZipCode;
        @SerializedName("property_address")
        @Expose
        private String propertyAddress;
        @SerializedName("property_latitude")
        @Expose
        private String propertyLatitude;
        @SerializedName("property_longitude")
        @Expose
        private String propertyLongitude;
        @SerializedName("no_of_bedroom")
        @Expose
        private String noOfBedroom;
        @SerializedName("no_of_bathroom")
        @Expose
        private String noOfBathroom;
        @SerializedName("no_of_balcony")
        @Expose
        private String noOfBalcony;
        @SerializedName("total_floors_in_building")
        @Expose
        private String totalFloorsInBuilding;
        @SerializedName("property_on_floors")
        @Expose
        private String propertyOnFloors;
        @SerializedName("area_unit_type")
        @Expose
        private String areaUnitType;
        @SerializedName("plot_area")
        @Expose
        private String plotArea;
        @SerializedName("carpet_area")
        @Expose
        private String carpetArea;
        @SerializedName("built_up_area")
        @Expose
        private String builtUpArea;
        @SerializedName("super_built_up_area")
        @Expose
        private String superBuiltUpArea;
        @SerializedName("property_construction_status")
        @Expose
        private String propertyConstructionStatus;
        @SerializedName("property_possession")
        @Expose
        private String propertyPossession;
        @SerializedName("property_furnishing_status")
        @Expose
        private String propertyFurnishingStatus;
        @SerializedName("property_des")
        @Expose
        private String propertyDes;
        @SerializedName("property_rera_no")
        @Expose
        private String propertyReraNo;
        @SerializedName("property_map")
        @Expose
        private String propertyMap;
        @SerializedName("property_video")
        @Expose
        private String propertyVideo;
        @SerializedName("property_walk_video")
        @Expose
        private String propertyWalkVideo;
        @SerializedName("property_brochure")
        @Expose
        private String propertyBrochure;
        @SerializedName("property_min_price")
        @Expose
        private String propertyMinPrice;
        @SerializedName("property_max_price")
        @Expose
        private String propertyMaxPrice;
        @SerializedName("property_deal_percentage")
        @Expose
        private String propertyDealPercentage;
        @SerializedName("property_income_percentage")
        @Expose
        private String propertyIncomePercentage;
        @SerializedName("property_price_per_unit")
        @Expose
        private String propertyPricePerUnit;
        @SerializedName("property_maintenance_charges")
        @Expose
        private String propertyMaintenanceCharges;
        @SerializedName("property_maintenance_charges_type")
        @Expose
        private String propertyMaintenanceChargesType;
        @SerializedName("is_hide_price")
        @Expose
        private String isHidePrice;
        @SerializedName("property_water_charges")
        @Expose
        private String propertyWaterCharges;
        @SerializedName("property_plan_type")
        @Expose
        private String propertyPlanType;
        @SerializedName("property_offer")
        @Expose
        private String propertyOffer;
        @SerializedName("bank_name")
        @Expose
        private String bankName;
        @SerializedName("account_no")
        @Expose
        private String accountNo;
        @SerializedName("account_holder_name")
        @Expose
        private String accountHolderName;
        @SerializedName("bank_ifsc_code")
        @Expose
        private String bankIfscCode;
        @SerializedName("property_builder")
        @Expose
        private String propertyBuilder;
        @SerializedName("property_builder_dis")
        @Expose
        private String propertyBuilderDis;
        @SerializedName("published")
        @Expose
        private String published;
        @SerializedName("deleted")
        @Expose
        private String deleted;
        @SerializedName("property_verified")
        @Expose
        private String propertyVerified;
        @SerializedName("created")
        @Expose
        private String created;
        @SerializedName("amenities_id")
        @Expose
        private String amenitiesId;
        @SerializedName("property_image")
        @Expose
        private String propertyImage;
        @SerializedName("city_name")
        @Expose
        private String cityName;
        @SerializedName("locality_name")
        @Expose
        private String localityName;
        @SerializedName("max_unit_area")
        @Expose
        private String maxUnitArea;
        @SerializedName("min_unit_area")
        @Expose
        private String minUnitArea;

        public String getPropertyId() {
            return propertyId;
        }

        public void setPropertyId(String propertyId) {
            this.propertyId = propertyId;
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

        public String getPropertyPlace() {
            return propertyPlace;
        }

        public void setPropertyPlace(String propertyPlace) {
            this.propertyPlace = propertyPlace;
        }

        public String getPropertyPlaceType() {
            return propertyPlaceType;
        }

        public void setPropertyPlaceType(String propertyPlaceType) {
            this.propertyPlaceType = propertyPlaceType;
        }

        public String getPropertyPostType() {
            return propertyPostType;
        }

        public void setPropertyPostType(String propertyPostType) {
            this.propertyPostType = propertyPostType;
        }

        public String getPropertyCityId() {
            return propertyCityId;
        }

        public void setPropertyCityId(String propertyCityId) {
            this.propertyCityId = propertyCityId;
        }

        public String getPropertyLocalityId() {
            return propertyLocalityId;
        }

        public void setPropertyLocalityId(String propertyLocalityId) {
            this.propertyLocalityId = propertyLocalityId;
        }

        public String getPropertyZipCode() {
            return propertyZipCode;
        }

        public void setPropertyZipCode(String propertyZipCode) {
            this.propertyZipCode = propertyZipCode;
        }

        public String getPropertyAddress() {
            return propertyAddress;
        }

        public void setPropertyAddress(String propertyAddress) {
            this.propertyAddress = propertyAddress;
        }

        public String getPropertyLatitude() {
            return propertyLatitude;
        }

        public void setPropertyLatitude(String propertyLatitude) {
            this.propertyLatitude = propertyLatitude;
        }

        public String getPropertyLongitude() {
            return propertyLongitude;
        }

        public void setPropertyLongitude(String propertyLongitude) {
            this.propertyLongitude = propertyLongitude;
        }

        public String getNoOfBedroom() {
            return noOfBedroom;
        }

        public void setNoOfBedroom(String noOfBedroom) {
            this.noOfBedroom = noOfBedroom;
        }

        public String getNoOfBathroom() {
            return noOfBathroom;
        }

        public void setNoOfBathroom(String noOfBathroom) {
            this.noOfBathroom = noOfBathroom;
        }

        public String getNoOfBalcony() {
            return noOfBalcony;
        }

        public void setNoOfBalcony(String noOfBalcony) {
            this.noOfBalcony = noOfBalcony;
        }

        public String getTotalFloorsInBuilding() {
            return totalFloorsInBuilding;
        }

        public void setTotalFloorsInBuilding(String totalFloorsInBuilding) {
            this.totalFloorsInBuilding = totalFloorsInBuilding;
        }

        public String getPropertyOnFloors() {
            return propertyOnFloors;
        }

        public void setPropertyOnFloors(String propertyOnFloors) {
            this.propertyOnFloors = propertyOnFloors;
        }

        public String getAreaUnitType() {
            return areaUnitType;
        }

        public void setAreaUnitType(String areaUnitType) {
            this.areaUnitType = areaUnitType;
        }

        public String getPlotArea() {
            return plotArea;
        }

        public void setPlotArea(String plotArea) {
            this.plotArea = plotArea;
        }

        public String getCarpetArea() {
            return carpetArea;
        }

        public void setCarpetArea(String carpetArea) {
            this.carpetArea = carpetArea;
        }

        public String getBuiltUpArea() {
            return builtUpArea;
        }

        public void setBuiltUpArea(String builtUpArea) {
            this.builtUpArea = builtUpArea;
        }

        public String getSuperBuiltUpArea() {
            return superBuiltUpArea;
        }

        public void setSuperBuiltUpArea(String superBuiltUpArea) {
            this.superBuiltUpArea = superBuiltUpArea;
        }

        public String getPropertyConstructionStatus() {
            return propertyConstructionStatus;
        }

        public void setPropertyConstructionStatus(String propertyConstructionStatus) {
            this.propertyConstructionStatus = propertyConstructionStatus;
        }

        public String getPropertyPossession() {
            return propertyPossession;
        }

        public void setPropertyPossession(String propertyPossession) {
            this.propertyPossession = propertyPossession;
        }

        public String getPropertyFurnishingStatus() {
            return propertyFurnishingStatus;
        }

        public void setPropertyFurnishingStatus(String propertyFurnishingStatus) {
            this.propertyFurnishingStatus = propertyFurnishingStatus;
        }

        public String getPropertyDes() {
            return propertyDes;
        }

        public void setPropertyDes(String propertyDes) {
            this.propertyDes = propertyDes;
        }

        public String getPropertyReraNo() {
            return propertyReraNo;
        }

        public void setPropertyReraNo(String propertyReraNo) {
            this.propertyReraNo = propertyReraNo;
        }

        public String getPropertyMap() {
            return propertyMap;
        }

        public void setPropertyMap(String propertyMap) {
            this.propertyMap = propertyMap;
        }

        public String getPropertyVideo() {
            return propertyVideo;
        }

        public void setPropertyVideo(String propertyVideo) {
            this.propertyVideo = propertyVideo;
        }

        public String getPropertyWalkVideo() {
            return propertyWalkVideo;
        }

        public void setPropertyWalkVideo(String propertyWalkVideo) {
            this.propertyWalkVideo = propertyWalkVideo;
        }

        public String getPropertyBrochure() {
            return propertyBrochure;
        }

        public void setPropertyBrochure(String propertyBrochure) {
            this.propertyBrochure = propertyBrochure;
        }

        public String getPropertyMinPrice() {
            return propertyMinPrice;
        }

        public void setPropertyMinPrice(String propertyMinPrice) {
            this.propertyMinPrice = propertyMinPrice;
        }

        public String getPropertyMaxPrice() {
            return propertyMaxPrice;
        }

        public void setPropertyMaxPrice(String propertyMaxPrice) {
            this.propertyMaxPrice = propertyMaxPrice;
        }

        public String getPropertyDealPercentage() {
            return propertyDealPercentage;
        }

        public void setPropertyDealPercentage(String propertyDealPercentage) {
            this.propertyDealPercentage = propertyDealPercentage;
        }

        public String getPropertyIncomePercentage() {
            return propertyIncomePercentage;
        }

        public void setPropertyIncomePercentage(String propertyIncomePercentage) {
            this.propertyIncomePercentage = propertyIncomePercentage;
        }

        public String getPropertyPricePerUnit() {
            return propertyPricePerUnit;
        }

        public void setPropertyPricePerUnit(String propertyPricePerUnit) {
            this.propertyPricePerUnit = propertyPricePerUnit;
        }

        public String getPropertyMaintenanceCharges() {
            return propertyMaintenanceCharges;
        }

        public void setPropertyMaintenanceCharges(String propertyMaintenanceCharges) {
            this.propertyMaintenanceCharges = propertyMaintenanceCharges;
        }

        public String getPropertyMaintenanceChargesType() {
            return propertyMaintenanceChargesType;
        }

        public void setPropertyMaintenanceChargesType(String propertyMaintenanceChargesType) {
            this.propertyMaintenanceChargesType = propertyMaintenanceChargesType;
        }

        public String getIsHidePrice() {
            return isHidePrice;
        }

        public void setIsHidePrice(String isHidePrice) {
            this.isHidePrice = isHidePrice;
        }

        public String getPropertyWaterCharges() {
            return propertyWaterCharges;
        }

        public void setPropertyWaterCharges(String propertyWaterCharges) {
            this.propertyWaterCharges = propertyWaterCharges;
        }

        public String getPropertyPlanType() {
            return propertyPlanType;
        }

        public void setPropertyPlanType(String propertyPlanType) {
            this.propertyPlanType = propertyPlanType;
        }

        public String getPropertyOffer() {
            return propertyOffer;
        }

        public void setPropertyOffer(String propertyOffer) {
            this.propertyOffer = propertyOffer;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getAccountNo() {
            return accountNo;
        }

        public void setAccountNo(String accountNo) {
            this.accountNo = accountNo;
        }

        public String getAccountHolderName() {
            return accountHolderName;
        }

        public void setAccountHolderName(String accountHolderName) {
            this.accountHolderName = accountHolderName;
        }

        public String getBankIfscCode() {
            return bankIfscCode;
        }

        public void setBankIfscCode(String bankIfscCode) {
            this.bankIfscCode = bankIfscCode;
        }

        public String getPropertyBuilder() {
            return propertyBuilder;
        }

        public void setPropertyBuilder(String propertyBuilder) {
            this.propertyBuilder = propertyBuilder;
        }

        public String getPropertyBuilderDis() {
            return propertyBuilderDis;
        }

        public void setPropertyBuilderDis(String propertyBuilderDis) {
            this.propertyBuilderDis = propertyBuilderDis;
        }

        public String getPublished() {
            return published;
        }

        public void setPublished(String published) {
            this.published = published;
        }

        public String getDeleted() {
            return deleted;
        }

        public void setDeleted(String deleted) {
            this.deleted = deleted;
        }

        public String getPropertyVerified() {
            return propertyVerified;
        }

        public void setPropertyVerified(String propertyVerified) {
            this.propertyVerified = propertyVerified;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getAmenitiesId() {
            return amenitiesId;
        }

        public void setAmenitiesId(String amenitiesId) {
            this.amenitiesId = amenitiesId;
        }

        public String getPropertyImage() {
            return propertyImage;
        }

        public void setPropertyImage(String propertyImage) {
            this.propertyImage = propertyImage;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getLocalityName() {
            return localityName;
        }

        public void setLocalityName(String localityName) {
            this.localityName = localityName;
        }

        public String getMaxUnitArea() {
            return maxUnitArea;
        }

        public void setMaxUnitArea(String maxUnitArea) {
            this.maxUnitArea = maxUnitArea;
        }

        public String getMinUnitArea() {
            return minUnitArea;
        }

        public void setMinUnitArea(String minUnitArea) {
            this.minUnitArea = minUnitArea;
        }

    }

}
