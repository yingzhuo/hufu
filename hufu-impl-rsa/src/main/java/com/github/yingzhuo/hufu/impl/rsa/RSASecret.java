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

/**
 * 秘钥对实现
 *
 * @author 应卓
 * @see com.github.yingzhuo.hufu.api.Secret
 * @see com.github.yingzhuo.hufu.api.PublicKey
 * @see com.github.yingzhuo.hufu.api.PrivateKey
 * @since 0.1.0
 */
public final class RSASecret implements Secret {

    private final String publicKey;
    private final String privateKey;

    public RSASecret(String publicKey, String privateKey) {
        if (publicKey == null || privateKey == null) {
            throw new NullPointerException();
        }

        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    @Override
    public String getPublicKey() {
        return this.publicKey;
    }

    @Override
    public String getPrivateKey() {
        return this.privateKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RSASecret other = (RSASecret) o;

        if (!publicKey.equals(other.publicKey)) return false;
        return privateKey.equals(other.privateKey);
    }

    @Override
    public int hashCode() {
        int result = publicKey.hashCode();
        result = 31 * result + privateKey.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s:%s", getPublicKey(), getPrivateKey());
    }

}
