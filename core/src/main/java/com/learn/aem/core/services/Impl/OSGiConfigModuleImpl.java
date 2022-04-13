package com.learn.aem.core.services.Impl;


import com.learn.aem.core.config.AEMOSGiConfig;
import com.learn.aem.core.services.OSGiConfigModule;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = OSGiConfigModule.class, immediate = true)
@Designate(ocd= AEMOSGiConfig.class)
public class OSGiConfigModuleImpl implements OSGiConfigModule{

    private int serviceId;
    private String serviceName;
    private String serviceURL;

    @Activate
    protected void activate(AEMOSGiConfig aemOSGiConfig){
        serviceId=aemOSGiConfig.serviceID();
        serviceName=aemOSGiConfig.serviceName();
        serviceURL=aemOSGiConfig.serviceURL();
    }
    @Override
    public int getServiceId() {
        return serviceId;
    }
    @Override
    public String getServiceName() {
        return serviceName;
    }
    @Override
    public String getServiceURL() {
        return serviceURL;
    }
}

