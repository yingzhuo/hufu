/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  _   _        __
 * | | | |_   _ / _|_   _
 * | |_| | | | | |_| | | |
 * |  _  | |_| |  _| |_| |
 * |_| |_|\__,_|_|  \__,_|        https://github.com/yingzhuo/hufu
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package com.github.yingzhuo.hufu.impl.dsa;

import com.github.yingzhuo.hufu.api.PrivateKey;
import com.github.yingzhuo.hufu.api.PublicKey;
import com.github.yingzhuo.hufu.api.Signature;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * 签名实现
 *
 * @author 应卓
 * @since 0.1.3
 */
public class DSASignature implements Signature {

    private static final String DSA = "DSA";
    private static final String SHA1_WITH_DSA = "SHA1withDSA";
    private static final String SUN = "SUN";

    @Override
    public String sign(byte[] data, PrivateKey privateKey) {
        final String str;

        try {
            // 解密由base64编码的私钥
            byte[] bytes = decryptBase64(privateKey.getPrivateKey());
            // 构造PKCS8EncodedKeySpec对象
            PKCS8EncodedKeySpec pkcs = new PKCS8EncodedKeySpec(bytes);
            // 指定的加密算法
            KeyFactory factory = KeyFactory.getInstance(DSA);
            // 取私钥对象
            java.security.PrivateKey key = factory.generatePrivate(pkcs);
            // 用私钥对信息生成数字签名
            java.security.Signature dsa = java.security.Signature.getInstance(SHA1_WITH_DSA, SUN);
            dsa.initSign(key);
            dsa.update(data);
            str = encryptBase64(dsa.sign());
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            throw new AssertionError(e.getMessage(), e); // 实际不会发生此异常
        } catch (InvalidKeySpecException | InvalidKeyException | SignatureException e) {
            throw new com.github.yingzhuo.hufu.api.SignatureException(e);
        }

        return str;
    }

    @Override
    public boolean verify(byte[] data, String sign, PublicKey publicKey) {
        final boolean flag;
        try {
            // 解密由base64编码的公钥
            byte[] bytes = decryptBase64(publicKey.getPublicKey());
            // 构造X509EncodedKeySpec对象
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(bytes);
            // 指定的加密算法
            KeyFactory factory = KeyFactory.getInstance(DSA);
            // 取公钥对象
            java.security.PublicKey key = factory.generatePublic(keySpec);
            // 用公钥验证数字签名
            java.security.Signature dsa = java.security.Signature.getInstance(SHA1_WITH_DSA, SUN);
            dsa.initVerify(key);
            dsa.update(data);
            flag = dsa.verify(decryptBase64(sign));
            return flag;
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            throw new AssertionError(e.getMessage(), e); // 实际不会发生此异常
        } catch (InvalidKeySpecException | InvalidKeyException | SignatureException e) {
            throw new com.github.yingzhuo.hufu.api.SignatureException(e);
        }
    }

    private static byte[] decryptBase64(String key) {
        return Base64.getDecoder().decode(key);
    }

    private static String encryptBase64(byte[] key) {
        return new String(Base64.getEncoder().encode(key));
    }
}
