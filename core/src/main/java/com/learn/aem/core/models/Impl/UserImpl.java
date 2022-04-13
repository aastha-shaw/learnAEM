package com.learn.aem.core.models.Impl;

import com.day.cq.search.QueryBuilder;
import com.day.cq.wcm.api.Page;
import com.learn.aem.core.models.User;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = User.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)


public class UserImpl implements User {
    public static final Logger LOG = LoggerFactory.getLogger(UserImpl.class);

    @ValueMapValue
    @Default(values = "Aastha")
    private String text;

    @ScriptVariable
    Page currentPage;

    @SlingObject
    ResourceResolver resourceResolver;

    @Self
    SlingHttpServletRequest slingHttpServletRequest;

    @RequestAttribute(name="rAttribute")
    public String reqAttribute;

    @ResourcePath(path="/content/learnAEM/en")@Via("resource")
    Resource resource;

    @OSGiService
    QueryBuilder queryBuilder;

    @Inject
    @Via("resource")
    @Named("jcr:lastModifiedBy")
    String modifiedBy;

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String getPageTitle() {
        return currentPage.getTitle();
    }

    @Override
    public String getRequestAttribute() {
        return reqAttribute;
    }

    @Override
    public String getEnPageName() {
        return resource.getName();
    }

    @Override
    public String getLastModifiedBy() {
        return modifiedBy;
    }

    @PostConstruct
    protected void init() {
        LOG.info("\n Inside INIT{} : {}",currentPage.getTitle(),resource.getPath());
    }
}
