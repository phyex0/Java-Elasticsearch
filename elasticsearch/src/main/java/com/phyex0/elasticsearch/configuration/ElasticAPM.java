//package com.phyex0.elasticsearch.configuration;
//
//import co.elastic.apm.attach.ElasticApmAttacher;
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//@RequiredArgsConstructor
//public class ElasticAPM {
//
//    private static final String SERVER_URL_KEY = "server_url";
//    private static final String SERVICE_NAME_KEY = "service_name";
//    private static final String SECRET_TOKEN_KEY = "secret_token";
//    private static final String ENVIRONMENT_KEY = "environment";
//    private static final String APPLICATION_PACKAGES_KEY = "application_packages";
//    private static final String LOG_LEVEL_KEY = "log_level";
//
//    @Value("${spring.elasticsearch.apm.server-url}")
//    private String serverUrl;
//    @Value("${spring.elasticsearch.apm.service-name}")
//    private String serviceName;
//    @Value("${spring.elasticsearch.apm.environment}")
//    private String environment;
//    @Value("${spring.elasticsearch.apm.application-packages}")
//    private String applicationPackages;
//    @Value("${spring.elasticsearch.apm.log-level}")
//    private String logLevel;
//    @Value("${spring.elasticsearch.apm.server-url}")
//    private String secretToken;
//
//    @PostConstruct
//    public void init() {
//        Map<String, String> apmProps = new HashMap<>();
//        apmProps.put(SERVER_URL_KEY, serverUrl);
//        apmProps.put(SERVICE_NAME_KEY, serviceName);
//        apmProps.put(ENVIRONMENT_KEY, environment);
//        apmProps.put(APPLICATION_PACKAGES_KEY, applicationPackages);
//        apmProps.put(LOG_LEVEL_KEY, logLevel);
//        apmProps.put(SECRET_TOKEN_KEY, secretToken);
//        ElasticApmAttacher.attach(apmProps);
//    }
//}
