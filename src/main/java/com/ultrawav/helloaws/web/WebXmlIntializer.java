package com.ultrawav.helloaws.web;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebXmlIntializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(SpringConfig.class);

		servletContext.addListener(new ContextLoaderListener(context));

		AnnotationConfigWebApplicationContext dispatcherServletContext = new AnnotationConfigWebApplicationContext();
		dispatcherServletContext.register(WebConfig.class);

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("link", new DispatcherServlet(
				dispatcherServletContext));
		dispatcher.setLoadOnStartup(0);
		dispatcher.addMapping("/");

		servletContext.addFilter("Spring OpenEntityManagerInViewFilter", OpenEntityManagerInViewFilter.class)
				.addMappingForUrlPatterns(null, false, "/*");

		servletContext.addFilter("HttpMethodFilter", HiddenHttpMethodFilter.class).addMappingForUrlPatterns(null,
				false, "/*");
		
		FilterRegistration charEncodingfilterReg = servletContext.addFilter("CharacterEncodingFilter",
				CharacterEncodingFilter.class);
		charEncodingfilterReg.setInitParameter("encoding", "UTF-8");
		charEncodingfilterReg.setInitParameter("forceEncoding", "true");
		charEncodingfilterReg.addMappingForUrlPatterns(null, false, "/*");

	}

}
