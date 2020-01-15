package com.carto.entity;


import java.util.HashMap;
import java.util.Map;

public class ProductInfoEs {
    private String productId;
    private String productGroupId;
    private String stageId;
    private String promotionId;
    private String skuId;
    private String productName;
    private String productUrl;
    private String copyWriting;
    private String copyWritingDown;
    private String tag;
    private String backUpPritures;
    private String backUpWords;
    private int imgCheckResult;
    private String source;
    private String extension;
    private String activeFlag;
    private String lastUpdateTime;
    private String lastUpdateErpNo;
    private String createTime;
    private String createbyErpNo;
    private int classIdL1;
    private int classIdL2;
    private int classIdL3;
    private long venderId;
    private long shopId;
    private String isInterfered;
    private String interfereProperty;
    private String useDelivery;

    public ProductInfoEs() {
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductGroupId() {
        return this.productGroupId;
    }

    public void setProductGroupId(String productGroupId) {
        this.productGroupId = productGroupId;
    }

    public String getStageId() {
        return this.stageId;
    }

    public void setStageId(String stageId) {
        this.stageId = stageId;
    }

    public String getPromotionId() {
        return this.promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public String getSkuId() {
        return this.skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductUrl() {
        return this.productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getCopyWriting() {
        return this.copyWriting;
    }

    public void setCopyWriting(String copyWriting) {
        this.copyWriting = copyWriting;
    }

    public String getCopyWritingDown() {
        return this.copyWritingDown;
    }

    public void setCopyWritingDown(String copyWritingDown) {
        this.copyWritingDown = copyWritingDown;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getBackUpPritures() {
        return this.backUpPritures;
    }

    public void setBackUpPritures(String backUpPritures) {
        this.backUpPritures = backUpPritures;
    }

    public String getBackUpWords() {
        return this.backUpWords;
    }

    public void setBackUpWords(String backUpWords) {
        this.backUpWords = backUpWords;
    }

    public int getImgCheckResult() {
        return this.imgCheckResult;
    }

    public void setImgCheckResult(int imgCheckResult) {
        this.imgCheckResult = imgCheckResult;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getActiveFlag() {
        return this.activeFlag;
    }

    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
    }

    public String getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdateErpNo() {
        return this.lastUpdateErpNo;
    }

    public void setLastUpdateErpNo(String lastUpdateErpNo) {
        this.lastUpdateErpNo = lastUpdateErpNo;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreatebyErpNo() {
        return this.createbyErpNo;
    }

    public void setCreatebyErpNo(String createbyErpNo) {
        this.createbyErpNo = createbyErpNo;
    }

    public int getClassIdL1() {
        return this.classIdL1;
    }

    public void setClassIdL1(int classIdL1) {
        this.classIdL1 = classIdL1;
    }

    public int getClassIdL2() {
        return this.classIdL2;
    }

    public void setClassIdL2(int classIdL2) {
        this.classIdL2 = classIdL2;
    }

    public int getClassIdL3() {
        return this.classIdL3;
    }

    public void setClassIdL3(int classIdL3) {
        this.classIdL3 = classIdL3;
    }

    public long getVenderId() {
        return this.venderId;
    }

    public void setVenderId(long venderId) {
        this.venderId = venderId;
    }

    public long getShopId() {
        return this.shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public String getIsInterfered() {
        return this.isInterfered;
    }

    public void setIsInterfered(String isInterfered) {
        this.isInterfered = isInterfered;
    }

    public String getInterfereProperty() {
        return this.interfereProperty;
    }

    public void setInterfereProperty(String interfereProperty) {
        this.interfereProperty = interfereProperty;
    }

    public String getUseDelivery() {
        return this.useDelivery;
    }

    public void setUseDelivery(String useDelivery) {
        this.useDelivery = useDelivery;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap();
        map.put("productGroupId", this.productGroupId);
        map.put("productStageId", this.stageId);
        map.put("productId", this.productId);
        map.put("promotionId", this.promotionId);
        map.put("skuId", this.skuId);
        map.put("picUrl", this.productUrl);
        if (this.productName == null) {
            this.productName = "";
        }

        map.put("name", this.productName);
        map.put("copyWriting", this.copyWriting);
        map.put("copyWritingDown", this.copyWritingDown);
        map.put("tag", this.tag);
        String bakUpWords = this.backUpWords;
        if (this.backUpWords == null) {
            bakUpWords = "[]";
        }

        map.put("backUpWords", bakUpWords);
        String backUpPics = this.backUpPritures;
        if (this.backUpPritures == null || this.backUpPritures.equals("")) {
            backUpPics = "[]";
        }

        map.put("backUpPics", backUpPics);
        map.put("classIdL1", this.classIdL1);
        map.put("classIdL2", this.classIdL2);
        map.put("classIdL3", this.classIdL3);
        map.put("venderId", this.venderId);
        map.put("shopId", this.shopId);
        map.put("extension", this.extension);
        map.put("useDelivery", this.useDelivery);
        return map;
    }
}