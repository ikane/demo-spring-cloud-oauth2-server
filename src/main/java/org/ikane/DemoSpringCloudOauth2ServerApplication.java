package org.ikane;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class DemoSpringCloudOauth2ServerApplication {
	
	public static final Logger logger = LoggerFactory.getLogger(DemoSpringCloudOauth2ServerApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoSpringCloudOauth2ServerApplication.class, args);
		
		Environment env = context.getEnvironment();
		logger.info("\n\thttp://localhost:{}{}\n\tProfiles:{}\n", 
				StringUtils.defaultIfEmpty(env.getProperty("server.port"), "8080"), 
				StringUtils.defaultIfEmpty(env.getProperty("server.context-path"), "/"),
				Arrays.toString(env.getActiveProfiles()));
	}
}
