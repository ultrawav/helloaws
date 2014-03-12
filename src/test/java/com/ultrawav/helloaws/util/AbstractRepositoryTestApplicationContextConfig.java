package com.ultrawav.helloaws.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurableEnvironment;


@Configuration
@ImportResource({"classpath:simple-repository-context.xml"})
public class AbstractRepositoryTestApplicationContextConfig {

	@Autowired
	private ConfigurableEnvironment configurableEnvironment;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
