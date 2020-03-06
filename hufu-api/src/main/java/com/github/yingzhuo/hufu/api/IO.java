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
import java.nio.charset.StandardCharsets;

/**
 * IO相关工具
 *
 * @author 应卓
 * @since 0.1.1
 */
final class IO {

    static byte[] toBytes(String data) {
        return data.getBytes(StandardCharsets.UTF_8);
    }

    static byte[] toBytes(InputStream data) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        byte[] buffer = new byte[0xFFFF];
        for (int len = data.read(buffer); len != -1; len = data.read(buffer)) {
            os.write(buffer, 0, len);
        }
        return os.toByteArray();
    }

    static byte[] toBytes(File file) throws IOException {
        byte[] data = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        dataInputStream.readFully(data);
        close(dataInputStream);
        close(fileInputStream);
        return data;
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
