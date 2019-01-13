package com.carto.lib.fspResponse;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.File;

@ControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    public static final String SUCCESS_ERROR_CODE = "200";

    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return MappingJackson2HttpMessageConverter.class.isAssignableFrom(converterType);
    }

    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body == null || body instanceof String || body instanceof File || body instanceof FspResult) {
            return body;
        } else {
            FspResult fspResult = new FspResult();
            fspResult.setSuccess(true);
            fspResult.setErrorCode(SUCCESS_ERROR_CODE);
            fspResult.setData(body);
            return fspResult;
        }
    }
}
