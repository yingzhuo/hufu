/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  _   _        __
 * | | | |_   _ / _|_   _
 * | |_| | | | | |_| | | |
 * |  _  | |_| |  _| |_| |
 * |_| |_|\__,_|_|  \__,_|        https://github.com/yingzhuo/hufu
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package com.github.yingzhuo.hufu.core;

import com.github.yingzhuo.hufu.api.SecretFactory;
import com.github.yingzhuo.hufu.api.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author 应卓
 * @since 0.1.0
 */
public final class Hufu {

    private static final Logger log = LoggerFactory.getLogger(Hufu.class);

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
    private Hufu() {
    }
}
