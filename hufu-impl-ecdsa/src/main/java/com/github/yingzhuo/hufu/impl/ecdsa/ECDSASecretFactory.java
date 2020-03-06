/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  _   _        __
 * | | | |_   _ / _|_   _
 * | |_| | | | | |_| | | |
 * |  _  | |_| |  _| |_| |
 * |_| |_|\__,_|_|  \__,_|        https://github.com/yingzhuo/hufu
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package com.github.yingzhuo.hufu.impl.ecdsa;

import com.github.yingzhuo.hufu.api.Secret;
import com.github.yingzhuo.hufu.api.SecretFactory;

import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.util.Base64;

/**
 * 秘钥工厂实现
 *
 * @author 应卓
 * @since 0.1.3
 */
public class ECDSASecretFactory implements SecretFactory {

    private static final String ALG = "EC";
    private static final int DEFAULT_KEY_SIZE = 1024;

    @Override
    public Secret createRandom() {
        try {
            final KeyPairGenerator generator = KeyPairGenerator.getInstance(ALG);
            generator.initialize(new ECGenParameterSpec("secp256r1"), new SecureRandom());
            java.security.KeyPair keyPair = generator.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            return new ECDSASecret(
                    new String(Base64.getEncoder().encode(publicKey.getEncoded())),
                    new String(Base64.getEncoder().encode(privateKey.getEncoded()))
            );

        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException e) {
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

        return new ECDSASecret(parts[0], parts[1]);
    }

}
