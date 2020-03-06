/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  _   _        __
 * | | | |_   _ / _|_   _
 * | |_| | | | | |_| | | |
 * |  _  | |_| |  _| |_| |
 * |_| |_|\__,_|_|  \__,_|        https://github.com/yingzhuo/hufu
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package com.github.yingzhuo.hufu.api;

import java.io.Serializable;

/**
 * 秘钥对，包含公钥和私钥。
 *
 * @author 应卓
 * @since 0.1.0
 */
public interface Secret extends Serializable, PublicKey, PrivateKey {

    @Override
    public String getPublicKey();

    @Override
    public String getPrivateKey();

    @Override
    public String toString();

}
