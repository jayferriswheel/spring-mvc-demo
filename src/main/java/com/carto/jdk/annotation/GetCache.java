package com.carto.jdk.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface GetCache {
    /**
     * 单位 秒 失效时间 0 或者 -1 永远不失效 <br>
     * 默认1天
     *
     * @return 过期时间
     */
    int expire() default 300;

    /**
     * 配置的失效时间的key
     *
     * @return key
     */
    String expireKey() default "";

    /**
     * 缓存开关
     *
     * @return cache switch
     */
    boolean isCache() default true;

    /**
     * 本地缓存开关
     *
     * @return local cache switch
     */
    boolean isLocal() default false;

    /**
     * key的前缀
     *
     * @return cache前缀
     */
    String keyPrefix() default "";

    /**
     * 是否需要对key做hash，主要针对key过长的情况
     *
     * @return isHash
     */
    boolean isHash() default false;

    /**
     * hash方式
     *
     * @return md5 sha1
     */
    String hashType() default "md5";

    /**
     * 是否缓存空对象，可解决缓存穿透问题，但需要额外空间
     */
    boolean cacheNull() default true;

    /**
     * 使用的序列化方式，ProtoStuff在1.6有兼容性问题
     *
     * @return 0 Hessian,1 Java,2 Jackson,3 ProtoStuff, 默认Hessian，ProtoStuff不兼容JDK1.6
     */
    int serializer() default 0;

    /**
     * 跟本地缓存开关配合使用，单个注解最大缓存对象个数，默认1000
     *
     * @return
     */
    int size() default 1000;
}
