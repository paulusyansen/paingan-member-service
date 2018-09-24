package org.paingan.member.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		.authorizeRequests()
			.antMatchers("/uaa/**","/login","/oauth/**").permitAll()
			.anyRequest().authenticated()
			.and().formLogin()
			.loginPage("/login")
			.and().httpBasic().disable();
	}
	
//	private final AuthenticationManagerBuilder authenticationManagerBuilder;
//	
//    @Autowired
//	private UserDetailsService userDetailsService;
//    
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;


//    public SecurityConfiguration(AuthenticationManagerBuilder authenticationManagerBuilder, UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
//    	this.authenticationManagerBuilder = authenticationManagerBuilder;
//    	this.userDetailsService = userDetailsService;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
    
//    @PostConstruct
//    public void init() {
//        try {
//            authenticationManagerBuilder
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());
//        } catch (Exception e) {
//            throw new BeanInitializationException("Security configuration failed", e);
//        }
//    }
    
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
    
    
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
//    }
	
    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////    	http
////        	.authorizeRequests()
////        	.antMatchers("/").permitAll();
//
//    	http.authorizeRequests()
//        .antMatchers("/login").permitAll()
//        .anyRequest().authenticated()
//        .and()
//        .formLogin().permitAll();
//
//    	http.headers().frameOptions().disable(); //h2-console enable jdbc-url: jdbc:h2:mem:testdb
//    	http.headers().frameOptions().sameOrigin(); //h2-console enable
//
//    	
//    }
//    
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//           .ignoring()
//               .antMatchers("/**");
//    }

}
