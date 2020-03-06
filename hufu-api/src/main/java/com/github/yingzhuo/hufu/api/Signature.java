/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  _   _        __
 * | | | |_   _ / _|_   _
 * | |_| | | | | |_| | | |
 * |  _  | |_| |  _| |_| |
 * |_| |_|\__,_|_|  \__,_|        https://github.com/yingzhuo/hufu
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package com.github.yingzhuo.hufu.api;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;

import static com.github.yingzhuo.hufu.api.IO.toBytes;

/**
 * 签名
 *
 * @author 应卓
 * @since 0.1.0
 */
public interface Signature {

    public String sign(byte[] data, PrivateKey privateKey);

    public default String sign(String data, PrivateKey privateKey) {
        return sign(toBytes(data), privateKey);
    }

    public default String sign(InputStream data, PrivateKey privateKey) {
        try {
            return sign(toBytes(data), privateKey);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public default String sign(File data, PrivateKey privateKey) {
        try {
            return sign(toBytes(data), privateKey);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    // ---------------------------------------------------------------------------------------------------------------

    public boolean verify(byte[] data, String sign, PublicKey publicKey);

    public default boolean verify(String data, String sign, PublicKey publicKey) {
        return verify(toBytes(data), sign, publicKey);
    }

    public default boolean verify(InputStream data, String sign, PublicKey publicKey) {
        try {
            return verify(toBytes(data), sign, publicKey);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public default boolean verify(File data, String sign, PublicKey publicKey) {
        try {
            return verify(toBytes(data), sign, publicKey);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}
