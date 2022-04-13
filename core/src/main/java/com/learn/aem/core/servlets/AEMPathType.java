package com.learn.aem.core.servlets;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service= Servlet.class, property = {Constants.SERVICE_DESCRIPTION+ "=Demo of path type servlet",
        "sling.servlet.paths=" + "/bin/servletOne"
})
public class AEMPathType extends SlingSafeMethodsServlet {
private static final Logger LOG = LoggerFactory.getLogger(AEMPathType.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        final Resource resource = request.getResource();
        LOG.debug("Inside doGet method of AEMPathType in DEBUG");
        LOG.info("Inside doGet method of AEMPathType in INFO");
        LOG.error("Inside doGet method of AEMPathType in ERROR");
        response.getWriter().println("When this page is loaded you are firing ServletOne.java");
        response.getWriter().println("Page Name is " + resource.getName());
    }
}
