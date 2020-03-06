/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  _   _        __
 * | | | |_   _ / _|_   _
 * | |_| | | | | |_| | | |
 * |  _  | |_| |  _| |_| |
 * |_| |_|\__,_|_|  \__,_|        https://github.com/yingzhuo/hufu
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package com.github.yingzhuo.hufu.springboot;

import com.github.yingzhuo.hufu.spring.SecretFactoryBean;
import com.github.yingzhuo.hufu.spring.SignatureFactoryFactoryBean;
import org.springframework.context.annotation.Bean;

/**
 * @author 应卓
 * @since 0.1.1
 */
public class HufuAutoConfig {

    @Bean
    public SecretFactoryBean secretFactory() {
        return new SecretFactoryBean();
    }

    @Bean
    public SignatureFactoryFactoryBean signature() {
        return new SignatureFactoryFactoryBean();
    }

    @Bean("__signatureUtils__")
    public SignatureUtils signatureUtils() {
        return new SignatureUtils();
    }

}
