package com.shamniestate.shamniestate.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PropertyDetailsModel {


    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("Data")
    @Expose
    private PropertyData data;

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

    public PropertyData getData() {
        return data;
    }

    public void setData(PropertyData data) {
        this.data = data;
    }

    public  class  PropertyData{
        @SerializedName("property")
        @Expose
        private List<Property> property = null;
        @SerializedName("property_gallery")
        @Expose
        private List<PropertyGallery> propertyGallery = null;
        @SerializedName("property_amenities")
        @Expose
        private List<PropertyAmenity> propertyAmenities = null;
        @SerializedName("property_units")
        @Expose
        private PropertyUnits propertyUnits;
        @SerializedName("property_slot")
        @Expose
        private List<PropertySlot> propertySlot = null;
        @SerializedName("commStrPrice")
        @Expose
        private CommStrPrice commStrPrice;
        @SerializedName("admin_level")
        @Expose
        private List<AdminLevel> adminLevel = null;
        @SerializedName("faqs")
        @Expose
        private List<Object> faqs = null;
        @SerializedName("property_banks")
        @Expose
        private List<PropertyBank> propertyBanks = null;
        @SerializedName("nearProperty")
        @Expose
        private List<NearProperty> nearProperty = null;

        public List<Property> getProperty() {
            return property;
        }

        public void setProperty(List<Property> property) {
            this.property = property;
        }

        public List<PropertyGallery> getPropertyGallery() {
            return propertyGallery;
        }

        public void setPropertyGallery(List<PropertyGallery> propertyGallery) {
            this.propertyGallery = propertyGallery;
        }

        public List<PropertyAmenity> getPropertyAmenities() {
            return propertyAmenities;
        }

        public void setPropertyAmenities(List<PropertyAmenity> propertyAmenities) {
            this.propertyAmenities = propertyAmenities;
        }

        public PropertyUnits getPropertyUnits() {
            return propertyUnits;
        }

        public void setPropertyUnits(PropertyUnits propertyUnits) {
            this.propertyUnits = propertyUnits;
        }

        public List<PropertySlot> getPropertySlot() {
            return propertySlot;
        }

        public void setPropertySlot(List<PropertySlot> propertySlot) {
            this.propertySlot = propertySlot;
        }

        public CommStrPrice getCommStrPrice() {
            return commStrPrice;
        }

        public void setCommStrPrice(CommStrPrice commStrPrice) {
            this.commStrPrice = commStrPrice;
        }

        public List<AdminLevel> getAdminLevel() {
            return adminLevel;
        }

        public void setAdminLevel(List<AdminLevel> adminLevel) {
            this.adminLevel = adminLevel;
        }

        public List<Object> getFaqs() {
            return faqs;
        }

        public void setFaqs(List<Object> faqs) {
            this.faqs = faqs;
        }

        public List<PropertyBank> getPropertyBanks() {
            return propertyBanks;
        }

        public void setPropertyBanks(List<PropertyBank> propertyBanks) {
            this.propertyBanks = propertyBanks;
        }

        public List<NearProperty> getNearProperty() {
            return nearProperty;
        }

        public void setNearProperty(List<NearProperty> nearProperty) {
            this.nearProperty = nearProperty;
        }


        public class Property {

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
            @SerializedName("property_type_name")
            @Expose
            private Object propertyTypeName;
            @SerializedName("city_name")
            @Expose
            private String cityName;
            @SerializedName("locality_name")
            @Expose
            private String localityName;

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

            public Object getPropertyTypeName() {
                return propertyTypeName;
            }

            public void setPropertyTypeName(Object propertyTypeName) {
                this.propertyTypeName = propertyTypeName;
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

        }

        public class PropertyAmenity {

            @SerializedName("amenities_name")
            @Expose
            private String amenitiesName;
            @SerializedName("amenities_icon")
            @Expose
            private String amenitiesIcon;

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

        public class PropertyBank {

            @SerializedName("bank_name")
            @Expose
            private String bankName;
            @SerializedName("bank_img")
            @Expose
            private String bankImg;

            public String getBankName() {
                return bankName;
            }

            public void setBankName(String bankName) {
                this.bankName = bankName;
            }

            public String getBankImg() {
                return bankImg;
            }

            public void setBankImg(String bankImg) {
                this.bankImg = bankImg;
            }

        }

        public class PropertyGallery {

            @SerializedName("gallery_id")
            @Expose
            private String galleryId;
            @SerializedName("property_id")
            @Expose
            private String propertyId;
            @SerializedName("gallery_name")
            @Expose
            private String galleryName;
            @SerializedName("gallery_type")
            @Expose
            private String galleryType;

            public String getGalleryId() {
                return galleryId;
            }

            public void setGalleryId(String galleryId) {
                this.galleryId = galleryId;
            }

            public String getPropertyId() {
                return propertyId;
            }

            public void setPropertyId(String propertyId) {
                this.propertyId = propertyId;
            }

            public String getGalleryName() {
                return galleryName;
            }

            public void setGalleryName(String galleryName) {
                this.galleryName = galleryName;
            }

            public String getGalleryType() {
                return galleryType;
            }

            public void setGalleryType(String galleryType) {
                this.galleryType = galleryType;
            }

        }

        public class PropertySlot {

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

        }

        public class PropertyUnits {

            @SerializedName("0")
            @Expose
            private _0 _0;
            @SerializedName("units")
            @Expose
            private List<Unit> units = null;

            public _0 get0() {
                return _0;
            }

            public void set0(_0 _0) {
                this._0 = _0;
            }

            public List<Unit> getUnits() {
                return units;
            }

            public void setUnits(List<Unit> units) {
                this.units = units;
            }

            public class Unit {

                @SerializedName("unit_id")
                @Expose
                private String unitId;
                @SerializedName("property_id")
                @Expose
                private String propertyId;
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

                public String getUnitId() {
                    return unitId;
                }

                public void setUnitId(String unitId) {
                    this.unitId = unitId;
                }

                public String getPropertyId() {
                    return propertyId;
                }

                public void setPropertyId(String propertyId) {
                    this.propertyId = propertyId;
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

            }

            public class _0 {

                @SerializedName("property_type_id")
                @Expose
                private String propertyTypeId;
                @SerializedName("property_type_name")
                @Expose
                private String propertyTypeName;

                public String getPropertyTypeId() {
                    return propertyTypeId;
                }

                public void setPropertyTypeId(String propertyTypeId) {
                    this.propertyTypeId = propertyTypeId;
                }

                public String getPropertyTypeName() {
                    return propertyTypeName;
                }

                public void setPropertyTypeName(String propertyTypeName) {
                    this.propertyTypeName = propertyTypeName;
                }

            }

        }

        public class AdminLevel {

            @SerializedName("level_id")
            @Expose
            private String levelId;
            @SerializedName("level_name")
            @Expose
            private String levelName;
            @SerializedName("level_per")
            @Expose
            private String levelPer;
            @SerializedName("level_associate")
            @Expose
            private String levelAssociate;

            public String getLevelId() {
                return levelId;
            }

            public void setLevelId(String levelId) {
                this.levelId = levelId;
            }

            public String getLevelName() {
                return levelName;
            }

            public void setLevelName(String levelName) {
                this.levelName = levelName;
            }

            public String getLevelPer() {
                return levelPer;
            }

            public void setLevelPer(String levelPer) {
                this.levelPer = levelPer;
            }

            public String getLevelAssociate() {
                return levelAssociate;
            }

            public void setLevelAssociate(String levelAssociate) {
                this.levelAssociate = levelAssociate;
            }

        }

        public class CommStrPrice {

            @SerializedName("0")
            @Expose
            private _0__1 _0;
            @SerializedName("units")
            @Expose
            private List<Unit__1> units = null;

            public _0__1 get0() {
                return _0;
            }

            public void set0(_0__1 _0) {
                this._0 = _0;
            }

            public List<Unit__1> getUnits() {
                return units;
            }

            public void setUnits(List<Unit__1> units) {
                this.units = units;
            }

            public class Unit__1 {

                @SerializedName("unit_id")
                @Expose
                private String unitId;
                @SerializedName("property_id")
                @Expose
                private String propertyId;
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

                public String getUnitId() {
                    return unitId;
                }

                public void setUnitId(String unitId) {
                    this.unitId = unitId;
                }

                public String getPropertyId() {
                    return propertyId;
                }

                public void setPropertyId(String propertyId) {
                    this.propertyId = propertyId;
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

            }
            public class _0__1 {

                @SerializedName("property_type_id")
                @Expose
                private String propertyTypeId;
                @SerializedName("property_type_name")
                @Expose
                private String propertyTypeName;

                public String getPropertyTypeId() {
                    return propertyTypeId;
                }

                public void setPropertyTypeId(String propertyTypeId) {
                    this.propertyTypeId = propertyTypeId;
                }

                public String getPropertyTypeName() {
                    return propertyTypeName;
                }

                public void setPropertyTypeName(String propertyTypeName) {
                    this.propertyTypeName = propertyTypeName;
                }

            }

        }

        public class NearProperty {

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
            @SerializedName("property_image")
            @Expose
            private String propertyImage;
            @SerializedName("city_name")
            @Expose
            private String cityName;
            @SerializedName("locality_name")
            @Expose
            private String localityName;
            @SerializedName("distance")
            @Expose
            private String distance;

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

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

        }


    }

}
