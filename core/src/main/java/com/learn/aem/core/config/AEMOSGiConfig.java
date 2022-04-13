package com.learn.aem.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="Learn AEM - Modular OSGi Configuration",
description = "Modular OSGi Configuration Demo")
public @interface AEMOSGiConfig {

    @AttributeDefinition(
        name= "Service ID",
        description= "Enter Service ID",
        type= AttributeType.INTEGER)
    int serviceID();

    @AttributeDefinition(
            name="Service Name",
            description="Enter Service Name",
            type= AttributeType.STRING)
    public String serviceName() default "Learn AEM - Service";

    @AttributeDefinition(
            name="Service URL",
            description="Enter Service URL",
            type= AttributeType.STRING)
    public String serviceURL() default "localhost";
}

