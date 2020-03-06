/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  _   _        __
 * | | | |_   _ / _|_   _
 * | |_| | | | | |_| | | |
 * |  _  | |_| |  _| |_| |
 * |_| |_|\__,_|_|  \__,_|        https://github.com/yingzhuo/hufu
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package com.github.yingzhuo.hufu.spring;

import com.github.yingzhuo.hufu.api.SecretFactory;
import com.github.yingzhuo.hufu.core.Hufu;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author 应卓
 * @since 0.1.0
 */
public class SecretFactoryBean implements FactoryBean<SecretFactory>, InitializingBean {

    private SecretFactory bean;

    @Override
    public SecretFactory getObject() {
        return bean;
    }

    @Override
    public Class<?> getObjectType() {
        return SecretFactory.class;
    }

    @Override
    public void afterPropertiesSet() {
        try {
            this.bean = Hufu.createSecretFactory();
        } catch (Exception e) {
            throw new BeanCreationException(e.getMessage(), e);
        }
    }
}
