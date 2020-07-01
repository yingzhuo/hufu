/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  _   _        __
 * | | | |_   _ / _|_   _
 * | |_| | | | | |_| | | |
 * |  _  | |_| |  _| |_| |
 * |_| |_|\__,_|_|  \__,_|        https://github.com/yingzhuo/hufu
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package com.github.yingzhuo.hufu.api;

/**
 * @author 应卓
 * @see BytesBuilder
 * @since 1.0.1
 */
@FunctionalInterface
public interface BytesSerializable {

    public byte[] serialize();

}
