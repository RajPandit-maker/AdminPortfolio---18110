package in.adminportfolio.portfolio.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    // 1) In‑memory admin user with {noop} prefix so no custom PasswordEncoder is needed
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withUsername("Raj Pandit")
                .password("{noop}R@jP0rtF0l!0")  // {noop} = plain text, demo only
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }

    // 2) Let Spring build AuthenticationManager from AuthenticationConfiguration
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)
            throws Exception {
        return configuration.getAuthenticationManager();
    }

    // 3) Security filter chain
    @Bean
    public SecurityFilterChain filterChain(
            org.springframework.security.config.annotation.web.builders.HttpSecurity http,
            JwtAuthFilter jwtAuthFilter) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                // static resources and index page
                .requestMatchers("/", "/index.html", "/favicon.ico",
                                 "/**/*.css", "/**/*.js", "/**/*.png",
                                 "/**/*.jpg", "/**/*.jpeg", "/**/*.gif").permitAll()

                // public APIs
                .requestMatchers("/api/admin/login").permitAll()
                .requestMatchers("/api/portfolio").permitAll()   // GET open; PUT restricted by @PreAuthorize
                .requestMatchers("/api/contact").permitAll()

                // everything else requires auth
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}