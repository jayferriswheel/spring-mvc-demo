package com.carto.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Static functions to simplifiy common {@link MessageDigest} tasks.  This
 * class is thread safe.
 *
 * @author minsiqiang
 */
public class SHA1Util {

    private SHA1Util() {
    }

    /**
     * Returns a MessageDigest for the given <code>algorithm</code>.
     * <p>
     * algorithm
     * The MessageDigest algorithm name.
     *
     * @return An MD5 digest instance.
     * @throws RuntimeException when a {@link NoSuchAlgorithmException} is
     *                          caught
     */

    static MessageDigest getDigest() {
        try {
            return MessageDigest.getInstance("sha1");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Calculates the MD5 digest and returns the value as a 16 element
     * <code>byte[]</code>.
     *
     * @param data Data to digest
     * @return MD5 digest
     */
    public static byte[] handle(byte[] data) {
        return getDigest().digest(data);
    }

    /**
     * Calculates the MD5 digest and returns the value as a 16 element
     * <code>byte[]</code>.
     *
     * @param data Data to digest
     * @return MD5 digest
     */
    public static byte[] handle(String data) {
        return handle(data.getBytes());
    }
}
