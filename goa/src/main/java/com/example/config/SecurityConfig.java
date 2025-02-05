//package com.example.config;
//
//import java.util.Arrays;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable()) // Disable CSRF for testing; enable in production
//            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
//            .cors();
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));  // Your frontend URL
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
//        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//}
//



package com.example.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable())  // Disable CSRF for testing, enable in production
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/auth/login", "/auth/register").permitAll()
//                .requestMatchers("/hotels/create").permitAll()// Allow login and register endpoints for everyone
//                .anyRequest().authenticated())  // Secure all other endpoints
//            .cors();  // Enable CORS
//        return http.build();
//    }
	
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http.csrf(csrf -> csrf.disable())  // Disable CSRF for testing
	        .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())  // Allow all requests
	        .cors();
	    return http.build();
	}


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Password encoding with BCrypt
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000","http://localhost:8081"));  // Allow requests from React frontend
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));  // Allowed HTTP methods
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));  // Allowed headers
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);  // Apply CORS configuration to all endpoints
        return source;
    }
}

