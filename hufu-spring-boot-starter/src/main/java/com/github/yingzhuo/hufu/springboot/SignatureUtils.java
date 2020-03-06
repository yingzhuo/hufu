/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  _   _        __
 * | | | |_   _ / _|_   _
 * | |_| | | | | |_| | | |
 * |  _  | |_| |  _| |_| |
 * |_| |_|\__,_|_|  \__,_|        https://github.com/yingzhuo/hufu
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package com.github.yingzhuo.hufu.springboot;

import com.github.yingzhuo.hufu.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.file.Path;

/**
 * 签名工具
 *
 * @author 应卓
 * @since 0.1.1
 */
public final class SignatureUtils implements ApplicationContextAware {

    private static final Logger log = LoggerFactory.getLogger(SignatureUtils.class);

    private static ApplicationContext applicationContext;

    public static Secret createRandom() {
        return applicationContext.getBean(SecretFactory.class).createRandom();
    }

    public static Secret createFromString(String value) {
        return applicationContext.getBean(SecretFactory.class).createFromString(value);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static String sign(byte[] data, PrivateKey privateKey) {
        return applicationContext.getBean(Signature.class).sign(data, privateKey);
    }

    public static String sign(CharSequence data, PrivateKey privateKey) {
        return applicationContext.getBean(Signature.class).sign(data, privateKey);
    }

    public static String sign(InputStream data, PrivateKey privateKey) {
        return applicationContext.getBean(Signature.class).sign(data, privateKey);
    }

    public static String sign(File data, PrivateKey privateKey) {
        return applicationContext.getBean(Signature.class).sign(data, privateKey);
    }

    public static String sign(RandomAccessFile data, PrivateKey privateKey) {
        return applicationContext.getBean(Signature.class).sign(data, privateKey);
    }

    public static String sign(Path data, PrivateKey privateKey) {
        return applicationContext.getBean(Signature.class).sign(data, privateKey);
    }

    public static String sign(ByteBuffer data, PrivateKey privateKey) {
        return applicationContext.getBean(Signature.class).sign(data, privateKey);
    }

    public static String sign(SerializableObject data, PrivateKey privateKey) {
        return applicationContext.getBean(Signature.class).sign(data, privateKey);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static boolean verify(byte[] data, String sign, PublicKey publicKey) {
        return applicationContext.getBean(Signature.class).verify(data, sign, publicKey);
    }

    public static boolean verify(CharSequence data, String sign, PublicKey publicKey) {
        return applicationContext.getBean(Signature.class).verify(data, sign, publicKey);
    }

    public static boolean verify(InputStream data, String sign, PublicKey publicKey) {
        return applicationContext.getBean(Signature.class).verify(data, sign, publicKey);
    }

    public static boolean verify(File data, String sign, PublicKey publicKey) {
        return applicationContext.getBean(Signature.class).verify(data, sign, publicKey);
    }

    public static boolean verify(RandomAccessFile data, String sign, PublicKey publicKey) {
        return applicationContext.getBean(Signature.class).verify(data, sign, publicKey);
    }

    public static boolean verify(Path data, String sign, PublicKey publicKey) {
        return applicationContext.getBean(Signature.class).verify(data, sign, publicKey);
    }

    public static boolean verify(ByteBuffer data, String sign, PublicKey publicKey) {
        return applicationContext.getBean(Signature.class).verify(data, sign, publicKey);
    }

    public static boolean verify(SerializableObject data, String sign, PublicKey publicKey) {
        return applicationContext.getBean(Signature.class).verify(data, sign, publicKey);
    }

    // -----------------------------------------------------------------------------------------------------------------

    SignatureUtils() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("{}} set up!", SignatureUtils.class.getName());
        SignatureUtils.applicationContext = applicationContext;
    }

}
