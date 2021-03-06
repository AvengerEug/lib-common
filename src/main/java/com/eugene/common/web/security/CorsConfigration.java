package com.eugene.common.web.security;

import com.eugene.common.constants.FilterOrderConstants;
import com.eugene.common.factory.FilterFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CorsConfigration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .cors()
                .and()
                .authorizeRequests()
                .antMatchers(
                        "/**"
                )
                .permitAll()
                .anyRequest().authenticated();

        http.headers().cacheControl().disable();

        // add jwt filter
        http.addFilterBefore(FilterFactory.getFilter("authFilter", "/*", FilterOrderConstants.AUTH_FILTER_ORDER).getFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
