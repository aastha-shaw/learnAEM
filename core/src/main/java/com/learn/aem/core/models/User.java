package com.learn.aem.core.models;

import com.day.cq.wcm.api.Page;

public interface User {
    String getText();
    String getPageTitle();
    String getRequestAttribute();
    String getEnPageName();
    String getLastModifiedBy();
}
