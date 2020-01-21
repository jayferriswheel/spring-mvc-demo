package com.carto.jdk.annotation;

public interface IAnnotation {
    @GetCache(keyPrefix = "SH_DELIVERY_QUERY_RULE_BY_ID_20191127", expireKey = "threeMinitues", isLocal = true, cacheNull = true)
    void tell();
}
