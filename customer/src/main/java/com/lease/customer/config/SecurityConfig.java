package com.lease.customer.config;

import java.net.http.HttpRequest;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.lease.customer.service.CustomerUserDetailsService;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;


@Configuration
public class SecurityConfig {
	
	private  RsaKeyProperties jwtConfigProperties;
	private  CustomerUserDetailsService customerUserDetailsService;
	private  PasswordEncoder passwordEncoder;
	
	
	public SecurityConfig(CustomerUserDetailsService service, PasswordEncoder encoder) throws NoSuchAlgorithmException {
		this.customerUserDetailsService = service;
		this.passwordEncoder = encoder;
		this.jwtConfigProperties = generateRsaKeyProperties();
	}
	
	private RsaKeyProperties generateRsaKeyProperties() throws NoSuchAlgorithmException {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(2048);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
	    RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

	    return new RsaKeyProperties(publicKey, privateKey);
	}

	/*@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
	        return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher("/h2-console/**"));
	}
	 	
	 @Bean
	 SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
	 		return http
	 				.authorizeHttpRequests(
	 					(auth) -> {
	 						auth.anyRequest().permitAll();
	 					}
	 				)
	 				.build();
	 }*/
	 
	 @Bean
	 public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception{
		 return http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(customerUserDetailsService)
				 .passwordEncoder(passwordEncoder)
				 .and()
				 .build();
				 
	 }
	 
	 @Bean
	 @Order(1)
	 SecurityFilterChain securityFilterChainToken(HttpSecurity http) throws Exception{
		return http.securityMatcher("/token")
				.csrf(csrf->csrf.disable())
				.headers(header->header.frameOptions().disable())
				.authorizeHttpRequests(auth->auth.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.build();
		 
	 }
	 
	 @Bean
	 @Order(2)
	 SecurityFilterChain securityFilterChainJwt(HttpSecurity http) throws Exception{
		 return http
	                .securityMatcher("/customer/**")
	                .csrf(csrf -> csrf.disable())
	                .headers(header-> header.frameOptions().disable())	
	                .authorizeHttpRequests(auth -> {
	                    auth.anyRequest().authenticated();
	                })
	                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	                .oauth2ResourceServer(oauth2->oauth2.jwt(jwt->jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())))
	                .exceptionHandling(ex->ex.authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
	                		.accessDeniedHandler(new BearerTokenAccessDeniedHandler())).build();

	              
	 }
	 
	 @Bean
	  JwtDecoder jwtDecoder() {
	       return NimbusJwtDecoder.withPublicKey(jwtConfigProperties.getPublicKey()).build();
	  }

	 
	 @Bean
	 JwtEncoder jwtEncoder() {
		 JWK jwk = new RSAKey.Builder(jwtConfigProperties.getPublicKey()).privateKey(jwtConfigProperties.getPrivateKey()).build();
		 JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
	     return new NimbusJwtEncoder(jwks);
	 }

	 
	    @Bean
	    public JwtAuthenticationConverter jwtAuthenticationConverter() {
	        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
	        return converter;
	    }
	 	
}
