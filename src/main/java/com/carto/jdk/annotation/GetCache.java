package com.carto.jdk.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface GetCache {
    /**
     * ��λ �� ʧЧʱ�� 0 ���� -1 ��Զ��ʧЧ <br>
     * Ĭ��1��
     *
     * @return ����ʱ��
     */
    int expire() default 300;

    /**
     * ���õ�ʧЧʱ���key
     *
     * @return key
     */
    String expireKey() default "";

    /**
     * ���濪��
     *
     * @return cache switch
     */
    boolean isCache() default true;

    /**
     * ���ػ��濪��
     *
     * @return local cache switch
     */
    boolean isLocal() default false;

    /**
     * key��ǰ׺
     *
     * @return cacheǰ׺
     */
    String keyPrefix() default "";

    /**
     * �Ƿ���Ҫ��key��hash����Ҫ���key���������
     *
     * @return isHash
     */
    boolean isHash() default false;

    /**
     * hash��ʽ
     *
     * @return md5 sha1
     */
    String hashType() default "md5";

    /**
     * �Ƿ񻺴�ն��󣬿ɽ�����洩͸���⣬����Ҫ����ռ�
     */
    boolean cacheNull() default true;

    /**
     * ʹ�õ����л���ʽ��ProtoStuff��1.6�м���������
     *
     * @return 0 Hessian,1 Java,2 Jackson,3 ProtoStuff, Ĭ��Hessian��ProtoStuff������JDK1.6
     */
    int serializer() default 0;

    /**
     * �����ػ��濪�����ʹ�ã�����ע����󻺴���������Ĭ��1000
     *
     * @return
     */
    int size() default 1000;
}
