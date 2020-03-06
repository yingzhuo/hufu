/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  _   _        __
 * | | | |_   _ / _|_   _
 * | |_| | | | | |_| | | |
 * |  _  | |_| |  _| |_| |
 * |_| |_|\__,_|_|  \__,_|        https://github.com/yingzhuo/hufu
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package com.github.yingzhuo.hufu.api;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * IO相关工具
 *
 * @author 应卓
 * @since 0.1.1
 */
final class IO {

    static byte[] toBytes(CharSequence data) {
        return data.toString().getBytes(StandardCharsets.UTF_8);
    }

    static byte[] toBytes(InputStream data) throws IOException {
        byte[] bytes = new byte[data.available()];
        data.read(bytes);
        return bytes;
    }

    static byte[] toBytes(File file) throws IOException {
        return Files.readAllBytes(file.toPath());
    }

    static byte[] toBytes(RandomAccessFile file) throws IOException {
        byte[] data = new byte[(int) file.length()];
        file.readFully(data);
        return data;
    }

    static byte[] toBytes(Path data) throws IOException {
        return Files.readAllBytes(data);
    }

    static byte[] toBytes(ByteBuffer data) {
        return data.array();
    }

    static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                // NOP
            }
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    private IO() {
    }
}
