package com.bstk.config;

import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig  extends ResourceConfig {

    private void ApplicationInit(){
        // Register CORS filter.
        register(com.bstk.filters.ResponseFilter.class);
    }

     public ApplicationConfig() {
        ApplicationInit();
    }
}