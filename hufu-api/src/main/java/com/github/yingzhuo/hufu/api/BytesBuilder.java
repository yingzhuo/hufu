/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  _   _        __
 * | | | |_   _ / _|_   _
 * | |_| | | | | |_| | | |
 * |  _  | |_| |  _| |_| |
 * |_| |_|\__,_|_|  \__,_|        https://github.com/yingzhuo/hufu
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package com.github.yingzhuo.hufu.api;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UncheckedIOException;

/**
 * @author 应卓
 * @see BytesSerializable
 * @since 1.0.3
 */
public final class BytesBuilder {

    private final ByteArrayOutputStream out;

    private BytesBuilder() {
        this.out = new ByteArrayOutputStream(1024);
    }

    public static BytesBuilder newInstance() {
        return new BytesBuilder();
    }

    public BytesBuilder append(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(out)) {
            oos.writeObject(object);
            oos.flush();
        } catch (IOException ex) {
            throw new UncheckedIOException("Failed to serialize object of type: " + object.getClass(), ex);
        }
        return this;
    }

    public byte[] build() {
        return this.out.toByteArray();
    }

}
