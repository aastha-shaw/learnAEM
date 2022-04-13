package com.learn.aem.core.models;

import com.learn.aem.core.services.OSGiFactoryConfig;

import java.util.List;

public interface OSGiConfigDemo {
  /* String getServiceName();

    int getServiceCount();

    boolean isLiveData();

    String[] getCountries();

    String getRunModes();

    int getConfigId();

 String getServiceNameModule();

 String getServiceURL(); */

    List<OSGiFactoryConfig> getAllOSGiConfigs();
}
