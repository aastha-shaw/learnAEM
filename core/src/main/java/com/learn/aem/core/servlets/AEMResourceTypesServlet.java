package com.learn.aem.core.servlets;

import com.day.cq.commons.jcr.JcrConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
//import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;


    @Component(service = Servlet.class, property = {Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",

            "sling.servlet.resourceTypes = " + "learnAEM/components/structure/page"
    })
    public class AEMResourceTypesServlet extends SlingSafeMethodsServlet {
        private static final Logger LOG = LoggerFactory.getLogger(AEMResourceTypesServlet.class);

        @Override
        protected void doGet(final SlingHttpServletRequest req,
                             final SlingHttpServletResponse resp) throws ServletException, IOException {
            final Resource resource = req.getResource();
            LOG.info("Its from log");
            resp.setContentType("text/plain");
            resp.getWriter().write("Page Title = " + resource.getValueMap().get(JcrConstants.JCR_TITLE));
        }
    }


