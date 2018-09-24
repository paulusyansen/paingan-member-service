package org.paingan.member.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
public class SecurityResourceConfig extends ResourceServerConfigurerAdapter{

	public static final String RESOURCE_ID = "member";
	   
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/member/**")
                .access("#oauth2.hasScope('read')")
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
   
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
         resources.resourceId(RESOURCE_ID);
    }

    
//    private static final String RESOURCE_ID = "resource_id";
//
//	@Override
//	public void configure(ResourceServerSecurityConfigurer resources) {
//		resources.resourceId(RESOURCE_ID).stateless(false);
//	}
//
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//        http.
//                anonymous().disable()
//                .authorizeRequests()
//                .antMatchers("/uaa/**").permitAll()
//                .antMatchers("/oauth/**").permitAll()
//                .antMatchers("/users/**").access("hasRole('ADMIN')")
//                .antMatchers("/members/**").access("hasRole('ADMIN')")
//                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
//	}
	
}
