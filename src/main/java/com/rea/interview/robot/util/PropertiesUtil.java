package com.rea.interview.robot.util;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.rea.interview.robot.core.exception.FeedAbortException;

public class PropertiesUtil {

    private static interface Singleton {
        final PropertiesUtil INSTANCE = new PropertiesUtil();
    }

    public static PropertiesUtil getInstance() {
        return Singleton.INSTANCE;
    }

    private static Properties props;

    private PropertiesUtil() {

        Resource resource = new ClassPathResource("/feed.properties");

        try {
            props = PropertiesLoaderUtils.loadProperties(resource);

        } catch (IOException e) {

            throw new FeedAbortException("failed to load property file !!!", e);
        }

    }

    public String getPropertyValue(String propertyName) {
        return props.getProperty(propertyName);
    }

}
