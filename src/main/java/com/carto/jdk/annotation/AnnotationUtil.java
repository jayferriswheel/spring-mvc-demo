package com.carto.jdk.annotation;

import java.lang.reflect.Method;

public class AnnotationUtil {
    public static void main(String[] args) {
        Method method = IAnnotation.class.getMethods()[0];
        method.getAnnotation(GetCache.class);
    }
}
