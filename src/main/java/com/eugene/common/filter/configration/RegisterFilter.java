package com.eugene.common.filter.configration;

import com.eugene.common.factory.FilterFactory;
import com.eugene.common.constants.FilterOrderConstants;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * 过滤器注册中心
 */
public class RegisterFilter {

    @Bean
    public FilterRegistrationBean firstFilter() {
        return FilterFactory.getFilter("firstFilter");
    }

    /**
     * 该过滤器作为jwtAuth用, 不采用bean的方式注入 link to CorsConfigration类
     * @return
     */
    /*@Bean*/
    public FilterRegistrationBean authFilter() {
        return FilterFactory.getFilter("authFilter", "/*", FilterOrderConstants.AUTH_FILTER_ORDER);
    }

}
