package org.paingan.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration
@EnableResourceServer
public class PainganMemberServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PainganMemberServiceApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}