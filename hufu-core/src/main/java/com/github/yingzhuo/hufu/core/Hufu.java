/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  _   _        __
 * | | | |_   _ / _|_   _
 * | |_| | | | | |_| | | |
 * |  _  | |_| |  _| |_| |
 * |_| |_|\__,_|_|  \__,_|        https://github.com/yingzhuo/hufu
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package com.github.yingzhuo.hufu.core;

import com.github.yingzhuo.hufu.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author 应卓
 * @since 0.1.0
 */
public final class Hufu {

    private static final Logger log = LoggerFactory.getLogger(Hufu.class);

    private static final SecretFactory secretFactory = createSecretFactory();
    private static final Signature signature = createSignature();

    // -----------------------------------------------------------------------------------------------------------------

    public static SecretFactory createSecretFactory() {
        final ServiceLoader<SecretFactory> loader = ServiceLoader.load(SecretFactory.class);

        final List<SecretFactory> found = new LinkedList<>();
        for (SecretFactory it : loader) {
            found.add(it);
        }

        if (found.isEmpty()) {
            throw new NoImplementException("No implement found.");
        }

        if (found.size() != 1) {
            log.warn("Multiple implements found.");
            for (SecretFactory it : found) {
                log.warn(" {}", it.getClass());
            }
        }
        return found.iterator().next();
    }

    public static Signature createSignature() {
        final ServiceLoader<Signature> loader = ServiceLoader.load(Signature.class);

        final List<Signature> found = new LinkedList<>();
        for (Signature it : loader) {
            found.add(it);
        }

        if (found.isEmpty()) {
            throw new NoImplementException("No implement found.");
        }

        if (found.size() != 1) {
            log.warn("Multiple implements found.");
            for (Signature it : found) {
                log.warn(" {}", it.getClass());
            }
        }
        return found.iterator().next();
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static Secret createRandom() {
        return secretFactory.createRandom();
    }

    public static Secret createFromString(String value) {
        return secretFactory.createFromString(value);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static String sign(byte[] data, PrivateKey privateKey) {
        return signature.sign(data, privateKey);
    }

    public static String sign(CharSequence data, PrivateKey privateKey) {
        return signature.sign(data, privateKey);
    }

    public static String sign(InputStream data, PrivateKey privateKey) {
        return signature.sign(data, privateKey);
    }

    public static String sign(File data, PrivateKey privateKey) {
        return signature.sign(data, privateKey);
    }

    public static String sign(RandomAccessFile data, PrivateKey privateKey) {
        return signature.sign(data, privateKey);
    }

    public static String sign(Path data, PrivateKey privateKey) {
        return signature.sign(data, privateKey);
    }

    public static String sign(ByteBuffer data, PrivateKey privateKey) {
        return signature.sign(data, privateKey);
    }

    public static String sign(BytesSerializable data, PrivateKey privateKey) {
        return signature.sign(data, privateKey);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static boolean verify(byte[] data, String sign, PublicKey publicKey) {
        return signature.verify(data, sign, publicKey);
    }

    public static boolean verify(CharSequence data, String sign, PublicKey publicKey) {
        return signature.verify(data, sign, publicKey);
    }

    public static boolean verify(InputStream data, String sign, PublicKey publicKey) {
        return signature.verify(data, sign, publicKey);
    }

    public static boolean verify(File data, String sign, PublicKey publicKey) {
        return signature.verify(data, sign, publicKey);
    }

    public static boolean verify(RandomAccessFile data, String sign, PublicKey publicKey) {
        return signature.verify(data, sign, publicKey);
    }

    public static boolean verify(Path data, String sign, PublicKey publicKey) {
        return signature.verify(data, sign, publicKey);
    }

    public static boolean verify(ByteBuffer data, String sign, PublicKey publicKey) {
        return signature.verify(data, sign, publicKey);
    }

    public static boolean verify(BytesSerializable data, String sign, PublicKey publicKey) {
        return signature.verify(data, sign, publicKey);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private Hufu() {
    }
}
