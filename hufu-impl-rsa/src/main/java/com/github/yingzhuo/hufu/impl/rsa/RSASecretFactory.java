/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  _   _        __
 * | | | |_   _ / _|_   _
 * | |_| | | | | |_| | | |
 * |  _  | |_| |  _| |_| |
 * |_| |_|\__,_|_|  \__,_|        https://github.com/yingzhuo/hufu
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package com.github.yingzhuo.hufu.impl.rsa;

import com.github.yingzhuo.hufu.api.Secret;
import com.github.yingzhuo.hufu.api.SecretFactory;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

/**
 * 秘钥工厂实现
 *
 * @author 应卓
 * @since 0.1.0
 */
public class RSASecretFactory implements SecretFactory {

    private static final String ALG = "RSA";
    private static final int DEFAULT_KEY_SIZE = 512;

    @Override
    public Secret createRandom() {
        try {
            final KeyPairGenerator generator = KeyPairGenerator.getInstance(ALG);
            generator.initialize(DEFAULT_KEY_SIZE);
            java.security.KeyPair keyPair = generator.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            return new RSASecret(
                    new String(Base64.getEncoder().encode(publicKey.getEncoded())),
                    new String(Base64.getEncoder().encode(privateKey.getEncoded()))
            );

        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e.getMessage(), e); // 实际不会发生此异常
        }
    }

    @Override
    public Secret createFromString(String value) {
        if (value == null) {
            throw new NullPointerException();
        }

        final String[] parts = value.split(":", 2);
        if (parts.length != 2) {
            throw new IllegalArgumentException("value cannot be keypair.");
        }

        return new RSASecret(parts[0], parts[1]);
    }

}
