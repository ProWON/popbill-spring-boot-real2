package kr.co.linkhub.autoconfigure;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import kr.co.linkhub.autoconfigure.properties.CommonProperties;
import kr.co.linkhub.autoconfigure.properties.PopbillProperties;

@EnableConfigurationProperties(CommonProperties.class)
public class CommonAutoConfiguration {

    PopbillProperties makeInstanceProperties;

    @Autowired
    CommonProperties commonProperties;

    private static final Logger logger = LoggerFactory.getLogger(CommonAutoConfiguration.class);

    public <T> T getInstance(PopbillProperties immediateProperties, Class<T> clazz) {

        checkSeparateProperties(immediateProperties);

        T instance = null;

        try {
            instance = clazz.newInstance();
            logger.info("POPBiLL Create Instance : " + clazz.getName());
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                String methodName = method.getName();
                if (methodName.equals("setLinkID")) {
                    method.invoke(instance, makeInstanceProperties.getLinkId());
                } else if (methodName.equals("setSecretKey")) {
                    method.invoke(instance, makeInstanceProperties.getSecretKey());
                } else if (methodName.equals("setTest")) {
                    method.invoke(instance, makeInstanceProperties.isTest());
                } else if (methodName.equals("setUseStaticIP")) {
                    method.invoke(instance, makeInstanceProperties.isUseStaticIp());
                } else if (methodName.equals("setUseGAIP")) {
                    method.invoke(instance, makeInstanceProperties.isUseGaIp());
                } else if (methodName.equals("setUseLocalTimeYN")) {
                    method.invoke(instance, makeInstanceProperties.isUseLocalTimeYn());
                } else if (methodName.equals("setIPRestrictOnOff")) {
                    method.invoke(instance, makeInstanceProperties.isIpRestrectOnOff());
                } else if (methodName.equals("setAuthURL")) {
                    method.invoke(instance, makeInstanceProperties.getAuthUrl());
                } else if (methodName.equals("setServiceURL")) {
                    method.invoke(instance, makeInstanceProperties.getServiceUrl());
                } else if (methodName.equals("setTestServiceURL")) {
                    method.invoke(instance, makeInstanceProperties.getTestServiceUrl());
                } else if (methodName.equals("setProxyIP")) {
                    method.invoke(instance, makeInstanceProperties.getProxyIp());
                } else if (methodName.equals("setProxyPort")) {
                    method.invoke(instance, makeInstanceProperties.getProxyPort());
                }
            }
        } catch (Exception e) {
            logger.info("Failure Initializing Instance : " + clazz.getName());
            return instance;
        }
        return instance;
    }

    private void checkSeparateProperties(PopbillProperties properties) {
        if (commonProperties.isUseSeparateConfig()) {
            makeInstanceProperties = properties;
        } else {
            makeInstanceProperties = commonProperties;
        }
    }
}
