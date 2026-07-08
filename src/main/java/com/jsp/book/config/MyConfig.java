package com.jsp.book.config;

import java.nio.file.Paths;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableAsync
public class MyConfig implements WebMvcConfigurer {

	@Value("${local.storage.base-path:uploads}")
	private String storageBasePath;

	@Bean
	SecureRandom secureRandom() {
		return new SecureRandom();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String uploadPath = Paths.get(System.getProperty("user.dir"), storageBasePath).toAbsolutePath().toString();
		if (!uploadPath.endsWith("/")) {
			uploadPath += "/";
		}
		registry.addResourceHandler("/uploads/**")
				.addResourceLocations("file:" + uploadPath);
	}
}

